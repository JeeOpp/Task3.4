package entity;

/**
 * Created by DNAPC on 18.11.2017.
 */
public interface List {
    public void fill(Integer[] values);

    public int size();

    public boolean isEmpty();

    public int indexOf(Object value);

    public Object get(int index);

    public void set(int index, Object element);

    public void add(Object value);

    public void add(int index, Object value);

    public void remove(int index);

    public Iterator iterator();
}
