// 2ms Beats 85.34% of users with Java
// 43.45MB Beats 48.88% of users with Java

class Solution {
		public String maximumOddBinaryNumber(String s) {
			int oneCount = 0;
			for (char sChar : s.toCharArray()) {
				if (sChar == '1') {
					oneCount++;
				}
			}
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < s.length()-1; i++) {
				if (oneCount > 1) {
					result.append("1");
					oneCount--;
				} else {
					result.append("0");
				}
			}
			result.append("1");

			return result.toString();
		}
}
