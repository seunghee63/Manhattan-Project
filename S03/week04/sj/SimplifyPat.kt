// Runtime 215ms Beats 35.78% of users with Kotlin
// Memory 38.25MB Beats 37.68% of users with Kotlin
class Solution {
        fun simplifyPath(path: String): String {
            val pathBucket = Stack()

            val dirs = path.split("/")
            for (dir in dirs) {
                if (dir == "..") {
                    pathBucket.pop()
                    continue
                }

                if (dir == "" || dir == ".") {
                    continue
                }

                pathBucket.push(dir)
            }

            return pathBucket.elements.takeWhile { it != null }.joinToString (separator = "/", prefix = "/")
        }


        class Stack {
            val elements = arrayOfNulls<String>(3000)
            var size = 0

            fun push(element: String) {
                elements[size] = element
                size++
            }

            fun pop(): String? {
                if (size <= 0) {
                    return null
                }

                size--
                val pop = elements[size]
                elements[size] = null

                return pop
            }
        }
}
