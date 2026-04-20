package validpalindrome_test

import (
	"testing"

	validpalindrome "patterns/01-two-pointers/valid_palindrome"
)

func TestIsPlaindrome(t *testing.T) {
	tests := []struct {
		name     string
		input    string
		expected bool
	}{
		{name: "case 1", input: "A man, a plan, a canal: Panama", expected: true},
		{name: "case 2", input: "race a car", expected: false},
		{name: "case 3", input: " ", expected: true},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got := validpalindrome.IsPalindrome(tt.input)
			if got != tt.expected {
				t.Fatalf("IsPalindrome(%s) = %t, want %t", tt.input, got, tt.expected)
			}
		})
	}
}
