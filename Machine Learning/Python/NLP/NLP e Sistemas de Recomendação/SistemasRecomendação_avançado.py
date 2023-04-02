
# coding: utf-8

# # Sistemas avançados de recomendação com Python
# 
# Bem-vindo ao notebook sobre criação de sistemas avançados de recomendação com Python. Este é um notebook de referência opcional. Atualmente não há vídeo para esta palestra por causa do nível de matemática usado e do uso intenso do SciPy aqui.
# 
# Os sistemas de recomendação geralmente dependem de conjuntos de dados maiores e, especificamente, precisam ser organizados de forma particular. Devido a isso, não teremos um projeto para acompanhar este tópico, em vez disso, teremos um processo passo a passo mais intenso na criação de um sistema de recomendação com Python com o mesmo conjunto de dados de filme.
# 
# * Nota: A matemática real por trás dos sistemas de recomendação é bastante pesada na Álgebra Linear. *

# ## Métodos utilizados
# 
# Dois tipos mais comuns de sistemas de recomendação são  baseados em ** conteúdo colaborativo e filtragem colaborativa (CF) **.
# 
# * A filtragem colaborativa produz recomendações com base no conhecimento da atitude dos usuários em relação aos itens, que é usar a "sabedoria da multidão" para recomendar itens.
# * Os sistemas de recomendação baseados no conteúdo se concentram nos atributos dos itens e oferecem recomendações com base na semelhança entre eles.
# 
# ## Filtragem colaborativa
# 
# Em geral, a filtragem colaborativa (CF) é mais comumente usada do que sistemas baseados em conteúdo colaborativo, porque geralmente dá melhores resultados e é relativamente fácil de entender (a partir de uma perspectiva de implementação geral). O algoritmo tem a capacidade de fazer o aprendizado de recursos por conta própria, o que significa que pode começar a aprender por si mesmo e quais recursos usar.
# 
# CF pode ser dividido em ** Filtragem colaborativa baseada em memória ** e ** Filtragem colaborativa baseada em modelos **.
# 
# Neste tutorial, implementaremos o CF baseado em modelo usando a decomposição de valor singular (SVD) e o CF baseado em memória, calculando a similaridade do coseno.
# 
# ## Os dados
# 
# Usaremos o famoso conjunto de dados MovieLens, que é um dos conjuntos de dados mais comuns usados ​​na implementação e teste dos engines recomendadoras. Contém mais de 100.000 classificações de filmes de 943 usuários e uma seleção de 1682 filmes.
# 
# Você pode baixar o conjunto de dados [aqui](http://files.grouplens.org/datasets/movielens/ml-100k.zip) ou apenas usar o arquivo u.data que já está incluído nesta pasta.
# 
# ____
# ## Começando
# 
# Vamos importar algumas bibliotecas que precisaremos:

# In[2]:

import numpy as np
import pandas as pd


# Podemos então ler no arquivo ** u.data **, que contém o conjunto de dados completo. Você pode ler uma breve descrição do conjunto de dados [aqui](http://files.grouplens.org/datasets/movielens/ml-100k-README.txt).
# 
# Observe como especificamos o argumento separador para um arquivo separador de tabulação.

# In[3]:

column_names = ['user_id', 'item_id', 'rating', 'timestamp']
df = pd.read_csv('u.data', sep='\t', names=column_names)


# Vamos dar uma rápida olhada nos dados.

# In[4]:

df.head()


# Observe como só temos o item_id, e não o nome do filme. Podemos usar o arquivo csv Movie_ID_Titles para pegar os nomes dos filmes e juntá-los com este dataframe:

# In[15]:

movie_titles = pd.read_csv("Movie_Id_Titles")
movie_titles.head()


# Em seguida, junte os dataframes:

# In[16]:

df = pd.merge(df,movie_titles,on='item_id')
df.head()


# Agora vamos dar uma olhada no número de usuários e filmes exclusivos.

# In[26]:

n_users = df.user_id.nunique()
n_items = df.item_id.nunique()

