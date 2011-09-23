package test1;

import java.util.*;

class Empty {   
}

class Extended extends Empty {  
}

public class Generics1 {    
        public static void doStuff1(List<Empty> list) {
                // some code
        }
        public static void doStuff2(List list) {        
                // some code
        }
        public static void doStuff3(List<? extends Empty> list) {
                // some code            
        }
        
        public static void main(String args[]) {
                List<Empty> list1 = new LinkedList<Empty>();
                List<Extended> list2 = new LinkedList<Extended>();
                
                // more code here
                
                doStuff1(list1);
                doStuff1(list2);	// typy generyczne musze sie DOKLADNIE zgadzac
                doStuff2(list1);                
                doStuff2(list2);
                doStuff3(list1);
                doStuff3(list2);
        }
}