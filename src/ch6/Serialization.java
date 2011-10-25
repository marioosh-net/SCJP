package ch6;

import java.io.*;

/**
 * ZASADY:
 *  1. klasa serializowana musi implementowac Serializable
 *  2. referencje do innych obiektow, ktore zawiera klasa musza byc rowniez Serializable,
 *     albo ustawione na transient (czyli nie serializowane - po deserializacji sa null!)
 *  3. proba serializowania obiektu nieserializowalnego rzuca wyjatek java.io.NotSerializableException
 *  4. class Object does NOT implement Serializable (Object nie jest serializowalny!)
 *  5. superclass serializable --> subclasses serializable
 *  6. dla nieserializowalnej superklasy jej skladowe nie bede serializowane nawet gdy serializuje sie
 *     podklase (wywolywany jest konstruktor dla superklasy i skladowe przyjmuja domyslne wartosci)
 *  7. przy serializacji tablic/kolekcji wszystkie ich skladowe musze by serializowalne
 *  8. statics are NOT serialized! (because they don't belong to the object)
 */
public class Serialization {

  public static void main(String[] args) {
    new Serialization().serialize();
    new Serialization().unserialize();
  }

  void serialize() {
    try {
      Book book = new Book("Hobbit");
      book.setAuthor(new Author("B.Prus"));
      Dog d = new Dog();
      book.stat1 = 14;
      
      FileOutputStream f = new FileOutputStream("book.ser");
      ObjectOutputStream o = new ObjectOutputStream(f);
      o.writeObject(book);
      o.writeObject(d);
      o.close();

      System.out.println("static before serialize: " + book.stat1);
      System.out.println("date before serialize: " + book.getDate());
      System.out.println("bar before serialize: " + book.bar.x);

      System.out.println("Dog name before serialize: " + d.name);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  void unserialize() {
    try {
      FileInputStream f = new FileInputStream("book.ser");
      ObjectInputStream o = new ObjectInputStream(f);
      Book book = (Book) o.readObject();
      Dog d = (Dog) o.readObject();
      o.close();

      System.out.println(book.getTitle());
      System.out.println("static after serialize: " + book.stat1);
      System.out.println("date after serialize: " + book.getDate());
      System.out.println("library after serialize: " + book.getLibrary().name);
      System.out.println("obj after serialize: " + (String) book.obj);
      System.out.println("bar after serialize: " + book.bar.x);

      System.out.println("Dog name after serialize: " + d.name);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

class Dom {
	
}
/**
 * interfejs Serializable nie wymaga definiowania zadnych metod, 
 * jest to tzw. marker interface
 */
class Book implements Serializable {

  private String title; // String is serializable
  private java.util.Date date;
  private Author author;
  private transient Library library = new Library("Biblioteka");
  transient Object obj = new Object();  // Object nie jest Serializable dlatego musi byc transient !!
  Bar bar = new Bar();
  static int stat1 = 10;
  
  static Dom dom = new Dom(); // ok, bo static, nie bedzie serializowany
  Dom dom1; // ok, bo null
  // Dom dom = new Dom(); // nie ok, bo not serializable => exception

  Book(String title) {
    this.title = title;
    this.date = new java.util.Date();
  }

  /**
   * RECZNA SERIALIZACJA:
   * redefiniecje metod do serializacji i deserializacji
   * i w nich recznie serializowac i deserializowac elementy nieserializowalne
   *  (nie implementujace Serializable lub transient)
   */
  private void writeObject(ObjectOutputStream os) {
    // metoda wykonywana przy serializacji
    try {
      os.defaultWriteObject();        // normalna serrializacja (jakby nie bylo redefinicji metody writeObject)
      os.writeUTF(this.library.name); // dodajemy recznie library do serializacji!
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void readObject(ObjectInputStream is) {
    // metoda wykonywana przy deserializacji
    try {
      is.defaultReadObject();   // normalna deserializacja (jakby nie bylo redefinicji metody readObject)

      String libName = is.readUTF();
      this.library = new Library(libName);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public java.util.Date getDate() {
    return this.date;
  }

  public void setAuthor(Author a) {
    this.author = a;
  }

  public Library getLibrary() {
    return this.library;
  }
}

class Author implements Serializable {

  private String name;

  Author(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

class Library {

  String name;

  Library(String name) {
    this.name = name;
  }
}

class Bar implements Serializable {

  transient int x = 42; // po deserializacja x bedzie rowny 0 !!!
  static int y = 10;	// statyczne nie sa serializowane - po deserializacji bedzie rowna tyle ile przed. 
}

/**
 *
 * Serializacja i dziedziecznie
 *
 * ZASADA - UWAGA!:
 *  jesli superklasa nie jest Serializable, a podklasa jest Serializable
 *  to skladowe dziedziczone z superklasy NIE BEDA serializowane i przyjma swe
 *  domyslne wartosci (wywolywany jest KONSTRUKTOR superklasy !)
 */
class Animal {

  public String name;

  Animal() {
    name = "Kotek";
  }
}

class Dog extends Animal implements Serializable {
// the rest of the Dog code

  Dog() {
    this.name = "Piesek";
  }
}

