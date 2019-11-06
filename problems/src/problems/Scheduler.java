package problems;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> hours = new ArrayList<Integer>();
		int[] test = {2,2,1,3,4};
		for(int i=0;i<test.length;i++)
			hours.add(test[i]);
		List<Integer> optimal = new ArrayList<>();
		List<Integer> output = optimize(hours,hours, 8,optimal,0);
		System.out.println(output.toString());
	}
	
	public static List<Integer> optimize(List<Integer> hours, List<Integer> remHours, int time, List<Integer> optimal, int sum){
		int n = remHours.size();
		List<Integer> output = new ArrayList<>();
		if(time<0)
			return output;
		if(n==1) {
			if(remHours.get(0)+sum<time)
				optimal.add(remHours.get(0));
			else
				return optimal;
		}
		else
			for(int i=0;i<n;i++) {
				int ele = remHours.get(i);
				sum+=ele;
				if(sum<=time)
					optimal.add(ele);
				remHours.remove(i);
				List<Integer> list2 = optimize(hours, remHours.subList(i,n-1), time-ele,optimal, sum);
				optimal = optimal.size()>list2.size()?optimal:list2;
			}
		if(output.size()>optimal.size())
			output = optimal;
		optimal = new ArrayList<>();
		sum = 0;
		remHours  = hours;
		return output;
	}
	
	/*
	
	public static Node optimize(int[] hours, int remainingHours, Node root){
		int n = hours.length;
		for(int i=0;i<n;i++)
			
		
		return null;
	}
	
	class Node{
		int num;
		Node children;
		
		public Node(int num){
			this.num = num;
		}
	}
	*/

}
