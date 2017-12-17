package DataHandle;

import java.io.IOException;
import java.util.Scanner;

public class TestMain {
	static GetDataFromMySql mysql = new GetDataFromMySql();
	static int adminid=0;
	public static void main(String[] args) {
		String password=null;
		Scanner sc = new Scanner(System.in);
		System.out.println("*****管理员端********");
		System.out.println("请输入管理账号：（）");
		int Input_adminid = sc.nextInt();
		System.out.println("请输入密码");
		String Input_password = sc.next();
		password=mysql.selectAdmin_ID_Password(Input_adminid);
		if(Input_password.equals(password)) {
			System.out.println("登陆成功");
			mysql.displayGoods();
			
		}else if(password==null) {
			System.out.println("你输入的账号不存在");
		}else {
			System.out.println("你输入的密码不正确");
		}
		
	}
}
