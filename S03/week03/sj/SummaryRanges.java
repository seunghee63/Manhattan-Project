// Runtime 5ms Beats 78.16% of users with Java
// Memory 41.21MB Beats 90.02% of users with Java
class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }

        ArrayList<String> result = new ArrayList<>();
        Integer curNum = nums[0];
        Integer curRangeStartNum = nums[0];
        
        for (int num: nums) {
            if (curNum == num) {
                continue;
            }

            if (curNum + 1 == num) {
                curNum++;
                continue;
            }

            if (curNum + 1 < num) {
                if (curNum.equals(curRangeStartNum)) {
                    result.add(String.valueOf(curRangeStartNum));
                } else {
                    result.add(curRangeStartNum + "->" + curNum);
                }

                curNum = num;
                curRangeStartNum = num;
            }
        }

        if (curNum.equals(curRangeStartNum)) {
            result.add(String.valueOf(curRangeStartNum));
        } else {
            result.add(curRangeStartNum + "->" + curNum);
        }

        return result;
    }
}
