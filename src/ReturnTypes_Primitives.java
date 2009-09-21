
/**
 *
 * @author muniek
 */
public class ReturnTypes_Primitives {

  int getInt() {
    char c = 0;
    return c;
  }

  double getDouble() {
    long l = 0;
    return l;
  }

  // possible lost of precission
  // nie mozna zwracac szerszego zakresu
  int getDouble2() {
    long l = 0;
    return l;
  }

  long getDouble3() {
    int l = 0;
    return l;
  }

  void Void() {

    if (true) {
      return; // return nothing and exit from method
    } else {
      // kod ponizej nie zostanie nigdy wykonany
      System.out.println("it can't be done");
    }
  }

  void Void_() {
    return; // return nothing
  }
}
