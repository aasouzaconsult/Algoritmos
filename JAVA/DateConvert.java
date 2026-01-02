import java.util.Scanner;

class DateConvert {
// There are two common formats used for dates. For example “December 25, 2012” is more 
// commonly used in the UK, whereas “25 December 2012” is more popular with the Americans. 
// Write a program DateConvert.java that reads a string in the UK date format and outputs the 
// equivalent American format, and also whether the year is a leap year. 
// The input consists of the month, a space, the day, a comma, a space, and the year. You may 
// assume that all inputs follow this format, and that the input date is a valid date. 
// You are to define a class method isLeapYear(int) that takes in an integer parameter which 
// represents the year, and returns true if it is a leap year, or false otherwise. A year is a leap year 
// if it satisfies one of the following two conditions: 
// It is divisible by 400; or 
// It is divisible by 4 but not by 100 
// For example, 2012, 1996, and 2000 are leap years, but 1998, 2013, 2100 and 2200 are not. 

	public static boolean isLeapYear(int year) {
		if (year%400 == 0) {
			return true;
		} else if (year%4 == 0 && year%100 != 0) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		String month, day_string;
		int day, year;
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter date in UK format: ");
		month = sc.next();
		day_string = sc.next();
		day = Integer.parseInt(day_string.substring(0, day_string.length()-1));
		year = sc.nextInt();
		System.out.println("Date in American format: " + day + " " + month +" " + year);
		if (isLeapYear(year) == true) {
			System.out.println(year + " is a leap year.");
		} else {
			System.out.println(year + " is not a leap year.");
		}
	}
}