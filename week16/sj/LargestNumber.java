// Runtime 12ms Beats 14.45% of users with Java
// Memory 43.51MB Beats 38.63% of users with Java
class Solution {
    public String largestNumber(int[] nums) {
        String result = Arrays.stream(nums)
            .boxed()
            .map(String::valueOf)
            .sorted(Comparator.comparing(Function.identity(), (a, b) -> (b + a).compareTo(a + b)))
            .collect(Collectors.joining());
        
        if (result.charAt(0) == '0') {
            return "0";
        }
        
        return result;
    }
}
