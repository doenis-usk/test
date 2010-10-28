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
		
		System.out.println("10進数を基数変換します．");
		do{
			do{
				System.out.print("変換する非負の整数：");
				no = stdIn.nextInt();
			}while(no < 0);
			
			do{
				System.out.print("何進数にしますか(2-36):");
				cd = stdIn.nextInt();
			}while(cd < 2 || cd > 36);
			
			dno = cardConvR(no,cd,cno);
			
			System.out.print(cd + "進数では");
			for(int i=dno-1;i>=0;i--){
				System.out.print(cno[i]);
			}
			System.out.println("です．");
			
			System.out.print("もう一度しますか(1・・・はい/0・・・いいえ):");
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
