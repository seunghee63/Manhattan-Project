// Runtime 1ms Beats 90.87% of users with Java
// Memory 41.24MB Beats 68.25% of users with Java
class Solution {
    public boolean isSubsequence(String s, String t) {
			int subsequenceLength = s.length();
			int subsequenceIndex = 0;

            if (subsequenceLength == 0) {
                return true;
            }

			for (int i = 0; i < t.length(); i++) {
				if (s.charAt(subsequenceIndex) == t.charAt(i)) {
					subsequenceIndex++;
				}
				
				if (subsequenceIndex == subsequenceLength) {
					return true;
				}
			}

			return false;
		}
}
