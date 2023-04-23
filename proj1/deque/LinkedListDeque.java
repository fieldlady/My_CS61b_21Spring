package deque;

import java.util.Iterator;
import java.util.List;

public class LinkedListDeque<T> {
    class ListNode<T> {
        T val;
        ListNode next;
        ListNode prev;
        public ListNode(T val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
        public ListNode(T val, ListNode prev, ListNode next) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }


    //fields:
    ListNode sentinel;
    int size;


    //constructors:
    public LinkedListDeque() {
        sentinel = new ListNode(-1);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }


    //methods:

    public void addFirst(T item) {
        ListNode<T> newNode = new ListNode<>(item);
        ListNode<T> oldFirst = sentinel.next;
        newNode.next = oldFirst;
        oldFirst.prev = newNode;
        sentinel.next = newNode;
        newNode.prev = sentinel;
        size++;
    }

    public void addLast(T item) {
        ListNode<T> newNode = new ListNode<>(item);
        ListNode<T> oldLast = sentinel.prev;
        newNode.prev = oldLast;
        oldLast.next = newNode;
        newNode.next = sentinel;
        sentinel.prev = newNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (isEmpty()) {
            System.out.println();
            return;
        }

        ListNode<T> cur = sentinel.next;
        ListNode<T> last = sentinel.prev;
        while (cur != last) {
            System.out.print(cur.val);
            System.out.print(" ");
            cur = cur.next;
        }
        System.out.print(cur.val);
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        ListNode<T> oldFirst = sentinel.next;
        sentinel.next = oldFirst.next;
        oldFirst.next.prev = sentinel;
        size--;
        return oldFirst.val;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        ListNode<T> oldLast = sentinel.prev;
        sentinel.prev = oldLast.prev;
        oldLast.prev.next = sentinel;
        size--;
        return oldLast.val;
    }

    public T get(int index) {
        if (index < 0 || isEmpty()) {
            return null;
        }
        ListNode<T> cur = sentinel.next;
        while (cur != sentinel && index > 0) {
            cur = cur.next;
            index--;
        }
        if (cur == sentinel) {
            return null;
        }
        return cur.val;
    }

    public T getRecursive(int index) {
        return null;

    }


    public Iterator<T> iterator() {
        return null;

    }

    public boolean equals(Object o) {
        return true;

    }
}
