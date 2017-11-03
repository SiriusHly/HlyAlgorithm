package FieldTest;

import java.io.File;

public class DirectoryDemo {

	public DirectoryDemo() {
	}
	public static  boolean deleteDir(File dir){
		if(dir.isDirectory()){
			String []children = dir.list();
			for(int i=0;i<children.length;i++){
				boolean success = deleteDir(new File(dir,children[i]));
				if(!success){
					return false;
					
				}
			}
		}
		return dir.delete();
	}
	public static void main(String []args) {
		
		
	}

}
