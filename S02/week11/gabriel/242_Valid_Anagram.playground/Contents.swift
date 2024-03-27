import UIKit

/*
 Runtime - 16ms
 Memory - 17.25MB
 */

class Solution {
    func isAnagram(_ s: String, _ t: String) -> Bool {
        let sArr = Array(s)
        let tArr = Array(t)

        var sDict = [Character: Int]()
        var tDict = [Character: Int]()

        sArr.forEach { element in
            if let val = sDict[element] {
                sDict[element] = val + 1
            } else {
                sDict[element] = 1
            }
        }

        tArr.forEach { element in
            if let val = tDict[element] {
                tDict[element] = val + 1
            } else {
                tDict[element] = 1
            }
        }

        return sDict == tDict
    }
}
