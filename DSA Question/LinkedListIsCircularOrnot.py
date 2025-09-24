def is_circular(self):
    temp = self.head
    while temp and temp.next:
        temp = temp.next
        if temp == self.head:
            return True
    return False