print('Num. of Users: '+ str(n_users))
print('Num of Movies: '+str(n_items))


# ## Split teste-treino
# 
# Os sistemas de recomendação por sua própria natureza são muito difíceis de avaliar, mas ainda mostraremos como avaliá-los neste tutorial. Para fazer isso, dividiremos nossos dados em dois conjuntos. No entanto, não vamos fazer o nosso clássico X_train, X_test, y_train, y_test split. Em vez disso, podemos realmente apenas segmentar os dados em dois conjuntos de dados:

# In[27]:

from sklearn.cross_validation import train_test_split
train_data, test_data = train_test_split(df, test_size=0.25)


# ## Filtragem colaborativa baseada em memória
# 
# As abordagens de filtragem colaborativa baseada em memória podem ser divididas em duas seções principais: ** filtragem de itens do usuário ** e ** filtragem de item-item **.
# 
# A * filtragem de itens para usuários * pegará um usuário específico, encontrará usuários que sejam semelhantes a esse usuário com base na similaridade de avaliações e recomendem itens que esses usuários semelhantes gostaram.
# 
# Em contraste, * item-item filtering * pegará um item, encontrará usuários que gostaram desse item e encontre outros itens que esses usuários ou usuários similares também gostaram. Assim, pega itens e exibe outros itens como recomendações.
# 
# * * Filtragem colaborativa item-item  *: "Usuários que gostaram deste item também gostaram ..."
# * * Filtragem colaborativa do usuário-item *: "Usuários que são semelhantes a você também gostaram ..."

# Em ambos os casos, você criará uma matriz de item de usuário que foi construída a partir de todo o conjunto de dados.
# 
# Uma vez que dividimos os dados em testes e treinamento, precisaremos criar duas matrizes `` [943 x 1682] `` (todos os usuários por todos os filmes).
# 
# A matriz de treinamento contém 75% das avaliações e a matriz de teste contém 25% das avaliações.

# Exemplo de uma matriz item a item (referência em inglês):
# <img class="aligncenter size-thumbnail img-responsive" src="http://s33.postimg.org/ay0ty90fj/BLOG_CCA_8.png" alt="blog8"/>

# Depois de ter compilado a matriz do item do usuário, você calcula a similaridade e cria uma matriz de similaridade.
# 
# Os valores de similaridade entre itens na * Filtragem colaborativa * são medidos observando todos os usuários que avaliaram os dois itens.
# 
# <img class="aligncenter size-thumbnail img-responsive" style="max-width:100%; width: 50%; max-width: none" src="http://s33.postimg.org/i522ma83z/BLOG_CCA_10.png"/>

# Para a * Filtragem Colaborativa de usuário-Item * os valores de similaridade entre usuários são medidos observando todos os itens que são classificados por ambos os usuários.
# 
# <img class="aligncenter size-thumbnail img-responsive" style="max-width:100%; width: 50%; max-width: none" src="http://s33.postimg.org/mlh3z3z4f/BLOG_CCA_11.png"/>

# Uma métrica de distância comumente usada nos sistemas de recomendação é * similaridade coseno *, onde as classificações são vistas como vetores no espaço dimensional `` n`` e a similaridade é calculada com base no ângulo entre esses vetores.
# A similaridade dos cosenos para os usuários * a * e * m * pode ser calculada usando a fórmula abaixo, onde você tira produto do vetor do usuário * $ u_k $ * e o vetor do usuário * $ u_a $ * e divide-o pela multiplicação dos comprimentos dos vetores euclidianos.
# <img class="aligncenter size-thumbnail img-responsive" src="https://latex.codecogs.com/gif.latex?s_u^{cos}(u_k,u_a)=\frac{u_k&space;\cdot&space;u_a&space;}{&space;\left&space;\|&space;u_k&space;\right&space;\|&space;\left&space;\|&space;u_a&space;\right&space;\|&space;}&space;=\frac{\sum&space;x_{k,m}x_{a,m}}{\sqrt{\sum&space;x_{k,m}^2\sum&space;x_{a,m}^2}}"/>
# 
# Para calcular a semelhança entre itens * m * e * b * você usa a fórmula:
# 
# <img class="aligncenter size-thumbnail img-responsive" src="https://latex.codecogs.com/gif.latex?s_u^{cos}(i_m,i_b)=\frac{i_m&space;\cdot&space;i_b&space;}{&space;\left&space;\|&space;i_m&space;\right&space;\|&space;\left&space;\|&space;i_b&space;\right&space;\|&space;}&space;=\frac{\sum&space;x_{a,m}x_{a,b}}{\sqrt{\sum&space;x_{a,m}^2\sum&space;x_{a,b}^2}}
# "/>
# 
# Seu primeiro passo será criar a matriz do item do usuário. Uma vez que você tem dados de teste e treinamento, você precisa criar duas matrizes.

