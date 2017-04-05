package com.mkyong;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileExample1 {

	private static final String FILENAME = "/home/eadom/Desktop/writer.txt";

	public static void main(String[] args) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			String content = "This is the content to write into file\n";

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
