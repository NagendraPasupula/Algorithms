import java.util.Arrays;

public class MergeKlist extends LinkedList{
	public Node mergeKLists(Node[] lists){
		int k= lists.length;
		if(k==0) return null;
		if(k==1) return lists[0];
		if(k==2) return mergelists(lists[0],lists[1]);
		else{
			return mergelists(mergeKLists(Arrays.copyOfRange(lists, 0, k/2)),mergeKLists(Arrays.copyOfRange(lists, (k/2), k)));
		}
	}
	Node mergelists(Node l1, Node l2){
		Node result = new Node(0);
		Node result_head = result;
		int counter=0;
		if( l1 == null) return l2;
		else if(l2== null) return l1;
		else{
		while(l1!=null || l2 !=null){
			if(l1 == null || l2==null){
				result.next = (l1!=null)? l1:l2;
				if(l1!=null) l1=l1.next;
				else l2 =l2.next;
			}
			else if(l1.value < l2.value){
				result.next = l1;
				l1=l1.next;
			}else {
				result.next=l2;
				l2=l2.next;
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
		MergeKlist ml= new MergeKlist();
			list1.add(1);
			list1.add(3);
			list1.add(8);
			list1.add(15);
		LinkedList list2 = new LinkedList();
			list2.add(2);
			list2.add(4);
			list2.add(5);
		LinkedList list3 = new LinkedList();
			list3.add(6);
			list3.add(7);
			list3.add(9);
		LinkedList list4 = new LinkedList();
			list4.add(10);
			list4.add(11);
			list4.add(12);
		
		Node[] list = {list1.head,list2.head, list3.head, list4.head};
		Node temp = ml.mergeKLists(list);
		while(temp !=null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}	
}