# In[ ]:

# Crie duas matrizes de item de usuário, uma para treinamento e outra para teste
train_data_matrix = np.zeros((n_users, n_items))
for line in train_data.itertuples():
    train_data_matrix[line[1]-1, line[2]-1] = line[3]  

test_data_matrix = np.zeros((n_users, n_items))
for line in test_data.itertuples():
    test_data_matrix[line[1]-1, line[2]-1] = line[3]


# Você pode usar a função [pairwise_distances](http://scikit-learn.org/stable/modules/generated/sklearn.metrics.pairwise.pairwise_distances.html) da sklearn para calcular a similaridade do coseno. Observe que a saída variará de 0 a 1, uma vez que as classificações são positivas.

# In[29]:

from sklearn.metrics.pairwise import pairwise_distances
user_similarity = pairwise_distances(train_data_matrix, metric='cosine')
item_similarity = pairwise_distances(train_data_matrix.T, metric='cosine')


# O próximo passo é fazer previsões. Você já criou matrizes de semelhança: `user_similarity` e` item_similarity` e, portanto, você pode fazer uma previsão aplicando a seguinte fórmula para CF baseada em usuário:
# 
# <img class="aligncenter size-thumbnail img-responsive" src="https://latex.codecogs.com/gif.latex?\hat{x}_{k,m}&space;=&space;\bar{x}_{k}&space;&plus;&space;\frac{\sum\limits_{u_a}&space;sim_u(u_k,&space;u_a)&space;(x_{a,m}&space;-&space;\bar{x_{u_a}})}{\sum\limits_{u_a}|sim_u(u_k,&space;u_a)|}"/>
# 
# Você pode observar a semelhança entre usuários * k * e * a * como pesos multiplicados pelas classificações de um usuário similar * a * (corrigido pela classificação média desse usuário). Você precisará normalizá-lo para que as classificações permaneçam entre 1 e 5 e, como etapa final, somem as avaliações médias para o usuário que você está tentando prever.
# 
# A idéia aqui é que alguns usuários tendem sempre a conferir avaliações altas ou baixas a todos os filmes. A diferença relativa nas classificações que esses usuários dão é mais importante do que os valores absolutos. Para dar um exemplo: suponha, o usuário * k * dá 4 estrelas aos seus filmes favoritos e 3 estrelas para todos os outros bons filmes. Suponha agora que outro usuário * t * classifica filmes que ele / ela gosta de 5 estrelas, e os filmes que ele / ela adormeceu com 3 estrelas. Estes dois usuários podem ter um gosto muito parecido, mas tratar o sistema de classificação de forma diferente.
# 
# Ao fazer uma previsão para o CF com base em itens, você não precisa corrigir a classificação média dos usuários, já que o próprio usuário da consulta é usado para fazer previsões.
# 
# <img class="aligncenter size-thumbnail img-responsive" src="https://latex.codecogs.com/gif.latex?\hat{x}_{k,m}&space;=&space;\frac{\sum\limits_{i_b}&space;sim_i(i_m,&space;i_b)&space;(x_{k,b})&space;}{\sum\limits_{i_b}|sim_i(i_m,&space;i_b)|}"/>

