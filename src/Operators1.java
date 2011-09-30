
public class Operators1
{
    public static void main(String args[ ] )
    {
       int[] iArr = {1};
       incr(iArr) ;
       System.out.println( "iArr[0] = " + iArr [ 0 ] ) ;
       System.out.println(iArr instanceof Object);	// true
       
    }
    public static void incr(int[ ] n ) { n [ 0 ]++ ; }
}