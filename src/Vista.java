import java.util.Scanner;

public class Vista {

	private static Scanner sc = new Scanner(System.in);

	public static String askData(String s) {
		if (!s.equals("")) {
			System.out.println(s);
		}
		return sc .nextLine();
	}

	public static void printErrLn(String s) {
		System.err.println(s);
	}
	
	public static void print(String s) {
		System.out.print(s);
	}
	
	public static void printErr(String s) {
		System.err.print(s);
	}
	
	public static void printLn(String s) {
		System.out.println(s);
	}

}
