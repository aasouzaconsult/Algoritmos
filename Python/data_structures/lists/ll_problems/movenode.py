# This is a variant on push(). Instead of creating a new node and pushing it
# onto the given list. move_node() takes two lists, removes the front node from
# the second list and pushes it onto the front of the first.


def move_node(head_a, head_b):
    if head_b is None:
        return head_a, head_b
    node = head_b
    head_b = head_b.next
    node.next = head_a
    head_a = node
    return head_a, head_b
