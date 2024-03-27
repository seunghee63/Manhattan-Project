// 7ms, 49.68mb
class Solution {
		class Element {
			int count;
			int value;

			public Element(int count, int value) {
				this.count = count;
				this.value = value;
			}

			public void inc() {
				count++;
			}

			public int getCount() {
				return count;
			}

			public int getValue() {
				return value;
			}
		}
		Map<Integer, Element> elementMap = new HashMap<>();

		public int majorityElement(int[] nums) {

			int majorityElementMinCount = nums.length / 2 + nums.length % 2 ;
			Arrays.stream(nums).forEach(num -> {
				if (elementMap.containsKey(num)) {
					elementMap.get(num).inc();
				} else {
					elementMap.put(num, new Element(1, num));
				}
			});


			for (Integer value : elementMap.keySet()) {
				if (elementMap.get(value).count >= majorityElementMinCount) {
					return value;
				}
			}

			return -1;
		}
	}
