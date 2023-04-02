# Machine Learning é um subgrupo da IA que utiliza técnicas estatísticas para dar aos computadores a habilidade de aprender com dados sem serem explicitamente programados.

# Análise e Agrupamento de Clientes com K-Means - [https://www.youtube.com/watch?v=JgGVHAHkxKU&feature=youtu.be]
# ## Importando Bibliotecas.
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt 
import seaborn as sns 
import plotly as py
import plotly.graph_objs as go
from sklearn.cluster import KMeans
import warnings
import os

# ## Análise dos Dados
# Carregando a base de dados
df = pd.read_csv(r'Mall_Customers.csv')

# Aplicação - Campanhas por Segmentação de Clientes

# Verificando os dados
df.head()
#Annual Income  - Renda Anual
#Spending Score - Pontuação de Gastos

df.shape

# Estatística Descritiva
df.describe()

# Tipos de Dados
df.dtypes
# object - categórico

# Verificando registros nulos
df.isnull().sum()

# ## Visualização de Dados
plt.style.use('fivethirtyeight')

# Verificando as distribuição dos dados (por atributo)
plt.figure(1 , figsize = (15 , 6))
n = 0 
for x in ['Age' , 'Annual Income (k$)' , 'Spending Score (1-100)']:
    n += 1
    plt.subplot(1 , 3 , n)
    plt.subplots_adjust(hspace =0.5 , wspace = 0.5)
    sns.distplot(df[x] , bins = 25)
    plt.title('{} '.format(x))
plt.show()

# Contagem de Amostras por Sexo
plt.figure(1 , figsize = (15 , 5))
sns.countplot(y = 'Gender' , data = df)
plt.show()

# Relação entre Idade vs Renda Anual
plt.figure(1 , figsize = (15 , 6))
for gender in ['Male' , 'Female']:
    plt.scatter(x = 'Age' , y = 'Annual Income (k$)' , data = df[df['Gender'] == gender] ,
                s = 200 , alpha = 0.5 , label = gender)
plt.xlabel('Age'), plt.ylabel('Annual Income (k$)') 
plt.title('Idade vs Renda Anual')
plt.legend()
plt.show()

# Renda Anual vs Pontuação de Gastos
plt.figure(1 , figsize = (15 , 6))
for gender in ['Male' , 'Female']:
    plt.scatter(x = 'Annual Income (k$)',y = 'Spending Score (1-100)' ,
                data = df[df['Gender'] == gender] ,s = 200 , alpha = 0.5 , label = gender)
plt.xlabel('Annual Income (k$)'), plt.ylabel('Spending Score (1-100)') 
plt.title('Renda Anual vs Pontuação de Gastos')
plt.legend()
plt.show()

# Distribuição de Idade, Renda Anual e Pontuação de Gastos segmentado por Sexo
plt.figure(1 , figsize = (15 , 7))
n = 0 
for cols in ['Age' , 'Annual Income (k$)' , 'Spending Score (1-100)']:
    n += 1 
    plt.subplot(1 , 3 , n)
    plt.subplots_adjust(hspace = 0.5 , wspace = 0.5)
    sns.violinplot(x = cols , y = 'Gender' , data = df , palette = 'vlag')
    sns.swarmplot(x = cols , y = 'Gender' , data = df)
    plt.ylabel('Gender' if n == 1 else '')
    plt.title('Idade, Renda Anual e Pontuação de Gastos por Sexo' if n == 2 else '')
plt.show()


# ## Agrupamento de dados utilizando o K-Means

# **Algoritmo KMeans**
# *   **n_clusters**: número de clusters que queremos gerar com os nossos dados
# *   **init**: se refere ao modo como o algoritmo será inicializado.
# >> > *k-means++*: É o método padrão, e os centróides serão gerados utilizando um método inteligente que favorece a convergência.
# >> > *random*: Se refere ao modo de inicialização de forma aleatória, ou seja, os centróides iniciais serão gerados de forma totalmente aleatória sem um critério para seleção.
# >> > *ndarray*: array de valores indicando qual seriam os centróides que o algoritmo deveria utilizar  para a inicialização
# * **max_iter**: Quantidade máxima de vezes que o algoritmo irá executar, por padrão o valor é 300 iterações.
# * **n_jobs**: Quantos CPU´s iremos utilizar para executar o K-means.
# * **algorithm**: Versão do algoritmo K-Means a ser utilizada. A versão clássica é executada através do valor full.

# **Atributos Importantes** 
# > **inertia**: Soma das distâncias quadráticas intra cluster.
# > **labels_**: Rótulos dos Clusters atribuídos.
# > **cluster_centers_**: Valores dos Centroides.

# Selecionando o número de clusters através do método Elbow - cotovelo (Soma das distâncias quadráticas intra clusters).
X2 = df[['Annual Income (k$)' , 'Spending Score (1-100)']].iloc[: , :].values
inertia = []
for n in range(1 , 11):
    algorithm = (KMeans(n_clusters = n))
    algorithm.fit(X2)
    inertia.append(algorithm.inertia_)

plt.figure(1 , figsize = (15 ,6))
plt.plot(np.arange(1 , 11) , inertia , 'o')
plt.plot(np.arange(1 , 11) , inertia , '-' , alpha = 0.5)
plt.xlabel('Número de Clusters') , plt.ylabel('Soma das Distâncias Q intra Clusters')
plt.show()

# Inicializando e Computando o KMeans com o valor de 4 clusters
algorithm = (KMeans(n_clusters = 4))
algorithm.fit(X2)

# Visualizando os grupos criados e seus centroides
labels2 = algorithm.labels_
centroids2 = algorithm.cluster_centers_

h = 0.02
x_min, x_max = X2[:, 0].min() - 1, X2[:, 0].max() + 1
y_min, y_max = X2[:, 1].min() - 1, X2[:, 1].max() + 1
xx, yy = np.meshgrid(np.arange(x_min, x_max, h), np.arange(y_min, y_max, h))
Z = algorithm.predict(np.c_[xx.ravel(), yy.ravel()]) 

plt.figure(1 , figsize = (15 , 7) )
plt.clf()
Z2 = Z.reshape(xx.shape)
plt.imshow(Z2 , interpolation='nearest', extent=(xx.min(), xx.max(), yy.min(), yy.max()), cmap = plt.cm.Pastel2, aspect = 'auto', origin='lower')
plt.scatter( x = 'Annual Income (k$)' ,y = 'Spending Score (1-100)' , data = df , c = labels2 , s = 200 )
plt.scatter(x = centroids2[: , 0] , y =  centroids2[: , 1] , s = 300 , c = 'red' , alpha = 0.5)
plt.ylabel('Pontuação de Gastos (1-100)') , plt.xlabel('Renda Anual (k$)')
plt.show()

# ### Analisando os dados agrupados
# adicionado os Labels
df["clusters"] = algorithm.labels_

# Visualizando
df.head()

# Criar grupo para ver as estatísticas
df_group = df.drop(["CustomerID","Age"],axis=1).groupby("clusters")

# Visualizando as estatísticas
df_group.describe()