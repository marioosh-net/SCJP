import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Format {

	public static void main(String[] args) {
		int x = 8;
		int y = 3;

		System.out.printf("%d + %d \n", y, x); // stmt1
		System.out.printf("%f + %f \n", (float) y, (float) x);// stmt2
		System.out.printf("%d + %d \n", x, y);// stmt3
		System.out.format("%2$d + %1$d", x, y);// stmt4
		
		byte b=64;
		b += b;
		b= b + b;
		System.out.println(b);
		double d = (byte)1;

		 Set set = new TreeSet();
		        set.add(1);
		        set.add(2);
		        set.add("3");
		        
	}
}



class MyList {
	public static <X, Y extends X> void isPresent(X x, Y[] y){
		
	}
	
	public void takeList(List<? extends Object> l) {
		l.add(new Object());
	}
}
