from binary_tree import Node
from collections import deque


def huffman_decode(array, code):
    """

    Huffman code takes in an array of freq:data sets in the format
    [(freq1:data1), (freq2:data2), ...] and decode the *code* parameter
    according to huffman tree.

    """
    tree = generate_huffman_tree(array)
    result = ""
    trav = tree
    for num in code:
        if num == '0':
            trav = trav.left
        else:
            trav = trav.right
        if trav.left is None and trav.right is None:
            result += trav.data
            trav = tree
    return result


def huffman_table(array, tree):
    result = {}
    for item in array:
        print item[1]
        path = build_path(tree, item[1], [], "")
        result[item[1]] = path[0]
    return result


def build_path(node, alphabet, paths, path):
    if node is None:
        return
    build_path(node.left, alphabet, paths, path+"0")
    build_path(node.right, alphabet, paths, path+"1")
    if node.data == alphabet:
        paths.append(path)
    return paths


def generate_huffman_tree(array):
    while len(array) > 1:
        array.sort(key=lambda array: array[0])
        first = array.pop(0)
        second = array.pop(0)
        node = Node(first[0] + second[0])
        if type(first[1]) is str:
            node.left = Node(first[1])
        else:
            node.left = first[1]
        if type(second[1]) is str:
            node.right = Node(second[1])
        else:
            node.right = second[1]
        array.append((first[0] + second[0], node))
    return array[0][1]


def level_order_traversal(node):
    """
    Traverse the tree in level order sequence.

    """
    if node is None:
        return
    queue = deque([node])
    while len(queue) > 0:
        trav = queue.popleft()
        if type(trav) is str:
            print trav,
            continue
        else:
            print trav.data,
        if trav.left is not None:
            queue.append(trav.left)
        if trav.right is not None:
            queue.append(trav.right)
    print ""


if __name__ == "__main__":
    test = [(45, 'a'), (13, 'b'), (12, 'c'), (16, 'd'), (9, 'e'), (5, 'f')]
    test2 = [(45, 'a'), (13, 'b'), (12, 'c'), (16, 'd'), (9, 'e'), (5, 'f')]
    code = '001011101'
    print huffman_decode(test, code)
    print huffman_table(test2, generate_huffman_tree(test))
