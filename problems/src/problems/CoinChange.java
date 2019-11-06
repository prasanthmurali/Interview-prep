package problems;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(minCoins(list,4));
	}
	
	public static int minCoins(List<Integer> list, int price) {
		if(price==0)
			return 0;
		int res = 9999;
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i)<=price) {
				int subRes = minCoins(list,price-list.get(i));
				if(subRes<=res)
					res  = subRes + 1;
			}
		}
		return res;
			/*
			{
			 x = 1 + minCoins(list,price-list.get(i));
		}
		return x;
		*/
	}

}
