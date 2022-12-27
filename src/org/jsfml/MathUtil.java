package org.jsfml;

public final class MathUtil {
	private MathUtil() {
	}
	
	public static float sqrtRoot(float from) {
		return sqrtRoot(from, 5);
	}
	
	public static float sqrtRoot(float from, int iterations) {
		return root(2, from, iterations);
	}
	/**
	 * 
	 * @param n root
	 * @param a from
	 * @param iterations
	 * @return
	 */
	public static float root(int n, float a, int iterations) {
		// a^(1/n) = b
		// b*n = a
		float b = a/n;
		float c = 0;
		
		for(int i=0; i<iterations; i++) {
			c=a/(float)Math.pow(b, n-1);
			b=(b * (n-1) + c) / n; 
			
			if(c==b)
				break;
			System.out.println(b);
			System.out.println(c);
		}
		
	    return b;
	}
}