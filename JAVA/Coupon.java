import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

class Coupon {
	//Attributes
	private String name;
	private double rate;

	//Constructors
	public Coupon() {}
	public Coupon(String new_name, double new_rate) {
		this.name = new_name;
		this.rate = new_rate;
	}

	//Accessors 
	public String getName() {
		return this.name;
	}
	public double getRate() {
		return this.rate;
	}
	//Methods
	public double payment(double price) {
		double pay =0.0;
		if (this.rate < 1) { //discount coupon
			pay = (1-rate) * price;
		} else { //cash coupon
			if (price > this.rate) {
				pay = this.rate - price;
			} else {
				pay = price - this.rate;
			}
		}
		return pay;
	}

}

class Redeem {
	public static void main(String[] args) {
		//Declare a scanner object to read input
		Scanner scan = new Scanner(System.in);
		//Declare the necessary variables
		double price, rate, value_pay; 
		int index=0, num_coupon;
		String name;
		//Read input and process them accordingly
		price = scan.nextDouble();
		num_coupon = scan.nextInt();
		Coupon[] coupon = new Coupon[num_coupon];
		double[] pay = new double[num_coupon];
		double[] theory_pay = new double[num_coupon];

		for (int i=0; i < num_coupon; i++) {// Instantiate coupons
			name = scan.next();
			rate = scan.nextDouble();
			coupon[i] = new Coupon(name, rate);
			pay[i] = coupon[i].payment(price);
			theory_pay[i] = Math.abs(pay[i]);
		}
		value_pay = theory_pay[0];
		for (int i=0; i < num_coupon; i++) {
			if (theory_pay[i] < value_pay) {
				value_pay = theory_pay[i];
				index = i;
			}
		}
		if (pay[index] < 0) {
			value_pay = 0.0;
		}
		System.out.println("Best choice: " + coupon[index].getName());
		System.out.println("You need to pay $" + value_pay);
	}
}