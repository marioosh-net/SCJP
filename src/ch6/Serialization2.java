package ch6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization2 {
	public static void main(String[] args) {
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("account.ser"));
			o.writeObject(new Account1());	// ok
			o.writeObject(new Account2());	// java.io.NotSerializableException: ch6.Address
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Address {
}

class Account1 implements Serializable {
	private Address address;
}

class Account2 implements Serializable {
	private Address address = new Address();
}
