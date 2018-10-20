package cl.uach.info090.clase1;

import javax.swing.JOptionPane;

public class INFO090_SchneppVera_Actividad2 {

	static String outputPalabras(int[] contadores) {
		String outputString;
		outputString = new String();
		for (int i = 0; i < contadores.length; i++) {
			outputString = outputString + "Palabras de largo " + (i + 1) + ": " + contadores[i] + "\n";
		}
		return outputString;
	}

	public static void main(String[] args) {
		String texto = JOptionPane.showInputDialog("Ingresa un texto: ");
		if (texto == null) {
			JOptionPane.showMessageDialog(null, "Has cancelado el programa... hasta luego!");
		} else {
			String[] palabras = texto.split(" ");
			int talleDePalabraMasLargo = 1;
			for (int i = 0; i < palabras.length; i++) {
				String[] unaPalabra = palabras[i].split("");
				if (unaPalabra.length > talleDePalabraMasLargo) {
					talleDePalabraMasLargo = unaPalabra.length;
				}
			}
			int[] contadores;
			contadores = new int[talleDePalabraMasLargo];
			for (int i = 0; i < palabras.length; i++) {
				String[] unaPalabra = palabras[i].split("");
				contadores[(unaPalabra.length) - 1] = contadores[(unaPalabra.length) - 1] + 1;
			}
			JOptionPane.showMessageDialog(null,
					"Número total de palabras: " + palabras.length + "\n" + outputPalabras(contadores));
		}
	}

}
