package cl.uach.info090.clase1;

import java.util.*;

public class Word {
	private String word;
	private int count;
	
	public Word(String word, int count) {
		this.word = word;
		this.count = count;
	}
	
	public Word(String word) {
		this(word, 1);
	}
	
	public void counting() {
		count += 1;
	}
	
	public int getCount() {
		return count;
	}
	
	public String getWord() {
		return word;
	}
	
	public static void main(String[] args) {
	String line = "hallo, ich heiﬂe vera!";
	line = line.replaceAll("/p{Punct}", "");
	System.out.println(line);
	}
}
