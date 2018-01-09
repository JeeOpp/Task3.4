package entity;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by DNAPC on 03.01.2018.
 */
public class DeleteRootTest {

    @Test
    public void deleteRoot() throws Exception{
        StringBuilder modified = new StringBuilder();
        List list = new ArrayList(4, 2, 1, 3, 6, 5, 7);
        BinaryTree binaryTree = new BinaryTree(list);
        binaryTree.deleteNode(binaryTree.getRoot(),(Integer) binaryTree.getRoot().value);
        binaryTree.preOrderTraverseTree(modified, binaryTree.getRoot());
        Assert.assertEquals('5',modified.charAt(0));
    }
}
