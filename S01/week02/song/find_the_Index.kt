// runtime: 136 ms, menory: 35 MB
fun strStr(haystack: String, needle: String): Int {
    val needleSize = needle.length

    haystack.forEachIndexed { index, c ->
        if (c == needle.first() && haystack.length >= index + needleSize && haystack.substring(index, index + needleSize) == needle){
            return index
        }
    }
    return -1
}