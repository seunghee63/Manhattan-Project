// Runtime 418ms Beats 23.05% of users with Kotlin
// Memory 57.38MB Beats 27.73% of users with Kotlin
class Trie {
    val root = Node(Character.MIN_VALUE)

    fun insert(word: String) {
        var curDepth = root.children

        word.forEach { ch ->
            if (curDepth.containsKey(ch)) {
                curDepth = curDepth[ch]!!.children
                return@forEach
            }

            val new = Node(ch)
            curDepth[ch] = new
            curDepth = new.children
        }

        curDepth[Char.MIN_VALUE] = null
    }

    fun search(word: String): Boolean {
        var curDepth = root.children

        word.forEach { ch ->
            if (curDepth.containsKey(ch)) {
                curDepth = curDepth[ch]!!.children
                return@forEach
            }

            return false
        }

        return curDepth.containsKey(Char.MIN_VALUE)
    }

    fun startsWith(prefix: String): Boolean {
        var curDepth = root.children

        prefix.forEach { ch ->
            if (curDepth.containsKey(ch)) {
                curDepth = curDepth[ch]!!.children
                return@forEach
            }

            return false
        }

        return true
    }

    data class Node(val value: Char, val children: HashMap<Char, Node?> = HashMap())
}



/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
