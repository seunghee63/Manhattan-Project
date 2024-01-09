// 60ms, 116.67MB

class LRUCache {
		private Map<Integer, Integer> lru;
		private Set<Integer> history = new LinkedHashSet<>();
		private Integer lruCapacity;


		public LRUCache(int capacity) {
			lruCapacity = capacity;
			lru = new HashMap<>(capacity);
		}

		public int get(int key) {
            if (lru.containsKey(key)) {
				history.remove(key);
				history.add(key);
				
				return lru.get(key);
			}
			
			return -1;
		}

		public void put(int key, int value) {
			if (lru.containsKey(key)) {
				history.remove(key);
				lru.remove(key);
			}

			
			if (Objects.equals(lruCapacity, lru.size())) {
				Iterator<Integer> iter = history.iterator();
				Integer historyKey = (Integer) iter.next();
				lru.remove(historyKey);
				history.remove(historyKey);
			}

			lru.put(key, value);
			history.add(key);
		}
	}
