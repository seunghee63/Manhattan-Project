// 11ms Beats 17.88% of users with Java
// 44.39MB Beats 15.04% of users with Java

class Solution {
    public String largestNumber(int[] nums) {
		LargestNumberComparator comparator = new LargestNumberComparator();

		String result =  Arrays.stream(nums)
				.boxed()
				.sorted((o1, o2) -> comparator.compare(String.valueOf(o1), String.valueOf(o2)))
				.map(String::valueOf)
				.reduce((v1, v2) -> v1+v2)
				.orElse("");
		Character ZERO = '0';
		if (ZERO.equals(result.toCharArray()[0])) {
			result = ZERO.toString();
		}
		return result;
	}
	
	class LargestNumberComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			Integer k1 = o1.length();
			Integer k2 = o2.length();
			char[] o1Chars = o1.toCharArray();
			char[] o2Chars = o2.toCharArray();

			int o1i = 0;
			int o2i = 0;
			while (k1 != 0 && k2 != 0) {
				Integer o1Int = Integer.valueOf(o1Chars[o1i++]);
				Integer o2Int = Integer.valueOf(o2Chars[o2i++]);
				k1--; k2--;
				if (o1Int.compareTo(o2Int) == 0) {
					continue;
				}

				return -o1Int.compareTo(o2Int);
			}

			return compareBigValue(o1, o2);
		}

		public int compareBigValue(String o1, String o2) {
			String v1 = o1 + o2;
			String v2 = o2 + o1;
			char[] v1Chars = v1.toCharArray();
			char[] v2Chars = v2.toCharArray();

			for (int i = 0; i < v1.length(); i++) {
				if (Integer.valueOf(v1Chars[i]) < Integer.valueOf(v2Chars[i])) {
					return 1;
				}

				if (Integer.valueOf(v1Chars[i]) > Integer.valueOf(v2Chars[i])) {
					return -1;
				}
			}
			
			return 0;
		}
    }
}
