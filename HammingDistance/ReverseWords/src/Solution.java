
public class Solution {
	private String reverse(String word) {
		char charArray[] = word.toCharArray();
		int stringLenByTwo = word.length()/2;
		for (int i = 0; i < stringLenByTwo; i++) {
			char	tmpChar = charArray[i];
			charArray[i] = charArray[word.length() - i - 1];
			charArray[word.length() - i - 1] = tmpChar;
		}
		String revWord = new String(charArray);
		// System.out.println(revWord);
		return revWord;
	}

	public String reverseWords(String s) {
		String words[] = s.split(" "); 
		String retStr = new String();
		for(int i = 0; i < words.length; i++) {
			retStr += (reverse(words[i]) + ((i ==  (words.length - 1)) ? "" : " "));
		}
		return retStr;
	}
}
