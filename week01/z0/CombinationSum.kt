class Solution {
  // 케이스 통과 다 못함...ㅠ
  // candidates = [7,3,2] / target = 18 인 케이스

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        if(target == 1) return mutableListOf()

        val sortedCandidates = candidates.sorted()
        val result = mutableSetOf<List<Int>>()
        for(i in 0 .. sortedCandidates.lastIndex) {
            val pieces = findRemain(sortedCandidates, target, i, mutableListOf())
            if(pieces.sum() == target) {
                result.add(pieces.sorted())
            }
        }
        return result.toList()
    }

    private fun findRemain(candidates: List<Int>, target: Int, startIndex: Int, temp: MutableList<Int>): MutableList<Int> {
        for(i in startIndex..candidates.lastIndex) {
            val remain = target - candidates[i]
            when {
                remain == 0 -> {
                    temp.add(candidates[i])
                    return temp
                }
                remain == 1 -> continue
                remain > 0 -> {
                    if(findRemain(candidates, remain, 0, temp).lastOrNull() == -1) {
                        temp.removeLast()
                        continue
                    } else {
                        temp.add(candidates[i])
                        return temp
                    }
                }
                else -> {
                    temp.add(-1)
                    return temp
                }
            }
        }
        return temp
    }
}
