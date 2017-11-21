package entity;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * Created by DNAPC on 18.11.2017.
 */
public class ArrayList implements List {
    private Object[] values;
    private int size=0;

    public ArrayList(){
        values = new Object[size];
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
    public int indexOf(Object o){
        for (int i=0;i < size; ++i){
            if (o.equals(values[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object get(int index) {
        if (checkRange(index)) {
            return values[index];
        }
        return null;
    }

    @Override
    public void set(int index, Object value){
        if (checkRange(index)){
            values[index] = value;
        }
    }

    @Override
    public void add(Object value){
        values = Arrays.copyOf(values, ++size);
        values[size-1] = value;
    }

    @Override
    public void add(int index, Object value){
        if(checkRange(index)){
            System.arraycopy(values,index, values, index+1, size - index );
            values[index] = value;
            ++size;
        }

    }

    @Override
    public void remove(int index){
        int numMoved = size - index - 1;
        if(checkRange(index)){
            if(numMoved>0) {
                System.arraycopy(values, index + 1, values, index, size - index - 1);
            }else{
                values = null;
            }
            --size;
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator();
    }

    private boolean checkRange(int index) {
        return index < size;
    }

    private class Iterator implements entity.Iterator{
        int cursor;
        int lastReturned = -1;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Object next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] values = ArrayList.this.values;
            if (i >= values.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return values[lastReturned = i];
        }

        @Override
        public void remove() {
            if (lastReturned < 0) {
                throw new IllegalStateException();
            }else {
                ArrayList.this.remove(lastReturned);
                cursor = lastReturned;
                lastReturned = -1;
            }
        }
    }
}
