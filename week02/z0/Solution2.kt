class Week2 {
    // 167 ms
    // 37.7 MB
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableSetOf<String>()
        f(n, 0,"", result)
        return result.toList()
    }

    private fun f(start: Int, end: Int, temp: String, total: MutableSet<String>) {
        // 종료조건
        if(start == 0 && end == 0) {
            total.add(temp)
            return
        } else {
            // '('를 한번 소모하고 ')'를 추가한다
            if(start > 0) f(start-1, end+1,"$temp(", total)
            // ')'를 소모한다
            if(end > 0) f(start, end-1,"$temp)", total)
        }
    }


    /* 처음 시도했던 방법
    f(n) = (f(n-1)), ()f(n-1), f(n-1)()
    근데 예외가 있어서 케이스를 다 커버하지 못함
    m + l = n
    f(n) = f(m)f(l), f(l)f(m)
    class Solution {
        fun generateParenthesis(n: Int): List<String> {
            val result = mutableSetOf<String>()
            f(n, "", result)
            return result.toList()
        }

        private fun f(n: Int, temp: String, total: MutableSet<String>) {
            // 종료조건
            if(n == 0) {
                total.add(temp)
            } else {
                f(n-1, "($temp)", total)
                f(n-1, "()$temp", total)
                f(n-1, "$temp()", total)
            }
        }
    }*/
}
