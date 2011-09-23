
import java.lang.Integer;

import java.util.PriorityQueue;
import java.util.Queue;

public class Debug {
	
  {
    System.out.println("2 instancyjne");
  }  // wykona sie przed utworzeniem obiektu (przed konstruktorem)


  static {
    System.out.println("1 statyczne");
  } // wykona sie jeszcze wczesniej, nawet bez tworzenia obiektu Debug


  public static void main(String args[]) {
      Queue<String> q = new PriorityQueue<String>();
      q.add("3");
      q.add("1");
      q.add("2");
      System.out.print(q.poll() + " ");
      System.out.print(q.peek() + " ");
      System.out.print(q.peek());
      
      new Debug().setX(2);
      

      
      
  }
  
  public Debug() {
	  t();
	  t();
  }
  

  int x = 1;
  
  static Object setX(int x) {
	  x += 1;
	  this.x = 2;
	  System.out.println(x);
	  return null;
  }
  
  Object t() {
	  return null;
  }
  
}


