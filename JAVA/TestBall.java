import java.util.*;

class TestBall {
	public static Ball readBall(Scanner sc) {
		//Read ball input and create a ball object
		System.out.print("Enter color: "); 
		String inputColor = sc.next();
		System.out.print("Enter radius: ");
		double inputRadius = sc.nextDouble();

		return new Ball(inputColor, inputRadius);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		Ball myBall = readBall(sc);
		System.out.println();

		Ball myBall2 = readBall(sc);
		System.out.println();

		System.out.println(Ball.getQuantity() + " balls are created.");
		System.out.println("1st ball's colour and radius: " + myBall.getColor() + ", " + myBall.getRadius());
		System.out.println("2nd ball's colour and radius: " + myBall2.getColor() + ", " + myBall2.getRadius());

	}
}