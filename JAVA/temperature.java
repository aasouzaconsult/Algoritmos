import java.util.Scanner;

class Temperature {
	public static void main(String[] args) {
		double fahrenheit, celsius;
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter temperature in Fahrenheit: ");
		fahrenheit = sc.nextDouble();
		celsius = (5.0/9) * (fahrenheit - 32);
		System.out.println("Celsius: "+ celsius);
	}
}