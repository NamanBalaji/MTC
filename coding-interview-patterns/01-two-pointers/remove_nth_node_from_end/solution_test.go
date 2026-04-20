package removenthnodefromend

import (
	"patterns/pkg"
	"reflect"
	"testing"
)

func buildList(vals []int) *pkg.ListNode[int] {
	dummy := &pkg.ListNode[int]{}
	curr := dummy
	for _, v := range vals {
		curr.Next = &pkg.ListNode[int]{Value: v}
		curr = curr.Next
	}
	return dummy.Next
}

func toSlice(head *pkg.ListNode[int]) []int {
	var out []int
	for head != nil {
		out = append(out, head.Value)
		head = head.Next
	}
	return out
}

func TestRemoveNthFromEnd(t *testing.T) {
	tests := []struct {
		name     string
		input    []int
		n        int
		expected []int
	}{
		{name: "case 1", input: []int{1, 2, 3, 4, 5}, n: 2, expected: []int{1, 2, 3, 5}},
		{name: "case 2", input: []int{1}, n: 1, expected: nil},
		{name: "case 3", input: []int{1, 2}, n: 1, expected: []int{1}},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got := toSlice(removeNthFromEnd(buildList(tt.input), tt.n))
			if !reflect.DeepEqual(got, tt.expected) {
				t.Fatalf("removeNthFromEnd(%v, %d) = %v, want %v", tt.input, tt.n, got, tt.expected)
			}
		})
	}
}
