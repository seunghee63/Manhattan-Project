class SeatManager {
    private Heap availableSeats;
    private Set<Integer> reservedSeats;

    public SeatManager(int n) {
        this.reservedSeats = new HashSet<>(n);
        this.availableSeats = new Heap(n);
        IntStream.range(1, n + 1)
            .forEach(seatNumber -> availableSeats.push(seatNumber));
    }

    public int reserve() {
        int targetSeat = this.availableSeats.pop();
        this.reservedSeats.add(targetSeat);
        return targetSeat;
    }

    public void unreserve(int seatNumber) {
        this.reservedSeats.remove(seatNumber);
        this.availableSeats.push(seatNumber);
    }

    private static class Heap {
        private List<Integer> elements;

        public Heap(int capacity) {
            this.elements = new ArrayList<>(capacity);
        }

        public boolean isEmpty() {
            return this.elements.isEmpty();
        }

        public void push(int value) {
            this.elements.add(value);
            swap();
        }

        public int pop() {
            Integer element = this.elements.remove(0);

            swap();

            return element;
        }

        private void swap() {
            for (int i = this.elements.size() - 1; i > 0; i--) {
                if (elements.get(i/2) > this.elements.get(i)) {
                    int temp = this.elements.get(i);
                    this.elements.set(i , this.elements.get(i/2));
                    this.elements.set(i/2, temp);
                }
            }
        }
    }
}

// 97ms Beats 22.21% of users with Java
// 104.44MB Beats 5.09% of users with Java
class SeatManager {
    private PriorityQueue<Integer> availableSeats;
    private Set<Integer> reservedSeats;

    public SeatManager(int n) {
        this.reservedSeats = new HashSet<>(n);
        this.availableSeats = new PriorityQueue<>();
        IntStream.range(1, n + 1)
            .forEach(availableSeats::add);
    }

    public int reserve() {
        int targetSeat = this.availableSeats.poll();
        this.reservedSeats.add(targetSeat);
        return targetSeat;
    }

    public void unreserve(int seatNumber) {
        this.reservedSeats.remove(seatNumber);
        availableSeats.add(seatNumber);
    }
}
