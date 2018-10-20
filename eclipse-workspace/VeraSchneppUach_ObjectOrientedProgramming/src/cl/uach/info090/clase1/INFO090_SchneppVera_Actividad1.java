package cl.uach.info090.clase1;

import javax.swing.JOptionPane;

public class INFO090_SchneppVera_Actividad1 {
	static String counting(String[] characters, String[] contadores) {
		String outputString;
		outputString = new String();
		for (int i = 0; i < characters.length; i++) {
			outputString = outputString + characters[i] + " " + contadores[i] + "\n";
		}
		return outputString;
	}

	public static void main(String[] args) {
		String[] contadores;
		contadores = new String[6];
		contadores[0] = "cententas de mil";
		contadores[1] = "decentas de mil";
		contadores[2] = "unidades de mil";
		contadores[3] = "cententas";
		contadores[4] = "decentas";
		contadores[5] = "unidades";
		String chifre = JOptionPane.showInputDialog("Ingresa una chifre entre 0 y 999999");
		if (chifre == null) {
			JOptionPane.showMessageDialog(null, "Has cancelado el programa... hasta luego!");
		}
		if (Integer.parseInt(chifre) < 0 || Integer.parseInt(chifre) > 999999) {
			JOptionPane.showMessageDialog(null,
					"El número ingresado debe ser igual o mayor de 0 y menor que 1.000.000");
		} else {
			String[] characters = chifre.split("");
			JOptionPane.showMessageDialog(null, "Cifras del numero " + "\n" + counting(characters, contadores));

		}

	}

}
