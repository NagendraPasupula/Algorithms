
public class AddList extends LinkedList {
	 public Node AddNumbers(Node l1, Node l2) {
	        Node temp=l1;
			Node temp1 = l2;
			Node result_head =null;
			Node result_tail=null;
			int counter=0;
			int carry = 0;
			while((temp != null || temp1 != null)){
				int x =0;
			if(temp != null && temp1 != null){
			 x = temp.value + temp1.value;	
			}else if(temp == null && temp1 != null){
			x = temp1.value;
			}else{
			x = temp.value;	
			}
			
			if(x>9 && carry == 0){
				carry = 1;
				x = x%10;
			}else if(x>=9 && carry != 0){
				x = (x%10)+carry;
				if(x>9){
					carry = 1;
					x = x%10;
				}
			}else{
				x = x+carry;
				carry =0;
			}
			Node result = new Node(x);
			if(counter==0){
			    result_head = result;
			    result_tail = result_head;
			    counter++;
			}else{
			    result_tail.next = result;
			    result_tail = result;
			}
			if(temp !=null){
			temp = temp.next;}
			if(temp1 !=null){
			temp1 = temp1.next;}
			if((temp == null && temp1 == null) && carry != 0){
				Node temp_carry = new Node(1);
				result_tail.next = temp_carry;
			}
			}
			return result_head;
	    }
	
	public static void main(String[] args){
		LinkedList ll = new LinkedList();
		AddList al= new AddList();
		for(int i=1;i<6;i++){
			ll.add(i);
		}
		LinkedList ll2 = new LinkedList();
		for(int i=6;i<10;i++){
			ll2.add(i);
		}
		Node temp = al.AddNumbers(ll.head,ll2.head);
		while(temp !=null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
}
