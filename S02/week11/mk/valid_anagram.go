// 8ms, 2.86mb
package main

import "fmt"

func main() {
	fmt.Println(isAnagram("ac", "bb"))
}

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	mp := map[int]int{}
	for i := 0; i < len(s); i++ {
		sAscii := (int)(s[i] - 'a')
		tAscii := (int)(t[i] - 'a')
		mp[sAscii] = mp[sAscii] + 1
		mp[tAscii] = mp[tAscii] - 1

	}

	for _, v := range mp {
		if v != 0 {
			return false
		}
	}

	return true
}
