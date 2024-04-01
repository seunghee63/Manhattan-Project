// Runtime 11ms Beats 34.19% of users with Java
// Memory 45.22 MB Beats 16.14% of users with Java
class Solution {
		public String reverseWords(String s) {
			String[] splitted = s.split(" ");

			String reversed = "";
			for (int i = splitted.length - 1; i >= 0; i--) {
				if (splitted[i].isEmpty()) {
					continue;
				}

				reversed += " " + splitted[i];
			}

			return reversed.substring(1);
		}
}
