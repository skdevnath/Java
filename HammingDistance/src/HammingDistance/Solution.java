package HammingDistance;

public class Solution {
    public int hammingDistance(int x, int y) {
    	int ones = 0; 
    	int xorVal = x ^ y;
    	while (xorVal != 0) {
    		if ((xorVal & 1) > 0) {
    			ones++;
    		}
    		xorVal = (xorVal >> 1);
    	}
    	return ones;
    }
}
