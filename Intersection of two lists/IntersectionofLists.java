/**
 * A: 		 a1 → a2
                   	↘
                     c1 → c2 → c3
                   	↗            
   B:    b1 → b2 → b3
 * @author Venkata Nagendra Kumar Pasupula
 *
 */
public class IntersectionofLists extends LinkedList{
	Node intersection(Node headA, Node headB){
		if(headA==null || headB==null) return null;
		Node p = headA;
		Node q = headB;
		int len_A=0, len_B=0;
		while(p!=null || q!=null){
			if(p!=null){
				len_A++;
				p=p.next;
			}
			if(q!=null){
				len_B++;
				q=q.next;
			}
		}
		int diff = Math.abs(len_A-len_B);
		Node a = (len_A >= len_B)?headA:headB;
		Node b = (len_A < len_B)?headA:headB;
		for(int i=0;i< Math.max(len_A, len_B);i++){
			if(i<diff) a = a.next;
			else{
				if(a.value==b.value){
					return a;
				}else{
					a =a.next;
					b=b.next;
				}
			}
		}
		
		return null;
	}
public static void main(String[] args){
	LinkedList list1 = new LinkedList();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		list1.add(6);
		list1.add(8);
	LinkedList list2 = new LinkedList();
		list2.add(2);
		list2.add(4);
		list2.add(5);
		list2.add(6);
	IntersectionofLists il = new IntersectionofLists();
	Node temp = il.intersection(list1.head, list2.head);
	if(temp!=null)
	System.out.println("Lists intersect at Node "+temp.value);
	else
		System.out.println("Both lists do not intersect");
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
