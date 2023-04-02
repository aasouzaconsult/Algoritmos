# # Semana de Data Science
# **Vendas de uma concessionária de veículos usados**

import pandas as pd

df = pd.read_excel('carros_usados.xls')

# -**`Visualizando as 5 primeiras linhas do Dataframe`**
df.head()

# -**`Visualizando as informações de colunas do Dataframe`**
df.info()

# **- `Informações estatísticas das colunas Dataframe`**
df.describe()

# **Consultando dados nulos ou Missing Values no Dataframe**
df.isnull().sum()

# ## `Análise Exploratória de Dados`
import seaborn as sns
from matplotlib import pyplot as plt

# **Define um estilo para nossos plots**
plt.style.use('ggplot')

# **Plota a distribuição da variável `total.cost`**
get_ipython().magic(u'matplotlib notebook')
sns.distplot(df['total.cost'],color='green', kde=False)
plt.title('Distribuição da coluna total.cost')

# #### `Conclusões`:
# *Podemos observar que a maioria dos carros custam em torno de 3k e 6k.*

# ### Qual a quantidade média de dias que os carros ficam na concessionária?
get_ipython().magic(u'matplotlib notebook')
sns.distplot(df['lot.sale.days'],color='red', kde=False)
plt.title('Distribuição da coluna lot.sale.days')

# #### `Conclusões`:

# - *Podemos observar que os dias de vendas são inclinados para o lado esquerdo
#  isso nos mostra que a maioria dos são vendidos nos primeiros 90 dias.*
# - *Os restantes 20% são vendidos após 20 dias e são vendidos a preço de desconto.*

# ### Qual a Kilometragem média dos veículos da concessionária?

get_ipython().magic(u'matplotlib notebook')
sns.distplot(df['mileage'],color='blue', kde=False)
plt.title('Distribuição da coluna mileage')

# #### `Conclusões`:

# - *Podemos observar que a grande maioria dos veículos estão na faixa de 60.000 a 90.000 de kilometragem*

# ### Qual a idade média dos veículos da concessionária?

get_ipython().magic(u'matplotlib notebook')
sns.distplot(df['vehicle.age'],color='red', kde=False)
plt.title('Distribuição da coluna vehicle.age')

# #### `Conclusões`:
# - *Podemos observar que a idade média dos veículos da concessionária são de 3 a 7 anos.*

# ### Visualizando a Correlação entre algumas variáveis

# - O quanto alguma variável numérica tem correlação com outra variável ?
# - Correlação pode ser positiva ou negativa
df[['mileage','vehicle.age','lot.sale.days','total.cost']].head()

# - Calcula a correlação com método corr()
df[['mileage','vehicle.age','lot.sale.days','total.cost']].corr()
correlacoes = df[['mileage','vehicle.age','lot.sale.days','total.cost']].corr()

# - Plot o mapa de calor para visualizar as correlações
get_ipython().magic(u'matplotlib notebook')
sns.heatmap(correlacoes, annot=True, cmap="YlGnBu")

# #### `Conclusões`:

# - *O gráfico de calor acima nos mostra que não existe uma correlação forte das variáveis com a quantidade de dias de vendas(lot.sale.days)*
# - *Podemos ver que a kilometragem tem uma correlação positiva com a idade do veículo.*
# - *Podemos ver também que os dias de vendas (lot.sale.days) tem uma correlação positiva com o custo total do veículo (total.cost) e com a idade do veículo (vehicle.age)*

# ### Visualizando a disperssão entre os dias de vendas e algumas variáveis
get_ipython().magic(u'matplotlib notebook')
sns.scatterplot(x='lot.sale.days', y="total.cost", data=df)

get_ipython().magic(u'matplotlib notebook')
sns.scatterplot(x='lot.sale.days', y="mileage", color='green', data=df)

# ### Tempo médio de vendas por tipos de Veiculos
get_ipython().magic(u'matplotlib notebook')
sns.boxplot(x="domestic.import", y="lot.sale.days", data=df)

# ### Tempo médio de vendas por categoria de Veiculos
get_ipython().magic(u'matplotlib notebook')
sns.boxplot(x="vehicle.type", y="lot.sale.days", data=df)

# **`Conclusões`**:

# - *Não existem diferenças significativas entre veículos domesticos e veículos importados em termos de quão rápido eles são vendidos.*
# - *Veiculos econômicos demoram um pouco mais para serem vendidos se comparado veículos de família, de luxo ou sedans.*
# - *Em média, leva 90 dias para vender veículos econômicos,  84 dias para vender veículos de família e 40 dias para vender veículos de luxo.*

# ### Tempo médio de vendas por cor de Veiculos
get_ipython().magic(u'matplotlib notebook')
sns.boxplot(x="color.set", y="lot.sale.days", data=df)

# **`Conclusões`**