# In[30]:

def predict(ratings, similarity, type='user'):
    if type == 'user':
        mean_user_rating = ratings.mean(axis=1)
        ratings_diff = (ratings - mean_user_rating[:, np.newaxis]) 
        pred = mean_user_rating[:, np.newaxis] + similarity.dot(ratings_diff) / np.array([np.abs(similarity).sum(axis=1)]).T
    elif type == 'item':
        pred = ratings.dot(similarity) / np.array([np.abs(similarity).sum(axis=1)])     
    return pred


# In[31]:

item_prediction = predict(train_data_matrix, item_similarity, type='item')
user_prediction = predict(train_data_matrix, user_similarity, type='user')


# ### Avaliação
# Existem muitas métricas de avaliação, mas uma das métricas mais populares usadas para avaliar a precisão das classificações previstas é * Raiz da média dos erros quadrados (Root Mean Squared Error - RMSE) *.
# <img src="https://latex.codecogs.com/gif.latex?RMSE&space;=\sqrt{\frac{1}{N}&space;\sum&space;(x_i&space;-\hat{x_i})^2}" title="RMSE =\sqrt{\frac{1}{N} \sum (x_i -\hat{x_i})^2}" />
# 
# Você pode usar a função [mean_square_error](http://scikit-learn.org/stable/modules/generated/sklearn.metrics.mean_squared_error.html) (MSE) do `sklearn`, onde o RMSE é apenas a raiz quadrada de MSE. Para ler mais sobre diferentes métricas de avaliação, você pode dar uma olhada [neste artigo](http://research.microsoft.com/pubs/115396/EvaluationMetrics.TR.pdf).

# Since you only want to consider predicted ratings that are in the test dataset, you filter out all other elements in the prediction matrix with `prediction[ground_truth.nonzero()]`. 

# In[32]:

from sklearn.metrics import mean_squared_error
from math import sqrt
def rmse(prediction, ground_truth):
    prediction = prediction[ground_truth.nonzero()].flatten() 
    ground_truth = ground_truth[ground_truth.nonzero()].flatten()
    return sqrt(mean_squared_error(prediction, ground_truth))


# In[33]:

print('User-based CF RMSE: ' + str(rmse(user_prediction, test_data_matrix)))
print('Item-based CF RMSE: ' + str(rmse(item_prediction, test_data_matrix)))


# Memory-based algorithms are easy to implement and produce reasonable prediction quality. 
# The drawback of memory-based CF is that it doesn't scale to real-world scenarios and doesn't address the well-known cold-start problem, that is when new user or new item enters the system. Model-based CF methods are scalable and can deal with higher sparsity level than memory-based models, but also suffer when new users or items that don't have any ratings enter the system. I would like to thank Ethan Rosenthal for his [post](http://blog.ethanrosenthal.com/2015/11/02/intro-to-collaborative-filtering/) about Memory-Based Collaborative Filtering. 

# # Filtragem colaborativa baseada em modelo
# 
# A filtragem colaborativa baseada em modelo é baseada em ** factorização da matriz (MF) **, que recebeu maior exposição, principalmente como um método de aprendizagem não supervisionado para a decomposição variável latente e a redução da dimensionalidade. A factorização da matriz é amplamente utilizada para sistemas de recomendação, onde pode lidar melhor com a escalabilidade e a dispersão do que a CF baseada em memória. O objetivo do MF é aprender as preferências latentes dos usuários e os atributos latentes de itens de classificações conhecidos (aprender recursos que descrevem as características das classificações) para então prever as avaliações desconhecidas através do produto escalar das características latentes dos usuários e itens.
# Quando você tem uma matriz muito esparsa, com muitas dimensões, fazendo a fatoração da matriz, você pode reestruturar a matriz do item do usuário em uma estrutura de baixo posto e assim pode representar a matriz pela multiplicação de duas matrizes de baixo índice, onde a as linhas contêm o vetor latente. Você ajusta essa matriz para aproximar sua matriz original, tanto quanto possível, multiplicando as matrizes de baixo posto, que preenche as entradas que faltam na matriz original.
# 
# Vamos calcular o nível de esparsidade do conjunto de dados MovieLens:

