
public class LinkedList<E> {
	private class Node {
		E value;

		Node next;

		Node(E value) {
			this.value = value;
		}
	}

	private Node rootNode;
	private int size;

	public LinkedList() {
		rootNode = null;
		size = 0;
	}

	public int insertEnd(E value) {
		Node node = new Node(value);
		size++;
		
		if(rootNode == null) {
			rootNode = node;
		} else {
			Node n = rootNode;
			while(n.next != null) {
				n = n.next;
			}
			
			n.next = node;
		}
		
		return size - 1;
	}
	
	public int insertStart(E value) {
		Node node = new Node(value);
		size++;
		
		if(rootNode == null) {
			rootNode = node;
		} else {
			node.next = rootNode;
			rootNode = node;
		}
		
		return 0;
	}
	
	public Node remove(E value) {
		Node n = rootNode;
		
		if(n == null) {
			return null;
		}
		
		if(n.value.equals(value)) {
			rootNode = n.next;
			return n;
		} else {
			while(n.next != null) {
				if(n.next.value.equals(value)) {
					Node toRemove = n.next;
					n.next = n.next.next;
					return toRemove;
				}
			}
		}
		
		return null;
	}
	
	public void insertAfter(E value, E afterValue) {
		Node n = rootNode;
		
		Node newNode = new Node(value);
		
		if(n == null) {
			rootNode = newNode;
		}
		
		if(n.value.equals(afterValue)) {
			Node nextNode = n.next;
			n.next = newNode;
			newNode.next = nextNode;
			rootNode = n;
		} else {
			while(n.next != null) {
				if(n.next.value.equals(afterValue)) {
					Node nextNode = n.next.next;
					n.next.next = newNode;
					newNode.next = nextNode;
				}
			}
		}
	}
	
	public void insertBefore(E value, E beforeValue) {
		Node n = rootNode;
		
		Node newNode = new Node(value);
		
		if(n == null) {
			rootNode = newNode;
		}
		
		if(n.value.equals(beforeValue)) {
			rootNode = newNode;
			rootNode.next = n;
		} else {
			while(n.next != null) {
				if(n.next.value.equals(rootNode)) {
					Node nextNode = n.next;
					n.next = newNode;
					newNode.next = nextNode;
				}
			}
		}
	}
}
