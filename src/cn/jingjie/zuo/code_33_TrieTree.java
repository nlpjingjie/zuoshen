package cn.jingjie.zuo;

public class code_33_TrieTree {
	
	// 前缀树节点，以位置对应字符。一个前缀树节点，包括经过该节点的次数，以该节点结尾的次数，以及一个前缀树节点的集合(存储下一级的字符)
	public static class TrieNode{
		public int path;
		public int end;
		public TrieNode[] nexts;
		
		public TrieNode(){
			path = 0;
			end = 0;
			nexts = new TrieNode[26];
		}
	}
	
	// 前缀树，能够保存大量的字符串，并能够查询某个字符串添加的次数，以及以某个字符串为前缀的字符串个数
	public static class TrieTree{
		public TrieNode root;
		// 初始化一颗前缀树的root节点，代表整颗前缀树的起始
		public TrieTree() {
			root = new TrieNode();
		}
		
		// 往前缀树中插入节点
		public void insert(String w) {
			if(w == null) {
				return;
			}
			TrieNode node = root;
			char[] chs = w.toCharArray();
			int index = 0;
			for(int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if(node.nexts[index] == null) {
					node.nexts[index] = new TrieNode();
				}
				node = node.nexts[index];
				node.path++;
			}
			node.end++;
		}
		
		// 从前缀树中查询字符串,返回其被添加的次数
		public int search(String w) {
			if(w == null) {
				return 0;
			}
			TrieNode node = root;
			char[] chs = w.toCharArray();
			int index = 0;
			for(int i=0; i < chs.length; i++) {
				index = chs[i] - 'a';
				// 字符串中有任何字符不存在于前缀树，直接返回0
				if(node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.end;
		}
		
		// 从前缀树中查询以某字符串为前缀的字符个数
		public int prefixNumbers(String w) {
			if(w == null) {
				return 0;
			}
			TrieNode node = root;
			char[] chs = w.toCharArray();
			int index = 0;
			for(int i=0; i < chs.length; i++) {
				index = chs[i] - 'a';
				// 字符串中有任何字符不存在于前缀树，直接返回0
				if(node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.path;
		}
		
		// 从前缀树中删除某字符串
		public void delete(String w) {
			if(search(w) == 0) {
				return;
			}
			TrieNode node = root;
			int index = 0;
			char[] chs = w.toCharArray();
			for(int i=0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if(node.nexts[index] == null) {
					return;
				}
				node = node.nexts[index];
				node.path--;
			}
			node.end--;
		}
	}

	public static void main(String[] args) {
		TrieTree trie = new TrieTree();
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNumbers("zuo"));

	}
}
