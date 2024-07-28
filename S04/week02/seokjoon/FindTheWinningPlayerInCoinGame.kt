//145ms, 34.36mb

class Solution {
    fun losingPlayer(x: Int, y: Int) = if(min(x, y / 4) % 2 == 0) "Bob" else "Alice"
}
