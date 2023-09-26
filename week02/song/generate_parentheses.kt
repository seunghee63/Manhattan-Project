//
fun generateParenthesis(n: Int): List<String> {
    val ans = mutableListOf<String>()
    val parenthesis = "(".repeat(n) + ")".repeat(n)
    comb(ans, parenthesis, n * 2, 0, "")
    return ans
}

private fun comb(
    ans: MutableList<String>,
    parenthesis: String,
    target: Int,
    index: Int,
    tmp: String
) {
    if (index == target) {
        if (isValid(tmp)) {
            ans.add(tmp)
        }
    } else {
        for (i in index until parenthesis.length) {
            val newTmp = tmp + parenthesis[i]
            comb(ans, parenthesis, target, i + 1, newTmp)
        }
    }
}

private fun isValid(combination: String): Boolean {
    var balance = 0

    combination.forEach {
        if (it == '(') {
            balance++
        } else {
            balance--
        }
        if (balance < 0) {
            return false
        }
    }
    return balance == 0
}