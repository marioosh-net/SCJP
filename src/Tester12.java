import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface chewable {}

class Gum implements chewable {
	public void test(){}
}

/**
 * ja pierdole !
 * @author marioosh
 *
 */
public class Tester12 {

	public static void main(String[] args) {
		Map<Integer, Gum> m = new HashMap<Integer, Gum>();
		List<Gum> list1 = new ArrayList<Gum>();
		List list2 = list1;
		Map m2 = m;
		list1.add(new Integer(1));				// zle
		list2.add(new Integer(1));				// ale tak juz ok
		m.put(new Integer(1), new Animal());	// zle
		m2.put(new Integer(1), new Animal());	// ale tak juz ok
	}
}
class Animal {
	
}
                     