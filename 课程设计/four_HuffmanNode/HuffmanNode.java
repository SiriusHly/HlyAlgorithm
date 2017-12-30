package four_HuffmanNode;


public class HuffmanNode implements Comparable<HuffmanNode> {

    private String chars = "";
    private int weight = 0;

    private HuffmanNode parent;//父节点
    private HuffmanNode leftChild;//左孩子
    private HuffmanNode rightChild;//右孩子

    public int compareTo(HuffmanNode o) {
        return weight - o.getWeight();
    }
    //是否是根节点
    public boolean isRoot() {
        return parent == null;
    }
    //是否是左孩子
    public boolean isLeftChild() {
        return parent != null && this == parent.leftChild;
    }
    //是否是右孩子
    public boolean isRightChile() {
        return parent != null && this == parent.rightChild;
    }
    //是否是叶子节点
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public String getChars() {
        return chars;
    }

    public void setChars(String chars) {
        this.chars = chars;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public HuffmanNode getParent() {
        return parent;
    }

    public void setParent(HuffmanNode parent) {
        this.parent = parent;
    }

    public HuffmanNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(HuffmanNode leftChild) {
        this.leftChild = leftChild;
    }

    public HuffmanNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(HuffmanNode rightChild) {
        this.rightChild = rightChild;
    }

}
