package generics;

import static net.mindview.util.Tuple.tuple;

//: generics/DynamicProxyMixin.java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import net.mindview.util.TwoTuple;

/**
 * 利用代理，把几个不相干的类组装成一个混合类型，并调用其中的方法<br>
 * 首先要建立一个二元元组<br>
 * 利用delegatesByMethod盛放等待调用的对象和方法
 */
class MixinProxy implements InvocationHandler {
    Map<String, Object> delegatesByMethod;

    /*
     * map 和list等集合中存储的并不是真正的对象，而是对象的引用
     */
    public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
        delegatesByMethod = new HashMap<String, Object>();
        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {
                String methodName = method.getName();
                // The first interface in the map
                // implements the method.
                if (!delegatesByMethod.containsKey(methodName)) {
                    delegatesByMethod.put(methodName, pair.first);
                }
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }

    @SuppressWarnings("unchecked")
    public static Object newInstance(TwoTuple... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].second;
        }
        ClassLoader cl = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(DynamicProxyMixin.class
                .getClassLoader(), new Class[] { Basic.class, TimeStamped.class, SerialNumbered.class }, new MixinProxy(pairs));
    }
}

public class DynamicProxyMixin {
    public static void main(String[] args) {
        Object mixin = MixinProxy
                .newInstance(tuple(new BasicImp(), Basic.class), tuple(new TimeStampedImp(), TimeStamped.class), tuple(new SerialNumberedImp(), SerialNumbered.class));
        Basic b = (Basic) mixin;
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
    }
} /* Output: (Sample)
  Hello
  1132519137015
  1
  *///:~
