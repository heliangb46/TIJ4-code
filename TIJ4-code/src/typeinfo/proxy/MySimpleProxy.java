package typeinfo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

import typeinfo.pets.Person;

public class MySimpleProxy {

    static class MyHandler implements InvocationHandler {

        private Object item;

        public MyHandler(Object item) {
            super();
            this.item = item;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(item + " --- proxy method is Call: method=" + method.getName());
            return method.invoke(item, args);
        }
    }

    public static void main(String[] args) {
        Object obj = new Person("hel");
        //        obj = new Rodent();
        //                obj = new Object();
        obj = new ArrayList();
        Comparable call = (Comparable) Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[] {Comparable.class}, new MyHandler(new ArrayList()));

        System.out.println(call.hashCode());
    }

}
