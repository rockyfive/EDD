package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class Calculator {


	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	public static Class classTypeOf(Object x) {
		
		return x.getClass();
	}


	/*
     * devuelve una lista con los n n�meros de la serie de fibonacci.
     */
	public static List<Integer> fibonacci(int n) {
		List<Integer> lista = new ArrayList<Integer>();
		if (n < 1)
			return lista;
		lista.add(1);
		if (n == 1)
			return lista;
		lista.add(1);
		if (n == 2)
			return lista;
		

		for (int i = 2; i < n; i++) {
			lista.add(lista.get(i - 2) + lista.get(i - 1));
		}
		return lista;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		if (step == 0)
			return new int[0];
		int[] lista = new int[(number - 1) / step];
		
		int i = 0;
		while (number > step){
			number -= step;
			lista[i] = number;

			i++;
		}
	return lista;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		
		if (n < 1)
			return null;
		
		int count = 0;
		for (int i = n; i > 0; i--)
			if (n % i == 0)
				count++;
		
		int d[] = new int[count];
		
		for (int i = 1; i <= n; i++)
			if (n % i == 0) {
				count--;
				d[count] = i;
			}

		return d;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		
		if (cadena == null) {
			return false;
		}
		cadena = cadena.toLowerCase();
		String clean = "";
		String acentos = "áéíóúü";
		String noacentos = "aeiouu";
		
		for (int i = 0; i < cadena.length(); i++){
			if (Character.isLetter(cadena.charAt(i))) {
				if (acentos.indexOf(cadena.charAt(i)) != -1) 
					clean += noacentos.charAt(acentos.indexOf(cadena.charAt(i)));
				else
					clean += cadena.charAt(i);
			}
		}
		
		for (int i = 0; i < clean.length() / 2; i++){
			if (clean.charAt(i) != clean.charAt(clean.length() - 1 - i))
				return false;
		}
		return true;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String nombreNum;
		String[] unidades = new String[] {"cero", "uno", "dos", "tres", "cuatro", 
				"cinco", "seis", "siete", "ocho", "nueve"};
		String[] decenas1 = {"once", "doce", "trece", "catorce", "quince", "dieciséis"};
		String[] decenas2 = {"dieci", "veinti"};
		String[] decenas3 = {"diez", "veinte", "treinta", "cuarenta", "cincuenta", 
				"sesenta", "setenta", "ochenta", "noventa"};
		
		if ((n / 10) == 0)
			return firstUpperCase(unidades[n]);
		if ((n % 10) == 0)
			return firstUpperCase(decenas3[(n / 10) - 1]);
		if (n < 17)
			return firstUpperCase(decenas1[n - 11]);
		if (n < 30)
			return firstUpperCase(decenas2[(n / 10) - 1] + unidades[n % 10]);
		
		if (n > 99)
			return "Más de dos dígitos";
		
		return firstUpperCase(decenas3[(n / 10) - 1] + " y " + unidades[n % 10]);
	}

	public static String firstUpperCase(String s){
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (!isValidDate(fecha))
			return false;
		
		int year = Integer.parseInt(fecha.substring(6));

		if ((year % 4) != 0)
			return false;
		if (((year % 100) == 0) && ((year % 400) != 0))
			return false;
		return true;
		
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		int day, month, year;
		try {
			day = Integer.parseInt(date.substring(0, 2));
			month = Integer.parseInt(date.substring(3, 5));
			year = Integer.parseInt(date.substring(6));
		} catch(NumberFormatException e){
	        return false;
	    }catch(StringIndexOutOfBoundsException e){
	        return false;
	    }
		if ((day <= 31) && (day > 0))
			if ((month <= 12) && (month > 0))
				if (year > 0)
					return true;
		return false;
					
	}
}
