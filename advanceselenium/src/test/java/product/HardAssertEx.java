package product;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
@Test
	public void m1() {
		System.out.println("step1");
		System.out.println("step2");
		Assert.assertEquals("A","B");

		System.out.println("step3");
		System.out.println("step4");

	}
@Test
public void m2() {
	int exp=10;
	int act=10;
	Assert.assertEquals(act, exp);
	
}
@Test
public void m3() {
	int exp=10;
	int act=20;
	Assert.assertEquals(act, exp,"Asserts are not equal");
	System.out.println("Assert pass");
}
@Test
public void m4() {
	String exp="Qspiders";
	String act="Qspiders";
	Assert.assertNotEquals(act, exp,"Both are equal");
	System.out.println("both are not equal");
}

@Test
public void m5() {
	String exp="Qspiders";
	String act="Qspider";
	Assert.assertNotEquals(act, exp,"Both are equal");
	System.out.println("both are not equal");
}

@Test
public void m6() {
	String exp="Qspiders";
	String act="Qspiders";
	Assert.assertTrue(act.equalsIgnoreCase(exp),"AssertFail");
	System.out.println("Assert pass");
}


@Test
public void m7() {
	String exp="Qspiders";
	String act="Qspiders ";
	Assert.assertTrue(act.equalsIgnoreCase(exp),"AssertFail");
	System.out.println("Assert pass");
}
@Test
public void m8() {
	String exp="Qspiders";
	String act="Qspiders ";
	Assert.assertFalse(act.equalsIgnoreCase(exp),"AssertFail");
	System.out.println("Assert pass");
}
@Test
public void m9() {
	String exp="Qspiders";
	String act="Qspiders";
	Assert.assertFalse(act.equalsIgnoreCase(exp),"AssertFail");
	System.out.println("Assert pass");
}
@Test
public void m10() {
	String s=null;
	
	Assert.assertNull(s,"value is not null");
	System.out.println("value is null");
}
@Test
public void m11() {
	String s="qspiders";
	
	Assert.assertNull(s,"value is not null");
	System.out.println("value is null");
}
@Test
public void m12() {
	String s="qspiders";
	
	Assert.assertNotNull(s,"value is  null");
	System.out.println("value is not null");
}
@Test
public void m13() {
	String s=null;
	
	Assert.assertNotNull(s,"value is  null");
	System.out.println("value is not null");
}
@Test
public void m14() {
	String exp="Hello";
	String act="Hello";
	
	Assert.assertSame(act,exp,"Not same");
	System.out.println("values are same");
}
@Test
public void m15() {
	String exp="Hello";
	String act="Hi";
	
	Assert.assertSame(act,exp,"Not same");
	System.out.println("values are same");
}
@Test
public void m16() {
	int exp=10;
	int act=20;
	
	Assert.assertNotSame(act,exp,"same values");
	System.out.println("values are not same");
}
@Test
public void m17() {
	Assert.fail("i am failing the script");
}
}
