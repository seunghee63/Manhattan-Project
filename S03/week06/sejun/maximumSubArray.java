// Time Limit Exceeded..

class Solution {
		public int maxSubArray(int[] nums) {
			int[][] sum = new int[2][100001];
			int size = nums.length;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				sum[0][i] = nums[i];
				max = max >= sum[0][i] ? max : sum[0][i];
			}
			for (int i = 1; i < size; i++) {
				for (int j = 0; j < size - i; j++) {
					sum[i%2][j] = sum[(i-1)%2][j] + nums[i+j];
					max = max >= sum[i%2][j] ? max : sum[i%2][j];
				}
			}

			return max;
		}
	}
