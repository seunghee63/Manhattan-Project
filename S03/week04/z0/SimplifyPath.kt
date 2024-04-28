class Solution {
    // 201ms(64.93%)
    // 37.98MB(53.79%)
    fun simplifyPath(path: String): String {
        val stack = Stack<String>()
        path.split("/").forEach {
            if(it == "..") {
                if(stack.isNotEmpty()) stack.pop()
            } else if(it != "" && it != "."){
                stack.push(it)
            }
        }
        return stack.joinToString(separator = "/", prefix = "/")
    }
}
