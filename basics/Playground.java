package basics;

public class Playground {

	public static void main(String[] args) {
		// divisionException();
		arrayException();
	}
	
	private static void arrayException() {
		String[] cities = { "Atlanta", "Herndon", "Columbus", "Denver" };
		
		for (int i=0; i <= cities.length; i++) {
			try {
				System.out.println(cities[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Could not access the element at position " + i);
			}
		}
		/*
		for (String city : cities) {
			System.out.println(city);
		}
		*/
		System.out.println("Program is ending");
	}
	
	private static void divisionException() {
		int a = 5;
		int b = 0;
		
		try {
			int c = a/b;
		} catch (ArithmeticException e) {
			System.out.println("ERROR! Divison by zero!");
		}
		
		System.out.println("This end of the program");
	}

}
