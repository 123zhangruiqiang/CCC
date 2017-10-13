import java.io.File;

import org.junit.Test;
import org.junit.runner.JUnitCore;


public class TestAll {
	@Test
	public void test1() throws ClassNotFoundException{
		
		File path=new File(this.getClass().getClassLoader().getResource("").getPath());
		String s="zhangruqiiang";
		
		System.out.println(path);
		long timeBegin=System.currentTimeMillis();
		runCustom(path);
		long timeEnd=System.currentTimeMillis();
		System.out.println("本次方法的执行时间:"+(timeEnd-timeBegin)/1000+"s");
		/*File files[]=path.listFiles();
		String method=Thread.currentThread().getStackTrace()[1].getClassName();
		System.out.println(method);
		for(File f:files){
			if(f.isDirectory()||f.getName().contains(method)){
				continue;
				
			}
			//System.out.println(f.getName());
			run(Class.forName(f.getName().replace(".class", "")));
		}*/
	}
	
	@Test
	public void test2() {
		Thread.currentThread().getStackTrace()[1].getClassName();
		long timeBegin=System.currentTimeMillis();
		System.out.println(System.currentTimeMillis());
		long timeEnd=System.currentTimeMillis();
		System.out.println(timeEnd);
		
		System.out.println("本次方法的执行时间:"+(timeEnd-timeBegin)/1000);
	}
	private void runCustom(File file) throws ClassNotFoundException{
		
		File files[]=file.listFiles();
		String method=Thread.currentThread().getStackTrace()[1].getClassName();
		System.out.println(method);
		for(File f:files){
			if(f.isDirectory()||f.getName().contains(method)){
				continue;
				
			}
			//System.out.println(f.getName());
			run(Class.forName(f.getName().replace(".class", "")));
		}
	}
	
	
	private void run(Class<?>...classes){
		
		JUnitCore runner=new JUnitCore();
		runner.run(classes);
		
	}
	
}
