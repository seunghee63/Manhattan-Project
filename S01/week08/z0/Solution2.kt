class Solution {
    // 222 ms, 38 MB
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if(root == null) return emptyList()

        val map = mutableMapOf<Int, MutableList<Int>>()
        collectRoot(root, 0, map)

        val list = mutableListOf<List<Int>>()
        map.forEach { (_, it) ->
            list.add(it)
        }
        return list
    }

    private fun collectRoot(root: TreeNode?, level: Int, map: MutableMap<Int, MutableList<Int>>) {
        if(root == null) return

        map.getOrElse(level) { mutableListOf() }.apply {
            add(root.`val`)
            map[level] = this
        }

        collectRoot(root.left, level+1, map)
        collectRoot(root.right, level+1, map)
    }
}
