package problems;
import java.util.HashMap;

public class MiddleCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, String> courses = new HashMap<>();
		courses.put("DS", "algo");
		courses.put("FCS", "OS");
		courses.put("CN", "CA");
		courses.put("algo", "FCS");
		courses.put("CA", "DS");
		courses.put("SD", "CN");
		findMiddleCourse(courses);
	}
	
	public static void findMiddleCourse(HashMap<String, String>courses){
		HashMap<String, String> children = new HashMap<>();
		int n = 0;
		for(String parent: courses.keySet()) {
			children.put(courses.get(parent), parent);
			n++;
		}
		String root = "";
		for(String parent: courses.keySet()) {
			if(!children.containsKey(parent)) {
				root = parent;
				break;
			}
		}
		String[] listOfCourses = new String[n+1];
		int i = 0;
		while(courses.get(root)!=null) {
			listOfCourses[i] = root;
			root = courses.get(root);
			i++;
		}
		listOfCourses[i] = root;
		System.out.println(listOfCourses[(n+1)/2]);
	}

}
