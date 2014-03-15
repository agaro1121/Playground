package csvParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import com.googlecode.jcsv.util.CSVUtil;

public class CSV_Parser {
	private List<String[]> originalData = new ArrayList<String[]>();
	private File testFile = new File("testQuote.csv");
	private URL testURL;
	private String inputQuotes;

	public List<String[]> getQuotes(){
		List<String[]> newData = new ArrayList<String[]>();
		getFile();
		try {
			Reader reader = new FileReader("testQuote.csv");
			CSVReader<String[]> parser = CSVReaderBuilder.newDefaultReader(reader);
			originalData = parser.readAll();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			testFile.delete();
		}
		// 1. Implodes every String array in original Data delimited by comma
		// 2. Splits it into individual parts and those parts get their own array and are added to new Data array list
		// 3. As a result I can now access individual parts where I couldn't before
		for (String[] stringArray : originalData) {
			newData.add(CSVUtil.implode(stringArray, ",").split(","));
		}
		//		for (String[] string : newData) {
		//			System.out.println(string[3] +" "+string[0]+" $"+new DecimalFormat("#.##").format(Double.parseDouble(string[1]))); //can access individual parts now
		//		}
		//		System.out.println();

		return newData;
	}

	public void setQuotes(String quotes){
		inputQuotes=quotes.replace(" ", "+");
	}

	private void getFile(){
		try {
			testURL = new URL("http://finance.yahoo.com/d/quotes.csv?s="+inputQuotes+"&f=sl1p2n");
			FileUtils.copyURLToFile(testURL, testFile);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
