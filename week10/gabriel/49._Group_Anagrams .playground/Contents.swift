import UIKit

/*
 Runtime - 101ms
 Memory - 16.18MB
 */

class Solution {
    func groupAnagrams(_ strs: [String]) -> [[String]] {
        guard strs.isEmpty == false else { return [] }
        var resultDict = [String: [String]]()
        for element in strs {
            let sorted = element.sorted()
            let key = String(sorted)

            if var val = resultDict[key] {
                val.append(element)
                resultDict[key] = val
            } else {
                resultDict[key] = [element]
            }
        }
        
        print(resultDict)
        let vals = resultDict.values
        return Array(vals)
    }
}

Solution().groupAnagrams(["eat","tea","tan","ate","nat","bat"])
