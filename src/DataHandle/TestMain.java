package DataHandle;

import java.io.IOException;
import java.util.Scanner;

public class TestMain {
	static GetDataFromMySql mysql = new GetDataFromMySql();
	static int adminid=0;
	public static void main(String[] args) {
		String password=null;
		Scanner sc = new Scanner(System.in);
		System.out.println("*****����Ա��********");
		System.out.println("����������˺ţ�����");
		int Input_adminid = sc.nextInt();
		System.out.println("����������");
		String Input_password = sc.next();
		password=mysql.selectAdmin_ID_Password(Input_adminid);
		if(Input_password.equals(password)) {
			System.out.println("��½�ɹ�");
			mysql.displayGoods();
			
		}else if(password==null) {
			System.out.println("��������˺Ų�����");
		}else {
			System.out.println("����������벻��ȷ");
		}
		
	}
}
