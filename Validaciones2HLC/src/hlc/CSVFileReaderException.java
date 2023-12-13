package hlc;

public class CSVFileReaderException extends RuntimeException {

	  public CSVFileReaderException(String string) {
	    super(string);
	  }

	  public CSVFileReaderException(Exception e) {
	    super(e);
	  }
}