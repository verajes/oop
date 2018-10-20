package cl.uach.info090.clase1;
		
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextField;
	
	import java.awt.Color;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
		
		
public class Actividad2_letzterVersuch implements ActionListener{
	static JFrame window;
	static JLabel label;
	static JTextField insert;
	static JButton button;
	
	public static void main(String[] args) {
		window = new JFrame ("Find the most frequent word of a document");
		window.setBounds(400, 200, 400, 200);
		window.setLayout(null);
		
		label = new JLabel ("Insert document: ");
		label.setBounds(50,20,150,30);
		insert = new JTextField(30);
		insert.setBounds(200,20,150,30);
		insert.setBackground(Color.white);
		button = new JButton ("Process");
		button.setBounds(50,70,300,30);
		
		window.add(label);
		window.add(insert);
		window.add(button);
		
		window.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filename = insert.getText();
				{try {
					BufferedReader reader = new BufferedReader(new FileReader(filename));
					String line = reader.readLine();
					ArrayList<Word> wordObjects = new ArrayList<Word>();
					while (line != null) {
						line = line.toLowerCase();
						line = line.replaceAll("[./!?:,;-_+*#'&%()]", " ");
						String lineWords[] = line.split("\\s+");
						for (int i=0; i<wordObjects.size(); i++) {
							for (int j=0; j<lineWords.length; j++){
								if (wordObjects[i].getWord()==lineWords[j]) {
									
								}
							}
						}
						line = reader.readLine();
					}
					reader.close();
				} catch (IOException f) {
					f.printStackTrace();
				}}
				
			}
		});
			
		}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	}

