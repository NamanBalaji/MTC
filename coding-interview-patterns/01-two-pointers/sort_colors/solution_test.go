package sortcolors

import (
	"reflect"
	"testing"
)

func TestSortColors(t *testing.T) {
	tests := []struct {
		name     string
		input    []int
		expected []int
	}{
		{name: "case 1", input: []int{2, 0, 2, 1, 1, 0}, expected: []int{0, 0, 1, 1, 2, 2}},
		{name: "case 2", input: []int{2, 0, 1}, expected: []int{0, 1, 2}},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			sortColors(tt.input)
			if !reflect.DeepEqual(tt.input, tt.expected) {
				t.Fatalf("sortColors() = %v, want %v", tt.input, tt.expected)
			}
		})
	}
}
