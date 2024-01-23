// 841ms, 109.80MB
class SeatManager(n: Int) {
    private val availableSeats = PriorityQueue<Int>(n)
    init {
        availableSeats.addAll((1..n).toList())
    }

    fun reserve(): Int {
        return availableSeats.poll()
    }

    fun unreserve(seatNumber: Int) {
        availableSeats.add(seatNumber)
    }

}
