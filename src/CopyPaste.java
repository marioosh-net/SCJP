public class CopyPaste {

	public static void main(String[] args) throws Exception {
		// Soccer.main(args);

		XXXX.main(args);
	}
}

class XXXX {
	static int x = 5;
	public static void main(String[] args) {

		boolean b1 = false;
		boolean b2  = false;
		if (b2 = (b1 == false))
		{
		   System.out.println("true");
		} else
		{
		   System.out.println("false");
		}
		
		int count = 0, sum = 0;
		do
		{
			if(count % 3 == 0) continue;
			sum+=count;
		}
		while(count++ < 11);
		System.out.println(sum);
		
      int i, j, k;
      i = j = k = 9;
      System.out.println(i);
		
	}
	
	public RETURNTYPE methodX( byte by)	{
	    double d = 10.0;
	    return (long) by     /d*3;
	}


	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

}

class Game {
	public void play() {
		System.out.println("Playing...");
	}
}

class Soccer extends Game {
	public void play() {
		System.out.println("Playing Soccer...");
	}

	public static void main(String[] args) {
		Game g = new Soccer();
		g.play();

		for (int i = 0; i++ < 2; System.out.println(i), System.out.println(i))
			;
	}
}
