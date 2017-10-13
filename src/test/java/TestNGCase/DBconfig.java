package TestNGCase;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DBconfig {
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("zheshi beforesuite");
  }
  @AfterSuite
  public void aftersuite() {
	  System.out.println("zheshi aftersuite");
	  
  }
  @BeforeTest
  public void beforetest() {
	  System.out.println("zhehsi beforetest");
	  
  }
  @AfterTest
  public void aftertest() {
	  System.out.println("zheshi aftertest");
	  
	  
  }
}
