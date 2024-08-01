    fun losingPlayer(x: Int, y: Int): String {
        val gameCnt = minOf(x, y / 4)
        return if (gameCnt % 2 == 1) "Alice" else "Bob"
    }
