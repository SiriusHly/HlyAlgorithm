package FieldTest;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.xml.crypto.Data;

public class FileDemo {

	public FileDemo() {
	}
	public static void main(String []args){
		String path ="f:"+File.separator+ File.separator+"book"+File.separator+"hly8.txt";
		System.out.println("path="+path);
		File file =new File(path);
		System.out.println("file.absolute="+file.getAbsolutePath());
		if(file.exists()){
			System.out.println("file exists");}
			else{
				System.out.println("file not exists");
		}
		boolean success = false;
		try{
		success=file.createNewFile();
		if(success){
			System.out.println("file create");
		}
		else{
			System.out.println("file not create");
			
		}
		}
		catch(IOException e){
			e.printStackTrace();
			
		}
		long fileLength=file.length();
System.out.println("fileLength="+fileLength);
if(success){
	System.out.println("file delete");
}
else
{
	System.out.println("file delete fail");
}
success = file.renameTo(new File("f:\\book\\dest.txt"));
if(success){
	System.out.println("file rename");
}
else {
	System.out.println("file not rename");
}
long lastModifiedTime=file.lastModified();
Date s = new Date(lastModifiedTime);
System.out.println("lastModifiedTime="+s);
//System.out.println("lastModifiedTime = " + new Date(lastModifiedTime));
	}
	}


