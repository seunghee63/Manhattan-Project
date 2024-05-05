class Trie() {
    // 373ms(58.25%)
    // 55.77MB(51.09%)

    private val head = Node()

    fun insert(word: String) {
        var parent = head
        for(c in word) {
            val child = parent.children[c-'a'] ?: Node().apply { parent.children[c - 'a'] = this }
            parent = child
        }
        parent.isTerminal = true
    }

    fun search(word: String): Boolean = match(word, true)

    fun startsWith(prefix: String): Boolean = match(prefix, false)

    private fun match(word: String, fullMatch: Boolean): Boolean {
        var curNode = head
        for (c in word) {
            curNode.children[c-'a']?.let {
                curNode = it
            } ?: run {
                return false
            }
        }
        return if(fullMatch) curNode.isTerminal else true
    }

}

class Node {
    val children = arrayOfNulls<Node>(('a'..'z').count())
    var isTerminal : Boolean = false
}
