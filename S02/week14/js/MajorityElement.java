	public int majorityElement(int[] nums) {
		int majorityCount = nums.length / 2;
		
        Map<Integer, Integer> counter = new HashMap<>();
		
        for (int i = 0; i < nums.length; i++) {
			counter.compute(nums[i], (key, old) -> old == null ? 1 : old + 1);
			if (counter.get(nums[i]) > majorityCount) {
				return nums[i];
			}
		}

		return -1;
	}
