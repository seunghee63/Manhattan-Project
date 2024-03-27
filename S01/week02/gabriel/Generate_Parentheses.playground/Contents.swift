import UIKit

// Runtime: 25 ms, Memory: 14.3 MB

/*
 1. Open == close, "("이 와야한다.
 2. 멀티버스 생성 시점
    - open > 0, "("가 와야함
    - 이후에 ")"가 와야함
3. open == 0 && close == 0 모든 상황 종료


 */
class Solution {
    var arr = [String]()
    func generateParenthesis(_ n: Int) -> [String] {
        calc(open: n, close: n, str: "")
        return arr
    }

    func calc(open: Int, close: Int, str: String) {
        if open == 0 && close == 0 {
            arr.append(str)
            return
        }

        if open == close {
            calc(open: open - 1, close: close, str: str+"(")
        } else {
            if open > 0 {
                calc(open: open - 1, close: close, str: str+"(")
            }

            calc(open: open, close: close - 1, str: str+")")
        }
    }
}
