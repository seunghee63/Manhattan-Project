// https://leetcode.com/problems/roman-to-integer/
// 163ms , 36.9mb

class Solution {
    fun romanToInt(s: String): Int {
        var result = 0
        var index = 0

        while(index < s.length){
            when(s[index]){
                'I' -> {
                    if(index + 1 < s.length && (s[index+1] == 'V' || s[index+1] == 'X')){
                        if(s[index+1] == 'V') result += 4
                        else if(s[index+1] == 'X') result += 9
                        index += 2
                        continue
                    }else result += 1
                }
                'V' -> result += 5
                'X' -> {
                    if(index + 1 < s.length && (s[index+1] == 'L' || s[index+1] == 'C')){
                        if(s[index+1] == 'L') result += 40
                        else if(s[index+1] == 'C') result += 90
                        index += 2
                        continue
                    }else result += 10
                }
                'L' -> result += 50
                'C' -> {
                    if(index + 1 < s.length && (s[index+1] == 'D' || s[index+1] == 'M')){
                        if(s[index+1] == 'D') result += 400
                        else if(s[index+1] == 'M') result += 900
                        index += 2
                        continue
                    }else result += 100
                }
                'D' -> result += 500
                'M' -> result += 1000
            }
            index += 1
        }
        return result
    }
}
