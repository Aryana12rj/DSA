def length(self):
    count = 0
    temp = self.head
    while temp:
        count += 1
        temp = temp.next
    return count