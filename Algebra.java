// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	} 
	
	int i=0;

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		while (x2 > 0) {
			x1++;
			x2--;
		}
		while (x2 < 0) {
			x1--;
			x2++;
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		while (x2 > 0) {
			x1--;
			x2--;
		}
		while (x2 < 0) {
			x1++;
			x2++;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		boolean isNeg = (x1 < 0) != (x2 < 0);
		int a = Math.abs(x1);
		int b = Math.abs(x2);

		int min = Math.min(a, b);
   		int max = Math.max(a, b);
		
		int i = 0;
		int c = 0;
		while (i < min) {
			c = plus(c, max);
			i++;
		}
		if (isNeg) {
			return -c;
		} else {
			return c;
		}
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int i = 1;
		int base = Math.abs(x);
		int c = base;
		
		if (n == 0) {
			return 1;
		}
		while (i < n) {
			c = times(c, base);
			i++;
		}
		if (x < 0 && n % 2!= 0) {
			return times(c, -1);
		} else {
			return c;
		}
	}


	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		int d = 0;
		boolean isNeg = (x1 < 0) != (x2 < 0);
		int dividend = Math.abs(x1);
    	int divisor = Math.abs(x2);

		while (dividend >= divisor) {
			dividend = minus(dividend, divisor);
			d++;
		}
		if (isNeg) {
			return minus(0,d);
		} else {
			return d;
		}
	}
		//System.out.println(mod(25,7));   // 25 % 7 = 4
   		//System.out.println(mod(120,6));  // 120 % 6
	// Returns x1 % x2
	// remainder = dividend - (Quotient*divisor)
	//  4(r) = 25(x1) - 7(x2) * k()
	public static int mod(int x1, int x2) {
		int k = 1;
		int c = 0;
		int r = 0;

		while (c <= x1) {
			c = times(k, x2);
			k++;

			if (c == x1) {
				return 0;
			}
		r = minus(x1, times(x2, div(x1, x2)));
		}
		return r;
	}	



		//System.out.println(sqrt(36));
		//System.out.println(sqrt(263169));
   		//System.out.println(sqrt(76123));

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int i = 1;
		while (times(i, i)<= x) {
			i++;
		}
		i--;
		return i;
	}	  	  
}