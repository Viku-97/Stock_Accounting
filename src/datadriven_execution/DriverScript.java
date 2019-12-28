package datadriven_execution;


import CommonFunLibrary.ERP_Functions;
import Utilities.ExcelFileUtil;

public class DriverScript {

	static String res;
	public static void main(String[] args) throws Exception {
		
		
		ExcelFileUtil exl= new ExcelFileUtil();
		int rowcount=exl.rowCount("Supplier");
		
		for(int i=1;i<=rowcount;i++){
			
			String SupplierName=exl.getData("Supplier", i, 0);
			String Address=exl.getData("Supplier", i, 1);
			String City=exl.getData("Supplier", i, 2);
			String Country=exl.getData("Supplier", i, 3);
			String ContactPerson=exl.getData("Supplier", i, 4);
			String PhoneNumber=exl.getData("Supplier", i, 5);
			String Email=exl.getData("Supplier", i, 6);
			String MobileNumber=exl.getData("Supplier", i, 7);
			String Notes=exl.getData("Supplier", i, 8);
			
			  res=ERP_Functions.lanchAPP("http://webapp.qedge.com/login.php");
	          res=ERP_Functions.login("admin", "master");
	          res=ERP_Functions.supplier(SupplierName, Address, City, Country, ContactPerson, PhoneNumber, Email, MobileNumber, Notes);
	          res=ERP_Functions.logout();
          
	          if(res.equalsIgnoreCase("Pass")){
	        	  exl.setData("Supplier", i, 9, "Pass");
	          }else{
	        	  exl.setData("Supplier", i, 9, "Fail");
	          }
		}
			
	}

}
