// 1ms Beats 64.32% of users with Java
// 40.68MB Beats 46.29% of users with Java
class Solution {
		Set<Integer> happyNumberSet = new HashSet<>();

		public boolean isHappy(int n) {
			int num = n;
			boolean happy = false;


			while (!happy) {
				int div = 10;
				int result = square(num % div);
				while (num / div != 0) {
					num = num / div;
					int remainder = num % div;
					result = result + square(remainder);
				}

				if (happyNumberSet.contains(result)) {
					return false;
				}
				happyNumberSet.add(result);

				num = result;

				happy = num == 1;
			}

			return true;

		}

		public int square(int num) {
			return num * num;
		}

	}
