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
    public Node deleteNode(Node root, int value) {
        if (root == null) return null;
        if (value < (int) root.value) {
            root.left = deleteNode(root.left, value);
        } else {
            if (value > (int) root.value) {
                root.right = deleteNode(root.right, value);
            } else {
                if (root.left == null) {
                    return root.right;
                } else {
                    if (root.right == null) {
                        return root.left;
                    }
                }
            }
            root.value = getMinValue(root.right);
            root.right = deleteNode(root.right,(int) root.value);
        }
        return root;
    }

    private Object getMinValue(Node root) {
        Object value = root.value;
        while (root.left!=null) {
            root = root.left;
            value = root.value;
        }
        return value;
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
