import java.util.LinkedList;

public class HashMap<K, V> {
	private static final int HASH_SIZE = 10;
	private LinkedList<Node<K, V>>[] hashArray;

	private static class Node<K, V> {
		private K key;
		private V value;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	public HashMap() {
		hashArray = new LinkedList[HASH_SIZE];
	}

	public void put(K key, V value) {
		int keyHash = getHashCode(key);

		LinkedList<Node<K, V>> linkedList = hashArray[keyHash];
		if (linkedList == null) {
			linkedList = new LinkedList<>();
		}

		linkedList.add(new Node<>(key, value));

		hashArray[keyHash] = linkedList;
	}

	public V get(K key) {
		int keyHash = getHashCode(key);

		LinkedList<Node<K, V>> linkedList = hashArray[keyHash];
		if (linkedList == null) {
			return null;
		}

		for (Node<K, V> node : linkedList) {
			if (node.key.equals(key)) {
				return node.value;
			}
		}

		return null;
	}
	
	public V remove(K key) {
		int keyHash = getHashCode(key);

		LinkedList<Node<K, V>> linkedList = hashArray[keyHash];
		if (linkedList == null) {
			return null;
		}
		
		int cnt = linkedList.size();
		
		for (int i = 0;i<cnt;i++) {
			Node<K,V> node = linkedList.get(i);
			if (node.key.equals(key)) {
				linkedList.remove(i);
				return node.value;
			}
		}

		return null;
	}

	private int getHashCode(K key) {
		int code = key.hashCode();
		code = code % HASH_SIZE;
		return code;
	}
}
