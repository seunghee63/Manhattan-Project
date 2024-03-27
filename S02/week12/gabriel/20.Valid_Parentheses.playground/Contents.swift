import UIKit

class Solution {
    func isValid(_ s: String) -> Bool {
        var stack = [Character]()
        var interrupt = false

        Array(s).forEach { char in
            switch char {
            case "(","{","[":
                stack.append(char)
            case ")","}","]":
                if let first = stack.last,
                   first == char.pairString {
                    stack.removeLast()
                } else {
                    interrupt = true
                    break
                }
            default:
                interrupt = true
                break
            }
        }

        if interrupt {
            return false
        }

        return stack.count == 0
    }
}

extension Character {
    var pairString: Character {
        switch self {
        case ")": return "("
        case "}": return "{"
        case "]": return "["
        default: return self
        }
    }
}
