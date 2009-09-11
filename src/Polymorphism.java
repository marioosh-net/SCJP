/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muniek
 */
public class Polymorphism {

  public static void main(String[] args) {
    Puzon c = new Puzon();
    Gitara d = new Gitara();

    Soundable a;
    
    a = c;
    a.makeSound();  // tutaj wywola sie wersja makeSound() dla c
    a = d;
    a.makeSound(); // tutaj wywola sie wersja makeSound() dla d
  }
}


interface Soundable {
  void makeSound();
}

class Puzon implements Soundable {

  public void makeSound() {
    System.out.println("dzwiek puzona");
  }
}
class Gitara implements Soundable {

  public void makeSound() {
    System.out.println("dzwiek gitary");
    try {

      
    } catch ( java.lang.ArithmeticException e) {
      
    }
  }
}



