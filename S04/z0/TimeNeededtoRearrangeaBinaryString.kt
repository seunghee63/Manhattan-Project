class Solution {
    // Runtime: 407ms(24.24%)
    // Memory: 40.51MB(6.06%)
    fun secondsToRemoveOccurrences(s: String): Int {
        var result = 0
        var string = s
        while(true) {
            val temp = string.replace("01", "10") // "01"은 모두 "10"으로 변경한다
            if(string == temp) { // 변경 전과 후가 같으면 반복문을 끝낸다
                return result
            } else {
                string = temp // 변경 전과 후가 다를 경우 count를 올리고 다음 반복문을 실행한다
                result++
            }
        }
    }
}
