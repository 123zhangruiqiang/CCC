package TestNGCase;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;
@RunWith(Theories.class)
public class Demo {
  @Test
  public void test1() {
	  
	  System.out.println("zhangruiqiang");
	  
  }
  @Test(enabled=true,invocationCount=10,threadPoolSize=4)
  
  public void test2() {
	  
	  System.out.println("hahaha");
  }
  @Test(enabled=false)
  public void test3() {
	  System.out.println("zheshism ");
	  
  }
  
  @DataPoint
  public static String nameValue1 = "Tony";
  @DataPoint
  public static String nameValue2 = "Jim";
  @DataPoint    
  public static int ageValue1 = 10;
  @DataPoint
  public static int ageValue2 = 20;
  
  
  
  
  
  @Theory
  public void testMethod(String name, int age){
      System.out.println(String.format("%s's age is %s", name, age));
  }
}
