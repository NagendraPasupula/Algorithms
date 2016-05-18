
public class LinkedList {
	class Node{
		int value;
		Node next;
		Node(int x){
			value = x;
		}
	}
	Node head;
	public void add(int x){
		Node temp1 = head;
		Node temp = new Node(x);
		temp.next = null;
		if(head == null){
			head = temp;
		}else{
			while(temp1.next != null){
				temp1 = temp1.next;
			}
			temp1.next = temp;
		}
	}
	public Node reverse(Node list){
		Node l1 = list;
		Node l2 = list.next;
		list.next = null;
		while(l1!=null && l2!=null){
			Node temp = l2.next;
			l2.next = l1;
			l1=l2;
			if(temp != null)
				l2=temp;
			else
				break;
		}
		return l1;
	}
	void display(){
		Node temp = head;
		while(temp != null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
}
