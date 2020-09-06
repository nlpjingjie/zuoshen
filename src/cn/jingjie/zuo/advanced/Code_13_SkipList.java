package cn.jingjie.zuo.advanced;

import java.util.ArrayList;
import java.util.Iterator;


// һ�����ݽṹ�����������ѯ�����롢ɾ����ʱ�临�Ӷ�ΪO(log n)����ƽ��������ӽ���
public class Code_13_SkipList {
	// ����ڵ���������ֵ������ÿ���Ӧ������ڵ�ļ���
	// ���ݺͲ����Ƿ�װ��һ���
	public static class SkipNode{
		public Integer value;
		public ArrayList<SkipNode> nextNodes;
		
		public SkipNode(Integer data) {
			value = data;
			nextNodes = new ArrayList<>();
		}
	} 
	
	// ʵ�ֲ��ң����룬ɾ��
	public static class SkipList{
		private SkipNode head; // �����ͷ�ڵ�
		private int maxLevel; // ��������㣬head��maxLevel�������ʼ����λ��
		private int size; // �����ԭʼ�����С�����Ƿ���������һ��(0��)
		private static final double probability = 0.5; // ��ӽڵ�ʱ�����������ĸ��ʡ�����ʹ����ƽ���ֲ�
		
		public SkipList() {
			// ͷ�ڵ��ֵ����Ҫ�����Գ�ʼ��Ϊ�����С����null
			this.head = new SkipNode(null);
			this.head.nextNodes.add(null);
			this.maxLevel = 0;
			this.size = 0;
		}
		
		public void add(Integer newValue) {
			if(!contains(newValue)) {
				size++;
				int level = 0;
				// �¼���ڵ���������Ĳ���
				while(Math.random() < probability) {
					level++;
				}
//				System.out.println(level);
				// ���maxLevelС��level��maxLevel����������level,��֤maxLevel������������
				while(level > maxLevel) {
					head.nextNodes.add(null);
					maxLevel++;
				}
//				System.out.println(maxLevel);
				SkipNode newNode = new SkipNode(newValue);
				SkipNode cur = head;
				// �����������������û������level=0Ҫ���½ڵ�ӽ�0��
				
				// �����������������
				int levelAll = maxLevel;
				do {
					cur = findNext(newValue, cur, levelAll);
					if(level >= levelAll) {
						// ��level���cur����һ���ڵ㴮��newNode��level�����
						newNode.nextNodes.add(0, cur.nextNodes.get(level));
						// level���cur����һ���ڸ�ΪnewNode
						cur.nextNodes.set(level, newNode);
						level--;
					}
				} while(levelAll-->0);
//				System.out.println(head.nextNodes.get(0).value);
			}
		}

		// �ҵ�ÿ��С��newValue�����һ��ֵ�Ľڵ�λ��
		private SkipNode findNext(Integer newValue, SkipNode cur, int level) {
			while(cur.nextNodes.get(level) != null && cur.nextNodes.get(level).value < newValue) {
				cur = cur.nextNodes.get(level);
			}
			return cur;
		}

		// �ж�Ҫ��ӵĽڵ��Ƿ��Ѿ�������������
		private boolean contains(Integer newValue) {
			if(size == 0) {
				return false;
			}
			int curLevel = maxLevel;
			SkipNode cur = head;
			
			// ����������
			while(curLevel > -1) {
				if(cur.nextNodes.get(curLevel) != null) {
					if(cur.nextNodes.get(curLevel).value == newValue) {
						return true;
					}else if(cur.nextNodes.get(curLevel).value < newValue) {
						cur = cur.nextNodes.get(curLevel);
					}else {
						// ��ǰ��û�ҵ�ȥ����һ��
						curLevel--;
					}
				}else {
					// �������Ԫ�أ���һ��
					curLevel--;
				}
			}
			return false;
		}
		
		// ���Ҹ�contains�Ĵ������һ��
		public boolean search(Integer newValue) {
			return false;
		}
		
		// ��������������У������ҵ���Ӧ�Ľڵ㣬Ȼ��ÿ���ǰ������
		public void delete(Integer newValue) {
			
		}
		
		// ����ʵ��һ������������0��ı����������,���������ճ���ģ�ѧϰ��һ���Լ�������������ʵ�ֵ�������
		class SkipListIterator implements Iterator<Integer> {
		    private SkipNode cur;
		    public SkipListIterator(SkipList skipList) {
		        this.cur = skipList.head;
		    }

		    @Override
		    public boolean hasNext() {
		        return cur.nextNodes.get(0) != null;
		    }

		    @Override
		    public Integer next() {
		        int value = cur.nextNodes.get(0).value;
		        cur = cur.nextNodes.get(0);
		        return value;
		    }
		}

		@Override
		public String toString() {
		    SkipListIterator iterator = new SkipListIterator(this);
		    String res = "[ ";
		    while (iterator.hasNext()) {
		        res += iterator.next()+" ";
		    }
		    res += "]";
		    System.out.println();
		    return res;
		}
	}
	
	 public static void main(String[] args) {
	        SkipList skipList = new SkipList();
	        skipList.add(1);
	        skipList.add(2);
	        System.out.println(skipList.size);
	        skipList.add(3);
	        skipList.add(4);
	        skipList.add(5);
	        System.out.println(skipList.size);
	        //mark a break point here to check the memory structure of skipList
	        System.out.println(skipList);
	    }
}
