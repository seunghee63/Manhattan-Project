class Solution {
    // 165 ms, 36.7 MB
    
    // f(n) = f(n1) operator f(n2)
    // 2*3-4*5 = 2 * (3-4*5)
    // 3-4*5 = 3 - (4*5)
    // 4*5 = 20
    fun diffWaysToCompute(expression: String): List<Int> {
        val temp = mutableListOf<Int>()
        expression.forEachIndexed { index, c ->
            if(c == '+' || c == '-' || c == '*') {
                val nums1 = diffWaysToCompute(expression.substring(0, index))   // 새로운 수식 f(n1) 시작
                val nums2 = diffWaysToCompute(expression.substring(index+1))    // 새로운 수식 f(n2) 시작
                for(n1 in nums1) {
                    for (n2 in nums2) {
                        temp.add(
                            // f(n1) operator f(n2) 계산결과
                            when(c) {
                                '+' -> n1 + n2
                                '-' -> n1 - n2
                                '*' -> n1 * n2
                                else -> throw ArithmeticException()
                            }
                        )
                    }
                }
            }
        }
        // expression에 연산식이 없을 경우, 그대로 숫자로 취급 
        if(temp.isEmpty()) {
            temp.add(expression.toInt())
        }
        return temp
    }
}
