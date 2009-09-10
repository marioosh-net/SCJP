
interface Device {

  public void doIt();
}

interface Device2 {

  public void doIt2();
}

public class Interfaces implements Device {

  public static void main(String args[]) {
    Test1 t = new Test1();
    Device d = new Test1();
    d.doIt();
    Device2 d2 = t;
    
  }

  public void doIt() {
  }
}

abstract class Phone1 extends Interfaces {
}

class Test1 implements Device, Device2 {

  public void doIt2() { }
  
  public void doIt() {
    System.out.println("ala ma kota");
  }
}

abstract class Phone2 extends Interfaces {

  public void doIt(int x) {
  }
}

class Phone3 extends Interfaces implements Device {

  public void doStuff() {
    for (int __x = 0; __x < 3; __x++);

  }
}
