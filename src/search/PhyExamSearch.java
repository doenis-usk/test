package search;

import java.util.*;

public class PhyExamSearch {
	static class PhyscData{
		String name;
		int height;
		double vision;
		
		public PhyscData(String name,int height,double vision){
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
		
		public String toString(){
			return name + " " + height + " " + vision; 
		}
		
		public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
		
		private static class HeightOrderComparator implements Comparator<PhyscData>{
			public int compare(PhyscData d1,PhyscData d2){
				return (d1.height > d2.height) ? 1 :
					(d1.height < d2.height) ? -1 : 0;
			}
		}
	}
	
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		PhyscData[] x = new PhyscData[]{
			new PhyscData("�ԍ⒉�Y",162,0.3),
			new PhyscData("���l�ǈ�",168,0.4),
			new PhyscData("���x���Y",169,0.8),
			new PhyscData("���c�M��",171,1.5),
			new PhyscData("�����x��",173,0.7),
			new PhyscData("�l�c�N��",174,1.2),
			new PhyscData("�֓�����",175,2.0)
		};
		System.out.print("��cm�̐l��T���܂���:");
		int height = stdIn.nextInt();
		int idx = Arrays.binarySearch(x,new PhyscData("",height,0.0),PhyscData.HEIGHT_ORDER);
		if(idx<0){
			System.out.println("���̒l�̗v�f�͑��݂��Ă��܂���");
		}else{
			System.out.println("���̒l��" + "x[" + idx + "]�ɂ���܂�");
			System.out.println("�f�[�^:"+x[idx]);
		}
	}
}
