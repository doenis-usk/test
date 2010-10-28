package basicAlgorithm;

import java.io.*;

public class Max3 {
	public static void main(String[] args){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try{
			String line = reader.readLine();
			int a = Integer.parseInt(line);
			line = reader.readLine();
			int b = Integer.parseInt(line);
			line = reader.readLine();
			int c = Integer.parseInt(line);
			int max = a;
			if(b > max) max = b;
			if(c > max) max = c;
			
			System.out.println(max);
		}catch(IOException e){
			System.out.println(e);
		}
	}
}
