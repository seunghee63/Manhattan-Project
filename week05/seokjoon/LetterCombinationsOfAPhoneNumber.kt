// https://leetcode.com/problems/letter-combinations-of-a-phone-number
// 169ms , 38.21mb

class Solution {
    fun letterCombinations(digits: String): List<String> {
        if(digits.isBlank()) return emptyList<String>()
        val map = mapOf('2' to "abc", '3' to "def",'4' to "ghi",'5' to "jkl",'6' to "mno",'7' to "pqrs",
         '8' to "tuv",'9' to "wxyz")
        val result = mutableListOf<String>()

        rec(result, map, 0, digits, "")
         return result
    }

    private fun rec(result : MutableList<String>,map : Map<Char,String>, index : Int, digits : String, str : String){
        if(index >= digits.length){
            result.add(str)
        }else {
            map[digits[index]]?.forEach {
                rec(result, map, index+1,digits,str+it)
            }
        }
    }
}
