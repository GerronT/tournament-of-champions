package toc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Utility {
	private static Tournament tr;
	
	public static void closeQuietly(ObjectOutputStream oos) {
		if (oos != null) {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void closeQuietly(ObjectInputStream ois) {
		if (ois != null) {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public static String listFiles(File path) {
		File[] listOfFiles = path.listFiles();
		String fileList = "";
		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
		    fileList += listOfFiles[i].getName() + "\n";
		  }
		}
		return fileList;
	}
	

}
