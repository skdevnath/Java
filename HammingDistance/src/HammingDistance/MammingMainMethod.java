package HammingDistance;

public class MammingMainMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1, y = 4;
		Solution sol = new Solution();
		int outPut = sol.hammingDistance(x, y);
		System.out.printf("Hamming distance of X(%s) and Y(%s) is %d\n", 
				Integer.toBinaryString(x), Integer.toBinaryString(y), outPut);
	}

}
