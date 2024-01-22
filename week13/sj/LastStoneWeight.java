// 2ms Beats 31.71% of users with Java
// 40.75 MB Beats 53.48% of users with Java
class Solution {
    public int lastStoneWeight(int[] stones) {
		Heap heap = new Heap(stones.length);

		for (int stone : stones) {
			heap.push(stone);
		}

		while(!heap.isEmpty()) {
			int heaviestStone = heap.pop();
			if (heap.isEmpty()) {
				return heaviestStone;
			}

			int dust = heaviestStone - heap.pop();
			
			heap.push(dust);
		}
		
		return -1;
	}

    private static class Heap {
		private List<Integer> elements;

		public Heap(int capacity) {
			this.elements = new ArrayList<>(capacity);
		}
		
		public boolean isEmpty() {
			return elements.isEmpty();
		}

		public void push(int value) {
			elements.add(value);
			swap();
		}

		public int pop() {
			Integer element = elements.remove(0);

			swap();

			return element;
		}

		private void swap() {
			for (int i = elements.size() - 1; i > 0; i --) {
				if (elements.get(i/2) < elements.get(i)) {
					int temp = elements.get(i);
					elements.remove(i);
					elements.add(i , elements.get(i/2));
					elements.remove(i/2);
					elements.add(i/2, temp);
				}
			}
		}
	}
}
