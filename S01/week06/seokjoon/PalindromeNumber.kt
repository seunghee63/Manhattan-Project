// https://leetcode.com/problems/palindrome-number/
// 215ms, 37.3mb

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if(x < 0 ) return false
        else if(x < 10) return true
        else {
            getNumbersAtIndex(x).let{
                for(i in 0 until it.size / 2){
                    if(it[i] != it[it.size -1 - i]) return false
                }
            }
            return true
        }
    }

    private fun getNumbersAtIndex(number : Int) : Array<Int> {
        val stack = Stack<Int>()
        var target = number

        while(target > 0){ // 스택에 number의 자리수를 끝에서부터 하나씩 넣는다.
            stack.push(target % 10)
            target /= 10
        }

        val arr = Array(stack.size){ 0 } 

        while(stack.isNotEmpty()){
            arr[arr.size - stack.size] = stack.pop() // 스택에는 number의 자리수가 반대로 들어있으므로 arr의 끝에서부터 자리수를 넣어준다.
        }
        
        return arr
    }
}
