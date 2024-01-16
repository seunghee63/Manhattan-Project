class Solution {
    // 141ms, 34.84MB
    // 여는 괄호는 add
    // 닫는 괄호는 앞서 저장된 적이 있는지 확인한 후, remove 시킴
    fun isValid(s: String): Boolean {
        val stack = mutableListOf<Char>()
        s.forEach { c->
            when(c) {
                '(', '{', '[' -> stack.add(c)
                ')' -> {
                    if (stack.isEmpty() || stack.last() != '(') {
                        return false
                    } else {
                        stack.removeAt(stack.lastIndex)
                    }
                }
                '}' -> {
                    if (stack.isEmpty() || stack.last() != '{') {
                        return false
                    } else {
                        stack.removeAt(stack.lastIndex)
                    }
                }
                ']' -> {
                    if (stack.isEmpty() || stack.last() != '[') {
                        return false
                    } else {
                        stack.removeAt(stack.lastIndex)
                    }
                }
            }
        }
        return stack.isEmpty()
    }
}
