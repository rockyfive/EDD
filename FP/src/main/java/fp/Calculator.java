package fp;
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
		String limpia = "";
		String acentos = "áéíóúàèìòùü";
		String noacentos = "aeiouaeiouu";

		for (int i = 0; i < cadena.length(); i++){
			if (Character.isLetter(cadena.charAt(i))) {
				if (acentos.indexOf(cadena.charAt(i)) != -1)
					limpia += noacentos.charAt(acentos.indexOf(cadena.charAt(i)));
				else
					limpia += cadena.charAt(i);
			}
		}

		for (int i = 0; i < limpia.length() / 2; i++){
			if (limpia.charAt(i) != limpia.charAt(limpia.length() - 1 - i))
				return false;
		}
		return true;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n){
		String number = numberToLetter(n);
		return number.substring(0, 1).toUpperCase() + number.substring(1);
	}

	public static String numberToLetter(int n) {

		String[] unicos = {"cero", "uno", "dos", "tres", "cuatro",
				"cinco", "seis", "siete", "ocho", "nueve", "diez", "once",
				"doce",	"trece", "catorce", "quince", "dieciséis"};
		String[] decenas = {"dieci", "veinti", "veinte", "treinta", "cuarenta",
				"cincuenta", "sesenta", "setenta", "ochenta", "noventa"};

		if (n < 17)
			return unicos[n];

		if ((n % 10) == 0)
			return decenas[(n / 10)];

		if (n < 30)
			return decenas[(n / 10) - 1] + unicos[n % 10];

		if (n > 99)
			return "Más de dos dígitos";

		return decenas[(n / 10)] + " y " + unicos[n % 10];
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String date) {
		int[] dateNum = dateToNumbers(date);
		if (dateNum == null) return false;
		return isLeapYear(dateNum[2]);
	}

	public static boolean isLeapYear(int year) {
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
		int[] dateNum = dateToNumbers(date);
		if (dateNum == null) return false;
		return isValidDate(dateNum[0], dateNum[1], dateNum[2]);
	}
	
	public static boolean isValidDate(int day, int month, int year) {
		return isMonthAndYearValid(month, year) && isDayValid(day, month, year);		
	}
	
	public static int[] dateToNumbers(String date) {
		int day, month, year;
		try {
			day = Integer.parseInt(date.substring(0, 2));
			month = Integer.parseInt(date.substring(3, 5));
			year = Integer.parseInt(date.substring(6));
		} catch(NumberFormatException e){
			return null;
		}catch(StringIndexOutOfBoundsException e){
			return null;
		}
		if (date.charAt(2) == date.charAt(5) && "/.- ".indexOf(date.charAt(2)) != -1) {
			 return new int[] {day, month, year}; 
		}
		return null;
	}
	
	public static boolean isDayValid(int day, int month, int year) {
	int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	if (isLeapYear(year))
		daysPerMonth[1]++;	
	return day > 0 && day <= daysPerMonth[month - 1];
	}

	public static boolean isMonthAndYearValid(int month, int year) {
		return year > 0 && month <= 12 && month > 0;
	}
}
