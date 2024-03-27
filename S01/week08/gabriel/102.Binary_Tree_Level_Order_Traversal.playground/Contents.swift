import UIKit
/*
 Runtime - 20ms
 Beats 14.01%of users with Swift
 Memory - 14.37MB
 Beats 90.93%of users with Swift
 */

public class TreeNode {
    public var val: Int
    public var left: TreeNode?
    public var right: TreeNode?
    public init() { self.val = 0; self.left = nil; self.right = nil; }
    public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
    public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
        self.val = val
        self.left = left
        self.right = right
    }
}
class Solution {
    func levelOrder(_ root: TreeNode?) -> [[Int]] {
        guard let root = root else { return [] }
        var result = [[Int]]()
        var queue = [TreeNode]()
        queue.append(root)

        while queue.isEmpty == false {
            var count = queue.count
            var elements = [Int]()
            for _ in 0..<count {
                let current = queue.removeFirst()
                elements.append(current.val)
                if let left = current.left {
                    queue.append(left)
                }

                if let right = current.right {
                    queue.append(right)
                }
            }

            result.append(elements)
        }

        return result
    }
}

