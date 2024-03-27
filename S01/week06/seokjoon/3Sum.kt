// https://leetcode.com/problems/3sum
// 707ms, 53.52mb

class Solution {
    var l = 0
    var r = 0
    var mid = 0
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()

        val tempList = intArrayOf(0,0) 
        for(i in 0 .. nums.lastIndex){
            if(i > 0 && tempList[0] == nums[i]) continue // 같은 값이 차례로 나오면 넘어간다.
            for(j in i + 1 .. nums.lastIndex){
                if(j > i + 1 && tempList[1] == nums[j]) continue

                binarySearch(nums,i, j, -1 * (nums[i] + nums[j])).let {
                    if(it != -1) result.add(listOf(nums[i],nums[j],nums[it]))
                }

                tempList[1] = nums[j] 
            }
            tempList[0] = nums[i]
        }
        return result
    }

    private fun binarySearch( // 선택가능한 범위 내에서 이분탐색으로 target Index 를 구한다. 
        nums : IntArray,
        start : Int,
        end : Int,
        target : Int
    ) : Int {
        l = end
        r = nums.lastIndex
        mid = 0
        while(l <= r){
            if(l == start || l == end){ // 선택되어 있는 인덱스는 건너뛴다. 
                 l += 1
                 continue
            }

            if(r == start || r == end){
                r -= 1
                continue
            }

            mid = (l + r) / 2

            if(nums[mid] > target ){
                r = mid - 1
            }else if(nums[mid] < target){
                 l = mid + 1
            }else {
                return mid
            }
        }
        return -1
    }
}
