package service.impl;

import entity.ArrayList;
import entity.BinaryTree;
import entity.LinkedList;
import entity.List;
import service.BinaryTreeBuilder;
import service.Service;

/**
 * Created by DNAPC on 09.11.2017.
 */
public class ServiceImpl implements Service {

    private BinaryTreeBuilder binaryTreeBuilder;

    public ServiceImpl(){
        binaryTreeBuilder = new BinaryTreeBuilder();
    }

    @Override
    public List getList(String method) {
        if(method.equals("arrayList")){
            return new ArrayList();
        }
        if(method.equals("linkedList")){
            return new LinkedList();
        }
        return null;
    }

    @Override
    public Integer[] toIntegerArray(String[] values) {
        Integer[] integers = null;
        if(!values[0].equals("")) {
            integers = new Integer[values.length];
            for (int i = 0; i < values.length; i++) {
                integers[i] = Integer.parseInt(values[i]);
            }
        }
        return integers;
    }

    @Override
    public BinaryTree createBinaryTree(List list) {
        return binaryTreeBuilder.buildBinaryTree(list);
    }
}
