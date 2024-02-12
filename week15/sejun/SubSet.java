class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Integer listIndex = 1;
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        int size = nums.length;
        for (int subNumSize = 1; subNumSize <= size; subNumSize++) {
            for (int index = 0; index < nums.length; index++) {
                List<Integer> subList = new ArrayList<>();
                subList.add(nums[index]);
                subNums(nums, subNumSize, index, subList);
            }
        }
        return result;
    }

    public void subNums(int[] nums, int subSize, int index, List<Integer> subList) {
        if (subList.size() == subSize) {
            result.add(subList);
            return;
        }

        for (int subIndex = index + 1; subIndex < nums.length; subIndex++) {
            List<Integer> temp = new ArrayList<>(subList);
            temp.add(nums[subIndex]);
            subNums(nums, subSize, subIndex, temp);
        }
    }
}
