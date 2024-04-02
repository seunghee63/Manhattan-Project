package main

import "strings"

func reverseWords(s string) string {
	words := strings.Fields(s)

	start := 0
	end := len(words) - 1

	for start < end {
		words[start], words[end] = words[end], words[start]
		start++
		end--
	}

	return strings.Join(words, " ")
}
