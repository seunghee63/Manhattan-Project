import UIKit
/*
 Runtime - 706ms
 Beats 88.54%
 
 Memory - 17.95MB
 Beats 46.06%
 */
class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        var minNum = Int.max
        var maxNum = 0
        prices.forEach { price in
            let diff = price - minNum
            maxNum = diff > maxNum ? diff : maxNum
            minNum = min(price, minNum)
        }

        return maxNum
    }
}

Solution().maxProfit([7,1,5,3,6,4])
