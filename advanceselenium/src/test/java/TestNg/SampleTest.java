package TestNg;

import org.testng.annotations.Test;

import generic_utilities.BaseClass;
public class SampleTest extends BaseClass{
@Test
public void createcontact() {
	
	System.out.println("hi");
}
@Test
public void modifycontact() {
	System.out.println("hai");
}
@Test
public void deletecontact() {
	System.out.println("hello");
}
}
