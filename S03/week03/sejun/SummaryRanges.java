// 8ms Beats 6.45% of users with Java
// 41.91 MB Beats 8.89% of users with Java
class Solution {
    String arrow = "->";
    int[][] summary = new int[20][2];


    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int startInd = 0;
        int nextInd = 1;
        summary[startInd][0] = nums[0];
        summary[startInd][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (summary[startInd][1] + 1 == nums[i]) {
                summary[startInd][1] = nums[i];
                continue;
            }
            startInd++;
            summary[startInd][0] = nums[i];
            summary[startInd][1] = nums[i];
        }

        for (int i = 0; i <= startInd; i++) {
            result.add(summary[i][0] == summary[i][1] ? summary[i][0] + "" : summary[i][0] + arrow + summary[i][1]);
        }

        return result;
    }
}
