package XuanTi_System;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Manager extends Home {

	public String xx, xy, bj, xm, xh, xt, dh, bh, mc, js, ss, es, lx, jj;
	public String path = "c:\\Data";
	public String path2 = "c:\\Data\\Account";
	public Manager(String xx, String xy, String bj, String xm, String xh, String xt, String dh, String bh, String mc,
			String js, String ss, String es, String lx, String jj) {
		this.xx = xx;
		this.xy = xy;
		this.bj = bj;
		this.xm = xm;
		this.xh = xh;
		this.xt = xt;
		this.dh = dh;
		this.bh = bh;
		this.mc = mc;
		this.js = js;
		this.ss = ss;
		this.es = es;
		this.lx = lx;
		this.jj = jj;
	}
	public Manager() {
		File file = new File(path);
		file.mkdirs();
		btnxg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				luru();
			}
		});

		btntj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				luru();
			}
		});
		
		btncx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chaxun();
			}
		});
		
		btnsc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				shanchu();
			}
		});
		
		btncz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtxx2.setText(null);
				//txtxx.setText(null);
				txtxh.setText(null);
				txtxy.setText(null);
				txtbj.setText(null);
				txtxm.setText(null);
				txtxh2.setText(null);
				txtxt.setText(null);
				txtdh.setText(null);
				txtbh.setText(null);
				txtmc.setText(null);
				txtjs.setText(null);
				txtss.setText(null);
				txtes.setText(null);
				txtlx.setText(null);
				txtjj.setText(null);
				txtmm.setText(null);
			}
		});
		
	}
	
	/*public String toString() {
		return xx + " " + xy + " " + bj + " " + xm + " " + xh + " " + xt + " " + dh + " " + bh + " " + mc + " " + js
				+ " " + ss + " " + es + " " + lx + " " + jj;
	}*/
	public void luru() {
		String xx3 = txtxx.getText();
		String xh3 = txtxh.getText();
		FileWriter fw ;
		File filelu = new File(path + "\\" + xx3);
		filelu.mkdirs();
		if (filelu.exists()) {
			if(xx3.length()>0&&xh3.length()>0){
			int ok = JOptionPane.showConfirmDialog(p5, "基本信息将被录入", "确定", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (ok == JOptionPane.YES_OPTION) {
				xx = txtxx2.getText();
				xy = txtxy.getText();
				bj = txtbj.getText();
				xm = txtxm.getText();
				xh = txtxh2.getText();
				xt = txtxt.getText();
				dh = txtdh.getText();
				bh = txtbh.getText();
				mc = txtmc.getText();
				js = txtjs.getText();
				ss = txtss.getText();
				es = txtes.getText();
				lx = txtlx.getText();
				jj = txtjj.getText();
				String str = xx + " " + xy + " " + bj + " " + xm + " " + xh + " " + xt + " " + dh + " " + bh + " " + mc + " " + js
						+ " " + ss + " " + es + " " + lx + " " + jj;
				try {
					fw = new FileWriter(filelu + "\\" + xh3 + ".txt");
					fw.write(str);
					fw.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			
			
			}
		}
			else{
				JOptionPane.showMessageDialog(null, "请输入学校或学号");
				if (txtxx.getText().length() <= 0 && txtxh.getText().length() <= 0) {
					txtxx.requestFocus();
				} else if (txtxx.getText().length() <= 0) {
					txtxx.requestFocus();
				} else if (txtxh.getText().length() <= 0) {
					txtxh.requestFocus();
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "文件不存在");
			
		}
	}

	
	public void chaxun(){
		FileReader fr = null;
		BufferedReader  br= null;
		String xx4 = txtxx.getText();
		String xh4 = txtxh.getText();
		File filecx = new File(path+"\\"+xx4+"\\"+xh4+".txt");
		File filemm = new File(path2+"\\"+xh4+".txt");
		if(filecx.exists()){
		if(xx4.length()>0&&xh4.length()>0){
		try {
			fr = new FileReader(filecx);
			br = new BufferedReader(fr);
			String s=br.readLine();
		    String s2[]=s.split(" ");
		    txtxx2.setText(s2[0]);
		    txtxy.setText(s2[1]);
		    txtbj.setText(s2[2]);
		    txtxm.setText(s2[3]);
		    txtxh2.setText(s2[4]);
		    txtxt.setText(s2[5]);
		    txtdh.setText(s2[6]);
		    txtbh.setText(s2[7]);
		    txtmc.setText(s2[8]);
		    txtjs.setText(s2[9]);
		    txtss.setText(s2[10]);
		    txtes.setText(s2[11]);
		    txtlx.setText(s2[12]);
		    txtjj.setText(s2[13]);
		   
		    fr = new FileReader(filemm);
			br = new BufferedReader(fr);
			String s3=br.readLine();
		    String s4[]=s3.split(" ");
		    txtmm.setText(s4[1]);
		   // System.out.println(s4[1]);
		    br.close();
		    fr.close();
		   
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
			
		}
		
		else{
			JOptionPane.showMessageDialog(null, "请输入学校或学号");
			if (xx4.length() <= 0 && xh4.length() <= 0) {
				txtxx.requestFocus();
			} else if (xx4.length() <= 0) {
				txtxx.requestFocus();
			} else if (xh4.length() <= 0) {
				txtxh.requestFocus();
			}
		}
		}
		else{
			JOptionPane.showMessageDialog(null,"该账号不存在");
		}
		
		
	}
	

	public void shanchu(){
		FileReader fr = null;
		BufferedReader  br= null;
		//String xx5 = txtxx.getText();
		//String xh5 = txtxh.getText();
		
		File filesc = new File(path+"\\"+txtxx.getText()+"//"+txtxh.getText()+".txt");
		
		//System.out.println(path+"\\"+xx5+"\\"+xh5+".txt");
		if(filesc.exists()){
			
				int ok2=JOptionPane.showConfirmDialog(p5, "点击'否'查看信息,点击'是'删除", "请再次确认信息是否删除", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				if(ok2==JOptionPane.YES_OPTION){
					
					filesc.delete();
					
					//System.out.println(path+"\\"+xx5+"\\"+xh5+".txt");
					JOptionPane.showMessageDialog(null, "删除成功");
				
					txtxx2.setText("");
					txtxh.setText("");
					txtxy.setText("");
					txtbj.setText("");
					txtxm.setText("");
					txtxh2.setText("");
					txtxt.setText("");
					txtdh.setText("");
					txtbh.setText("");
					txtmc.setText("");
					txtjs.setText("");
					txtss.setText("");
					txtes.setText("");
					txtlx.setText("");
					txtjj.setText("");
					txtmm.setText("");
					
					
				}
					else{
						
					
					
			try {
				fr = new FileReader(filesc);
				br = new BufferedReader(fr);
				String s=br.readLine();
			    String s2[]=s.split(" ");
			  
			    txtxx2.setText(s2[0]);
			    txtxy.setText(s2[1]);
			    txtbj.setText(s2[2]);
			    txtxm.setText(s2[3]);
			    txtxh2.setText(s2[4]);
			    txtxt.setText(s2[5]);
			    txtdh.setText(s2[6]);
			    txtbh.setText(s2[7]);
			    txtmc.setText(s2[8]);
			    txtjs.setText(s2[9]);
			    txtss.setText(s2[10]);
			    txtes.setText(s2[11]);
			    txtlx.setText(s2[12]);
			    txtjj.setText(s2[13]);
			    br.close();
			    fr.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			}
			
		else{
			JOptionPane.showMessageDialog(null, "该学号不存在");
		}
	}
	
	
	public void xiugai(){
		
	}
	public static void main(String[] args) {

	}

}
