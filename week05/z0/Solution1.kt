class Solution {
  // 177 ms, 38.3 MB
  // 가장 긴 공통의 prefix 찾기
    fun longestCommonPrefix(strs: Array<String>): String {
        // 주어진 어레이의 값이 1개일 경우 그 값을 바로 리턴
        if(strs.size == 1) return strs[0]

        // 주어진 어레이를 length를 기준으로 오름차순 정렬한다 
        val sortedList = strs.sortedBy { it.length }
        // 주어진 값 중 가장 짧은 string을 prefix 기준으로 삼는다
        var prefix = sortedList[0]
        var index = prefix.lastIndex

        // 어레이 중 prefix로 시작하는 string의 갯수와 전체 어레이의 갯수가 같아 질 때까지 반복
        while(sortedList.count { it.startsWith(prefix) } != sortedList.size) {
            // prefix를 뒤에서 한 글자씩 줄여나가며 반복해서 비교
            prefix = prefix.substring(0, index--)
        }

        return prefix
    }
}
