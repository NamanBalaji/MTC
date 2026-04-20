package validpalindrome

import (
	"strings"
	"unicode"
)

/*
	A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
	and removing all non-alphanumeric characters, it reads the same forward and backward.
	Alphanumeric characters include letters and numbers.

	Given a string s, return true if it is a palindrome, or false otherwise.

	Example 1:

	Input: s = "A man, a plan, a canal: Panama"
	Output: true
	Explanation: "amanaplanacanalpanama" is a palindrome.
	Example 2:

	Input: s = "race a car"
	Output: false
	Explanation: "raceacar" is not a palindrome.
	Example 3:

	Input: s = " "
	Output: true
	Explanation: s is an empty string "" after removing non-alphanumeric characters.
	Since an empty string reads the same forward and backward, it is a palindrome.


	Constraints:

	1 <= s.length <= 2 * 105
	s consists only of printable ASCII characters.
*/

func IsPalindrome(s string) bool {
	runes := []rune(strings.ToUpper(s))

	i, j := 0, len(runes)-1
	for i < j {
		if !unicode.IsLetter(runes[i]) && !unicode.IsDigit(runes[i]) {
			i++
			continue
		}

		if !unicode.IsLetter(runes[j]) && !unicode.IsDigit(runes[j]) {
			j--
			continue
		}

		if runes[i] != runes[j] {
			return false
		}

		i++
		j--
	}

	return true
}
