//185ms , 37.80mb
class Solution {
    fun reverseWords(s: String): String {
        var c = ""
        var result = ""
        s.trim().let { str -> 
            str.forEachIndexed { idx, ch ->
                if(idx < str.lastIndex && (str[idx]== ' ' && str[idx + 1] == ' ')) // 빈 공백이 연달아 있는 경우 건너뛴다
                    return@forEachIndexed
                else if(ch == ' ') { // 빈공백이 연달아 있는 경우가 아닌 경우
                    result = result.getFormattedResultWithOhter(c)
                    c = ""
                }
                else c += ch
            }
        }
        return result.getFormattedResultWithOhter(c)
    }

    fun String.getFormattedResultWithOhter(c : String) : String { // 문자열을 처음 더하는 경우(this == "")와 아닌 경우를 다르게 처리하는 함수 
        return if(this != "") "${c} ${this}" else c
    }
}
