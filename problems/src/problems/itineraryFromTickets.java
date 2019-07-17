package problems;
import java.util.HashMap;
import java.util.Map;
public class itineraryFromTickets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> dataset = new HashMap<String, String>();
		dataset.put("Chennai", "Bangalore");
		dataset.put("Bombay","Delhi");
		dataset.put("Goa","Chennai");
		dataset.put("Delhi", "Goa");
		System.out.println(getItinerary(dataset));
	}

	private static String getItinerary(HashMap<String, String> dataset) {
		Map<String,String> reverseMap = new HashMap<String, String>();
		String start="";
		String itinerary = "";
		// TODO Auto-generated method stub
		for(Map.Entry<String,String> entry: dataset.entrySet()) {
			reverseMap.put(entry.getValue(), entry.getKey());
		}
		for(Map.Entry<String,String> entry: reverseMap.entrySet()) {
			if(!reverseMap.containsKey(entry.getValue())) {
				start = entry.getValue();
			}
		}
		while(dataset.get(start)!=null) {
			itinerary = itinerary + " " + start;
			start = dataset.get(start);
		}
		return itinerary + " " + start;
		
	}

}
