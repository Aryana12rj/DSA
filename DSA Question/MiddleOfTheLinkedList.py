# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Brute Force Approach: Count nodes, then traverse to middle
def middleNode_brute_force(head: ListNode) -> ListNode:
    count = 0
    curr = head
    while curr:
        count += 1
        curr = curr.next
    mid = count // 2
    curr = head
    for _ in range(mid):
        curr = curr.next
    return curr

# Efficient Approach: Fast and slow pointer
def middleNode_efficient(head: ListNode) -> ListNode:
    slow = fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
    return slow

# Example usage:
# Create linked list: 1 -> 2 -> 3 -> 4 -> 5
head = ListNode(1)
head.next = ListNode(2)
head.next.next = ListNode(3)
head.next.next.next = ListNode(4)
head.next.next.next.next = ListNode(5)

# Brute force
mid_brute = middleNode_brute_force(head)
print("Brute force middle:", mid_brute.val)

# Efficient
mid_efficient = middleNode_efficient(head)
print("Efficient middle:", mid_efficient.val)