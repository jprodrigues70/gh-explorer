package File;

import java.io.FileWriter;
import java.io.IOException;

public class Csv implements Files {
	private FileWriter writer;
	
	public Csv() throws IOException {
		this.writer = new FileWriter("./teste.csv");
		this.writer.close();
	}
}
