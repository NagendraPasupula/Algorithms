public class ReverseListRecursively extends LinkedList{
	Node reverseRecursive(Node head){
		if(head==null || head.next==null) return head;
		Node q= head.next;
		head.next =null;
		Node temp = reverseRecursive(q);
		q.next = head;
		return temp;
	}
	
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		l1.add(1);
		l1.add(4);
		l1.add(3);
		l1.add(2);
		l1.add(5);
		l1.add(2);
		ReverseListRecursively rl = new ReverseListRecursively();
		Node temp = rl.reverseRecursive(l1.head);
		while(temp !=null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
}
class LinkedList {
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
}