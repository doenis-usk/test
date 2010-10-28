package search;

public class ChainHash<K,V> {
	class Node<K,V>{
		K key;
		V data;
		Node<K,V> next;
	
		public Node(K key,V data,Node<K,V> next){
			this.key = key;
			this.data = data;
			this.next = next;
		}
		
		public K getKey(){
			return key;
		}
		
		public V getValue(){
			return data;
		}
		
		public int hashCode(){
			return key.hashCode();
		}
	}
	
	int size;
	Node<K,V>[] table;
	
	public ChainHash(int capacity){
		try{
			table = new Node[capacity];
			this.size = capacity;
		}catch(OutOfMemoryError e){
			this.size = 0;
		}
	}
	
	int hashValue(Object key){
		return key.hashCode() % size;
	}
	
	V search(K key){
		int hash = hashValue(key);
		Node<K,V> p = table[hash];
		
		while(p != null){
			if(p.getKey().equals(key)){
				return p.getValue();
			}
			p = p.next;
		}
		return null;
	}
	
	int add(K key,V data){
		int hash = hashValue(key);
		Node<K,V> p = table[hash];
		
		while(p != null){
			if(p.getKey().equals(key)){
				return 1;
			}
			p = p.next;
		}
		Node<K,V> temp = new Node<K,V>(key,data,table[hash]);
		table[hash] = temp;
		return 0;
	}
	
	int remove(K key){
		int hash = hashValue(key);
		Node<K,V> p = table[hash];
		Node<K,V> pp = null;
		
		while(p != null){
			if(p.getKey().equals(key)){
				if(pp == null){
					table[hash] = p.next;
				}else{
					pp.next = p.next;
				}
				return 0;
			}
			pp = p;
			p = p.next;
		}
		return 1;
	}
	
	void dump(){
		for(int i=0; i<size;i++){
			Node<K,V> p = table[i];
			System.out.printf("%02d ", i);
			while(p != null){
				System.out.printf("Å® %s (%s)",p.getKey().toString(),p.getValue().toString());
				p = p.next;
			}
			System.out.println();
		}
	}
}
