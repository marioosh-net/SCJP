import java.util.HashMap;
import java.util.Map;

public class Exc {
	public static void main(String[] args) {
		System.out.println(new Exc().doit(1));

		map.put("a", 2);
		get("a");
	}

	private int doit(int x) {
		switch (x) {
		case 1:
			return 2;
		default:
			return 3;
		}

	}
	
	static Map<String, Integer> map = new HashMap<String, Integer>();
	static public int get(String b){
		return map.get(b);
	}

}

