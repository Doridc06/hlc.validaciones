package hlc;

public class MainApp {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.err.println("Error! Debe proporcionar el nombre del fichero");
			return;
		}

		String fichero = args[0];
		
		CSVFileReader.readerCSV(fichero);
	}
}
