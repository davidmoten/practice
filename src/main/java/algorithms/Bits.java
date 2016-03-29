package algorithms;

public class Bits {
	
	public static void main(String[] args) {
		int n = 0b10000111;
		int m = 0b11;
		int i = 3;
		int j = 4;
		
		int x = ~0;
		System.out.println(Integer.toBinaryString(x));
		int y = x - ((1 << (j)) -1);
		System.out.println(Integer.toBinaryString(y));
		int z = (1<<i-1) - 1;
		System.out.println(Integer.toBinaryString(z));
		int mask = y | z;
		System.out.println(Integer.toBinaryString(mask));
		
		int result = (n & mask);
		System.out.println(Integer.toBinaryString(result));
		int mShifted = m << (i-1);
		System.out.println(Integer.toBinaryString(mShifted));
		result = result | mShifted;
		System.out.println(Integer.toBinaryString(result));
		
	}

}
