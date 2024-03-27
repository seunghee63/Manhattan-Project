// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// 461ms , 57.5mb

class Solution {
    fun maxProfit(prices: IntArray): Int {
        if(prices.size == 1) return 0

        var curPrice = prices[0]
        var result = 0

        for(i in 1 .. prices.lastIndex){
            if(curPrice < prices[i]){
                result = maxOf(result, prices[i] - curPrice)
            }else {
                curPrice = prices[i]
            }
        }

        return result
    }
}
