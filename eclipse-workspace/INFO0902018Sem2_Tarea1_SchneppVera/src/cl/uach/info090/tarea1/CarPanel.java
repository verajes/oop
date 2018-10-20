package cl.uach.info090.tarea1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CarPanel {
	private File gasFile;
	private File odoFile;
	private double tankCapacity;
	
	public CarPanel (File gasFile, File odoFile, double tankCapacity) {
		this.gasFile = gasFile;
		this.odoFile = odoFile;
		this.tankCapacity = tankCapacity;
	}
	
	
	public double lastGasStatus(){
		double status = 0;
		{try {
			BufferedReader reader = new BufferedReader(new FileReader(gasFile));
			String line = reader.readLine();
			String saveLine = "";
			while (line!=null) {
				saveLine = line;
				line=reader.readLine();
			}
			String[] split = saveLine.split(",");
			status = Double.parseDouble(split[1]);
			reader.close();
		} catch (IOException f) {
			f.printStackTrace();
		}}
		return status;
	}
	
	public double lastOdoStatus(){
		double status = 0;
		{try {
			BufferedReader reader = new BufferedReader(new FileReader(odoFile));
			String line = reader.readLine();
			String saveLine = "";
			while (line!=null) {
				saveLine = line;
				line=reader.readLine();
			}
			String[] split = saveLine.split(",");
			status = Double.parseDouble(split[1]);
			reader.close();
		} catch (IOException f) {
			f.printStackTrace();
		}}
		return status/1000;
	}
	
	public double lastSpeed() {
		double speed = 0;
		{try {
			BufferedReader reader = new BufferedReader(new FileReader(odoFile));
			String line = reader.readLine();
			String saveLine1 = "";
			String saveLine2 = "";
			while (line!=null) {
				saveLine2 = saveLine1;
				saveLine1 = line;
				line=reader.readLine();
			}
			String[] splitLine1 = saveLine1.split(",");
			String[] splitLine2 = saveLine2.split(",");
			String[] dateArray1 = splitLine1[0].split(" ");
			String[] dateArray2 = splitLine2[0].split(" ");
			String date1 = dateArray1[0];
			String date2 = dateArray2[0];
			String time1 = dateArray1[1];
			String time2 = dateArray2[1];
			String[] timeArray1 = time1.split(":");
			String[] timeArray2 = time2.split(":");
			
			double seconds1 = Double.parseDouble(timeArray1[2]);
			double seconds2 = Double.parseDouble(timeArray2[2]);
			
			double timeDifference = seconds1-seconds2;
			
			if (timeDifference<=15 && timeDifference>0 && date1.equals(date2) && timeArray1[0].equals(timeArray2[0]) && timeArray1[1].equals(timeArray2[1])) {
				double metres1 = Double.parseDouble(splitLine1[1]);
				double metres2 = Double.parseDouble(splitLine2[1]);
				double distance = metres1-metres2;
				speed = (distance/1000)/(timeDifference/3600);
			}elseif(){
				
			}
			reader.close();
		} catch (IOException f) {
			f.printStackTrace();
		}}
		
		return speed;
	}
	
	public double autonomyKms() {
		double kilometres =0;
		{try {
		BufferedReader readerMetres = new BufferedReader(new FileReader(odoFile));
		String lineMetres = readerMetres.readLine();
		
		String saveLineMetres2 = "";
		String saveLineMetres1 = "";
		while (lineMetres!=null) {
			saveLineMetres2 = saveLineMetres1;
			saveLineMetres1 = lineMetres;
			lineMetres=readerMetres.readLine();
		}
		
		String[] splitLineMetres1 = saveLineMetres1.split(",");
		String[] splitLineMetres2 = saveLineMetres2.split(",");
		String[] dateArrayMetres1 = splitLineMetres1[0].split(" ");
		String[] dateArrayMetres2 = splitLineMetres2[0].split(" ");
		String dateMetres1 = dateArrayMetres1[0];
		String dateMetres2 = dateArrayMetres2[0];
		String timeMetres1 = dateArrayMetres1[1];
		String timeMetres2 = dateArrayMetres2[1];
		String[] timeArrayMetres1 = timeMetres1.split(":");
		String[] timeArrayMetres2 = timeMetres2.split(":");
		
		double secondsMetres1 = Double.parseDouble(timeArrayMetres1[2]);
		double secondsMetres2 = Double.parseDouble(timeArrayMetres2[2]);
		
		double secondsDifferenceMetres = secondsMetres1 - secondsMetres2;
		
		if (secondsDifferenceMetres!=0 && secondsDifferenceMetres>15 && dateMetres1.equals(dateMetres2) && timeArrayMetres1[0].equals(timeArrayMetres2[0]) && timeArrayMetres1[1].equals(timeArrayMetres2[1])) {
			
		}
		
		
		BufferedReader readerGas = new BufferedReader(new FileReader(gasFile));
		String lineGas = readerGas.readLine();
		
		
		readerMetres.close();
		readerGas.close();
	} catch (IOException f) {
		f.printStackTrace();
	}}
		
		return kilometres;
	}
	
}
