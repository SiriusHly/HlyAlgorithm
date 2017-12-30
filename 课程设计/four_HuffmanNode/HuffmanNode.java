package four_HuffmanNode;


public class HuffmanNode implements Comparable<HuffmanNode> {

    private String chars = "";
    private int weight = 0;

    private HuffmanNode parent;//���ڵ�
    private HuffmanNode leftChild;//����
    private HuffmanNode rightChild;//�Һ���

    public int compareTo(HuffmanNode o) {
        return weight - o.getWeight();
    }
    //�Ƿ��Ǹ��ڵ�
    public boolean isRoot() {
        return parent == null;
    }
    //�Ƿ�������
    public boolean isLeftChild() {
        return parent != null && this == parent.leftChild;
    }
    //�Ƿ����Һ���
    public boolean isRightChile() {
        return parent != null && this == parent.rightChild;
    }
    //�Ƿ���Ҷ�ӽڵ�
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
