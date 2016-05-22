
public class MergeLists extends LinkedList{

	Node mergesorted(Node l1, Node l2){
		Node p = l1;
		Node q = l2;
		Node result = new Node(0);
		Node result_head = result;
		int counter=0;
		if( p == null) return q;
		else if(q== null) return p;
		else{
		while(p!=null || q !=null){
			if(p == null || q==null){
				result.next = (p!=null)? p:q;
				if(p!=null) p=p.next;
				else q =q.next;
			}
			else if(p.value < q.value){
				result.next = p;
				p=p.next;
			}else {
				result.next=q;
				q=q.next;
			}
			if(counter==0){ result_head=result.next; counter++;}
			result =result.next;
			result.next=null;	
		}
		}
		return result_head;
	}
	public static void main(String args[]){
		LinkedList list1 = new LinkedList();
		MergeLists ml= new MergeLists();
		//	list1.add(1);
		//	list1.add(3);
			list1.add(2);
		LinkedList list2 = new LinkedList();
			list2.add(1);
		//	list2.add(4);
		//	list2.add(5);
		Node temp = ml.mergesorted(list1.head,list2.head);
		while(temp !=null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}	
}
