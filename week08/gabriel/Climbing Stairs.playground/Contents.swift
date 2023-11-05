import UIKit

/*
 Runtime 3ms
 Beats 53.31%of users with Swift

 Memory 13.92MB
 Beats 6.26%of users with Swift
 */
class Solution {
    func climbStairs(_ n: Int) -> Int {
        if n == 0 || n == 1 { return n }
        var dpArray = [0,1,2]

        for i in 3..<n+1 {
            let steps = dpArray[i-1] + dpArray[i-2]
            dpArray.append(steps)
        }

        return dpArray[n]
    }
}

Solution().climbStairs(10)
