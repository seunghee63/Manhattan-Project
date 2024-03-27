//Runtime 0ms Beats 100.00% of users with Java
//Memory 42.85MB Beats 22.81% of users with Java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(result.isEmpty()) {
            result.add(new ArrayList<>());
        }

        for (int indexOfSet = 0; indexOfSet < nums.length; indexOfSet++) {
            for (int i = 0; i < Math.pow(2, indexOfSet); i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(nums[indexOfSet]);
                result.add(subset);
            }
        }

        return result;
    }
}
