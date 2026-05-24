// https://cses.fi/problemset/task/1662
package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strconv"
)

// Given an array of n integers, your task is to count the number of subarrays where the sum of values is divisible by n.
//
// 	Input
// 		The first input line has an integer n: the size of the array.
// 		The next line has n integers a_1,a_2,...,a_n: the contents of the array.
//
// 	Output
// 		Print one integer: the required number of subarrays.
//
// 	Constraints
// 		1 <= n <= 2 * 10^5
// 		-10^9 <= a_i <= 10^9
//
// 	Example
// 		Input:
// 			5
// 			3 1 2 7 4
//
// 		Output:
// 			1

func readInt() int {
	reader.Scan()

	x, err := strconv.Atoi(reader.Text())
	if err != nil {
		log.Fatal(err)
	}

	return x
}

var reader *bufio.Scanner

func main() {
	reader = bufio.NewScanner(os.Stdin)
	reader.Split(bufio.ScanWords)

	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	n := readInt()
	nums := make([]int, n)

	for i := range n {
		nums[i] = readInt()
	}

	fmt.Fprintf(writer, "%d\n", countSubarrays(nums, n))
}

func countSubarrays(nums []int, n int) int {
	p := make([]int, n+1)
	set := make(map[int]int)
	set[0] = 1

	count := 0
	for i := 1; i < n+1; i++ {
		p[i] = p[i-1] + nums[i-1]

		rem := p[i] % n
		if rem < 0 {
			rem += n
		}

		if c, ok := set[rem]; ok {
			count += c
		}
		set[rem]++
	}

	return count
}
