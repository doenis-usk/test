package basicDataStructure;

import java.util.*;

public class Physical {
	final static int VMAX = 21;
	
	static class PhyscData{
		String name;
		int height;
		double vision;
		
		public PhyscData(String name,int height, double vision){
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
	}
	
	static double aveHeight(PhyscData[] dat){
		double sum=0;
		
		for(int i=0;i<dat.length;i++){
			sum += dat[i].height;
		}
		
		return sum/dat.length;
	}
	
	static void distVision(PhyscData[] dat, int[] dist){
		int i=0;
		
		dist[i]=0;
		for(i=0;i<dat.length;i++){
			if(dat[i].vision >= 0.0 && dat[i].vision <= VMAX/10.0){
				dist[(int)(dat[i].vision*10)]++;
			}
		}
	}
	
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		PhyscData[] x = new PhyscData[]{
				new PhyscData("A", 162, 0.3),
				new PhyscData("B", 173, 0.7),
				new PhyscData("C", 175, 2.0),
				new PhyscData("D", 171, 1.5),
				new PhyscData("E", 168, 0.4),
				new PhyscData("F", 174, 1.2),
				new PhyscData("G", 169, 0.8),
		};
		
		int[] vdist = new int[VMAX];
		
		System.out.println("■身体検査一覧表　■");
		System.out.println("氏名　　　　身長 視力");
		System.out.println("-----------------");
		for(int i=0; i<x.length;i++){
			System.out.printf("%-8s%3d%5.1f\n",x[i].name,x[i].height,x[i].vision);
		}
		System.out.printf("\n平均身長:%5.1fcm\n",aveHeight(x));
		
		distVision(x,vdist);
		
		System.out.println("\n視力の分布");
		for(int i=0;i<VMAX;i++){
			System.out.printf("%3.1f~:%2d人\n", i/10.0,vdist[i]);
			
		}
	}
	
	
}
