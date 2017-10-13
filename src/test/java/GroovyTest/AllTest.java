package GroovyTest;



import java.io.File;

import org.junit.Test;
import org.junit.runner.JUnitCore;

public class AllTest {
	@Test
	public  void testall() {
		// TODO Auto-generated method stub
		//run(AccModule.class);
		//System.out.println(System.getProperty("user.dir"));
	/*	File file=new File(System.getProperty("user.dir"));
		//System.out.println(file.getParent());
		File files[]=file.listFiles();
		for(File fi:files){
			if(fi.isDirectory()){
				System.out.println(fi);
			}
		}
		File file-*/
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName().split("\\.")[1]);
		System.out.println(Thread.currentThread().getStackTrace()[1].getFileName());
		String filename=Thread.currentThread().getStackTrace()[1].getFileName();
		File file=new File(filename);
		String path=file.getAbsolutePath();
		System.out.println(path);
		System.out.println("-----------");
		System.out.println(file.getParent());
		File file1=new File(path);
		System.out.println(file.getParent());
		System.out.println(file.getParentFile());
		File files[]=file1.listFiles();
		for(File f:files){
			System.out.println(f);
			
		}
		
		
	}
	
	private static void run(Class<?>...classes){
		
	
		
		for(Class<?> cl:classes){
			JUnitCore runner=new JUnitCore();
			/*ExecutionListener1 listener=new ExecutionListener1();
			runner.addListener(listener);*/
			runner.run(cl);
			/*MyReusltRecorder recorder=listener.recorder;
			System.out.println(recorder);*/
		}
		
	}
}
