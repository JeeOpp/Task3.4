package entity;

import java.util.NoSuchElementException;

/**
 * Created by DNAPC on 18.11.2017.
 */
public class LinkedList implements List {
    private int size = 0;
    private Node first;
    private Node last;

    public LinkedList(){

    }
    @Override
    public void fill(Integer[] values) {
        for(int i=0;i<values.length;i++){
            add(values[i]);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(Object value) {
        int index = 0;
        for (Node x = first; x != null; x = x.next) {
            if (value.equals(x.item))
                return index;
            index++;
        }
        return -1;
    }

    @Override
    public Object get(int index) {
        if (checkRange(index)) {
            return node(index).item;
        }
        return null;
    }

    @Override
    public void set(int index, Object element) {
        if (checkRange(index)) {
            Node x = node(index);
            x.item = element;
        }
    }

    @Override
    public void add(Object value){
        final Node l = last;
        final Node newNode = new Node(l, value, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public void add(int index, Object value) {
        if (checkRange(index)) {
            final Node curr = node(index);
            final Node prev = curr.prev;
            final Node newNode = new Node(prev, value, curr);

            curr.prev = newNode;
            if (prev == null)
                first = newNode;
            else
                prev.next = newNode;
            size++;
        }
    }

    @Override
    public void remove(int index){
        if (checkRange(index)){
            remove(node(index));
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator();
    }

    private void remove(Node node) {
        final Node next = node.next;
        final Node prev = node.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        node.item = null;
        size--;
    }

    private Node node(Integer index){
        Node x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    private int indexOf(Node node){
        int index = 0;
        for (Node x = first; x != null; x = x.next) {
            if (x.equals(node)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private boolean checkRange(int index){
        return index<size;
    }

    private static class Node {
        Object item;
        Node next;
        Node prev;

        Node(Node prev, Object element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            if (item != null ? !item.equals(node.item) : node.item != null) return false;
            if (next != null ? !next.equals(node.next) : node.next != null) return false;
            return prev != null ? prev.equals(node.prev) : node.prev == null;
        }

        @Override
        public int hashCode() {
            int result = item != null ? item.hashCode() : 0;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            result = 31 * result + (prev != null ? prev.hashCode() : 0);
            return result;
        }
    }

    private class Iterator implements entity.Iterator {
        private Node lastReturned = null;
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Object next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            cursor = i + 1;
            return (lastReturned = node(i)).item;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }else {
                LinkedList.this.remove(lastReturned);
                cursor = indexOf(lastReturned);
                lastReturned = null;
            }
        }



    }
}
