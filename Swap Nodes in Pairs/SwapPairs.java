


public class SwapPairs extends LinkedList{

	Node swap(Node head){
		if(head == null || head.next == null) return head;
			  Node swaphead = head.next;
			  Node p = head;
			  Node q = head;
			  Node r = head.next;
			  Node s = r.next;
			  while(r != null){
				  	p.next = r;
			    	r.next = q;
			    	q.next = s;
			    	p =q;
			    	q = p.next;
			    	r = (q !=null)?q.next:null;
			    	s = (r !=null)?r.next:null;
			  }
			  return swaphead;
	}
	public static void main(String[] args){
		LinkedList list1 = new LinkedList();
		SwapPairs sp= new SwapPairs();
			list1.add(1);
			list1.add(2);
			list1.add(3);
			list1.add(4);
			list1.add(5);
			list1.add(6);
		Node temp = sp.swap(list1.head);
		while(temp !=null){
			System.out.println(temp.value);
			temp = temp.next;
		}

	}
}
