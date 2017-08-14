package generics;

import java.util.Iterator;

//: generics/LinkedStack.java
// A stack implemented with an internal linked structure.

/**
 * 自定义的linkedStack,可以参考其数据结构
 */
public class LinkedStack<T> {
    private Node<T> top = new Node<T>(); // End sentinel

    private static class Node<U> {
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    public void push(T item) {
        top = new Node<T>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) top = top.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<String>();
        for (String s : "Phasers on stun!".split(" ")) {
            lss.push(s);
        }
        String s;
        while ((s = lss.pop()) != null) {
            System.out.println(s);
        }

    }
}
/* Output:
  stun!
  on
  Phasers
  *///:~

class MyList<T> {

    private Elem<T> topPoint = new Elem<T>(); // End sentinel 哨兵

    static class Elem<E> {
        E e;
        Elem<E> nextPoint = null;

        Elem() {
            e = null;
            nextPoint = null;
        }

        Elem(E u, Elem<E> nextPoint) {
            this.e = u;
            this.nextPoint = nextPoint;
        }

        public boolean hasNext() {
            return e == null && nextPoint == null;
        }
    }

    public void push(T item) {
        topPoint = new Elem<T>(item, topPoint);
    }

    public T pop() {
        T result = topPoint.e;
        if (!topPoint.hasNext()) {
            topPoint = topPoint.nextPoint;
        }
        return result;
    }
}

class YourList<T> implements Iterable<T> {
    private static class YourNode<X> {
        X x;
        YourNode<X> nextPoint = null;

        public YourNode() {
            super();
        }

        public YourNode(X x, YourNode<X> nextPoint) {
            this.x = x;
            this.nextPoint = nextPoint;
        }

        public boolean hasNext() {
            return x != null && nextPoint != null;
        }
    }

    private YourNode<T> topPoint = new YourNode<T>();

    public void push(T t) {
        topPoint = new YourNode<T>(t, topPoint);
    }

    public T pop() {
        T result = topPoint.x;
        if (topPoint.hasNext()) {
            topPoint = topPoint.nextPoint;
        }
        return result;
    }

    public static void main(String[] args) {
        YourList<String> yy = new YourList<String>();
        for (String s : "Do you want play GTA5!".split(" ")) {
            yy.push(s);
        }
        //        String s;
        //        while ((s = yy.pop()) != null) {
        //            System.out.println(s);
        //        }
        for (String xs : yy) {
            System.out.println(xs);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return topPoint.hasNext();
            }

            @Override
            public T next() {
                return pop();
            }

        };
    }
}
