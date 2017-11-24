package entity;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by DNAPC on 24.11.2017.
 */
public class LinkedListTest {
    private List linkedList = new LinkedList(5,4,3,2,1);

    @Test
    public void get() throws Exception {
        Object second = linkedList.get(1);
        Assert.assertEquals(4,second);
    }

    @Test
    public void add() throws Exception {
        linkedList.add(6);
        Assert.assertEquals(6,linkedList.get(5));
    }

    @Test
    public void remove() throws Exception {
        linkedList.remove(0);
        Assert.assertEquals(4,linkedList.get(0));
    }

}