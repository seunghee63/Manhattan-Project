//838ms, 111.1mb

class SeatManager(val n: Int) {
    val pq = PriorityQueue<Int>()

    init {
        for(i in 1 .. n){
            pq.add(i)
        }
    }

    fun reserve(): Int {
        val n = pq.poll()
        return n
    }

    fun unreserve(seatNumber: Int) {
        pq.add(seatNumber)
    }

}
