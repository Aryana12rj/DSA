def insert_at_start(self, data):
    new_node = Node(data)
    new_node.next = self.head
    self.head = new_node