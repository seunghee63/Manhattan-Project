// 106ms, 40.67mb

class SeatManager {
    private Queue<Integer> priorityQueue = new PriorityQueue<>((h1, h2) -> h1 < h2 ? -1 : ((h1.equals(h2)) ? 0 : 1));

    public SeatManager(int n) {
        for (int i = 1; i <= n; i++) {
            priorityQueue.add(i);
        }
    }

    public int reserve() {
        return priorityQueue.poll();
    }

    public void unreserve(int seatNumber) {
        priorityQueue.add(seatNumber);
    }
}
