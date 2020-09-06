package cn.jingjie.zuo;

public class code_33_TrieTree {
	
	// ǰ׺���ڵ㣬��λ�ö�Ӧ�ַ���һ��ǰ׺���ڵ㣬���������ýڵ�Ĵ������Ըýڵ��β�Ĵ������Լ�һ��ǰ׺���ڵ�ļ���(�洢��һ�����ַ�)
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
	
	// ǰ׺�����ܹ�����������ַ��������ܹ���ѯĳ���ַ�����ӵĴ������Լ���ĳ���ַ���Ϊǰ׺���ַ�������
	public static class TrieTree{
		public TrieNode root;
		// ��ʼ��һ��ǰ׺����root�ڵ㣬��������ǰ׺������ʼ
		public TrieTree() {
			root = new TrieNode();
		}
		
		// ��ǰ׺���в���ڵ�
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
		
		// ��ǰ׺���в�ѯ�ַ���,�����䱻��ӵĴ���
		public int search(String w) {
			if(w == null) {
				return 0;
			}
			TrieNode node = root;
			char[] chs = w.toCharArray();
			int index = 0;
			for(int i=0; i < chs.length; i++) {
				index = chs[i] - 'a';
				// �ַ��������κ��ַ���������ǰ׺����ֱ�ӷ���0
				if(node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.end;
		}
		
		// ��ǰ׺���в�ѯ��ĳ�ַ���Ϊǰ׺���ַ�����
		public int prefixNumbers(String w) {
			if(w == null) {
				return 0;
			}
			TrieNode node = root;
			char[] chs = w.toCharArray();
			int index = 0;
			for(int i=0; i < chs.length; i++) {
				index = chs[i] - 'a';
				// �ַ��������κ��ַ���������ǰ׺����ֱ�ӷ���0
				if(node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.path;
		}
		
		// ��ǰ׺����ɾ��ĳ�ַ���
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
