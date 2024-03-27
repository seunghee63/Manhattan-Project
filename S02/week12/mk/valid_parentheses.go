// 1ms, 2.22mb
package main

import (
	"container/list"
	"fmt"
)

func main() {
	fmt.Println(isValid("()[]{}"))
}

type Stack struct {
	v *list.List
}

func NewStack() *Stack {
	return &Stack{list.New()}
}

func (s *Stack) Push(v interface{}) {
	s.v.PushBack(v)
}

func (s *Stack) Pop() interface{} {
	back := s.v.Back()
	if back == nil {
		return nil
	}

	return s.v.Remove(back)
}

func (s *Stack) Len() int {
	return s.v.Len()
}

func isValid(s string) bool {
	if len(s) < 2 {
		return false
	}

	stack := NewStack()
	for i := 0; i < len(s); i++ {
		char := s[i]
		if char == '(' || char == '{' || char == '[' {
			stack.Push(char)
		} else {
			if stack.Len() < 1 {
				return false
			}
			item := stack.Pop().(uint8)
			if char == ')' && item != '(' {
				return false
			}
			if char == '}' && item != '{' {
				return false
			}
			if char == ']' && item != '[' {
				return false
			}
		}
	}

	return stack.Len() == 0
}
