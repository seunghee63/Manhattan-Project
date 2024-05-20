//Runtime: 77 ms
//Memory Usage: 68.2 MB
class Solution {
		int[] cardCount = new int[100001];
		Map<Integer, List<Integer>> cardToIndexs = new HashMap<>();
		public int minimumCardPickup(int[] cards) {
			for (int i = 0; i < cards.length; i++) {
				if (cardToIndexs.containsKey(cards[i])) {
					List<Integer> indexArray = cardToIndexs.get(cards[i]);
					indexArray.add(i);
					cardToIndexs.remove(cards[i]);
					cardToIndexs.put(cards[i], indexArray);
				} else {
					List<Integer> temp = new ArrayList<>();
					temp.add(i);
					cardToIndexs.put(cards[i], temp);
				}
			}
      
			int min = 10000000;
			for (Integer key : cardToIndexs.keySet()) {
				List<Integer> indexArray = cardToIndexs.get(key);
				if (indexArray.size() >= 2) {
					for (int i = 0; i < indexArray.size(); i++) {
						if (i+1 >= indexArray.size()) {
							continue;
						}
						int temp = indexArray.get(i+1) - indexArray.get(i) + 1;
						min = min < temp ? min : temp;
					}
				}
			};

			return min == 10000000 ? -1 : min;
		}
	}
