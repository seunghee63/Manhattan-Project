package main

func main() {

}
func isSubsequence(s string, t string) bool {
	sLen, tLen := len(s), len(t)

	sIndex, tIndex := 0, 0

	for sIndex < sLen && tIndex < tLen {
		if s[sIndex] == t[tIndex] {
			sIndex++
		}
		tIndex++
	}

	return sIndex == sLen
}
