package test1;


import java.io.*;

/**
 * 
 * Obiekty wewnetrzne nieserializowalne nie sa serializowane
 * ale musza byc oznaczone transient, bo inaczej poleci java.io.NotSerializableException
 *
 */
public class HotelSerializable implements Serializable {
	
	private Room room2 = new Room();			// java.io.NotSerializableException: test1.Room
    private transient Room room = new Room();
    
    public static void main(String[] args) {
        HotelSerializable h = new HotelSerializable();
        try {
            FileOutputStream fos = new FileOutputStream("HotelSerializable.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(h);
            oos.close();
            
            FileInputStream fis = new FileInputStream("HotelSerializable.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            HotelSerializable hd = (HotelSerializable) ois.readObject();
            System.out.println(hd.room);	// null (nie zostal zserializowany)
            // System.out.println(hd.room2);	// null (nie zostal zserializowany)
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}

class Room {
	int i = 1;
}