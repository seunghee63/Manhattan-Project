//https://leetcode.com/problems/generate-parentheses/
//Runtime : 173ms / Memory : 39.2 MB

class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        rec(0,0, "", n,result)
        return result
    }

    fun rec(ocnt : Int, ccnt : Int, str : String, n : Int ,result : MutableList<String>){
        if(str.length == 2 * n){
            if(check(str)) result.add(str)
        }else {
            if(ocnt < n){
                rec(ocnt + 1 , ccnt, str + "(", n,result)
            }
            if(ccnt < n){
                rec(ocnt, ccnt + 1, str + ")", n,result)
            }
        }
    }

    fun check(str : String) : Boolean{
        val stack : Stack<Char> = Stack()
        for(c in str){
            if(c == '('){
                stack.push(c)
            }else {
                if(stack.isEmpty()) return false
                else {
                    if(stack.pop() != '(') return false
                }
            }
        }
        return true
    }
}

//Runtime : 142ms / Memory : 37.13 MB
//스택을 사용하지 않고, 여는 괄호와 닫는 괄호의 수를 비교하여 구할 수 있다(고 한다..)
//닫는 괄호의 수가 여는 괄호의 수보다 작을 때 문자열에 추가 가능하다.
class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        rec(0,0, "", n,result)
        return result
    }

    fun rec(ocnt : Int, ccnt : Int, str : String, n : Int ,result : MutableList<String>){
        if(str.length == 2 * n){
            result.add(str)
        }else {
            if(ocnt < n){
                rec(ocnt + 1 , ccnt, str + "(", n,result)
            }
            if(ccnt < ocnt){
                rec(ocnt, ccnt + 1, str + ")", n,result)
            }
        }
    }
}
