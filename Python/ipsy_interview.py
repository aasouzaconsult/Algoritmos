"""
Consider this Node definition for a Linked List:

public class Node {
  int value; // value of the node
  Node next; // next pointer for the node in the linked list
  Node other; // pointer to a random node in the linked list
}

Write a method that creates a copy of a linked list with the node definition above. 

// (value, next, other)
// N1 (3, N2, N4)  N2 (4, N3, N1)   N3 (4, N4, null)  N4 (12, null, N1)

// New1 (3, New2, New4)  New2 (4, New3, New1)   New3 (4, New4, null)  New4 (12, null, New1)
// key, object
// key=head_ref, object=new_head_reference

/**
 * Creates a deep copy of the linked list
 * @param head - represents the head of the linked list
 * @return New head for the list, with all the elements copied
 */
Node copyList(Node head) {

}
# assumptions:
# 1.  max infinite
# 2. perform check for null link list
# 3. value is integers

def __init__(self, value, next=None, other=None)

# python
# O(n)
"""
def copyList(head):
    # check head is null
    if head is None:
        return None
    node_dict = {}
    new_head = Node(head.value, head.next, head.other)
    new_curr = new_head
    # traverse the list based on next pointer
    curr = head.next
    while curr is not None:
        new_curr.next = Node(curr.value, curr.next, curr.other)
        node_dict[curr] = new_curr
        new_curr = new_curr.next
        curr = curr.next
    # for every other pointer, point to the new_head equiv node
    curr = head
    new_curr = new_head
    while curr is not None:
        new_curr.other = node_dict[curr.other]
        new_curr = new_curr.next
        curr = curr.next
    # new_head == head
    return new_head