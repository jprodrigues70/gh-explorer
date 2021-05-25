package Output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Csv {
	private static Csv instance;
	private FileWriter writer;
	private String filename;
	private int size = 0;
	
	private Csv() throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.filename = sdf.format(timestamp) + ".csv";
        System.out.println(filename + " started.");
		this.writer = new FileWriter(filename);
	}

	public static Csv getInstance() throws IOException {
		if (instance == null) {
			instance = new Csv();
		}
		return instance;
	}
	
	public void print(ArrayList<String> list) throws IOException {
		for (int i = 0; i < list.size(); i++) {
			this.writer.append(list.get(i));
		}
		this.size = this.size + list.size();
	}
	
	public void close(String header) throws IOException {

		try {
			this.writer.flush();
			this.writer.close();	

			RandomAccessFile f = new RandomAccessFile(new File(filename), "rw");
			f.seek(0); // to the beginning
			f.write(header.getBytes());
			f.close();
		} catch (IOException e) {
			
		}
        System.out.println("\n" + filename + " finished.");
        System.out.println(size + " lines added.");
	}
}
