class Solution1 {
    // 441 ms, 56.1 MB
    fun maxProfit(prices: IntArray): Int {
        var min = prices[0]
        var profit = 0
        prices.forEach {
            if(it < min) min = it                         // 최소값을 찾는다
            val diff = it - min                           // 현재 값과 최소값의 차를 구한다
            profit = if(diff > profit) diff else profit   // 차이 값 중에 큰 값을 저장한다
        }

        return profit
    }
}
