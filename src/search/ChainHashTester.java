package search;

import java.util.*;

public class ChainHashTester {
	static Scanner stdIn = new Scanner(System.in);
	
	static class Data{
		public final static int NO = 1;
		public final static int NAME = 2;
		
		Integer no;
		String name;
		
		public Integer keyCode(){
			return no;
		}
		
		public String toString(){
			return name;
		}
		
		public void scanData(String guide,int sw){
			System.out.println(guide + "����f�[�^����͂��Ă�������");
			if((sw & NO) == NO){
				System.out.print("�ԍ�:");
				no = stdIn.nextInt();
			}
			if((sw & NAME) == NAME){
				System.out.print("���O:");
				name = stdIn.next();
			}
		}
	}
	
	public enum Menu{
		ADD("      �f�[�^�ǉ�"),
		REMOVE("   �f�[�^�폜"),
		SEARCH("   �f�[�^�T��"),
		DUMP("     �S�[�[�^�\��"),
		TERMINATE("�I��");
		
		private final String message;
		
		static public Menu MenuAt(int idx){
			for(Menu m:Menu.values()){
				if(m.ordinal() == idx){
					return m;
				}
			}
			return null;
		}
		
		Menu(String string){
			message = string;
		}
		
		public String getMessage(){
			return message;
		}
	}
	
	static Menu SelectMenu(){
		int key;
		do{
			for(Menu m:Menu.values()){
				System.out.printf("(%d) %s ", m.ordinal(),m.getMessage());
				if((m.ordinal()%3)==2 && m.ordinal() != Menu.TERMINATE.ordinal()){
					System.out.println();
				}
			}
			System.out.print(":");
			key = stdIn.nextInt();
		}while(key<Menu.ADD.ordinal() || key>Menu.TERMINATE.ordinal());
		
		return Menu.MenuAt(key);
	}
	
	public static void main(String[] args){
		Menu menu;
		Data data;
		Data temp = new Data();
		
		ChainHash<Integer,Data> hash = new ChainHash<Integer,Data>(13);
		
		do{
			switch(menu = SelectMenu()){
			case ADD:
				data = new Data();
				data.scanData("�ǉ�", Data.NO | Data.NAME);
				hash.add(data.keyCode(), data);
				break;
				
			case REMOVE:
				temp.scanData("�폜", Data.NO);
				hash.remove(temp.keyCode());
				break;
				
			case SEARCH:
				temp.scanData("�T��", Data.NO);
				Data t = hash.search(temp.keyCode());
				if(t != null){
					System.out.println("���̃L�[�����f�[�^��" + t.toString() + "�ł��D");
				}else{
					System.out.println("�Y������f�[�^�͂���܂���");
				}
				break;
				
			case DUMP:
				hash.dump();
				break;					
			}
		}while(menu != Menu.TERMINATE);
	}
}
