package problems;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class employeesUnderEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> dataset = new HashMap<>();
		dataset.put("A", "C");
		dataset.put("B", "C");
		dataset.put("C", "F");
		dataset.put("E", "F");
		dataset.put("D", "E");
		dataset.put("F", "F");
		HashMap<Character, Integer> outputMap = numberOfEmployeesUnderEveryEmployee(dataset);
		for(Entry<Character, Integer> entry: outputMap.entrySet()) {
		System.out.println(entry.getKey() + " "+ entry.getValue());
	}
	}

	private static HashMap<Character, Integer> numberOfEmployeesUnderEveryEmployee(HashMap<String, String> dataset) {
		// TODO Auto-generated method stub
		HashMap<Character,Integer> outputMap = new HashMap<Character, Integer>();
		for(char s='A';s<='F';s++) {
			outputMap.put(s, 0);
		}
		for(Map.Entry<String, String> entry: dataset.entrySet()) {
			char dataKey = entry.getKey().charAt(0);
			char dataVal = entry.getValue().charAt(0);
			if(dataKey!=dataVal) {
				int key = outputMap.get(entry.getValue().charAt(0));
				int value = outputMap.get(entry.getKey().charAt(0));
				outputMap.put(entry.getValue().charAt(0), key+value+1);
			}
		}
		return outputMap;
	}

}
