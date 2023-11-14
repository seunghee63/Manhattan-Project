import UIKit

extension Array {
    internal func validate(index: Index) -> Index? {
        if self.startIndex <= index && index < self.endIndex {
            return index
        }

        return nil
    }

    public subscript(safe index: Index?) -> Element? {
        return index.flatMap(self.validate)
                    .map { self[$0] }
    }
}

class Solution {
    func coinChange(_ coins: [Int], _ amount: Int) -> Int {
        guard amount > 0 else { return 0 }
        let sortedCoins = coins.sorted { $0 > $1 }
        var dpArray = [Int]()
        dpArray.append(0)

        for i in 1...amount {
            var coinIndex = 0
            var diff = i
            var count = 0

            while(coinIndex < sortedCoins.count) {
                count += 1

                if sortedCoins[coinIndex] > diff {
                    coinIndex += 1
                } else {
                    diff = diff - sortedCoins[coinIndex]
                }

                if diff == 0 {
                    dpArray.append(1)
                    break
                } else {
                    if let dpElement = dpArray[safe: diff] {
                        dpArray.append(1+dpElement)
                        diff = 0
                        break
                    }
                }

            }

            if coinIndex < sortedCoins.count && diff != 0 {
                dpArray.append(-1)
            }
        }

        print(dpArray)
        return dpArray.last ?? -1
    }
}



Solution().coinChange([2], 3)
