package four_HuffmanNode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Huffman {
    public static HuffmanTree t=null;
    // 对字符串进行编码
    public String encode(String crunodeStr) {//定义一个结点字符串
        if (crunodeStr == null){//如果字符串为空，返回空
            return "";
        }
        List<HuffmanNode> leafNodes =new ArrayList<HuffmanNode>();//八叶子结点存放到数组中
        t=buildTree(crunodeStr, leafNodes);//把结点的字符串和叶子结点存到树中
        Map<Character, String> codeMap = buildEncodingInfo(leafNodes);
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : crunodeStr.toCharArray()){
            stringBuilder.append(codeMap.get(c));
        }
        return stringBuilder.toString();
    }
    // 对字符串进行译码  
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
                    currentNode=currentNode.getLeftChild();//等于0，为左孩子
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

    // 对每个字符进行编码，返回一个map集合
    private Map<Character, String> buildEncodingInfo(List<HuffmanNode> leafNodes) {
        Map<Character, String> codeWords = new HashMap<Character, String>();
        for (HuffmanNode leaf : leafNodes) {
            Character character = leaf.getChars().charAt(0);
            String code = "";
            HuffmanNode currentNode = leaf;
            //从尾向头开始遍历
            do {
                if (currentNode.isLeftChild()) {
                    code += "0";
                } else {
                    code += "1";
                }

                currentNode = currentNode.getParent();

            } while (currentNode.getParent() != null);
            //逆序输出编码
            code=new StringBuilder(code).reverse().toString();
            codeWords.put(character, code);
            System.out.println("结点 " + character + "  编码 : " + code);
        }
        System.out.println();
        return codeWords;
    }

    // 创建树的过程
    private HuffmanTree buildTree(String crunodeStr, List<HuffmanNode> leafs) {

        Map<Character, Integer> statistics = statistics(crunodeStr.toCharArray());

        Comparator<HuffmanNode> comparator = new Comparator<HuffmanNode>() {
            public int compare(HuffmanNode o1, HuffmanNode o2) {
                return o1.getWeight() - o2.getWeight();
            }
        };

        //通过有序队列，找头是最小的元素
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>();

        for (Character c : statistics.keySet()) {
            System.out.println("结点" + c + " 权值 " + statistics.get(c));
        }
        System.out.println();
        /*这种写法相当于foreach，，：后边是一个String数组，前面是一个String变量。。
         * 意思就是，在String数组里取一个数据，赋值给str。
         *。若不为空，则继续循环。为空退出循环。。这个空不是NULL，是没有值。。
         * 这是循环遍历的写法。。*/
        for (Character c : statistics.keySet()) {
            HuffmanNode node = new HuffmanNode();
            node.setChars(c.toString());//获取结点并输出
            //获得次数
            node.setWeight(statistics.get(c));//获取权值并输出
            leafs.add(node);   //每个字符都是叶子结点
            queue.add(node);

        }
        int size = queue.size();
        for (int i = 1; i < size; i++) {  //n - 1次
            HuffmanNode node1 = queue.poll();//入队
            HuffmanNode node2 = queue.poll();//入队

            HuffmanNode countNode = new HuffmanNode();//建一个新的实例,一个新的对象,
            countNode.setChars(node1.getChars() + node2.getChars());//第一个结点+第二个节点
            countNode.setWeight(node1.getWeight() + node2.getWeight());//第一个结点的权值+第二个

            countNode.setLeftChild(node1);
            countNode.setRightChild(node2);

            node1.setParent(countNode);
            node2.setParent(countNode);

            queue.add(countNode);
        }

        HuffmanTree tree = new HuffmanTree();
        tree.setRoot(queue.poll());   //最后一次只剩下一个结点变成根节点
        return tree;
    }

    // 通过频率设置权重
     
    private Map<Character, Integer> statistics(char[] charArray) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character c : charArray) {
            if (map.containsKey(c)) {   //查看map中是否存在c，如果存在就将权重加1
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
     }
//层次遍历
    public void LevelOrder(HuffmanTree t){
        HuffmanNode p=null;
        Queue<HuffmanNode> Q=new LinkedList<HuffmanNode>();
        if(t!=null)
            Q.offer(t.getRoot());//入队 调用获取的值
        while(!Q.isEmpty()){
            p=Q.poll();//出队列
            System.out.print(p.getChars()+" ");//输出获取的值
            if(p.getLeftChild()!=null)//左孩子不为空
                Q.offer(p.getLeftChild());//入队获取的左孩子
            if(p.getRightChild()!=null)//右孩子不为空
                Q.offer(p.getRightChild());//入队获取的右孩子
        }
    }

    public static void main(String[] args){
        System.out.println("请输入一段字符串");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));//建立从控制台输入的类,缓冲字符输入流，
        //包装字符流，将字符流放入缓存里，先把字符读到缓存里，到缓存满了或者你flush的时候，再读入内存
        try {
            String str = buffer.readLine();//读取一行
            Huffman huffmanCode = new Huffman();
            String encodeStr = huffmanCode.encode(str);
            System.out.println("哈夫曼编码：" + encodeStr);
            String y=huffmanCode.decode(encodeStr);
            System.out.println("对哈夫曼的译码为："+y);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}  