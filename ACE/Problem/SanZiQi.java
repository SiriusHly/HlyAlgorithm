package Problem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class SanZiQi extends JFrame {
	/**
	 * ��������Ϸ����һ������JPanel��Ϊ������ʾ��������
	 * Cell��̳���JPanel�����Ķ������������һ������λ�ã�����ʱ�������Ǻ졢�ڷ�������������״
	 * ͬʱ������������ж���Ӯ���Ƿ��������̵ķ��������жϣ�����Ҫ��ӵ����¼�
	 * ����SanZiQi�������9��Cell����󻭳�һ�����̣�����ɨ�����̵ĸ�������λ�õ�״̬��
	 * �����ж��ж��Ƿ��������Ƿ�����Ӯ�ķ���
	 * @param args
	 */
	private String whoseTurn="red";//��¼��˭���ˣ�ȡֵΪ��red���ú췽�£�black���úڷ���
	private Cell[][] cells=new Cell[3][3];//9������λ�ã���9����Ԫ��ÿ����Ԫ����һ��JPanel
	private JLabel lblStatus=new JLabel("��red��...");//��ʾ��ǰ��״̬����red�£���black�£�red|blackӮ��ƽ��
	private JPanel qiPan=new JPanel();//���̣��Ǹ�JPanel
	public SanZiQi(){
		JPanel p=new JPanel();//���ڷ�������qiPan
		p.setLayout(new FlowLayout());
		qiPan.setLayout(new GridLayout(3,3,2,2));
		qiPan.setPreferredSize(new Dimension(300,280));
		qiPan.setBorder(new LineBorder(Color.BLUE,3));
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++){
				cells[i][j]=new Cell();
				qiPan.add(cells[i][j]);
			}
		Font font=new Font("����",Font.BOLD,40);
		lblStatus.setFont(font);
		this.add(lblStatus,BorderLayout.NORTH);
		this.add(p,BorderLayout.CENTER);
		p.add(qiPan);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//�ж��Ƿ�������
	public boolean isFull(){
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++){
				if(cells[i][j].getQiZiColor().equals("empty"))
					return false;
			}
		return true;
	}
	//�ж��Ƿ�Ӯ��
	public boolean isWon(String qiZi){
		//����ͬ����ɫ��һ��
		for(int i=0;i<3;i++){
			if(cells[i][0].getQiZiColor().equals(qiZi)&&cells[i][1].getQiZiColor().equals(qiZi)&&cells[i][2].getQiZiColor().equals(qiZi))
				return true;
		}
		//����ͬ����ɫ��һ��
		for(int j=0;j<3;j++){
			if(cells[0][j].getQiZiColor().equals(qiZi)&&cells[1][j].getQiZiColor().equals(qiZi)&&cells[2][j].getQiZiColor().equals(qiZi))
				return true;
		}
		//����ͬ����ɫ�����Խ�
		if(cells[0][0].getQiZiColor().equals(qiZi)&&cells[1][1].getQiZiColor().equals(qiZi)&&cells[2][2].getQiZiColor().equals(qiZi))
			return true;
		//����ͬ����ɫ�ĴζԽ�
		if(cells[0][2].getQiZiColor().equals(qiZi)&&cells[1][1].getQiZiColor().equals(qiZi)&&cells[2][0].getQiZiColor().equals(qiZi))
			return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SanZiQi game=new SanZiQi();
		game.setSize(500,400);
		game.setVisible(true);
		game.setResizable(false);
		game.setLocationRelativeTo(null);
	}
	public class Cell extends JPanel{
		String qiZiColor="empty";//��ʼΪempty,����췽���ˣ���Ϊred���ڷ�����Ϊblack
		public String getQiZiColor(){return qiZiColor;}
		public void setQiZiColor(String qiZiColor){
			//����������ɫʱ��Ҫ�ػ�
			this.qiZiColor=qiZiColor;
			repaint();
		}
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			if(qiZiColor.equals("red")){//�Ǻ췽�µ�
				g.setColor(Color.RED);
				//public abstract void fillOval(int x,int y,int width,int height)ʹ�õ�ǰ��ɫ������ָ�����ο����Բ�� 
				//������x - Ҫ�����Բ�����Ͻǵ� x ���ꡣy - Ҫ�����Բ�����Ͻǵ� y ���ꡣ
				//width - Ҫ�����Բ�Ŀ�ȡ�height - Ҫ�����Բ�ĸ߶ȡ�
				g.fillOval(10,10,getWidth()-20,getHeight()-20);
				//g.drawOval(10,10,getWidth()-20,getHeight()-10);
			}
			else if(qiZiColor.equals("black")){//�Ǻڷ��µ�
				g.setColor(Color.BLACK);
				g.fillOval(10,10,getWidth()-20,getHeight()-20);
			}
		}
		public Cell(){
			setBorder(new LineBorder(Color.BLACK,2));//���õ�Ԫ��ı߿�Ϊ��ɫ��2�����ؿ�
			this.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent me){
					if(!Cell.this.getQiZiColor().equals("empty")){
						return;
					}
						
					if(whoseTurn.equals("")){//Ϊ�գ���ʾ˫������������
						lblStatus.setText("��Ϸ����");
						return;
					}
					if(!whoseTurn.equals("")){
						setQiZiColor(whoseTurn);
					}
					if(isWon(whoseTurn)){
						lblStatus.setText(whoseTurn+" Ӯ�ˣ���Ϸ����");
						whoseTurn="";
					}else if(isFull()){
						lblStatus.setText("��Ϸ������ƽ�֣�");
						whoseTurn="";
					}else{
						whoseTurn=(whoseTurn.equals("red"))?"black":"red";
						lblStatus.setText("��"+whoseTurn+"��...");
					}
				}
			});
		}
	}

}
