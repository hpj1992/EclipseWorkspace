package contact;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.imageio.stream.FileImageInputStream;

public class convert {

	public static void main(String[] a)
	{
		
		File folder = new File("F:\\Contacts_harshit\\Contacts");
		File[] listOfFiles = folder.listFiles();
		for(int i=0;i< listOfFiles.length;i++)
		{
		FileInputStream in = null;
		String temp=listOfFiles[i].getName();
		temp=temp.replace(".contact", "");
		try {
			in = new FileInputStream(listOfFiles[i]);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		OutputStream os = null;
		try {
			os = new FileOutputStream(temp+".vcf");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        byte[] buf = new byte[1024];
        int len;
        try {
			while((len=in.read(buf))>0){
			    os.write(buf,0,len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	System.out.println(file.getName().indexOf(".contact"));
		    	String temp=file.getName();
		    	temp=temp.replace(".contact", "");
		    	temp=temp+".vcf";
		    	
		    	
		    	
		    	FileOutputStream o;
				try {
					o = new FileOutputStream(temp);
					FileInputStream br=new FileInputStream(file);
					try {
						o.write(br.read());
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	
		    	//file.renameTo("F:\\Contacts_harshit\\Contacts\\");
		    	
		    	String temp=file.getName().substring(0, file.getName().indexOf(".contact"));
		    	temp+=temp+".vcf";
		    	
		    	File f=new File(temp);
		    	try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        System.out.println(temp);
		    }
		}*/
		}
	}
}
