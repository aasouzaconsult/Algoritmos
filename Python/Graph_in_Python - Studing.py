# Criando uma matriz de adjacência dado uma lista de adjacências
graph = {'1': [{'2':'15'}, {'4':'7'}, {'5':'10'}],
    '2': [{'3':'9'}, {'4':'11'}, {'6':'9'}],
    '3': [{'5':'12'}, {'6':'7'}],
    '4': [{'5':'8'}, {'6':'14'}],
    '5': [{'6':'8'}]}
	
import numpy
def weighted_adjmatrix(adjlist, nodes):
    '''Returns a (weighted) adjacency matrix as a NumPy array.'''
    matrix = []
    for node in nodes:
        weights = {endnode:int(weight)
                   for w in adjlist.get(node, {})
                   for endnode, weight in w.items()}
        matrix.append([weights.get(endnode, 0) for endnode in nodes])
    matrix = numpy.array(matrix)
    return matrix + matrix.transpose()

MA = weighted_adjmatrix(graph, nodes=list('123456'))

#Out[4]: 
#array([[  0, 15,  0,  7, 10,  0],
#          [15,  0,  9, 11,  0,  9],
#          [  0,  9,  0,  0, 12,  7],
#          [  7, 11,  0,  0,  8, 14],
#          [10,  0, 12,  8,  0,  8],
#          [  0,  9,  7, 14,  8,  0]])

# Graficamente
G = nx.from_numpy_matrix(np.array(Alex), create_using=nx.MultiDiGraph())
pos = nx.circular_layout(G)
nx.draw_circular(G)
labels = {i : i + 1 for i in G.nodes()}
nx.draw_networkx_labels(G, pos, labels, font_size=15)
plt.show()


###########
## Sample 2 ##
###########

import networkx as nx
import matplotlib.pyplot as plt

def draw_graph(graph, labels=None, graph_layout='shell',
               node_size=1600, node_color='blue', node_alpha=0.3,
               node_text_size=12,
               edge_color='blue', edge_alpha=0.3, edge_tickness=1,
               edge_text_pos=0.3,
               text_font='sans-serif'):

    # create networkx graph
    G=nx.Graph()

    # add edges
    for edge in graph:
        G.add_edge(edge[0], edge[1])

    # these are different layouts for the network you may try
    # shell seems to work best
    if graph_layout == 'spring':
        graph_pos=nx.spring_layout(G)
    elif graph_layout == 'spectral':
        graph_pos=nx.spectral_layout(G)
    elif graph_layout == 'random':
        graph_pos=nx.random_layout(G)
    else:
        graph_pos=nx.shell_layout(G)

    # draw graph
    nx.draw_networkx_nodes(G,graph_pos,node_size=node_size, 
                           alpha=node_alpha, node_color=node_color)
    nx.draw_networkx_edges(G,graph_pos,width=edge_tickness,
                           alpha=edge_alpha,edge_color=edge_color)
    nx.draw_networkx_labels(G, graph_pos,font_size=node_text_size,
                            font_family=text_font)

    if labels is None:
        labels = range(len(graph))

    edge_labels = dict(zip(graph, labels))
    nx.draw_networkx_edge_labels(G, graph_pos, edge_labels=edge_labels, 
                                 label_pos=edge_text_pos)

    # show graph
    plt.show()

graph = [(0, 1), (1, 5), (1, 7), (4, 5), (4, 8), (1, 6), (3, 7), (5, 9),
         (2, 4), (0, 4), (2, 5), (3, 6), (8, 9)]

# you may name your edge labels
labels = map(chr, range(65, 65+len(graph)))
#draw_graph(graph, labels)

# if edge labels is not specified, numeric labels (0, 1, 2...) will be used
draw_graph(graph)


# https://stackoverflow.com/questions/29464252/adjacency-matrix-in-python
# https://stackoverflow.com/questions/29572623/plot-networkx-graph-from-adjacency-matrix-in-csv-file
# https://www.udacity.com/wiki/creating-network-graphs-with-python
