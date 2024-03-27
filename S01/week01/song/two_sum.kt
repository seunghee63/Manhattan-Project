fun main(args: Array<String>) {
    val test = Solution()
    println(test)
}

// Runtime: 204 ms, Memory: 37.8 MB
class Solution {

    // o(n^2)
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (target == nums[i] + nums[j]) {
                    return intArrayOf(i, j)
                }
            }
        }
        return nums
    }

    // o(n)
    fun twoSumOn(nums: IntArray, target: Int): IntArray {
        var hm = HashMap<Int, Int>()

        for (i in 0..nums.size) {
            if (hm.containsKey(target - nums[i])) {
                return intArrayOf(hm[target - nums[i]]!!, i)
            }
            hm[nums[i]] = i
        }

        return intArrayOf()
    }
}