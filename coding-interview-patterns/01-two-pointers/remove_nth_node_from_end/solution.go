package removenthnodefromend

import "patterns/pkg"

/*
	Given the head of a linked list, remove the nth node from the end of the list and return its head.

	Example 1:

	Input: head = [1,2,3,4,5], n = 2
	Output: [1,2,3,5]
	Example 2:

	Input: head = [1], n = 1
	Output: []
	Example 3:

	Input: head = [1,2], n = 1
	Output: [1]

	Constraints:

	The number of nodes in the list is sz.
	1 <= sz <= 30
	0 <= Node.val <= 100
	1 <= n <= sz
*/

func removeNthFromEnd(head *pkg.ListNode[int], n int) *pkg.ListNode[int] {
	dummy := pkg.ListNode[int]{
		Next: head,
	}

	curr, fast := &dummy, &dummy
	for i := 0; i <= n; i++ {
		fast = fast.Next
	}

	for fast != nil {
		curr = curr.Next
		fast = fast.Next
	}

	curr.Next = curr.Next.Next

	return dummy.Next
}
