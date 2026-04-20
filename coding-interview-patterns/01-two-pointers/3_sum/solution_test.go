package threesum

import (
	"reflect"
	"testing"
)

func TestThreeSum(t *testing.T) {
	tests := []struct {
		name     string
		input    []int
		expected [][]int
	}{
		{name: "case 1", input: []int{-1, 0, 1, 2, -1, -4}, expected: [][]int{{-1, -1, 2}, {-1, 0, 1}}},
		{name: "case 2", input: []int{0, 1, 1}, expected: [][]int{}},
		{name: "case 3", input: []int{0, 0, 0}, expected: [][]int{{0, 0, 0}}},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got := threeSum(tt.input)
			if len(got) == 0 && len(tt.expected) == 0 {
				return
			}
			if !reflect.DeepEqual(got, tt.expected) {
				t.Fatalf("threeSum(%v) = %v, want %v", tt.input, got, tt.expected)
			}
		})
	}
}
