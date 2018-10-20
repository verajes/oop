package cl.uach.info090.clase1;

import java.io.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class INFO090_SchneppVera_Actividad_2 {

	public static void main(String[] args) {
		
		JFrame ventana = new JFrame("Ingresa documento");
		ventana.setBounds(450, 200, 450, 200);

		ventana.setLayout(null);
		ventana.setResizable(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		ventana.add(panel);

		JLabel label = new JLabel("Documento: ");
		label.setBounds(30, 30, 400, 30);
		ventana.add(label);

		JTextField file = new JTextField(30);
		ventana.add(file);

		JButton boton = new JButton("Procesar");
		boton.setBounds(30, 70, 400, 30);

		ventana.add(boton);
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filename = "test.txt";
				// file.getText();

				ArrayList<String> words = new ArrayList<String>();
				BufferedReader reader1;
				{
					try {
						reader1 = new BufferedReader(new FileReader(filename));
						String line = reader1.readLine();
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
							line = reader1.readLine();
						}
						reader1.close();
					} catch (IOException f) {
						f.printStackTrace();
					}
					int[] counterDifferentWords = new int[words.size()];
					BufferedReader reader2;
					{
						try {
							reader2 = new BufferedReader(new FileReader(filename));
							String line = reader2.readLine();
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
								line = reader2.readLine();
							}

							reader2.close();
						} catch (IOException g) {
							g.printStackTrace();
						}
						// List<String> lines = Arrays.asList("The first line", "The second line");
						// Path file = Paths.get("the-file-name.txt");
						// Files.write (<file, lines>);
						try {
							String str = "";
							/*class Word {
								String word; int amount;
							}
							public static void Word (String word; int amount) { 
						        this.word = word; 
						        this.amount = amount; 
						    } 
							ArrayList<Word> w = new ArrayList<Word>(); 
							for (int j = 0; j < words.size(); j++) {
								w.add(new Word(words.get(j), counterDifferentWords[j])); 
							}
							class Sortbyamount implements Comparator<Word> 
							{ 
							    public int compare(Student a, Student b) 
							    { 
							        return a.amount - b.amount; 
							    } 
							} 
							  
							Collections.sort(ar, new Sortbyamount()); 
							
							for (int i = 0; i < words.size(); i++) {
								str += (words.get(i) + ", " + counterDifferentWords[i] + "\n");
							} 
							*/
						
							BufferedWriter writer = new BufferedWriter(new FileWriter("texto_procesado.txt"));
							writer.write(str);

							writer.close();
						} catch (IOException h) {
							h.printStackTrace();
						}
					}
				}
				JLabel resumen = new JLabel("Numero de palabras distintas: " + words.size() + "\n" + "Palabra mas frecuente: " );
				label.setBounds(30, 30, 400, 30);
				ventana.add(label);
			}
		});

		ventana.setVisible(true);
		panel.setVisible(true);

	}
}
