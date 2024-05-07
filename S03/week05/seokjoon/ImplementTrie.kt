//426ms, 52.41mb

class Trie() {
    private val headTrieNode = TrieNode()

    fun insert(word: String) {
        var cur = headTrieNode
        
        for(i in 0 until word.length){
            val curChar = word[i]
            if(!cur.nextMap.contains(curChar)){
                cur.nextMap[curChar] = TrieNode(curChar)
            }
            cur = cur.nextMap.getValue(curChar)
        }
        cur.nextMap['\n'] = TrieNode()
    }

    fun search(word: String): Boolean {
        var cur = headTrieNode
        word.forEach {
            if(cur.nextMap.contains(it)) cur = cur.nextMap.getValue(it)
            else return false
        }
        return cur.nextMap.contains('\n')
    }

    fun startsWith(prefix: String): Boolean {
        var cur = headTrieNode
        prefix.forEach {
            if(cur.nextMap.contains(it)) cur = cur.nextMap.getValue(it)
            else return false
        }
        return true
    }
}

data class TrieNode(
    val char : Char = '\n',
    val nextMap : MutableMap<Char,TrieNode> = mutableMapOf()
)
