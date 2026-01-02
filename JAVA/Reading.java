import java.util.Scanner;
import java.util.ArrayList;

class Reading {
	// There are various techniques of parsing inputs. In this exercise, we will implement 3 common 
	// techniques: 
	// 1. Given an integer N, you should read N lines, each line containing some data. 
	// 2. Read until some special character(s) (e.g. read until -1). 
    // 3. Read until the end of the file.
    public static int add(int num1, int num2) {
    	int result;
    	result = num1 + num2;
    	return result;
    }
    public static int sub(int num1, int num2) {
    	int result;
    	result = num1 - num2;
    	return result;
    }
    public static int mul(int num1, int num2) {
		int result;
    	result = num1 * num2;
    	return result;
    }

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cmd, op;
		int n, num1, num2, result=0;

		cmd = scan.next();
		System.out.println(cmd);

		if (cmd.equals("LIMIT")) {
			n = scan.nextInt();
			for (int i=0; i<n; i++) {
				op = scan.next();
				num1 = scan.nextInt();
				num2 = scan.nextInt();
				if (op.equals("ADD")) {	
					result = add(num1, num2);					
				} else if (op.equals("SUB")) {
					result = sub(num1, num2);
				} else if (op.equals("MUL")) {
					result = mul(num1, num2);
				}
				System.out.println(result);
			}

		} else if (cmd.equals("SENTINEL")) {
			
			while (true) {
				op = scan.next();
				if (op.equals("-1")) {
					break;
				}
				num1 = scan.nextInt();
				num2 = scan.nextInt();
				if (op.equals("ADD")) {	
					result = add(num1, num2);					
				} else if (op.equals("SUB")) {
					result = sub(num1, num2);
				} else if (op.equals("MUL")) {
					result = mul(num1, num2);
				}
				System.out.println(result);
			}
		} else if (cmd.equals("EOF")) {
			ArrayList<Integer> output = new ArrayList<Integer>();
			while (scan.hasNext()) {
				op = scan.next();
				num1 = scan.nextInt();
				num2 = scan.nextInt();
				if (op.equals("ADD")) {	
					output.add(add(num1, num2));
				} else if (op.equals("SUB")) {
					output.add(sub(num1, num2));
				} else if (op.equals("MUL")) {
					output.add(mul(num1, num2));
				}
			}
			System.out.println(output);
		}
	}
}