class LRUCache {
		private LinkedHashMap<Integer, Integer> elements;
		private int capacity;

		public LRUCache(int capacity) {
			this.elements = new LinkedHashMap<>();
			this.capacity = capacity;
		}

		public int get(int key) {
			Integer value = elements.remove(key);
			if (value != null) {
				elements.put(key, value);
				return value;
			}

			return -1;
		}

		public void put(int key, int value) {
			if (elements.size() >= capacity && !elements.containsKey(key)) {
				Map.Entry<Integer, Integer> first = elements.entrySet().iterator().next();
				elements.remove(first.getKey());
			}

			if (elements.containsKey(key)) {
				elements.remove(key);
			}

			elements.put(key, value);
		}
	}

