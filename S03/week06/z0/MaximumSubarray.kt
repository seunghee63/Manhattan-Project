class Solution {
    // 413ms(87.37%)
    // 54.35MB(60.38%)
    fun maxSubArray(nums: IntArray): Int {
        var totalMax = Int.MIN_VALUE
        var subArrayMax = 0
        nums.forEach {
            // n번째까지의 (최대)합과 n번째 값을 비교
            // M(n) = Max(M(n-1)+n,n)
            subArrayMax = max(subArrayMax + it, it)
            // Max(M(0),..,M(n))
            totalMax = max(subArrayMax, totalMax)
        }
        return totalMax
    }
}