# In[34]:

sparsity=round(1.0-len(df)/float(n_users*n_items),3)
print('The sparsity level of MovieLens100K is ' +  str(sparsity*100) + '%')


# Para dar um exemplo das preferências latentes aprendidas dos usuários e itens: digamos que para o conjunto de dados do MovieLens você tem as seguintes informações: _ (ID do usuário, idade, localização, gênero, identificação do filme, diretor, ator, idioma, ano, classificação ) _. Ao aplicar a factorização da matriz, o modelo descobre que os recursos importantes do usuário são o grupo _idade (abaixo de 10, 10-18, 18-30, 30-90) _, _localização_ e _gênero_, e para recursos de filme, ele descobre que _decada_, _diretor_ e _ator_ são mais importante. Agora, se você olhar para as informações que você armazenou, não há nenhuma característica como o _decada_, mas o modelo pode aprender por conta própria. O aspecto importante é que o modelo CF usa apenas dados (user_id, movie_id, classificação) para aprender os recursos latentes. Se houver pouca disponibilidade de dados, o modelo de CF baseado em modelo irá prever mal, uma vez que será mais difícil aprender os recursos latentes.
# 
# Os modelos que usam classificações e recursos de conteúdo são chamados ** sistemas de recomendação híbridos **, onde os Filtragem colaborativa e os modelos baseados em conteúdo são combinados. Os sistemas de recomendação híbridos geralmente apresentam maior precisão do que Filtragem colaborativa ou modelos baseados em conteúdo por conta própria: eles são capazes de resolver melhor o problema de arranque a frio, pois, se você não possui classificações para um usuário ou um item, você pode usar os metadados do usuário ou item para fazer uma previsão.

# ### SVD
# Um método de factorização da matriz bem conhecido é ** Descomposição do valor singular (Singular value decomposition - SVD) **. A filtragem colaborativa pode ser formulada pela aproximação de uma matriz `X` usando a decomposição de valor singular. A equipe vencedora na competição do Prêmio Netflix usou modelos de factorização da matriz SVD para produzir recomendações de produtos, para mais informações eu recomendo leia os artigos: [Recomendações Netflix: além das 5 estrelas] (http://techblog.netflix.com/2012/04/netflix-recommendations-beyond-5-stars.html) e [Prêmio Netflix e SVD](http://buzzard.ups.edu/courses/2014spring/420projects/math420-UPS-spring-2014-gower-netflix-SVD.pdf).
# A equação geral pode ser expressa da seguinte maneira:
# <img src="https://latex.codecogs.com/gif.latex?X=USV^T" title="X=USV^T" />
# 
# Dada a matrx `X` `m x n`:
# * *`U`* matriz ortogonal *`(m x r)`*
# * *`S`* é uma matriz diagonal *`(r x r)`*  com números reais não negativos na diagonal
# * *V^T* é uma matriz ortogonal *`(r x n)`*
# 
# Elementos na diagonal de `S` são conhecidos como * valores singulares de `X` *.
# 
# Matrix * `X` * pode ser factorizado para *` U` *, * `S` * e *` V` *. A matriz * `U` * representa os vetores de características correspondentes aos usuários no espaço de recursos escondido e a matriz *` V` * representa os vetores de recursos correspondentes aos itens no espaço de recursos oculto.
# <img class="aligncenter size-thumbnail img-responsive" style="max-width:100%; width: 50%; max-width: none" src="http://s33.postimg.org/kwgsb5g1b/BLOG_CCA_5.png"/>
# 
# Agora você pode fazer uma previsão tomando produto ponto de * `U` *, *` S` * e * `V ^ T` *.
# 
# <img class="aligncenter size-thumbnail img-responsive" style="max-width:100%; width: 50%; max-width: none" src="http://s33.postimg.org/ch9lcm6pb/BLOG_CCA_4.png"/>

