package hlc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CSVFileReader { // Hay que procesar un fichero csv

	private static boolean hasHeader;

    public CSVFileReader(boolean hasHeader) {
        this.hasHeader = hasHeader;
    }

    public static void readerCSV(String path) {
      try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
          String line;

          // Si hay una cabecera, leemos la primera línea y la ignoramos
          if (hasHeader) {
              reader.readLine();
          }

          // Lee cada línea del archivo CSV
          while ((line = reader.readLine()) != null) {
              // Utiliza el método parseCSVLine para dividir la línea correctamente
              String[] fields = parseCSVLine(line);

              // Procesa la línea y valida los campos
              try {
                  procesaLinea(line,fields);
              } catch (CSVFileReaderException e) {
                  // Maneja la excepción e imprime el mensaje de error
                  System.out.println("Error en la línea: " + e.getMessage());
              }
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

    
    
    
    // LA COMA FUNCIONA SI ESTA DENTRO DE COMILLAS LA PASSWORD
    private static String[] parseCSVLine(String line) {
      List<String> fields = new ArrayList<>();
      boolean inQuotes = false;
      StringBuilder fieldBuilder = new StringBuilder();

      for (char c : line.toCharArray()) {
          if (c == '"') {
              inQuotes = !inQuotes;
          } else if (c == ',' && !inQuotes) {
              fields.add(fieldBuilder.toString());
              fieldBuilder.setLength(0); // Reinicia el StringBuilder para el próximo campo
          } else {
              fieldBuilder.append(c);
          }
      }

      // Agrega el último campo
      fields.add(fieldBuilder.toString());

      return fields.toArray(new String[0]);
  }


    
    
    
    
    private static void procesaLinea(String linea, String[] campos) throws CSVFileReaderException {
        ValidarPersona validarPersona = new ValidarPersona();

        // Validaciones específicas para cada campo
        if (!validarPersona.esValidoTitulo(campos[0])) {
        	throw new CSVFileReaderException("título y la razon es: " + ValidarPersona.getError());
        }


        if (!validarPersona.esNombre(campos[1], 50)) {
            throw new CSVFileReaderException("nombre y la razon es: " + ValidarPersona.getError());
        }

        if (!validarPersona.esApellido(campos[2], 100)) {
            throw new CSVFileReaderException("apellido y la razon es: " + ValidarPersona.getError());
        }

        if (!validarPersona.esValidoTelefono(campos[3])) {
            throw new CSVFileReaderException("teléfono y la razon es: " + ValidarPersona.getError());
        }

        if (!validarPersona.esCodPostal(campos[4])) {
            throw new CSVFileReaderException("codigo postal y la razon es: " + ValidarPersona.getError());
        }
        
        if (!validarPersona.esCorreoElectronico(campos[5])) {
            throw new CSVFileReaderException("correo electronico y la razon es: " + ValidarPersona.getError());
        }
        
        if (!validarPersona.esUrl(campos[6])) {
            throw new CSVFileReaderException("URL y la razon es: " + ValidarPersona.getError());
        }
        
        if (!validarPersona.esUsuario(campos[7])) {
            throw new CSVFileReaderException("Usuario y la razon es: " + ValidarPersona.getError());
        }
        
        if (!validarPersona.esPassword(campos[8])) {
            throw new CSVFileReaderException("Password y la razon es: " + ValidarPersona.getError());
        }
         
        if (!validarPersona.esFechaRegistro(campos[9])) {
            throw new CSVFileReaderException("Registro y la razon es: " + ValidarPersona.getError());
        }
        
        // Si llegamos hasta aquí, la línea es válida
        System.out.println("Línea válida: " + linea);
    }
}
	


