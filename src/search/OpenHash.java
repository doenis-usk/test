package search;

public class OpenHash<K,V> {
	
	enum Status{OCCUPIED,EMPTY,DELETED};
	
	static class Bucket<K,V>{
		K key;
		V data;
		Status stat;
		
		public Bucket(){
			stat = Status.EMPTY;
		}
		
		public void set(K key,V data,Status stat){
			this.key = key;
			this.data = data;
			this.stat = stat;
		}
		
		public void setStat(Status stat){
			this.stat = stat;
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
	Bucket<K,V>[] table;
	
	public OpenHash(int size){
		try{
			table = new Bucket[size];
			for(int i=0;i<size;i++){
				table[i] = new Bucket<K,V>();
			}
			this.size = size;
		}catch(OutOfMemoryError e){
			this.size = 0;
		}
	}
	
	int hashValue(Object key){
		return key.hashCode() % size;
	}
	
	int rehashValue(int hash){
		return (hash + 1) % size;
	}
	
	private Bucket<K,V> searchNode(K key){
		int hash = hashValue(key);
		Bucket<K,V> p = table[hash];
		
		for(int i=0;p.stat != Status.EMPTY && i<size; i++){
			if(p.stat == Status.OCCUPIED && p.getKey().equals(key)){
				return p;
			}
			hash = rehashValue(hash);
			p = table[hash];
		}
		return null;
	}
	
	V search(K key){
		Bucket<K,V> p = searchNode(key);
		if(p != null){
			return p.getValue();
		}else{
			return null;
		}
	}

	int add(K key,V data){
		if(search(key) != null){
			return 1;
		}
		int hash = hashValue(key);
		Bucket<K,V> p = table[hash];
		for(int i=0; i<size;i++){
			if(p.stat == Status.EMPTY || p.stat == Status.DELETED){
				p.set(key, data, Status.OCCUPIED);
				return 0;
			}
			hash = rehashValue(hash);
			p = table[hash];
		}
		return 2;
	}
	
	int remove(K key){
		Bucket<K,V> p = searchNode(key);
		if(p == null){
			return 1;
		}
		p.setStat(Status.DELETED);
		return 0;
	}
	
	void dump(){
		for(int i=0;i<size;i++){
			System.out.printf("%02d ",i);
			switch(table[i].stat){
			case OCCUPIED:
				System.out.printf("%s (%s)\n",table[i].getKey().toString(),table[i].getValue().toString());
				break;
			case EMPTY:
				System.out.println("--–¢“o˜^--");
				break;
			case DELETED:
				System.out.println("--íœÏ--");
				break;
			}
		}
	}
}
