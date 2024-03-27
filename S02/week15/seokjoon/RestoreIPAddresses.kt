// 183ms , 38.5mb

class Solution {
    fun restoreIpAddresses(s: String): List<String> {
        val result = mutableListOf<String>()

        rec(0,"",0,s,result)
        return result.toList()
    }

    fun rec(currentIndex : Int,currentString : String,currentSize : Int, s : String, result : MutableList<String>) {
        if(currentIndex > s.lastIndex){
            result.add(currentString)
        }else {
            if(s[currentIndex] == '0'){
                if(currentSize == 3 && currentIndex != s.lastIndex) return 
                if(s.lastIndex - currentIndex >= 4 - (currentSize + 1)){
                    rec(
                        currentIndex + 1, 
                        if(currentSize >= 1) currentString + ".${s[currentIndex]}"
                        else "${s[currentIndex]}",
                        currentSize + 1,
                        s,
                        result 
                    )
                } 
            }else {
                for(i in 0 .. 2){
                    val endIndex = currentIndex + i
                    if(endIndex >= s.length) break
                    if(s.lastIndex - endIndex < 4 - (currentSize + 1)) break
                    if(currentSize == 3 && endIndex != s.lastIndex) continue
                    val str = s.substring(currentIndex, endIndex+1)
                    if(str.toInt() > 255) break
                    rec(
                        endIndex + 1, 
                        if(currentSize >= 1) currentString + ".${str}"
                        else "${str}",
                        currentSize + 1,
                        s,
                        result 
                    )

                }
            }
        }
    }
}
