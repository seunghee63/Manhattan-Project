// 309ms , 42.06mb

class Solution {
    fun countPairs(nums: IntArray): Int {
        // 자리수가 더 큰 숫자들을 먼저 순회하기 위해 내림차순으로 정렬 (아래에 추가 설명)
        nums.sortDescending()

        // 각 수마다 두 개의 자리수를 swap하여 만들 수 있는 수들을 저장하는 set
        val arr = Array(nums.size){
            mutableSetOf<Int>()
        }

        // 각 수마다 두 개의 자리수를 swap하여 만들 수 있는 수를 저장하는 로직
        nums.forEachIndexed { idx , num ->
            arr[idx].add(num)
            val numStr = num.toString()
            for(i in 0 until numStr.length){
                for(j in i + 1 until numStr.length){
                    val target = numStr.substring(0, i) + numStr[j] + numStr.substring(i+ 1, j) + numStr[i] + numStr.substring(j+1,numStr.length)
                    arr[idx].add(target.toInt())
                }
            }
        }
        var answer = 0

        // nums를 순회하면서 해당 수로 만들 수 있는 `두 자리 수가 스왑된 수` set에 포함되어 있으면 answer를 1 더해준다. 
        // 이 때 3의 경우, 30이 almost equal라는 것을 알지 못하지만 (3의 set에는 3밖에 없으므로)
        // 30의 경우, 3이 almost equal라는 것을 알 수 있다. (30의 set에는 3과 30이 있으므로) 
        // 따라서 큰 수를 먼저 순회하도록 앞에서 내림차순 정렬을 해준다.
        for(i in 0 until nums.size){
            for(j in i + 1 until nums.size){
                if(arr[i].contains(nums[j])) answer += 1
            }
        }
        return answer
    }
}
