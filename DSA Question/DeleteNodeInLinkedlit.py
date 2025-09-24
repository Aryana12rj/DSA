def delete_node(self, key):
    temp = self.head
    if temp and temp.data == key:
        self.head = temp.next
        return
    prev = None
    while temp and temp.data != key:
        prev = temp
        temp = temp.next
    if temp:
        prev.next = temp.next