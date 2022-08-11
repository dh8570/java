package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass05 {
	public static void main(String[] args) {
		PrintStream ps = System.out;
		OutputStream os = ps;
		OutputStreamWriter osw = new OutputStreamWriter(os);
		try {
			osw.write(97);
			osw.write(44032);
			osw.write("\n");
			osw.write("aa");
			osw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