# In[35]:

import scipy.sparse as sp
from scipy.sparse.linalg import svds

#get SVD components from train matrix. Choose k.
u, s, vt = svds(train_data_matrix, k = 20)
s_diag_matrix=np.diag(s)
X_pred = np.dot(np.dot(u, s_diag_matrix), vt)
print('User-based CF MSE: ' + str(rmse(X_pred, test_data_matrix)))


# Carelessly addressing only the relatively few known entries is highly prone to overfitting. SVD can be very slow and computationally expensive. More recent work minimizes the squared error by applying alternating least square or stochastic gradient descent and uses regularization terms to prevent overfitting. Alternating least square and stochastic gradient descent methods for CF will be covered in the next tutorials.
# 
# 
# Resolver de forma negligente somente as entradas pouco conhecidas aumenta muito a chance de overfitting. SVD pode ser muito lento e computacionalmente caro. Os trabalhos mais recentes minimizam o erro ao quadrado aplicando métodos como gradient descent, por exemplo.

# Revisando:
# * Vimos como implementar métodos simples de ** Filtração colaborativa **, CF com base em memória e CF com base em modelo.
# * ** Os modelos baseados em memória ** baseiam-se na similaridade entre itens ou usuários, onde usamos coseno-similaridade.
# * ** O FC ** baseado em modelo é baseado na factorização da matriz onde usamos SVD para factorizar a matriz.
# * Construir sistemas de recomendação que funcionam bem em cenários de arranque a frio (onde pouca informação está disponível em novos usuários e itens) continua sendo um desafio. O método de filtragem colaborativo padrão funciona mal são essas configurações.

# ## Looking for more?
# 
# If you want to tackle your own recommendation system analysis, check out these data sets. Note: The files are quite large in most cases, not all the links may stay up to host the data, but the majority of them still work. Or just Google for your own data set!
# 
# ## Procurando por mais?
# 
# Se você quiser abordar sua própria análise de sistema de recomendação, confira esses conjuntos de dados. Nota: Os arquivos são bastante amplos na maioria dos casos, nem todos os links podem estar funcionando deles ainda, mas a maioria deles está. 
# 
# ** Recomendação de filmes: **
# 
# MovieLens - Datasets de recomendações de filmes http://www.grouplens.org/node/73
# 
# Yahoo! - Conjuntos de dados de classificações de filmes, músicas e imagens http://webscope.sandbox.yahoo.com/catalog.php?datatype=r
# 
# Jester - Datasets de recomendações de filmes (conjunto de dados de filtragem colaborativa)  http://www.ieor.berkeley.edu/~goldberg/jester-data/
# 
# Cornell University - Dados de revisão de filme para uso em experimentos de análise de sentimentos http://www.cs.cornell.edu/people/pabo/movie-review-data/
# 
# 
# ** Recomendação de música: **
# 
# Last.fm - Conjuntos de dados de recomendações de música http://www.dtic.upf.edu/~ocelma/MusicRecommendationDataset/index.html
# 
# Yahoo! - Conjuntos de dados de classificações de filmes, música e imagens http://webscope.sandbox.yahoo.com/catalog.php?datatype=r
# 
# Audioscrobbler - Conjuntos de dados de recomendações de música http://www-etud.iro.umontreal.ca/~bergstrj/audioscrobbler_data.html
# 
# Amazon - Recomendações de CD de áudio http://131.193.40.52/data/
# 
# **Recomendações de livros:**
# 
# Institut für Informatik, Universität Freiburg - Conjunto de dados para avaliações de livros http://www.informatik.uni-freiburg.de/~cziegler/BX/
# Food Recommendation:
# 
# Chicago Entree - Conjunto de dados sobre comidas http://archive.ics.uci.edu/ml/datasets/Entree+Chicago+Recommendation+Data
# Merchandise Recommendation:
# 
# ** Recomendação de namoro: **
# 
# www.libimseti.cz - Recomendação do site de namoro (filtragem colaborativa) http://www.occamslab.com/petricek/data/
