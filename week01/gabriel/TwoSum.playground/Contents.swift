import UIKit

// Runtime: 45ms / Memory: 14.6MB


/*
 dictionary를 이용하여 O(N) 풀이.
 target - nums[index]의 값을 nums에서 찾아내면 됨
 */
class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var dict = [Int: Int]()

        for (index, num) in nums.enumerated() {
            if let result = dict[num] {
                return [result, index]
            }

            dict[target-num] = index
        }

        return [0,1]
    }
}


