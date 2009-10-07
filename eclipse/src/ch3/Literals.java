package ch3;

/**
 *
 * @author muniek
 */
/**
 * zasady:
 *  wartosci bez kropki sa traktowane domyslnie jako int
 *  wartosci z kropka domyslnie traktowane sa jako double
 *  l - na koncu pozwala traktowac wartosc jako long
 *  f - na koncu pozwala traktowac zmienna jako float
 *  d - na koncu pozwala traktwoac zmienna jako double
 *
 *
 * Type Bits Bytes Minimum Range Maximum Range
 * byte   8   1     -2^7          2^7-1
 * short  16  2     -2^15         2^15-1
 * int    32  4     -2^31         2^31-1
 * long   64  8     -2^63         2^63-1
 * float  32  4     n/a           n/a
 * double 64  8     n/a           n/a
 */
public class Literals {

  static public void main(String[] a) {
    integers();
    longs();
    floatingPoints();
  }

  static void integers() {
    // decimal
    int i = 10;
    System.out.println(i);

    // octal - 0 na poaczątku oznacza liczbę ósemkową
    // 0101 = (od lewej) 1 * 8^0 + 0 * 8^1 + 1 * 8^2 + 0 * 8^3 = 65
    // 10 = (od lewej) 0 * 8^0 + 1 * 8^1 + 0 * 8^2 = 8
    // 70 = 7 * 8^1 = 56
    int j = 010; // 8
    System.out.println(j);

    //hexadecimal - 0x na początku
    int h = 0x0;
    h = 0xab0;
    h = 0Xab0; // x moze byc duzy
    h = 0xAffF1b0; // not case-sensitive (duze lub male literki)

    // takie przypisanie (dec,oct,hex) domyslnie traktuje wartosc jako int
    int max = 2147483647; // maksymalna wartosc int (2^31 - 1)
    int min = -2147483648; // minimalna wartosc int (- 2^31)
  }

  static void longs() {
    // zeby moc przpisac wieksze wartosci, trzeba uzyc l na koncu
    long k1 = 1333333333;  // dobrze (nie ma L na koncu ,ale miesci sie wartosc w zakresie inta)
    long k1 = 0111112231433333333333L;  // dobrze (L - na koncu oznacza wartosc long)
    long k3 = 0111112231433333333333l;  // dobrze (l - na koncu)
    long k2 = 0111112231433333333333;   // zle (integer too large)
  }

  static void floatingPoints() {
    // wartosci z kropka - defaults as double
    double k = 8882232.222323;

    // f,F - mozna przypisac do zmiennej float
    float f00 = 2;    // dobrze, nie ma przecinka nie musi byc f

    // error: possible lost of precision
    // you're trying to fit a number into a (potentially) less precise "container."
    float f0 = 8.22;  // zle 

    float f1 = 8882232.222323f;
    float f2 = 8882232.222323F;
  }

  static void booleans() {
    boolean t = true;  // Legal
    boolean f = 0;    // Compiler error!
  }

  static void characters() {
    char a = 's';
    char b = '@';
    char unicode_char = '\u004E'; // prefiks \u
    char t = 65535;

    // ZASADA: przenoszenie (konwersja) wiekszej wartosci do mniejszego kontenera (narrowing)
    // wymaga rzutowania, zeby przeszlo!
    char t1 = 70000; // error, 7000 jest poza zakresem char (2^16 = ok. 65000)
    char t2 = (char) 70000;

  }

  void otherInfos() {
    // identyczne
    byte b = 27;        // niejawne rzutowanie (robi je kompilator)
    byte c = (byte) 27; // jawne rzutowanie (cast) int na byte
    byte w1 = 127;      // rzutowanie int na byte (miesic sie w zakresie bajta)
    byte w2 = 128;      // przekracza byte!!

    // the result of an expression involving anything int-sized or smaller is always an int
    byte x = 32;
    byte y = 3;
    byte z = x + y; // error, bo wynik jest int, a int nie miesci sie w byte
    byte z2 = (byte) (x + y); // but this ok

    // jak widac to jest mozliwe, ale musi byc rzutowanie!
    float a1 = 1002321323123.00000000232321f;
    byte b1 = (byte) a1;

    int j1 = 3957.229; // error (niekompatybilne typy danych)
    int j = (int) 3957.229; // legal cast (obetnie po przecinku)
    System.out.println("int j = " + j); // int j = 3957

    // tutaj jest rzutowanie wiekszej wartosci na mniejsza
    // nastepuje obciecie reszty bitow ktore wykraczaja poza 8 najmlodszych
    // w efekcie czego na 8 bicie jest jedynka wskazujaca na wartosc ujemna
    long l = 130L;
    byte g = (byte) l;
    System.out.println("The byte is " + g); // The byte is -126

    // UWAGA: float faktycznie to double (niejawnie - implicitly) !!!!
    // jesli uzywamy zmiennej z przecinkiem i przypisujemy do float,
    // MUSIMY albo zrobic wyrazne rzutowanie, albo oznaczyc literka F
    float u = 2.23; // zle
    float u1 = 2.23f; // ok
    float u2 = (float) 2.23; // ok

    // ciekawy przyklad
    // ok
    byte b0 = 3;
    b0 += 7; // (operatory +=,-=,* = , and /= niejawnie rzutuja - implicitly casting)
    // ale to juz nie ok:
    byte bu = 3;
    bu = bu + 7;
    // ale to juz ok:
    byte bv = 3;
    bv = (byte) (bv + 7);

    // liczby bez zadnych znaczkow (f,d, bez kropki itd.) sa ZAWSZE domyslnie integerem!!!
    double ss1 = 2147483649;    // zle (domyslnie int)
    double ss2 = 2147483649.2;  // dobrze (domyslnie double, bo jest przecinek)
    double ss3 = 2147483649f;   // dobrze (float miesci sie w double)
  }
}
