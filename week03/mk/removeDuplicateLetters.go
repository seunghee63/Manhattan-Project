// 3ms, 2.39mb
package main

import (
	"fmt"
)

func main() {
	fmt.Println(removeDuplicateLetters("cbacdcbc"))
}

// bcabc 라는 문자열이 있을 때 우리는 abc라는 결과 값을 도출해야 합니다.
// 앞으로 `|` 는 current 즉 s 문자열에서 현재 position 정보를 의미한다고 생각해주시면 되겠습니다.

// bc | `a`bc 까지 읽었다고 가정하면 우리는 bc를 버리고 a를 최상단으로 올려야 한다는 것을 알고 있습니다. 왜? a의 아스키코드값이 더 작으니
// 그러면 이 경우를 가정해 봅시다 bc | `d`abc 여기서 d가 나왔을 때 앞에 bc를 버려야할까요? 아니면 그대로 d만 뒤에 추가 하면 될까요
// 당연히 bc는 두고 d만 뒤에 추가 하면 됩니다.
// 그렇다면 우리는 아래와 같은 결론을 내볼 수 있습니다.
// 결과값으로 쌓고 있는 문자열에서 (bc) 맨 마지막 문자가 새로 탐색한 문자(a)에 비해 더 작다면 해당 문자를(c) 버린다. 그리고 이 행위를 무한히 반복한다.
// 새로 탐색한 문자 보다 더 큰 문자들을 모조리 제거
// 단! 버리려는 대상의 문자가 뒤에 또 나온다는 가정하에 위 작업이 이루어져야 합니다.
// bc | `a`bc 이 경우 bc는 뒤에 또 새로 나오니 버려도 상관 없지만
// ebc | `a`bc 이 경우 `e` 를 버려도 될까요?
// 안되죠 e는 앞으로 더 나오지 않는 즉 마지막 문자이기 때문에요 해서 이 경우 ea | bc 와 같은 결과를 만들어내야 합니다.
// count = 각 문자가 몇개가 존재하는지 개수를 체크 하는 map
// charSet = 결과 문자열에 어떤 문자들이 포함되어 있는 지 체크하는 map
// 동일한 문자가 이미 포함 되어 있다면 즉 `a`bc | `a`bc 라면 이때 a는 그냥 skip (continue) 처리 하면 되기 때문에 `charSet` 이라는 map 함수를 두어 이를 관리합니다.
func removeDuplicateLetters(s string) string {
	count, charSet := make(map[string]int), make(map[string]bool)
	result := ""

	for i := 0; i < len(s); i++ {
		char := string(s[i])
		count[char]++
	}

	for i := 0; i < len(s); i++ {
		current := string(s[i])
		count[current]--

		if _, exist := charSet[current]; exist {
			continue
		}

		if len(result) > 0 {
			for len(result) > 0 && lastChar(result) > current && count[lastChar(result)] > 0 {
				delete(charSet, lastChar(result))
				result = result[:len(result)-1]
			}
		}

		result += current
		charSet[current] = true
	}

	return result
}

func lastChar(s string) string {
	return string(s[len(s)-1])
}
