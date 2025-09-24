class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Brute Force Approach:
# 1. Convert both linked lists to integers.
# 2. Add the integers.
# 3. Convert the result back to a linked list.
def addTwoNumbers_bruteForce(l1: ListNode, l2: ListNode) -> ListNode:
    def toInt(node):
        num = 0
        place = 1
        while node:
            num += node.val * place
            place *= 10
            node = node.next
        return num

    num1 = toInt(l1)
    num2 = toInt(l2)
    total = num1 + num2

    # Convert integer back to linked list
    if total == 0:
        return ListNode(0)
    dummy = ListNode(0)
    curr = dummy
    while total:
        curr.next = ListNode(total % 10)
        curr = curr.next
        total //= 10
    return dummy.next

# Efficient Approach:
# Traverse both lists, add corresponding digits, handle carry, and build the result list.
def addTwoNumbers_efficient(l1: ListNode, l2: ListNode) -> ListNode:
    dummy = ListNode(0)
    curr = dummy
    carry = 0

    while l1 or l2 or carry:
        val1 = l1.val if l1 else 0
        val2 = l2.val if l2 else 0
        total = val1 + val2 + carry
        carry = total // 10
        curr.next = ListNode(total % 10)
        curr = curr.next
        if l1:
            l1 = l1.next
        if l2:
            l2 = l2.next

    return dummy.next

# Approach Explanation:
# Brute Force: Converts lists to integers, adds, and converts back. Not memory efficient for large numbers.
# Efficient: Adds digit by digit, handles carry, and builds the result list in one pass. O(max(N, M)) time and O(1) extra space.