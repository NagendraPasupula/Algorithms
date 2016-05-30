
public class Palindrome extends LinkedList{

	boolean isPalindrome(Node head){
		if(head==null || head.next==null) return true;
		if(head.next.next==null)  return (head.value==head.next.value)?true:false;
		Node p = head;
		Node q = head.next.next;
		while((q!=null) && (q.next!=null)){
			q = q.next.next;
			p=p.next;
		}
		q = (q!=null)?(p.next.next):p.next;
		Node dummyhead = new Node(0);
		dummyhead.next = q;
		Node prev = dummyhead;
		while(q.next !=null){
			Node r = q.next;
			q.next = r.next;
			r.next = prev.next;
			prev.next =r;
		}
		while(dummyhead.next != null){
			if (dummyhead.next.value!=head.value) return false;
			dummyhead =dummyhead.next;
			head=head.next;
		}
		return true;
	}
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		l1.add(1);
		l1.add(2);
		l1.add(1);
//		l1.add(5);
//		l1.add(3);
//		l1.add(2);
//		l1.add(1);
		Palindrome pal = new Palindrome();
		boolean k = pal.isPalindrome(l1.head);
		if(k) System.out.println("Palindrome");
		else System.out.println("Not Palindrome");
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