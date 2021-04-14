package util;

public class Validator {

	public static boolean length(String cadena, int min, int max) {
        boolean validation = false;
        if (cadena != null || cadena.trim().length() != 0) {
            cadena = cadena.trim();
            if (cadena.length() >= min && cadena.length() <= max) {
                validation = true;
            }
        }
        return validation;
    }
	
	 public static boolean lengthDecimal(double numero, int precision, int escala) {
	        // los ceros a la izquierda ,y a la derecha de la parte decimal, son omitidos
	        //en java por el tipo Double.
	        String decimal = null;
	        if (numero < 0) {
	            numero *= -1;
	        }
	        // para la parte entera
	        if ((int) numero >= Math.pow(10, precision - escala)) {
	            return false;
	        }
	        // para los decimales
	        decimal = new Double(numero).toString();
	        decimal = decimal.substring(decimal.indexOf(".") + 1);

	        if (decimal.length() <= escala) {

	            return true;
	        } else {

	            return false;
	        }
	    }
	 
	 public static boolean email(String email, int emailMin, int emailMax) {
	        boolean validation = false;
	        if (Validator.length(email, emailMin, emailMax)) {
	            String regex = "/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/";
	            if (email.matches(regex)) {
	                validation = true;
	            }
	        }
	        return validation;
	    }
	 
	   public static boolean telephone(String phoneNo, int min, int max) {
	        boolean validation = false;
	        if (Validator.length(phoneNo, min, max)) {
	            phoneNo = phoneNo.trim();
	            if (phoneNo.length() > 0) {

	                String regex = "^[+]?([0-9]|\\s)+";
	                if (phoneNo.matches(regex)) {
	                    validation = true;
	                }

	            } else {
	                validation = true;
	            }
	        }
	        return validation;
	    }
	   
	    public static boolean DNI(String dni) {
	        boolean validation = false;
	        if (dni != null) {
	            dni = dni.trim();
	            String regex = "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\-[A-Za-z]{1}";
	            if (dni.matches(regex)) {
	                char[] letras = "TRWAGMYFPDXBNJZSQVHLCKE".toCharArray();
	                int numeroDNI = 0;
	                char miLetra;

	                // Quito los caracteres que no necesito
	                dni = dni.replace(".", "");
	                dni = dni.replace("-", "");

	                // Separo la letra de los números
	                miLetra = dni.charAt(dni.length() - 1);
	                dni = dni.substring(0, dni.length() - 1);
	                try {
	                    numeroDNI = Integer.parseInt(dni);
	                    if (letras[numeroDNI % 23] == miLetra) {
	                        validation = true;
	                    }
	                } catch (NumberFormatException e) {
	                    validation = false;
	                }

	            }
	        }
	        return validation;
	    }
	    
	    
}
