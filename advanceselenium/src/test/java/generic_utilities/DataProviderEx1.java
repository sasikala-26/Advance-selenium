package generic_utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
@Test(dataProvider="getData")
public void bookTickets(String src,String dest,int NoOfppl) {
	System.out.println("Books tickets from "+src+"to"+dest+"------->"+NoOfppl);
}
@DataProvider
public Object[][]getData(){
	Object[][]objArr=new Object[3][3];
	objArr[0][0]="Bangalore";
	objArr[0][1]="Goa";
	objArr[0][2]=10;
	
	objArr[1][0]="Bangalore";
	objArr[1][1]="Mysuru";
	objArr[1][2]=20;
	
	
	
	objArr[2][0]="Bangalore";
	objArr[2][1]="Hyd";
	objArr[2][2]=30;
	return objArr;
	
}
}
