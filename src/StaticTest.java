public class StaticTest
{
   static
   {
      System.out.println("static");
   }
   {
      System.out.println("nostatic");
   }
   public static void main(String args[ ])
   {
       System.out.println(" 1 ");
       StaticTest st1 = new StaticTest(); 
       System.out.println(" 2 ");
       StaticTest st2 = new StaticTest(); //3
   }
}
