class Solution {
    // Runtime: 252ms(33.85%)
    // Memory: 39.30MB(46.15%)
    // Time taken: 10 m 0 s
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        var count = 0
        while(count < k) {
            val min = nums.min() // 가장 min값을 찾음
            val index = nums.indexOf(min) // min값의 index를 구함
            nums[index] = min * multiplier // min값에 곱셈
            count++ // k번만큼 반복
        }
        return nums
    }
    
    // 시간 복잡도: O(k * n) 이어서 다른 방식도 찾아보기로 함
}

class Solution {
    // Runtime: 243ms(44.62%)
    // Memory: 37.83MB(78.46%)
    // Time taken: 16 m 49 s
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        // 우선순위 큐를 사용하여 최소값이 가장 맨 앞에 위치
        val minHeap = PriorityQueue<Pair<Int, Int>> { o1, o2 -> 
            // first : nums[index], second : index
            // nums[index] 값이 같을 경우, index가 더 작은 값이 우선순위를 가짐
            if(o1.first == o2.first) o1.second - o2.second else o1.first - o2.first 
        }
        
        // nums를 순회하여 모든 값을 큐에 저장
        nums.forEachIndexed { index, i ->
            minHeap.add(Pair(i, index))
        }
        
        // k번 반복
        for (count in 0 until k) {
            val (minValue, index) = minHeap.poll() // 큐에서 값 꺼냄
            
            nums[index] = minValue * multiplier // min값에 곱셈
        
            minHeap.add(Pair(nums[index], index)) // 다시 큐에 값을 업데이트
        }
        
        return nums
    }
}
