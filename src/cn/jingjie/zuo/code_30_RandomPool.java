package cn.jingjie.zuo;

import java.util.HashMap;

public class code_30_RandomPool {// 实现一个结构有insert,delete,getRandom方法
	public static class RandomPool<K>{// 编写泛型，需要定义泛型
		private HashMap<K, Integer> keyIndexMap;
		private HashMap<Integer, K> indexKeyMap;
		private Integer size;
		
		public RandomPool() {
			this.keyIndexMap = new HashMap<K, Integer>();
			this.indexKeyMap = new HashMap<Integer, K>();
			this.size = 0;// map的大小和编号
		}
		
		public void insert(K key) {// 不存在则插入
			if(!this.keyIndexMap.containsKey(key)) {
				this.keyIndexMap.put(key, this.size);
				this.indexKeyMap.put(this.size++, key);
			}
		}
		
		public void delete(K key) {// 将最后一个的序号改为被删除的序号，大小减1，保证序号索引连续
			Integer deleteIndex = this.keyIndexMap.get(key);
			Integer lastIndex = --this.size;// size减1，最后一个的拿不到，相当于删除
			K lastKey = this.indexKeyMap.get(lastIndex);
			this.keyIndexMap.put(lastKey, deleteIndex);
			this.indexKeyMap.put(deleteIndex, lastKey);
			this.keyIndexMap.remove(key);
			this.indexKeyMap.remove(lastIndex);
		}
		
		public K getRandom() {
			if(this.size == null) {
				return null;
			}
			Integer randomIndex = (int)(Math.random()*this.size); 
			return this.indexKeyMap.get(randomIndex);
		}
	}
/*public class code_30_RandomPool {

	public static class Pool<K> {
		private HashMap<K, Integer> keyIndexMap;
		private HashMap<Integer, K> indexKeyMap;
		private int size;

		public Pool() {
			this.keyIndexMap = new HashMap<K, Integer>();
			this.indexKeyMap = new HashMap<Integer, K>();
			this.size = 0;
		}

		public void insert(K key) {
			if (!this.keyIndexMap.containsKey(key)) {
				this.keyIndexMap.put(key, this.size);
				this.indexKeyMap.put(this.size++, key);
			}
		}

		public void delete(K key) {
			if (this.keyIndexMap.containsKey(key)) {
				int deleteIndex = this.keyIndexMap.get(key);
				int lastIndex = --this.size;
				K lastKey = this.indexKeyMap.get(lastIndex);
				this.keyIndexMap.put(lastKey, deleteIndex);
				this.indexKeyMap.put(deleteIndex, lastKey);
				this.keyIndexMap.remove(key);
				this.indexKeyMap.remove(lastIndex);
			}
		}

		public K getRandom() {
			if (this.size == 0) {
				return null;
			}
			int randomIndex = (int) (Math.random() * this.size); // 0 ~ size -1
			return this.indexKeyMap.get(randomIndex);
		}

	}*/

	public static void main(String[] args) {
		RandomPool<String> pool = new RandomPool<String>();
		pool.insert("zuo");
		pool.insert("cheng");
		pool.insert("yun");
		pool.delete("zuo");
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());

	}

}