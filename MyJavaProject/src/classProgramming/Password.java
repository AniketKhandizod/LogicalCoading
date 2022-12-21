package classProgramming;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;  
public class Password {
	static Scanner SC;
	String Token; 
	public  Object[] CreateAccount() {
	    SC = new Scanner (System.in); 
		System.out.println("To Create Account Give ID = ");
		String ID = SC.nextLine();
		System.out.println("To Create Account Give ID = ");
		String Pass = SC.nextLine();
		
		return new Object[] {ID,Pass}; 
	}
	public String Login() {
		Object[] A = new Password().CreateAccount();				
		System.out.println("What is your User_name : ");    
		String User_name = SC.next().trim();	 		
		System.out.println("What is your Password : ");  
		String Password = SC.next().trim();                
		
		if ((User_name.equals(A[0])) && (Password.equals(A[1]))) {
			System.out.println("You login succesfully");
			return RandomStringUtils.randomAlphanumeric(100);
		}		
		else {
			System.out.println("Fail to login");
		}
		return null;
	}
	public void Verification() {
		Token=new Password().Login();
		String K=Token==(null)?("Fail"):(Token);
		System.out.println(K.replaceAll("[0-9]", ""));
		String Y = K.replaceAll("[^0-9]", "");
		long C = Long.parseLong(Y);
		System.out.println(C);
	}
	public void OpenFile() throws IOException, InterruptedException {
		String [] path = {"rundll32 url.dll,FileProtocolHandler ","C:\\Users\\anike\\Desktop\\Laugh.png"};
		File file = new File(path[1]);
		if(file.exists()) {
	        Process pro = Runtime.getRuntime().exec(path[0] + path[1]);
	        pro.waitFor(5,TimeUnit.SECONDS);
	        pro.exitValue();
		}else {
			System.out.println("File Not Found");
		}
		Desktop.getDesktop().open(file);
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		new Password().OpenFile();
		
	
		
		
	}
}