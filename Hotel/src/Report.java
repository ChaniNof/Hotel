import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Report {

//private static	String path="./c/מחשב זה/שולחן העבודה/fail.txt";
private static	String path="fail.txt";

	public static void createReport(String fileName,List<?> data) throws IOException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(fileName)));
			//write to the file
			out.writeObject(data.toString());
			//out.writeObject(data.getClass());
			//flush - transfer the data from the stream to the file
			out.flush();

		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("exception");
		}finally{
			if(out != null)
				out.close();
		}
	}
	private static List<?> readReport(String ReportName) throws IOException{
		ObjectInputStream in=null;
		List<?> data=null;
		try {
			in= new ObjectInputStream(new BufferedInputStream(new FileInputStream(ReportName)));
			data =(List<?>)in.readObject();
		}
		catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(in!=null) {
				in.close();//close the stream
			}
		}
		return data;
	}
}
