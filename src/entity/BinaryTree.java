package entity;

/**
 * Created by DNAPC on 18.11.2017.
 */
public class BinaryTree {
    private Node root;

    public BinaryTree(){
    }

    public BinaryTree(List list){
        fill(list);
    }

    public Node getRoot() {
        return root;
    }

    public void addNode(Object value){
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if ((Integer)value < (Integer)focusNode.value) {
                    focusNode = focusNode.left;
                    if (focusNode == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.right;
                    if (focusNode == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void fill(List list){
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            addNode(iterator.next());
        }
    }

    public void inOrderTraverseTree(StringBuilder line ,Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(line,focusNode.left);
            line.append(focusNode.value);
            inOrderTraverseTree(line,focusNode.right);
        }
    }

    public void preOrderTraverseTree(StringBuilder line ,Node focusNode) {
        if (focusNode != null) {
            line.append(focusNode.value);
            preOrderTraverseTree(line,focusNode.left);
            preOrderTraverseTree(line,focusNode.right);
        }
    }

    public void postOrderTraverseTree(StringBuilder line ,Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(line,focusNode.left);
            postOrderTraverseTree(line,focusNode.right);
            line.append(focusNode.value);
        }
    }

    static class Node {
        Object value;

        Node left = null;
        Node right = null;

        Node(Object value){
            this.value = value;
        }
    }
}
