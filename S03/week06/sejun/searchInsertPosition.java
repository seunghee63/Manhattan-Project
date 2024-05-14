//Time Limit Exceeded

class Solution {
		public int searchInsert(int[] nums, int target) {
			int size = nums.length - 1;
			int left = 0;
			int mid = size / 2;
			int right = size;

			while (true) {
				if (nums[mid] == target) {
					return mid;
				}
				int temp = mid;

				if (target < nums[mid]) {
					right = mid;
					mid = ((mid - left) / 2);
				}

				if (nums[mid] < target) {
					left = mid;
					int nextIndex = ((right + mid) / 2);
					mid = mid + 1 > nextIndex ? mid + 1 : nextIndex;
				}

				if (mid >= size + 1 || temp == mid) {
					break;
				}
			}

			return mid;
		}
	}
