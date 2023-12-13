package hlc;

public class Validar {

	public Validar() {
	}

	public static boolean esVacio(String valor) {
		return (valor == null) || (valor.isEmpty());
	}

	public static boolean noEsVacio(String valor) {
		return !esVacio(valor);
	}

	public static boolean estaEnLaLista(String valor, String[] lista, boolean seUsa) {
		if (noEsVacio(valor)) {
			for (String actual : lista) {
				if (seUsa) {
					if (valor.equals(actual)) {
						return true;
					}
				}else {
					if (valor.equalsIgnoreCase(actual)) {
						return false;
					}
				}
			}
			return false;
		}else {
		return false;
		}
	}
	
	
	
	public static boolean tieneMaxCaracteres(String valor, int maxCaracteres) {
		if (valor.length() <= maxCaracteres) {
			return true;
		}
		return false;
	}
	
	
	
	
	 public static boolean esExpresionRegular(String valor, String expresion) {
		    return valor.matches(expresion);
		  }

	 
	
	
	public static boolean esURL(String valor) {
		if(valor.contains("https") || valor.contains("http")) {
			return true;
		}
		return false;
	}
	
	/*
	public static boolean esFechaValida(String valor) {
	      try {
	        LocalDate.parse(valor, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	        return true;
	      } catch (DateTimeParseException e) {
	        return false;
	      }
	  }
	
	*/
	
	
	
}
