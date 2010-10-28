package basicAlgorithm;

import java.util.*;

public class CardConvR {
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		int no;
		int cd;
		int dno;
		int retry;
		char[] cno = new char[32];
		
		System.out.println("10�i������ϊ����܂��D");
		do{
			do{
				System.out.print("�ϊ�����񕉂̐����F");
				no = stdIn.nextInt();
			}while(no < 0);
			
			do{
				System.out.print("���i���ɂ��܂���(2-36):");
				cd = stdIn.nextInt();
			}while(cd < 2 || cd > 36);
			
			dno = cardConvR(no,cd,cno);
			
			System.out.print(cd + "�i���ł�");
			for(int i=dno-1;i>=0;i--){
				System.out.print(cno[i]);
			}
			System.out.println("�ł��D");
			
			System.out.print("������x���܂���(1�E�E�E�͂�/0�E�E�E������):");
			retry = stdIn.nextInt();
		}while(retry == 1);
	}
	
	static int cardConvR(int x,int r,char[] d){
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do{
			d[digits++] = dchar.charAt(x%r);
			x /= r;
		}while(x != 0);
		return digits;
	}
}
