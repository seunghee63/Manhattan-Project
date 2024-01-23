// 2ms, 40.67mb

class Solution {
		private Queue<Integer> priorityQueue = new PriorityQueue<>((h1, h2) -> h1 < h2 ? 1 : ((h1.equals(h2)) ? 0 : -1));

		public int lastStoneWeight(int[] stones) {
			for (int stone : stones) {
				priorityQueue.add(stone);
			}

			while (priorityQueue.size() > 1) {
				int result = smash(priorityQueue.poll(), priorityQueue.poll());

				if (result > 0) {
					priorityQueue.add(result);
				}
			}

			if (priorityQueue.isEmpty()) {
				return 0;
			}

			return priorityQueue.poll();
		}

		public int smash(int h1, int h2) {
			return h1 - h2;
		}
	}
