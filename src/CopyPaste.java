import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CopyPaste {
	public static void main(String[] args) throws IOException {

		System.out.println("abcd".substring(2, 2));
		System.out.println(new StringBuilder("abcd").insert(1, "X"));
		
		File f = new File("test.txt");
		FileWriter w = new FileWriter(f);
		BufferedWriter bf = new BufferedWriter(w);
		bf.write("ala ma kota");
		bf.newLine();
		w.write(2);
		w.append('\u2113');

		w.close();
		
	}
}
