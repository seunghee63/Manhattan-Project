class Solution {
  // 167 ms, 38.5 MB
  // backtracking 모든 경우의 수를 전부 구한다
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        val keypad = mapOf(
            2 to listOf('a', 'b', 'c'), 3 to listOf('d', 'e', 'f'),
            4 to listOf('g', 'h', 'i'), 5 to listOf('j', 'k', 'l'), 6 to listOf('m','n','o'),
            7 to listOf('p', 'q', 'r', 's'), 8 to listOf('t', 'u', 'v'), 9 to listOf('w', 'x', 'y', 'z')
        )
        val result = mutableListOf<String>()
        combines(keypad, digits, 0, "", result)

        return result
    }

    private fun combines(keypad: Map<Int, List<Char>>, input: String, index: Int, temp: String, total: MutableList<String>) {
      // 종료조건 : index가 누른 숫자 길이만큼 도달했을 때
        if(index == input.length) {
            total.add(temp)
            return
        }

        val num = input[index].digitToInt() // 누른 숫자 하나를 가져옴
        val chars = keypad[num].orEmpty() // 키패드에 해당하는 알파벳들

        chars.forEach { char ->
          combines(keypad,input,index + 1,temp + char,total) 
        }
    }
}
