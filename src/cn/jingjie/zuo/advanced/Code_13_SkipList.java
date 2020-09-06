package cn.jingjie.zuo.advanced;

import java.util.ArrayList;
import java.util.Iterator;


// 一种数据结构，跳表。跳表查询、插入、删除的时间复杂度为O(log n)，与平衡二叉树接近。
public class Code_13_SkipList {
	// 跳表节点包括自身的值和它的每层对应的跳表节点的集合
	// 数据和层数是封装在一起的
	public static class SkipNode{
		public Integer value;
		public ArrayList<SkipNode> nextNodes;
		
		public SkipNode(Integer data) {
			value = data;
			nextNodes = new ArrayList<>();
		}
	} 
	
	// 实现查找，插入，删除
	public static class SkipList{
		private SkipNode head; // 跳表的头节点
		private int maxLevel; // 跳表的最大层，head和maxLevel跳表的起始查找位置
		private int size; // 跳表的原始链表大小，就是非索引的那一层(0层)
		private static final double probability = 0.5; // 添加节点时，建立索引的概率。可以使索引平均分布
		
		public SkipList() {
			// 头节点的值不重要，可以初始化为最大，最小或者null
			this.head = new SkipNode(null);
			this.head.nextNodes.add(null);
			this.maxLevel = 0;
			this.size = 0;
		}
		
		public void add(Integer newValue) {
			if(!contains(newValue)) {
				size++;
				int level = 0;
				// 新加入节点包括索引的层数
				while(Math.random() < probability) {
					level++;
				}
//				System.out.println(level);
				// 如果maxLevel小于level将maxLevel提升至等于level,保证maxLevel代表跳表最大层
				while(level > maxLevel) {
					head.nextNodes.add(null);
					maxLevel++;
				}
//				System.out.println(maxLevel);
				SkipNode newNode = new SkipNode(newValue);
				SkipNode cur = head;
				// 逐层设置索引。就算没有索引level=0要把新节点加进0层
				
				// 从上往下搜索会更快
				int levelAll = maxLevel;
				do {
					cur = findNext(newValue, cur, levelAll);
					if(level >= levelAll) {
						// 把level层的cur的下一个节点串到newNode的level层后面
						newNode.nextNodes.add(0, cur.nextNodes.get(level));
						// level层的cur的下一个节改为newNode
						cur.nextNodes.set(level, newNode);
						level--;
					}
				} while(levelAll-->0);
//				System.out.println(head.nextNodes.get(0).value);
			}
		}

		// 找到每层小于newValue的最后一个值的节点位置
		private SkipNode findNext(Integer newValue, SkipNode cur, int level) {
			while(cur.nextNodes.get(level) != null && cur.nextNodes.get(level).value < newValue) {
				cur = cur.nextNodes.get(level);
			}
			return cur;
		}

		// 判断要添加的节点是否已经存在于跳表中
		private boolean contains(Integer newValue) {
			if(size == 0) {
				return false;
			}
			int curLevel = maxLevel;
			SkipNode cur = head;
			
			// 兼顾向后向下
			while(curLevel > -1) {
				if(cur.nextNodes.get(curLevel) != null) {
					if(cur.nextNodes.get(curLevel).value == newValue) {
						return true;
					}else if(cur.nextNodes.get(curLevel).value < newValue) {
						cur = cur.nextNodes.get(curLevel);
					}else {
						// 当前层没找到去往下一层
						curLevel--;
					}
				}else {
					// 本层后方无元素，下一层
					curLevel--;
				}
			}
			return false;
		}
		
		// 查找跟contains的代码基本一致
		public boolean search(Integer newValue) {
			return false;
		}
		
		// 如果存在在跳表中，首先找到对应的节点，然后将每层的前后重连
		public void delete(Integer newValue) {
			
		}
		
		// 遍历实现一个迭代器，将0层的遍历输出就行,这个函数是粘贴的，学习在一个自己定义的类中如何实现迭代器。
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
