import Foundation
/*
 Runtime - 1399ms
 Beats 32.82%of users with Swift
 Memory - 33.11MB
 Beats 15.65%of users with Swift
 */
class Node {
    var prev, next: Node?
    let key, value: Int

    init(key: Int, value: Int) {
        self.key = key
        self.value = value
    }
}

extension Node: Hashable {
    static func == (lhs: Node, rhs: Node) -> Bool {
        lhs.key == rhs.key
    }
    
    func hash(into hasher: inout Hasher) {
        hasher.combine(key)
    }
}

extension Node: CustomDebugStringConvertible {
    var debugDescription: String {
        "key: \(key), value: \(value)"
    }
}

class LRUCache {
    private let capacity: Int
    private var caches = [Int: Node]()
    var head, tail: Node?

    init(_ capacity: Int) {
        self.capacity = capacity
        self.head = Node(key: -1, value: -1)
        self.tail = Node(key: -1, value: -1)
        head?.next = tail
        tail?.prev = head
    }

    func get(_ key: Int) -> Int {
        print("❤️❤️get key: \(key)")
        guard let node = caches[key] else { return -1 }
        removeNode(node)
        appendNode(node)
        return node.value
    }

    func put(_ key: Int, _ value: Int) {
        print("❤️❤️put key: \(key), value: \(value)")
        let newNode = Node(key: key, value: value)
        if let cache = caches[key] {
            removeNode(cache)
        }

        appendNode(newNode)
        caches[key] = newNode

        if caches.count > capacity {
            caches[tail!.prev!.key] = nil
            removeNode(tail!.prev)
        }
    }

    private func appendNode(_ node: Node) {
        let next = head?.next
        head?.next = node
        node.prev = head
        node.next = next
        next?.prev = node
    }

    private func removeNode(_ node: Node?) {
        node?.prev?.next = node?.next
        node?.next?.prev = node?.prev
    }
}
