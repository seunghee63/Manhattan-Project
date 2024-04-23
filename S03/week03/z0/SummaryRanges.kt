class Solution {
    // 169ms(20.24%)
    // 38.12MB(7.25%)
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) return emptyList()

        val result = mutableListOf<String>()
        var start = nums[0]
        var end = nums[0]

        for (i in 1..nums.lastIndex) {
            val preNumber = nums[i - 1]
            if (nums[i] > preNumber + 1) {
                if (start < end) {
                    result.add("$start->$end")
                } else {
                    result.add(start.toString())
                }
                start = nums[i]
            } else {
                end = nums[i]
            }
        }

        if (start < end) {
            result.add("$start->$end")
        } else {
            result.add(start.toString())
        }

        return result
    }
}
