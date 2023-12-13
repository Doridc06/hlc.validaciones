package hlc;

public class ValidarPersona {

	private static final String[] TITULOS_VALORES = { "Doctor", "Señor", "Señora" };
	private static final String EXPRESION_TELEFONO = "^[6-9]\\d{8}$";
	private static final String EXPRESION_USUARIO = "^[a-zA-Z0-9_-]{1,10}$";
	private static final String EXPRESION_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[.;,:/*&%$()])[A-Za-z\\d.;,:/*&%$()]{8,16}$";
	private static final String EXPRESION_COD_POSTAL = "^(0[1-9]|[1-4][0-9]|5[0-2])\\d{3}$";
	private static final String EXPRESION_EMAIL = "[a-zA-Z0-9_\\-]+@[a-zA-Z0-9_\\-]+(\\.[a-zA-Z0-9_\\-]+)*";
	private static final String EXPRESION_FECHA = "\\d{4}-\\d{2}-\\d{2}";

	
	private static String error = null;

	private void setError(String mensaje) {
		error = mensaje;
	}

	public static String getError() {
		return error;
	}

	public boolean esValidoTitulo(String valor) {
		if (Validar.noEsVacio(valor)) {
			if (Validar.estaEnLaLista(valor, TITULOS_VALORES, true)) {
				return true;
			} else {
				setError("El valor no esta en la lista");
				return false;
			}
		} else {
			setError("El valor esta vacio y es obligatorio");
			return false;
		}
	}

	public boolean esNombre(String valor, int maxCaracter) {
		if (Validar.noEsVacio(valor)) {
			if (Validar.tieneMaxCaracteres(valor, 50)) {
				return true;
			} else {
				setError("El formato no es correcto");
				return false;
			}
		} else {
			// El campo es obligatorio
			setError("El campo está vacío y es obligatorio");
			return false;
		}
	}

	public boolean esApellido(String valor, int maxCaracter) {
		if (Validar.noEsVacio(valor)) {
			if (Validar.tieneMaxCaracteres(valor, 100)) {
				return true;
			} else {
				setError("El formato no es correcto");
				return false;
			}
		} else {
			// El campo es obligatorio
			setError("El campo está vacío y es obligatorio");
			return false;
		}
	}

	public boolean esValidoTelefono(String valor) {
		if (Validar.noEsVacio(valor)) {
			if (Validar.esExpresionRegular(valor, EXPRESION_TELEFONO)) {
				return true;
			} else {
				setError("El formato no es correcto");
				return false;
			}
		} else {
			// El campo es obligatorio
			setError("El campo está vacío y es obligatorio");
			return false;
		}
	}

	public boolean esCodPostal(String valor) {
		if (Validar.noEsVacio(valor)) {
			if (Validar.esExpresionRegular(valor, EXPRESION_COD_POSTAL)) {
				return true;
			} else {
				setError("El formato no es correcto");
				return false;
			}
		} else {
			// El campo es obligatorio
			setError("El campo está vacío y es obligatorio");
			return false;
		}
	}

	public boolean esCorreoElectronico(String valor) {
		if (Validar.noEsVacio(valor)) {
			if (Validar.esExpresionRegular(valor, EXPRESION_EMAIL)) {
				return true;
			} else {
				setError("El formato no es correcto");
				return false;
			}
		} else {
			// El campo es obligatorio
			setError("El campo está vacío y es obligatorio");
			return false;
		}
	}

	public boolean esUrl(String valor) {
		if (Validar.esURL(valor)) {
			return true;
		} else {
			setError("El formato no es correcto");
			return false;
		}
	}

	public boolean esUsuario(String valor) {
		if (Validar.noEsVacio(valor)) {
			if (Validar.esExpresionRegular(valor, EXPRESION_USUARIO)) {
				return true;
			} else {
				setError("El formato no es correcto");
				return false;
			}
		} else {
			// El campo es obligatorio
			setError("El campo está vacío y es obligatorio");
			return false;
		}
	}

	public boolean esPassword(String valor) {
		if (Validar.noEsVacio(valor)) {
			if (Validar.esExpresionRegular(valor, EXPRESION_PASSWORD)) {
				return true;
			} else {
				setError("El formato no es correcto");
				return false;
			}
		} else {
			// El campo es obligatorio
			setError("El campo está vacío y es obligatorio");
			return false;
		}
	}


	
	public boolean esFechaRegistro(String valor) {
        if (Validar.esExpresionRegular(valor, EXPRESION_FECHA)) {
            return true;
        } else {
            setError("El formato no es correcto");
            return false;
        }
    }




}
