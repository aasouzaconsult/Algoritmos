import java.util.Scanner;
    // Static variables declarations

    // Instance variables declarations

    // Constructors

    // Methods (no specific order)

    // public static void main(...)
class ApproximatePi {
	public static void main(String[] args) {
		double PI = 0;
		int nTerms, i, sign =1, denom =1;
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of terms: ");
		nTerms = sc.nextInt();

		for (i = 0; i < nTerms; i++) {
			PI += 4.0 / (denom * sign);
			sign *= -1;
			denom += 2;
		}
		System.out.printf("PI = %.6f\n", PI);
	}
}