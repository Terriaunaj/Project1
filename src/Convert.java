import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Convert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		public static void convertFile(String filename) throws IOException{
			
			try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			BufferedWriter bw = new BufferedWriter(new FileWriter("triplog.csv"));
			
			bw.write("Time, Latitude, Longitude\n");
			
			
			int time = 0;
			
//			ArrayList<String> data = new ArrayList<String>();

			String line;
			
			while((line = br.readLine()) != null) {	
				
				//System.out.println(line);
				
			if(line.contains("<trkpt")) {
				
				String s = line;
				
				String[] data = s.split("\"");
				
				String lat = data[1].replaceAll("[^0-9.-]","").trim();
				
				String lon = data[3].replaceAll("[^0-9.-]","").trim();
				
				bw.write(time + "," + lat + "," + lon + "\n");
				time += 5;
			}	
			}
			
			
			//.replace for ? and .trim for spaces or strip
			br.close();
			bw.close();
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
