
/**
 * Remove the nth node from the end of list in one pass.
 * @author Venkata Nagendra Kumar Pasupula
 *
 */
public class RemoveNnode extends LinkedList{
	
	Node removenode(Node list, int n){
		Node p = list;
		Node q = list;
		int k=0;
		if(list == null){
			System.out.println("list is empty");
			return null;
		}
		else{
			for(int i=0;i<n;i++){
				if(q==null){
					System.out.println("Length of list is less than given node to remove");
					return null;
				}
				q = q.next;
			}
			if(q != null){
				k++;
			while(q.next != null){
				q= q.next;
				p=p.next;
			}
			}
			if((p.value == list.value) && (k==0)) list = list.next;
			else if(p.next.next != null) p.next = p.next.next;
			else p.next= null;
		}
		return list;
	}
	
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		RemoveNnode rem= new RemoveNnode();
			list.add(1);
			list.add(2);
			list.add(3);
			list.add(4);
			list.add(5);
			list.add(6);
		Node head = rem.removenode(list.head, 2);
		while(head != null){
			System.out.print(head.value+"->");
			head=head.next;
		}
	}	
	
}
