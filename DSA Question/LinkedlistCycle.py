# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

# Brute Force Approach: Using a set to track visited nodes
def hasCycle_brute_force(head: ListNode) -> bool:
    visited = set()
    current = head
    while current:
        if current in visited:
            return True
        visited.add(current)
        current = current.next
    return False

# Efficient Approach: Floyd's Tortoise and Hare Algorithm
def hasCycle_efficient(head: ListNode) -> bool:
    slow = fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow == fast:
            return True
    return False