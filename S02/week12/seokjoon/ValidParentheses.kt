//164ms, 38.10mb

class Solution {
    fun isValid(s: String): Boolean {
        val stack : Stack<Char> = Stack() 

        s.forEach {
            if(setOf('(','{','[').contains(it)){
                stack.push(it)
            }else {
                if(stack.isEmpty()) return false
                when(it){
                    ')' -> if(stack.pop() !='(') return false
                    '}' -> if(stack.pop() !='{') return false
                    else -> if(stack.pop() !='[') return false
                }
            }
        }
        return stack.isEmpty()
    }
}
