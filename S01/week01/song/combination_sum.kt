fun main(args: Array<String>) {
    val test = Solution()
    println(test)
}

// Runtime: 206 ms, Memory: 39.5 MB
class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val ans = mutableListOf<MutableList<Int>>()
        comb(ans, candidates, target, 0, mutableListOf())
        return ans
    }

    private fun comb(
        ans: MutableList<MutableList<Int>>,
        candidates: IntArray,
        target: Int,
        index: Int,
        tmp: MutableList<Int>
    ) {
        if (target < 0) {
            return
        } else if (target == 0) {
            ans.add(tmp.toMutableList())
        } else {
            for (i in index until candidates.size) {
                val newTmp = tmp.toMutableList()
                newTmp.add(candidates[i])
                comb(ans, candidates, target - candidates[i], i, newTmp)
            }
        }
    }
}