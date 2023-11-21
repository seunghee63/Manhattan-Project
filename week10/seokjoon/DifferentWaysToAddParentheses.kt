// https://leetcode.com/problems/different-ways-to-add-parentheses
// 151ms, 37.6mb

class Solution {
    fun diffWaysToCompute(expression: String): List<Int> {
        return(rec(expression))
    }

    fun rec(expression : String) : List<Int> {
        if(expression.length <= 2) {
            return listOf(expression.toInt())
        }else {
            val indexList = mutableListOf<Int>()
            for(i in 0 until expression.length){
                if(expression[i] == '+' || expression[i] == '-' || expression[i] == '*'){
                    indexList.add(i)
                }
            }
            val result = mutableListOf<Int>()
            indexList.forEach { index ->
                rec(expression.substring(0,index)).forEach { n1 -> 
                    rec(expression.substring(index+1)).forEach { n2 ->
                        result.add(calc(n1,expression[index],n2))
                    }
                }
            }
            return result
        }
    }

    fun calc(n1 : Int, op : Char,n2 : Int) : Int {
        return when(op){
            '+' -> n1 + n2
            '-' -> n1 - n2
            else -> n1 * n2 // +,-,*만 있으므로
        }
    }
}
