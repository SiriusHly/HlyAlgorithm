package ch14;

//package book.ch7;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
public class DirectoryDemo {
//ɾ��һ��Ŀ¼����Ҫ�ȵݹ�ɾ��Ŀ¼�µ������ļ�����Ŀ¼
  public static boolean deleteDir(File dir) {
    if (dir.isDirectory()) {
      String[] children = dir.list();
      for (int i = 0; i < children.length; i++) {
        boolean success = deleteDir(new File(dir, children[i]));
        if (!success) {
          return false;
        }
      }
    }
    return dir.delete();
  }

  public static void main(String[] args) {
    //�õ���ǰĿ¼
    //String curDir = System.getProperty("user.currentDir");
   String curDir = System.getProperty("user.dir");

    System.out.println("curDir = " + curDir);
    File currentDir = new File(curDir);
    File newDir = new File(curDir + File.separator + "newDir");
    //����һ����Ŀ¼
    boolean success = newDir.mkdir();
    if (success) {
      System.out.println("currentDir created");
    }

    //ɾ��Ŀ¼
    success = deleteDir(newDir);
    if (success) {
      System.out.println("currentDir deleted");
    }
/*
    //�õ�Ŀ¼�µ������ļ���Ŀ¼
    String[] children = currentDir.list();
    if (children == null) {
      System.out.println("current dir is empty");
    } else {
      for (int i = 0; i < children.length; i++) {
        String filename = children[i];
        System.out.println("filename = " + filename);
      }
    }
    //�õ�Ŀ¼�º�׺��".txt"�������ļ�
    FilenameFilter filter = new FilenameFilter() {
      public boolean accept(File dir, String name) {
        return !name.endsWith(".txt");
      }
    };
    children = currentDir.list(filter);

    File[] files = currentDir.listFiles();

    //�õ�������Ŀ¼
    FileFilter fileFilter = new FileFilter() {
      public boolean accept(File file) {
        return file.isDirectory();
      }
    };
    files = currentDir.listFiles(fileFilter);

    //�õ�ϵͳ�ĸ�Ŀ¼
    File[] roots = File.listRoots();
    for (int i = 0; i < roots.length; i++) {
      File root = roots[i];
      System.out.println("root = " + root);
    }
*/
  }
}
