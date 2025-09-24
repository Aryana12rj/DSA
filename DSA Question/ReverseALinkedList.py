def reverse(self):
    prev = None
    current = self.head
    while current:
        nxt = current.next
        current.next = prev
        prev = current
        current = nxt
    self.head = prev