package service;

import entity.BinaryTree;
import entity.List;

/**
 * Created by DNAPC on 08.11.2017.
 */
public interface Service {
    public List getList(String method);
    public Integer[] toIntegerArray(String[] values);
    public BinaryTree createBinaryTree(List list);
}
