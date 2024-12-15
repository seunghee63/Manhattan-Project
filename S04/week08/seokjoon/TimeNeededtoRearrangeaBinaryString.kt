class Solution {
    fun secondsToRemoveOccurrences(s: String): Int {
        var answer = 0
        var str = s
        while(true){ // "01" 이 없을 때까지 while문을 돌면서 "01" 을 "10"으로 바꿔주고 answer에 1을 더해준다.
            if(str.contains("01")){
                str = str.replace("01","10")
                answer++
            }else {
                return answer
            }
        }
    }
}
