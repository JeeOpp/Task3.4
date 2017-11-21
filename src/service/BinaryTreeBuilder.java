package service;

import entity.BinaryTree;
import entity.List;

/**
 * Created by DNAPC on 18.11.2017.
 */
public class BinaryTreeBuilder{
    public BinaryTreeBuilder(){}

    public BinaryTree buildBinaryTree(List list){
        return new BinaryTree(list);
    }

}
