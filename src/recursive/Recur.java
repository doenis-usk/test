package recursive;

import java.util.*;

public class Recur {
	static void recur(int n) {
		while (n > 0) {
			recur(n - 1);
			System.out.println(n);
			n = n-2;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("®”‚ğ“ü—Í‚¹‚æ:");
		int x = stdIn.nextInt();

		recur(x);
	}

}
