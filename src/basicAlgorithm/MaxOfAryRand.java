package basicAlgorithm;

import java.util.*;

public class MaxOfAryRand {
	public static void main(String[] args){
		Random r = new Random();
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("óvëfêîÇÕ:");
		int num = stdIn.nextInt();
		
		int[] a = new int[num];
		
		for(int i=0; i<num; i++){
			a[i] = r.nextInt();
			System.out.println("a["+ i + "]:"+ a[i]);
		}
		
		System.out.println("ç≈ëÂílÇÕ"+maxOf(a)+"Ç≈Ç∑ÅD");
		}
	
	static int maxOf(int[] a){
		int max = a[0];
		for(int i=0; i<a.length; i++){
			if(a[i]>max){
				max = a[i];
			}
		}
		return max;
	}
}
