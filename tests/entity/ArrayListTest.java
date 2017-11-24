package entity;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by DNAPC on 24.11.2017.
 */
public class ArrayListTest {
    private List arrayList = new ArrayList(5,4,3,2,1);

    @Test
    public void get() throws Exception {
        Object second = arrayList.get(1);
        Assert.assertEquals(4,second);
    }

    @Test
    public void add() throws Exception {
        arrayList.add(6);
        Assert.assertEquals(6,arrayList.get(5));
    }

    @Test
    public void remove() throws Exception {
        arrayList.remove(0);
        Assert.assertEquals(4,arrayList.get(0));
    }

}