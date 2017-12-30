package four_HuffmanNode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Huffman {
    public static HuffmanTree t=null;
    // ���ַ������б���
    public String encode(String crunodeStr) {//����һ������ַ���
        if (crunodeStr == null){//����ַ���Ϊ�գ����ؿ�
            return "";
        }
        List<HuffmanNode> leafNodes =new ArrayList<HuffmanNode>();//��Ҷ�ӽ���ŵ�������
        t=buildTree(crunodeStr, leafNodes);//�ѽ����ַ�����Ҷ�ӽ��浽����
        Map<Character, String> codeMap = buildEncodingInfo(leafNodes);
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : crunodeStr.toCharArray()){
            stringBuilder.append(codeMap.get(c));
        }
        return stringBuilder.toString();
    }
    // ���ַ�����������  
    public String decode(String crunodeStr){
        if (crunodeStr == null ) {
            return "";
        }
        char[] S=crunodeStr.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<S.length;){
            HuffmanNode currentNode=t.getRoot();
            while(currentNode.getRightChild()!=null&&currentNode.getLeftChild()!=null){
                if(S[i]=='0'){
                    currentNode=currentNode.getLeftChild();//����0��Ϊ����
                    i++;
                }
                else{
                    currentNode=currentNode.getRightChild();
                    i++;
                }
            }
            stringBuilder.append(currentNode.getChars());
        }
        return stringBuilder.toString();
    }

    // ��ÿ���ַ����б��룬����һ��map����
    private Map<Character, String> buildEncodingInfo(List<HuffmanNode> leafNodes) {
        Map<Character, String> codeWords = new HashMap<Character, String>();
        for (HuffmanNode leaf : leafNodes) {
            Character character = leaf.getChars().charAt(0);
            String code = "";
            HuffmanNode currentNode = leaf;
            //��β��ͷ��ʼ����
            do {
                if (currentNode.isLeftChild()) {
                    code += "0";
                } else {
                    code += "1";
                }

                currentNode = currentNode.getParent();

            } while (currentNode.getParent() != null);
            //�����������
            code=new StringBuilder(code).reverse().toString();
            codeWords.put(character, code);
            System.out.println("��� " + character + "  ���� : " + code);
        }
        System.out.println();
        return codeWords;
    }

    // �������Ĺ���
    private HuffmanTree buildTree(String crunodeStr, List<HuffmanNode> leafs) {

        Map<Character, Integer> statistics = statistics(crunodeStr.toCharArray());

        Comparator<HuffmanNode> comparator = new Comparator<HuffmanNode>() {
            public int compare(HuffmanNode o1, HuffmanNode o2) {
                return o1.getWeight() - o2.getWeight();
            }
        };

        //ͨ��������У���ͷ����С��Ԫ��
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>();

        for (Character c : statistics.keySet()) {
            System.out.println("���" + c + " Ȩֵ " + statistics.get(c));
        }
        System.out.println();
        /*����д���൱��foreach�����������һ��String���飬ǰ����һ��String��������
         * ��˼���ǣ���String������ȡһ�����ݣ���ֵ��str��
         *������Ϊ�գ������ѭ����Ϊ���˳�ѭ����������ղ���NULL����û��ֵ����
         * ����ѭ��������д������*/
        for (Character c : statistics.keySet()) {
            HuffmanNode node = new HuffmanNode();
            node.setChars(c.toString());//��ȡ��㲢���
            //��ô���
            node.setWeight(statistics.get(c));//��ȡȨֵ�����
            leafs.add(node);   //ÿ���ַ�����Ҷ�ӽ��
            queue.add(node);

        }
        int size = queue.size();
        for (int i = 1; i < size; i++) {  //n - 1��
            HuffmanNode node1 = queue.poll();//���
            HuffmanNode node2 = queue.poll();//���

            HuffmanNode countNode = new HuffmanNode();//��һ���µ�ʵ��,һ���µĶ���,
            countNode.setChars(node1.getChars() + node2.getChars());//��һ�����+�ڶ����ڵ�
            countNode.setWeight(node1.getWeight() + node2.getWeight());//��һ������Ȩֵ+�ڶ���

            countNode.setLeftChild(node1);
            countNode.setRightChild(node2);

            node1.setParent(countNode);
            node2.setParent(countNode);

            queue.add(countNode);
        }

        HuffmanTree tree = new HuffmanTree();
        tree.setRoot(queue.poll());   //���һ��ֻʣ��һ������ɸ��ڵ�
        return tree;
    }

    // ͨ��Ƶ������Ȩ��
     
    private Map<Character, Integer> statistics(char[] charArray) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character c : charArray) {
            if (map.containsKey(c)) {   //�鿴map���Ƿ����c��������ھͽ�Ȩ�ؼ�1
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
     }
//��α���
    public void LevelOrder(HuffmanTree t){
        HuffmanNode p=null;
        Queue<HuffmanNode> Q=new LinkedList<HuffmanNode>();
        if(t!=null)
            Q.offer(t.getRoot());//��� ���û�ȡ��ֵ
        while(!Q.isEmpty()){
            p=Q.poll();//������
            System.out.print(p.getChars()+" ");//�����ȡ��ֵ
            if(p.getLeftChild()!=null)//���Ӳ�Ϊ��
                Q.offer(p.getLeftChild());//��ӻ�ȡ������
            if(p.getRightChild()!=null)//�Һ��Ӳ�Ϊ��
                Q.offer(p.getRightChild());//��ӻ�ȡ���Һ���
        }
    }

    public static void main(String[] args){
        System.out.println("������һ���ַ���");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));//�����ӿ���̨�������,�����ַ���������
        //��װ�ַ��������ַ������뻺����Ȱ��ַ�������������������˻�����flush��ʱ���ٶ����ڴ�
        try {
            String str = buffer.readLine();//��ȡһ��
            Huffman huffmanCode = new Huffman();
            String encodeStr = huffmanCode.encode(str);
            System.out.println("���������룺" + encodeStr);
            String y=huffmanCode.decode(encodeStr);
            System.out.println("�Թ�����������Ϊ��"+y);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}  