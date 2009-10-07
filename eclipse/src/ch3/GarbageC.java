package ch3;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * ZASADA:
 *    An object is eligible for garbage collection when no live thread can access it
 *    Obiekt podlega "odśmiecaczowi", gdy żaden żywy wątek nie ma dostepu do tego obiektu
 *      (wykluczając String-i)
 *
 * zmienne lokalne (w metodzie) sa po zakonczeniu metody dostepne dla GC, chyba ze metoda
 * zwraca referencje do takiej zmiennej (obiektu) lokalnej.
 */
public class GarbageC {

  public static void main(String[] args) {

    Object o = new Object();
    o.toString();

    o = null; // teraz obiekt jest dostepny dla GC(garbace collector)

    Object o2 = getObj();
    // metoda zwraca obiekt, wiec lokalny Object d nie bedzie dostepny dla GC nawet po zakonczeniu metody
    //... complicated stuff...


    // wysepki
    Island x1 = new Island();
    Island x2 = new Island();
    Island x3 = new Island();
    x1.ref = x2;
    x2.ref = x3;
    x3.ref = x1;

    // to spowoduje ze pomimo istniejacych referencji do kazdego z obiektow (ref)
    // dostep ze swiata zwnetrznego jest zgubiony
    x1 = null;
    x2 = null;
    x3 = null;
    // GC wywali x1,x2,x3


    // suggest for garbage collections
    // to tylko zasugerowanie JVM, niekoniecznie to zadzaiala!!
    System.gc();
    new GarbageC().finalize();
  }

  public void finalize() {
    // zrob cos zanim obiekt zostanie usuniety przez GC
    // UWAGA: - nie zawsze ta metoda zostanie wykonana!!
    //        - metoda wykoynwana CO NAJWYZEJ raz dla danego obiektu
    //        - mozna spowodowac ze obiket moze zostac uratowany
    //          przez ta metode przed usunieciem przez GC
    System.out.println("finalize");
  }

  static Object getObj() {
    Object d = new Object();
    return d;
  }
}

class Island {
  Island ref;
}