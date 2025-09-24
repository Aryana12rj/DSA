def insert_at_position(self, data, pos):
    new_node = Node(data)
    if pos == 0:
        self.insert_at_start(data)
        return
    temp = self.head
    for _ in range(pos - 1):
        if not temp:
            return
        temp = temp.next
    new_node.next = temp.next
    temp.next = new_node