class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        List<Integer> sortedNums = Arrays.stream(nums)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .toList();

        int sum = 0;
        int subArrayLen = 0;
        while (target > sum && subArrayLen < sortedNums.size()) {
            sum += sortedNums.get(subArrayLen);
            subArrayLen++;
        }
        
        if (target > sum) {
            return 0;
        }

        return subArrayLen;
    }
}
