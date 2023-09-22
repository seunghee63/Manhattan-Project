import UIKit

// Runtime: 19ms, Memory: 14.39 MB

/*
 Sliding window 기법 사용.
 window의 역할을 stack으로 활용해보았다.

 needle을 stack으로 변환 후
 haystack의 element들과 하나씩 비교하였다.

 - 틀리면
    - pointer += 1 증가.
    - 다음 pointer와 needleStack 다시 하나씩 비교.
 - 맞으면
    - windowPointer += 1 증가,
    - needleStack 첫번쨰 요소 제거 (POP)
    - needleStack이 모두 POP 되면 정답을 찾음.

 */
class Solution {
    func strStr(_ haystack: String, _ needle: String) -> Int {
        guard haystack.count >= needle.count else { return -1 }
        let hayStackArr = Array(haystack)
        var needleStack = Array(needle)
        var occurrenceIndex = -1
        var pointer = 0
        var windowPointer = 0

        while pointer < haystack.count && windowPointer < haystack.count {
            guard let pop = needleStack.first else {
                return occurrenceIndex
            }

            if hayStackArr[windowPointer] == pop {
                if needle.count == needleStack.count {
                    occurrenceIndex = pointer
                }
                needleStack.removeFirst()
                windowPointer += 1

            } else {
                needleStack = Array(needle)
                pointer += 1
                windowPointer = pointer
            }
        }

        return needleStack.isEmpty ? occurrenceIndex : -1
    }
}
