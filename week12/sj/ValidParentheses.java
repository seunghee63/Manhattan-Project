// 2ms, 41.16MB
class Solution {
    private Map<Character, Character> closeAndOpen = Map.of(
		')', '(',
		'}', '{',
		']', '['
	);

	public boolean isValid(String s) {
		char[] parentheses = s.toCharArray();
		Stack<Character> bucket = new Stack<>();

		for (char parenthesis : parentheses) {
			Character open = closeAndOpen.get(parenthesis);
			if (open == null) {
				bucket.push(parenthesis);
				continue;
			}

			if (bucket.empty()) {
				return false;
			} 

			if (bucket.pop() != open) {
				return false;
			}
		}

		return bucket.empty();
	}
}
