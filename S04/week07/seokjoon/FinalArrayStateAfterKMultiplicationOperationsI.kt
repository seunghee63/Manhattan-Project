//228ms , 38mb

class Solution {
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        // 우선순위큐를 이용하여 nums의 인덱스와 값을 저장하고, 값을 오름차순 정렬하되 같은 경우 인덱스 오름차순으로 정렬한다.
        val pq = PriorityQueue<Pair<Int,Int>>({ p1, p2 ->
            if(p1.second != p2.second) p1.second - p2.second 
            else p1.first - p2.first
        })
        // 우선순위 값 추가
        nums.forEachIndexed { idx, value ->
            pq.add(Pair(idx,value))
        }
        // 오름차순 이므로 poll해서 나온 값이 가장 작으므로 multiplie로 곱하고 해당 인덱스에 값을 갱신시켜준다.
        repeat(k){
            val (idx, value) = pq.poll()
            pq.add(Pair(idx, value * multiplier))
            nums[idx] = value * multiplier
        }
        
        return nums
    }
}
