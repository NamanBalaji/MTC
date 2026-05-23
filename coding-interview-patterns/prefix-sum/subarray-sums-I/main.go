// https://cses.fi/problemset/task/1660
package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strconv"
)

// Given an array of n positive integers, your task is to count the number of subarrays having sum x.
//
// Input
// 	The first input line has two integers n and x: the size of the array and the target sum x.
// 	The next line has n integers a_1,a_2,\dots,a_n: the contents of the array.
//
// Output
// 	Print one integer: the required number of subarrays.
//
// Constraints
// 	1 <= n <= 2 <= 2 * 10^5
// 	1 <= x,a_i <= 10^9
//
// Example
// 	Input:
// 		5 7
// 		2 4 1 2 7
//
// 	Output:
// 		3

var reader *bufio.Scanner

func readInt() int {
	reader.Scan()
	x, err := strconv.Atoi(reader.Text())
	if err != nil {
		log.Fatal(err)
	}

	return x
}

func main() {
	reader = bufio.NewScanner(os.Stdin)
	reader.Split(bufio.ScanWords)

	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	n, target := readInt(), readInt()

	nums := make([]int, n)
	for i := range n {
		nums[i] = readInt()
	}

	fmt.Fprintf(writer, "%d\n", findSubarray(nums, target))
}

func findSubarray(nums []int, target int) int {
	n := len(nums)
	p := make([]int, n+1)

	set := make(map[int]struct{})
	set[0] = struct{}{}

	subarrayCount := 0
	for i := 1; i <= n; i++ {
		p[i] = p[i-1] + nums[i-1]
		set[p[i]] = struct{}{}

		if _, ok := set[p[i]-target]; ok {
			subarrayCount++
		}
	}

	return subarrayCount
}
