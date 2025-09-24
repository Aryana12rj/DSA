def add_lists(head1, head2):
    def reverse(head):
        prev = None
        while head:
            nxt = head.next
            head.next = prev
            prev = head
            head = nxt
        return prev

    head1 = reverse(head1)
    head2 = reverse(head2)
    carry = 0
    result = None

    while head1 or head2 or carry:
        val = carry
        if head1:
            val += head1.data
            head1 = head1.next
        if head2:
            val += head2.data
            head2 = head2.next
        carry, val = divmod(val, 10)
        new_node = Node(val)
        new_node.next = result
        result = new_node

    return result