# - *Podemos observar que nesse gráfico que em média os carros que saem mais rápido são carros pretos.*
# - *Em segundo lugar são carros dourados com 53 dias. Por fim os carros que demoram mais para serem vendidos são carros brancos com 90 dias*

# ### Tempo médio de vendas por marca dos Veiculos
get_ipython().magic(u'matplotlib notebook')
sns.boxplot(x="makex", y="lot.sale.days", data=df)
plt.xticks(size=5)

# **`Conclusões:`**

# - *Marcas tem uma grande diferença no tempo de vendas dos veículos.*
# - *Algumas marcas de veículos quem vendem rápido tendem a ser Honda, Chrysler, Dodge, Hyundai, Plymouth.*
# - *As marcas Daewoo, Oldsmobile, Buick e GEO permanecem por mais tempo antes de serem vendidos.*

# ### Tempo médio de vendas por estado

get_ipython().magic(u'matplotlib notebook')
sns.boxplot(x="state", y="lot.sale.days", data=df)

# #### `Conclusões`:

# - *Alguns estados como California, Georgia e Texas tem diferença significante de dias para serem vendidos se comparado com Florida, Arizona e Nevada.*
# 

# ### Construindo um Modelo de Machine Learning
df.head()

# **Pre-processando os dados**

# - Precisamos pré-processar algumas colunas, pois, são colunas categóricas.
# - Nesta etapa também removemos colunas não importantes para o modelo.

# **Removendo a coluna vehicle.age.group**

df.drop('vehicle.age.group', axis=1, inplace=True)

df.drop('data.set', axis=1, inplace=True)

# **Aplicando o LabelEncoder para codificação de variáveis categóricas**
from sklearn.preprocessing import LabelEncoder

label_encoder1 = LabelEncoder()
label_encoder2 = LabelEncoder()
label_encoder3 = LabelEncoder()
label_encoder4 = LabelEncoder()
label_encoder5 = LabelEncoder()
label_encoder6 = LabelEncoder()

# **Aplica o Labelencoder nos dados categóricos**

df['vehicle.type'] = label_encoder1.fit_transform(df['vehicle.type'])
df['domestic.import'] = label_encoder2.fit_transform(df['domestic.import'])
df['color.set'] = label_encoder3.fit_transform(df['color.set'])
df['makex'] = label_encoder4.fit_transform(df['makex'])
df['state'] = label_encoder5.fit_transform(df['state'])
df['make.model'] = label_encoder6.fit_transform(df['make.model'])

# **Dados transformados**
df.head()

# **Separa a classe dos dados**
y = df['overage']

y.head()

# **Apaga a coluna overage e a coluna lot.days.sales**
X = df.drop(['lot.sale.days','overage'], axis=1)

X.head()

# **Separando os dados de treino e teste**
from sklearn.model_selection import train_test_split

X_treino, X_teste, y_treino, y_teste = train_test_split(X, y)

X_treino.count()

y_treino.count()

X_treino.head()

y_treino.head()

X_teste.count()

y_teste.count()

X_teste.head()

# **Aplicando Machine Learning com Arvore de Decisão**
from sklearn import tree
arvore = tree.DecisionTreeClassifier()
arvore.fit(X_treino, y_treino)

# **Validação do Modelo**
X_teste.head()

arvore.predict(X_teste)

resultado = arvore.predict(X_teste)

resultado

from sklearn import metrics
print(metrics.classification_report(y_teste,resultado))

# **`Conclusões`:**

# - Tivemos uma precisão de 62% para classificar carros que superam os 90 dias.
# - O modelo pode melhorar se trabalhar mais nos dados, e com um trabalho de engenharia de features.

# **Features mais importantes para o modelo**

arvore.feature_importances_

feature_imp = pd.Series(arvore.feature_importances_,index=X_treino.columns)

feature_imp

# **Visualizando as Features mais importantes do Modelo**
get_ipython().magic(u'matplotlib notebook')
sns.barplot(x=feature_imp, y=feature_imp.index)

plt.xlabel('Importância de Features')
plt.ylabel('Features')
plt.title("Importância de Features")
plt.show()

# ## Visualizando a árvore de Decisão
# - Instala as bibliotecas para visualização no jupyter notebook

get_ipython().system(u'pip install pydot')
get_ipython().system(u'pip install graphviz')

import pydot
import graphviz 
from ipywidgets import interactive

dot_data = tree.export_graphviz(
         arvore,
         feature_names=X.columns,
         class_names=y,
         max_depth=3, 
         filled=True, 
         rounded=True,
         node_ids=True,
         label='all',
        )  
graph = graphviz.Source(dot_data)  
graph

# **`Conclusões`**
# - *O nó que melhor separa os dados é o nó vehicle.age, em seguida o nó total.cost e mileage.*

# **Minerando Dados**
# www.minerandodados.com.br
