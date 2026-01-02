import java.math.*;
import java.util.Scanner;

class AreaOfTriangle {
	public static double area(double len1, double len2, double len3) {
		double area, p;
		 p = (len1+len2+len3) / 2;
		area = Math.sqrt(p * (p-len1) * (p-len2) * (p-len3));
		return area;
	}
	public static boolean validTriangle(double len1, double len2, double len3) {
		if (len1+len2 > len3) {
			if (len1+len3 > len2) {
				if (len2+len3 > len1) {
					return true;
				}
			}
		} 			
		return false;
	}
	// Write a program AreaOfTriangle.java to read 3 positive real numbers a, b, and c 
	// which are the lengths of a triangle, and compute the area of the triangle using the 
	// Heron’s formula: 
	// area = math.sqrt(p * (p-a) * (p-b) * (p-c))
	// where p is half the perimeter, ie. p = (a+b+c)/2
	public static void main(String[] args) {
		double len1, len2, len3;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter lengths of triangle: ");
		len1 = sc.nextDouble();
		len2 = sc.nextDouble();
		len3 = sc.nextDouble();

		if (validTriangle(len1, len2, len3) == false) {
			System.out.println("Invalid triangle!");
		} else {
			System.out.println("Area = " + area(len1, len2, len3));
		}
	}
}