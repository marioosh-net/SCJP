package ch6;

public class Strings {

  static public void main(String[] args) {
    new Strings().immutable();
    new Strings().immuExample();
    new Strings().methods();
  }

  Strings() {
  }

  // NAJWAZNIEJSZE O STRINGACH:
  //  Strings are immutable (niezmienne) !
  //  (referencje moga sie zmieniac, ale sam obiekt String nie!)
  //
  // String class is final (cant class X extends String {...})
  //
  void immutable() {
    String s = "abc";
    s.concat("efg");  // tutaj jest tworzony nowy String, NIE zmienia sie stary!
    System.out.println("s = " + s);
    s.toUpperCase();  // tez jest tworzony nowy String, do ktorego nie mamy referencji
    System.out.println("s = " + s);

    s = s.concat("def");  // tworzymy nowy String: "abcdef" i przypisujemy stara referencje do niego
    System.out.println("s = " + s);
  }

  void immuExample() {
    String s1 = "spring ";
    String s2 = s1 + "summer ";
    s1.concat("fall ");
    s2.concat(s1);
    s1 += "winter ";
    System.out.println(s1 + " " + s2);
  }

  void methods() {
    String s = "tobi qwerty";
    String s2 = "TOBI qwerty";
    String s3 = "  T OBI qwerty   ";

    System.out.println(s.charAt(2)); // b
    System.out.println(s.concat(" dupa")); // tobi qwerty dupa
    boolean b;
    if (b = s.equalsIgnoreCase(s2)) {
      System.out.println(b); // true
    }

    System.out.println(s.length()); // 11
    //System.out.println( s.length ); // uwaga error !!!
    System.out.println(s.replace('t', 'T')); // Tobi qwerTy
    System.out.println(s.substring(5)); // qwerty
    System.out.println(s.substring(6, 8)); // we
    System.out.println(s2.toLowerCase()); // tobi qwerty
    System.out.println(s2.toUpperCase()); // TOBI QWERTY
    System.out.println(s2.toString()); // TOBI qwerty
    System.out.println(s3);         //   T OBI qwerty
    System.out.println(s3.trim());  // T OBI qwerty
  }
}

/**
 * StringBuffer  (thread safe)
 * StringBuilder (not thread safe - szybszy)
 */
class SBufferBuilder {

  static public void main(String[] args) {
    new SBufferBuilder();
  }

  SBufferBuilder() {
    StringBuffer sb = new StringBuffer("abc");
    sb.append("def");
    sb.append("def").reverse().insert(2, "33"); // mozna laczyc w lancuchy
    System.out.println("sb = " + sb);

    StringBuilder sbi = new StringBuilder("abc");
    sbi.append("def");
    sbi.append("def").reverse().insert(2, "33"); // mozna laczyc w lancuchy
    System.out.println("sb = " + sbi);

    /**
     * UWAGA!, nie mozna tak !!
     */
    StringBuffer b = new StringBuffer("abc"); /*
    b = "nowy string";  // ZLE */
    b = new StringBuffer("nowy string"); // dobrze
    

    /**
     * najważniejsze metody
     */
    StringBuffer s = new StringBuffer("abc");
    s.append("def");
    System.out.println(s);

    //s.delete(start_0-based, end_1-based);
    s.delete(1, 3); // usuwa z a[bc]def
    System.out.println(s);

    s = new StringBuffer("abc");
    //s.insert(offset, String)
    s.insert(1, "XXX"); // aXXXbc
    System.out.println(s);

    s = new StringBuffer("abc");
    System.out.println(s.reverse()); // cba

    System.out.println(s.toString()); // return cba

    /* UWAGA!
    s.toString().reverse(); // error. toString zwraca stringa a nie StringBuffer/StringBuilder */
    
  }
}

