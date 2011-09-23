package test1;

public class StaticMethods {

	public static void book() {
		cancelBooking();
	}

	public void cancelBooking() {
		book();
	}

}
