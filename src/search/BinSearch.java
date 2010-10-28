package search;

import java.util.*;

public class BinSearch {
	static int binSearch(int[] a,int n, int key){
		int pl=0;
		int pr=n-1;
		
		do{
			int pc=(pl+pr)/2;
			if(a[pc] == key){
				return pc;
			}else if(a[pc] < key){
				pl = pc+1;
			}else{
				pr = pc-1;
			}
		}while(pl <= pr);
		return -1;
	}
	
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("�v�f���F");
		int num = stdIn.nextInt();
		int[] x = new int[num];
		
		System.out.println("�����ɓ��͂��Ă�������");
		
		System.out.print("x[0]:");
		x[0] = stdIn.nextInt();
		
		for(int i=1;i<num;i++){
			do{
				System.out.print("x[" + i + "]:");
				x[i] = stdIn.nextInt();
			}while(x[i] < x[i-1]);
		}
		System.out.print("�T���l�F");
		int ky = stdIn.nextInt();
		
		int idx = binSearch(x,num,ky);
		
		if(idx == -1){
			System.out.println("���̒l�̗v�f�͑��݂��܂���");
		}else{
			System.out.println("���̒l��"+"x["+idx+"]�ɂ���܂�");
		}
	}
}
