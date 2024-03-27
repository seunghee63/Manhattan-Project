// 1ms  41.42MB

class Solution {
    private Stack<Character> left = new Stack<>();

    public boolean isValid(String s) {
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                left.add(c);
            } else {
                if (left.isEmpty() || !(Math.abs(c - left.pop()) <= 2)) {
                    return false;
                }
            }

        }

        return left.isEmpty();
    }
}
