class Solution {
    // 334 ms, 43.9 MB
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy { // 조건에 따라 리스트 원소 묶기. Map<key,List<>>를 반환
            it.toCharArray().sorted() // 주어진 단어를 알파벳 순서로 sort 시킨 후, 그 기준으로 원소들을 묶기
        }.values.toList() // map의 value들만 꺼내서 List로 만들기
    }

}
