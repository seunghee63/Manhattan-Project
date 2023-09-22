import UIKit

// Runtime: 113ms, Memory: 14.4MB
class Solution {
    var set     = Set<[Int]>()
    var answr  = 0

    func combinationSum(_ candidates: [Int], _ target: Int) -> [[Int]] {
        answr   = target
        let sort = candidates.sorted()

        for candidate in sort {
            calc([candidate], candids: sort.filter { $0 >= candidate }, sum: candidate)
        }

        return Array(set)
    }

    func calc(_ arr: [Int], candids: [Int], sum: Int) {
        if sum == answr {
            set.insert(arr)
            return
        }

        if sum > answr {
            return
        }

        for candid in candids {
            var tempArr = arr
            tempArr.append(candid)
            calc(tempArr, candids: candids.filter{ $0 >= candid }, sum: sum + candid)
        }
    }
}
