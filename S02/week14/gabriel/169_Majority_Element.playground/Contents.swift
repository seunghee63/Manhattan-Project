import UIKit
/*
 Runtime 104 ms
 Beats 47.95% of users with Swift
 */
class Solution {
    func majorityElement(_ nums: [Int]) -> Int {
        var countDict = [Int:Int]()
        nums.forEach { num in
            countDict[num, default: 0] += 1
        }

        return countDict
            .max { $0.value < $1.value }?
            .key ?? 0
    }
}

Solution().majorityElement([2,2,1,1,1,2,2,4,3,3,7])
