/******
 * Hash Table
 *Time complexity : O(n)
 *Space complexity : O(n)
 *@author : Venkata Nagendra Kumar Pasupula
 */

import java.util.HashMap;
import java.util.Map;
public class TargetSum_Hash_open {
	int[] input = {1,2,3,4,5};
	public int[] target(int target){
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<input.length;i++){
			if(map.containsKey(target-input[i])){
				return new int[] {map.get(target-input[i]),i};
			}
			map.put(input[i], i);
		}
		return new int[] {0,0};
	}
	public static void main(String[] args){
		TargetSum st = new TargetSum();
		int[] temp = st.target(8);
		System.out.println("["+temp[0]+","+temp[1]+"]");
	}
}
