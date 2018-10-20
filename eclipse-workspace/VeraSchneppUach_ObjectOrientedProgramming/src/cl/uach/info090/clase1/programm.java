package cl.uach.info090.clase1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class programm {

	public static void main(String[] args) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("/Users/pankaj/Downloads/myfile.txt"));
			String line = reader.readLine();
			ArrayList<String> words = new ArrayList<String>();
			boolean exist = false;
			while (line != null) {
				String lineWords[] = line.split(" ");
				for (int i = 0; i < lineWords.length; i++) {
					for (int j = 0; j < words.size(); j++) {
						if (lineWords[i] == words.get(j)) {
							exist = true;
							break;
						}
					}
					if (exist == false) {
						words.add(lineWords[i]);
					} else {
						exist = false;
					}
				}
				// read next line
				line = reader.readLine();
			}
			int[] counterDifferentWords = new int[words.size()];
			while (line != null) {
				String lineWords[] = line.split(" ");
				for (int i = 0; i < lineWords.length; i++) {
					for (int j = 0; j < words.size(); j++) {
						if (lineWords[i] == words.get(j)) {
							counterDifferentWords[j] += 1;
							break;
						}
					}
				}
				// read next line
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
