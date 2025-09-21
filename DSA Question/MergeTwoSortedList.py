# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Brute Force Approach: Collect values, sort, and rebuild list
def mergeTwoLists_brute_force(list1, list2):
    vals = []
    while list1:
        vals.append(list1.val)
        list1 = list1.next
    while list2:
        vals.append(list2.val)
        list2 = list2.next
    vals.sort()
    dummy = ListNode()
    curr = dummy
    for v in vals:
        curr.next = ListNode(v)
        curr = curr.next
    return dummy.next

# Efficient Approach: Merge in-place using pointers
def mergeTwoLists_efficient(list1, list2):
    dummy = ListNode()
    curr = dummy
    while list1 and list2:
        if list1.val < list2.val:
            curr.next = list1
            list1 = list1.next
        else:
            curr.next = list2
            list2 = list2.next
        curr = curr.next
    curr.next = list1 if list1 else list2
    return dummy.next