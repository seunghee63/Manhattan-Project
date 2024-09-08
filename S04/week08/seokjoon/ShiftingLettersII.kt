//// TIME LIMIT EXCEEDED

class Solution {
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val alphabetSize = 'z' - 'a' + 1

        // 각 문자의 아스키 코드를 저장하는데, 'a'를 0으로 두기 위해 'a'를 뺀다.
        val arr = s.map { c -> 
            c.toInt() - 'a'.toInt() 
        }.toTypedArray()
        
        shifts.forEach { shift ->
            for(i in shift[0] .. shift[1]){
                // 방향에 따라 아스키 코드 값에 1이나 -1을 더하는데 음수 계산이 까다로우므로 alphabetSize 와 나머지 연산을 사용
                val direction = if(shift[2] == 0) (alphabetSize -1) else 1
                arr[i] = (arr[i] + direction) % alphabetSize
            }
            
        }
        return arr.joinToString(""){
            (it + 'a'.toInt()).toChar().toString()
        }
    }
}
