class Solution {
    // Time Limit Exceeded T,.T
    public int minSubArrayLen(int target, int[] nums) {
		int minSubArrayLen = 0;
        // 순차 순회
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            // target보다 보다 크고 i를 subArray의 첫번째 요소로하는 subArray찾기
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                //subArray의 합이 target 보다 크면 length를 구해서 지금까지 구한 minSubArrayLen보다 작으면 length를 minSubArrayLen로 변경
                if (sum >= target) {
                    int length = j - i + 1;
                    if (minSubArrayLen == 0 || minSubArrayLen > length) {
                        minSubArrayLen = length;
                    }
                    break;
                }
            }
        }

        return minSubArrayLen;
    }
}
