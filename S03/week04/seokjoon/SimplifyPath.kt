//195ms, 38mb
class Solution {
    fun simplifyPath(path: String): String {
        val pathItemList = path.split("/")
        val stack = Stack<String>()

        for(pathItem in pathItemList){
            if(pathItem == ".."){
                if(stack.isNotEmpty()){
                    stack.pop()
                }
            }else if(pathItem == "." || pathItem.isEmpty()) continue
            else {
                stack.push(pathItem)   
            }
        }
        
        return "/${stack.joinToString("/")}"
    }
}
