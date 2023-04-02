# Aqui encontrarei:
# - Algoritmos: Regressão Linear, Arvore de Decisão, SVM, KNN
# - Análise Exploratória de Dados
# - Pré-Processamento (Eliminar nulos, completar faltantes...)
# - Tunning de Parametros com GridSearch

# Regressão linear
# Seu vizinho é um agente imobiliário e quer alguma ajuda a prever os preços das casas para as regiões nos EUA. Seria ótimo se você pudesse de alguma forma criar um modelo para ela que lhe permita colocar algumas características de uma casa e retornar uma estimativa de quanto a casa venderia.
# Ela perguntou se você poderia ajudá-la com suas novas habilidades de ciência de dados. Você diz sim e decide que a Regressão linear pode ser um bom caminho para resolver esse problema.
# Seu vizinho, em seguida, dá-lhe algumas informações sobre um monte de casas em regiões dos Estados Unidos. tudo está contido no arquivo: USA_Housing.csv.

# Os dados contém as seguintes colunas:
# * 'Avg. Area Income': Média da renda dos residentes de onde a casa está localizada.
# * 'Avg. Area House Age': Média de idade das casas da mesma cidade.
# * 'Avg. Area Number of Rooms': Número médio de quartos para casas na mesma cidade.
# * 'Avg. Area Number of Bedrooms': Número médio de quartos para casas na mesma cidade
# * 'Area Population': A população da cidade onde a casa está localizada.
# * 'Price': Preço de venda da casa.
# * 'Address': Endereço da casa;

# Confira os dados
# Nós conseguimos obter alguns dados do seu vizinho para os preços da habitação como um conjunto de csv, vamos preparar nosso ambiente com as bibliotecas que precisaremos e depois importar os dados!

# Importar bibliotecas
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

# Confira os dados
USAhousing = pd.read_csv('USA_Housing.csv')

USAhousing.head()
#    Avg. Area Income  ...                                            Address
# 0      79545.458574  ...  208 Michael Ferry Apt. 674\nLaurabury, NE 3701...
# 1      79248.642455  ...  188 Johnson Views Suite 079\nLake Kathleen, CA...
# 2      61287.067179  ...  9127 Elizabeth Stravenue\nDanieltown, WI 06482...
# 3      63345.240046  ...                          USS Barnett\nFPO AP 44820
# 4      59982.197226  ...                         USNS Raymond\nFPO AE 09386

USAhousing.info()
# <class 'pandas.core.frame.DataFrame'>
# RangeIndex: 5000 entries, 0 to 4999
# Data columns (total 7 columns):
# Avg. Area Income                5000 non-null float64
# Avg. Area House Age             5000 non-null float64
# Avg. Area Number of Rooms       5000 non-null float64
# Avg. Area Number of Bedrooms    5000 non-null float64
# Area Population                 5000 non-null float64
# Price                           5000 non-null float64
# Address                         5000 non-null object
# dtypes: float64(6), object(1)
# memory usage: 273.6+ KB

USAhousing.describe() # Valores estatísticos
#        Avg. Area Income  Avg. Area House Age  ...  Area Population         Price
# count       5000.000000          5000.000000  ...      5000.000000  5.000000e+03
# mean       68583.108984             5.977222  ...     36163.516039  1.232073e+06
# std        10657.991214             0.991456  ...      9925.650114  3.531176e+05
# min        17796.631190             2.644304  ...       172.610686  1.593866e+04
# 25%        61480.562388             5.322283  ...     29403.928702  9.975771e+05
# 50%        68804.286404             5.970429  ...     36199.406689  1.232669e+06
# 75%        75783.338666             6.650808  ...     42861.290769  1.471210e+06
# max       107701.748378             9.519088  ...     69621.713378  2.469066e+06
# [8 rows x 6 columns]

USAhousing.columns
# Index(['Avg. Area Income', 'Avg. Area House Age', 'Avg. Area Number of Rooms',
#       'Avg. Area Number of Bedrooms', 'Area Population', 'Price', 'Address'],
#      dtype='object')

# Verificar se tem valores nulos (nulls)
# Check for NaN values:
USAhousing.isnull().sum()

sns.heatmap(USAhousing.isnull(),yticklabels=False,cbar=False,cmap='viridis')

###################################
## Análise Exploratória de Dados ##
###################################

# Contagens - para variávies categóricas
sns.set_style('whitegrid')
sns.countplot(x='Avg. Area Number of Rooms',data=USAhousing,palette='RdBu_r')
plt.show()

# Histograma
USAhousing['Avg. Area Income'].hist(bins=30,color='darkred',alpha=0.7)
plt.show()

# Vamos criar alguns plots simples para verificar os dados.
sns.pairplot(USAhousing)
plt.show()
# preço tem uma certa relação linear com os demais campos

# Distribuição normal
sns.distplot(USAhousing['Price'], kde=True) # kde é a linha
plt.title('Distribuição da coluna Price')
plt.show()

# Correlação
#--------------------------------------------------------------------------
## - O quanto alguma variável numérica tem correlação com outra variável ?
## - Correlação pode ser positiva ou negativa
USAhousing[['Price','Avg. Area Income','Area Population','Avg. Area House Age']].head()

## - Calcula a correlação com método corr()
USAhousing[['Price','Avg. Area Income','Area Population','Avg. Area House Age']].corr()
correlacoes = USAhousing[['Price','Avg. Area Income','Area Population','Avg. Area House Age']].corr()

## - Plot o mapa de calor para visualizar as correlações
sns.heatmap(correlacoes, annot=True, cmap="YlGnBu")
plt.show()

sns.heatmap(USAhousing.corr())
plt.show()

sns.set_palette("GnBu_d")
sns.set_style('whitegrid')
#--------------------------------------------------------------------------

# Dispersão 
#--------------------------------------------------------------------------
sns.scatterplot(x='Avg. Area Income', y="Price", data=USAhousing)
plt.show()

# Mais tempo no site, mais dinheiro gasto
sns.jointplot(x='Price',y='Avg. Area Income',data=USAhousing)
plt.show()

sns.jointplot(x='Avg. Area Number of Rooms',y='Avg. Area Income',data=USAhousing)
plt.show()

# Use jointplot criar um lote de caixa hexagonal 2D
sns.jointplot(x='Price',y='Avg. Area Income',kind='hex',data=USAhousing)
plt.show()
#--------------------------------------------------------------------------

#BoxPlot
# X é bom ser categórica
# Encontrar Outliers
sns.boxplot(x="Avg. Area House Age", y="Price", data=df)
plt.show()

# Modelo Linear
#--------------------------------------------------------------------------
sns.lmplot(x='Price',y='Avg. Area Income',data=USAhousing)
#sns.lmplot(x='Avg. Area Number of Rooms',y='Avg. Area Income',data=USAhousing)
plt.show()

#--------------------------------------------------------------------------

# Treinando um modelo de regressão linear
# Vamos agora começar a treinar o modelo de regressão. Precisamos primeiro dividir nossos dados em uma matriz X que contém os recursos para treinar, e uma matriz y com a variável alvo, neste caso, a coluna Preço. Vamos descartar a coluna "Adress" porque só tem informações de texto que o modelo de regressão linear não pode usar.

# Arrays X e y
X = USAhousing[['Avg. Area Income', 'Avg. Area House Age', 'Avg. Area Number of Rooms',
               'Avg. Area Number of Bedrooms', 'Area Population']]
y = USAhousing['Price']

# Split de treino
# Vamos dividir os dados em um conjunto de treinamento e um conjunto de testes. Vamos criar o modelo usando o conjunto de treinamento e depois usar o conjunto de testes para avaliar o modelo.

from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.4, random_state=101)

# Criando e treinando o modelo
from sklearn.linear_model import LinearRegression
lm = LinearRegression()
lm.fit(X_train,y_train)

# Avaliação modelo
# Vamos avaliar o modelo ao verificar os coeficientes e como podemos interpretá-los.

# Printando a intercepção
print(lm.intercept_)

coeff_df = pd.DataFrame(lm.coef_,X.columns,columns=['Coefficient'])
coeff_df

# Interpretando os coeficientes:
# - Mantendo todas as outras variáveis constantes, um aumento de 1 unidade em ** Avg. Area Income ** está associado a um **aumento de \$ 21,52**.
# - Mantendo todas as outras variáveis constantes, um aumento de 1 unidade em ** Avg. Area House Age ** está associada a um ** aumento de \$ 164883.28 **.
# - Mantendo todas as outras variáveis constantes, um aumento de 1 unidade em ** Avg. Area Number of Bedrooms ** está associada a um ** aumento de \$ 122368.67 **.
# - Mantendo todas as outras variáveis constantes, um aumento de 1 unidade em ** Avg. Area Number of Bedrooms ** está associada a um ** aumento de \$ 2233.80 **.
# - Mantendo todas as outras variáveis constantes, um aumento de 1 unidade em ** Area Population ** está associado a um ** aumento de \$ 15.15 **.

# Isso faz sentido? Provavelmente não porque esses dados não são reais. Se quiser dados reais para repetir este tipo de análise, confira o [conjunto de dados de Boston](http://scikit-learn.org/stable/modules/generated/sklearn.datasets.load_boston.html):

#     from sklearn.datasets import load_boston
#     boston = load_boston()
#     print(boston.DESCR)
#     boston_df = boston.data

## Predições do nosso modelo
# Vamos pegar as previsões em nosso conjunto de testes e ver o quão bem!
predictions = lm.predict(X_test)

plt.scatter(y_test,predictions)
plt.show()

# **Histograma residual**
sns.distplot((y_test-predictions),bins=50);
plt.show()

# Métricas de avaliação de regressão
# Aqui estão três métricas de avaliação comuns para problemas de regressão:

# **Mean absolute error ** (erro absoluto médio) (MAE) é a média do valor absoluto dos erros:
# $$\frac 1n\sum_{i=1}^n|y_i-\hat{y}_i|$$

# ** Mean Squared Error ** (erro médio quadrático) (MSE) é a média dos erros quadrados:
# $$\frac 1n\sum_{i=1}^n(y_i-\hat{y}_i)^2$$

# ** Root Mean Square Error ** (raiz do erro quadrático médio) (RMSE) é a raiz quadrada da média dos erros quadrados:

# $$\sqrt{\frac 1n\sum_{i=1}^n(y_i-\hat{y}_i)^2}$$

# Comparando estas métricas:
# - **MAE** é o mais fácil de entender, porque é o erro médio.
# - **MSE** é mais popular que o MAE, porque a MSE "puniria" erros maiores, o que tende a ser útil no mundo real.
# - **RMSE** é ainda mais popular do que MSE, porque o RMSE é interpretável nas unidades "y".

# Todas estas são ** funções de perda **, porque queremos minimizá-las.
from sklearn import metrics

print('MAE:', metrics.mean_absolute_error(y_test, predictions))
print('MSE:', metrics.mean_squared_error(y_test, predictions))
print('RMSE:', np.sqrt(metrics.mean_squared_error(y_test, predictions)))

#MAE: 82288.22251914951
#MSE: 10460958907.208992
#RMSE: 102278.82922290904

# Este foi o seu primeiro projeto de Machine Learning real! Parabéns em ajudar o seu vizinho! Vamos deixar isso terminar aqui por enquanto, mas vá em frente e explore o Dataset de Boston mencionado anteriormente se este conjunto de dados específico for interessante para você!

#############
# Exemplo 2 #
#############

#####################
# Pré-Processamento #
#####################
import pandas as pd
df = pd.read_excel('carros_usados.xls') 

df.head()

# **Pre-processando os dados**

# - Precisamos pré-processar algumas colunas, pois, são colunas categóricas.
# - Nesta etapa também removemos colunas não importantes para o modelo.

# Deletando Colunas
# **Removendo a coluna vehicle.age.group**
df.drop('vehicle.age.group', axis=1, inplace=True)

df.drop('data.set', axis=1, inplace=True)

# Transformar dados categóricos em dados números
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

# Classificação usando Arvore de Decisão
#-------------------------------------------
# **Separa a classe dos dados**
y = df['overage']

y.head()

# **Apaga a coluna overage e a coluna lot.days.sales**
X = df.drop(['lot.sale.days','overage'], axis=1)

X.head()

# **Separando os dados de treino e teste**
from sklearn.model_selection import train_test_split
X_treino, X_teste, y_treino, y_teste = train_test_split(X, y)

# **Aplicando Machine Learning com Arvore de Decisão**
from sklearn import tree
arvore = tree.DecisionTreeClassifier()
arvore.fit(X_treino, y_treino)

# **Validação do Modelo**
X_teste.head()

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
sns.barplot(x=feature_imp, y=feature_imp.index)

plt.xlabel('Importância de Features')
plt.ylabel('Features')
plt.title("Importância de Features")
plt.show()

# ## Visualizando a árvore de Decisão
# - Instala as bibliotecas para visualização no jupyter notebook

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

###################################
# PRÉ-PROCESSAMENTO - continua... #
####################################################################
# Preencher dados faltantes, deletar colunas (Regressão Logística) #
####################################################################
import pandas as pd
train = pd.read_csv('titanic_train.csv')
train.head()

# Dados ausentes
# Podemos usar seaborn para criar um mapa de calor simples para ver onde estamos perdendo dados!
sns.heatmap(train.isnull(),yticklabels=False,cbar=False,cmap='viridis')
plt.show()

# Aproximadamente 20% dos dados de idade estão faltando. A proporção de idade que falta é provavelmente pequena o suficiente para que possamos fazer uma substituição razoável com alguma forma de imputação de dados. Olhando para a coluna Cabin, porém, parece que estamos perdendo muito desses dados para fazermos o mesmo. Provavelmente vamos descartar isso mais tarde ou mudá-lo para outro "Cabin Conhecido: 1 ou 0"

# Limpando os dados
# Queremos preencher dados de idade faltantes, em vez de simplesmente deixar cair as linhas de dados de idade que faltam. Uma maneira de fazer isso é preenchendo a idade média de todos os passageiros (imputação).
# No entanto, podemos ser mais inteligentes sobre isso e verificar a idade média pela classe de passageiros. Por exemplo:

plt.figure(figsize=(12, 7))
sns.boxplot(x='Pclass',y='Age',data=train,palette='winter')

# Podemos ver os passageiros mais ricos nas (que estão nas classes superiores) tendem a ser mais velhos, o que faz sentido. Usaremos esses valores de idade média para imputar com base em Pclass for Age.

def impute_age(cols):
    Age = cols[0]
    Pclass = cols[1]
    
    if pd.isnull(Age):

        if Pclass == 1:
            return 37

        elif Pclass == 2:
            return 29

        else:
            return 24

    else:
        return Age


# Agora aplique essa função!
train['Age'] = train[['Age','Pclass']].apply(impute_age,axis=1)

# Agora vamos verificar esse mapa de calor novamente!
sns.heatmap(train.isnull(),yticklabels=False,cbar=False,cmap='viridis')
plt.show()

# Ótimo! Vamos seguir em frente e deletar a coluna Cabin e a linha em Embarked que falta dado.
train.drop('Cabin',axis=1,inplace=True)
train.head()

# deletar nulos
train.dropna(inplace=True)

# Convertendo recursos categóricos
# Precisamos converter características categóricas em variáveis dummy usando pandas! Caso contrário, nosso algoritmo de Machine Learning não será capaz de aceitar esses recursos diretamente como entradas.
train.info()

sex = pd.get_dummies(train['Sex'],drop_first=True)  # drop_first=True > Para evitar a multi-colinaridade
embark = pd.get_dummies(train['Embarked'],drop_first=True)

train.drop(['Sex','Embarked','Name','Ticket'],axis=1,inplace=True)

train = pd.concat([train,sex,embark],axis=1)

train.head()

# Ótimo! Nossos dados estão prontos para o nosso modelo
# Construindo um modelo de Regressão Logística
 
# Vamos começar dividindo nossos dados em um conjunto de treinamento e conjunto de testes (há outro arquivo test.csv que você pode usar ao invés, caso queira usar todos esses dados para treinar).
 
# Divisão treino-teste
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(train.drop('Survived',axis=1), 
                                                    train['Survived'], test_size=0.30, 
                                                    random_state=101)

# Training and Predicting
from sklearn.linear_model import LogisticRegression
logmodel = LogisticRegression()
logmodel.fit(X_train,y_train)

predictions = logmodel.predict(X_test)

# Vamos seguir em frente para avaliar o nosso modelo!
# Avaliação
# Podemos verificar a precisão, o recall e a pontuação f1 usando o relatório de classificação!
from sklearn.metrics import classification_report

print(classification_report(y_test,predictions))

################################################################
#################### Mais exemplos #############################

# - GridSearchCV
#----------------------------------------
# Support Vector Machines
import pandas as pd
import numpy as np

# Obter dados
# Conjunto de dados de câncer de mama incorporado da Scikit Learn. Podemos obter com a função load:
from sklearn.datasets import load_breast_cancer
cancer = load_breast_cancer()

# O conjunto de dados é apresentado em uma forma de dicionário:
cancer.keys()

# Podemos pegar informações e arrays deste dicionário para configurar nosso dataframe e entender os recursos:
print(cancer['DESCR'])
cancer['feature_names']

# Configurando e Visualizando o DataFrame
df_feat = pd.DataFrame(cancer['data'],columns=cancer['feature_names'])
df_feat.info()

cancer['target']
df_target = pd.DataFrame(cancer['target'],columns=['Cancer'])

# Agora vamos verificar o dataframe:
df.head()

# Divisão treino-teste
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(df_feat, np.ravel(df_target), test_size=0.30, random_state=101)

# Treinando o Support Vector Classifier
from sklearn.svm import SVC
model = SVC()
model.fit(X_train,y_train)

# Previsões e avaliações
predictions = model.predict(X_test)

from sklearn.metrics import classification_report,confusion_matrix
print(confusion_matrix(y_test,predictions))
print(classification_report(y_test,predictions))
#               precision    recall  f1-score   support
#            0       0.95      0.85      0.90        66
#            1       0.91      0.97      0.94       105
#     accuracy                           0.92       171
#    macro avg       0.93      0.91      0.92       171
# weighted avg       0.93      0.92      0.92       171

#########################
# TUNNING de PARAMETROS #
#########################
# Note que estamos classificando tudo em uma única classe! Isso significa que nosso modelo precisa ter parâmetros ajustados (também pode ajudar a normalizar os dados).
# Podemos procurar por parâmetros usando um GridSearch!

# Gridsearch
# Encontrar os parâmetros certos (como o que o C ou os valores de gama para usar) é uma tarefa complicada! Mas, felizmente, podemos ser um pouco preguiçosos e apenas tentar um monte de combinações e ver o que funciona melhor! Essa idéia de criar uma "grade" de parâmetros e apenas experimentar todas as combinações possíveis é chamada Gridsearch, esse método é comum o suficiente para que o Scikit-learn tenha essa funcionalidade incorporada no GridSearchCV!

# O GridSearchCV usa um dicionário que descreve os parâmetros que devem ser testados e um modelo para treinar. A grade de parâmetros é definida como um dicionário, onde as chaves são os parâmetros e os valores são as configurações a serem testadas.

param_grid = {'C': [0.1,1, 10, 100, 1000], 'gamma': [1,0.1,0.01,0.001,0.0001], 'kernel': ['rbf']} 

from sklearn.model_selection import GridSearchCV

# Uma das grandes coisas do GridSearchCV é que é um meta-estimador. Ele pega um estimador como SVC e cria um novo estimador, que se comporta exatamente da mesma forma - neste caso, como um classificador. Você deve adicionar refit=True e escolher detalhadamente para  número desejado, maior o número, mais detalhado. 

# Você deve adicionar refit=True e escolher  um número para o parâmetro verbose. Quanto maior o número, mais detalhamento teremos.
grid = GridSearchCV(SVC(),param_grid,refit=True,verbose=3)

# O que o fit faz é um pouco mais complicado do que o habital. Primeiro, ele executa o mesmo loop com validação cruzada, para encontrar a melhor combinação de parâmetros. Uma vez que tenha a melhor combinação, ele corre novamente em todos os dados para fitá-los (sem validação cruzada), para construir um único modelo novo usando a melhor configuração de parâmetro.

# Talvez demore um pouco
grid.fit(X_train,y_train)

# Você pode inspecionar os melhores parâmetros encontrados pelo GridSearchCV no atributo best_params_ e o melhor estimador no melhor atributo \ _estimator_:
grid.best_params_
grid.best_estimator_

# Então você pode re-executar previsões neste objeto da grade exatamente como você faria com um modelo normal.
grid_predictions = grid.predict(X_test)

print(confusion_matrix(y_test,grid_predictions))
print(classification_report(y_test,grid_predictions))

#               precision    recall  f1-score   support
#            0       0.94      0.89      0.91        66
#            1       0.94      0.96      0.95       105
#     accuracy                           0.94       171
#    macro avg       0.94      0.93      0.93       171
# weighted avg       0.94      0.94      0.94       171

#-------------------------------------------
# Normalização de Dados
#-------------------------------------------
# - Normalizar variávies (KNN.py)
# K Nearest Neighbors
# Usando o KNN para criar um modelo que possa predizer diretamente a classe para um novo ponto de dados baseado nos parâmetros.

# Import Libraries
import pandas as pd
#import seaborn as sns
import matplotlib.pyplot as plt
import numpy as np

# Obter dados
# index_col = 0 para usar a primeira coluna como índice.
df = pd.read_csv("Classified Data",index_col=0)
df.head()

## Normalizar as variáveis
# Como o classificador KNN prediz a classe de uma determinada observação ao identificar as observações mais próximas, a escala da variável é importante. 
# Todas as variáveis que estão em grande escala terão um efeito muito maior na distância entre as observações e, portanto, sobre o classificador KNN, do que as variáveis em pequena escala.

from sklearn.preprocessing import StandardScaler
scaler = StandardScaler()
scaler.fit(df.drop('TARGET CLASS',axis=1)) # Treina todas com excessão a coluna das classes

# Transforma
scaled_features = scaler.transform(df.drop('TARGET CLASS',axis=1))

df_feat = pd.DataFrame(scaled_features,columns=df.columns[:-1])
df_feat.head()

## Divisão treino-teste
from sklearn.model_selection import train_test_split

X_train, X_test, y_train, y_test = train_test_split(scaled_features,df['TARGET CLASS'], test_size=0.30)

## Usando o KNN
# Estamos tentando encontrar um modelo para prever se alguém estará na TARGET CLASS ou não. Começaremos com k = 1
from sklearn.neighbors import KNeighborsClassifier
knn = KNeighborsClassifier(n_neighbors=1)

# train
knn.fit(X_train,y_train)
#KNeighborsClassifier(algorithm='auto', leaf_size=30, metric='minkowski',
#                     metric_params=None, n_jobs=None, n_neighbors=1, p=2,
#                     weights='uniform')

# predict
pred = knn.predict(X_test)

# Vamos avaliar o nosso modelo KNN!
from sklearn.metrics import classification_report,confusion_matrix
print(confusion_matrix(y_test,pred))
print(classification_report(y_test,pred))
#              precision    recall  f1-score   support
#           0       0.91      0.93      0.92       162
#           1       0.92      0.89      0.90       138
#    accuracy                           0.91       300
#   macro avg       0.91      0.91      0.91       300
#weighted avg       0.91      0.91      0.91       300

## Escolhendo um valor K
# Esar o método do cotovelo para escolher um bom Valor K:

error_rate = []

# Levará algum tempo
for i in range(1,40):
    
    knn = KNeighborsClassifier(n_neighbors=i)
    knn.fit(X_train,y_train)
    pred_i = knn.predict(X_test)
    error_rate.append(np.mean(pred_i != y_test))

plt.figure(figsize=(10,6))
plt.plot(range(1,40),error_rate,color='blue', linestyle='dashed', marker='o',
         markerfacecolor='red', markersize=10)
plt.title('Error Rate vs. K Value')
plt.xlabel('K')
plt.ylabel('Error Rate')
plt.show()

# Aqui podemos ver que, após cerca de K > 23, a taxa de erro tende a girar em torno de 0,06-0,05. Vamos treinar novamente o modelo com isso e verificar o relatório de classificação!

# PRIMEIRA COMPARAÇÃO RÁPIDA PARA O NOSSO ORIGINAL K = 1
knn = KNeighborsClassifier(n_neighbors=1)

knn.fit(X_train,y_train)
pred = knn.predict(X_test)

print('WITH K=1')
print('\n')
print(confusion_matrix(y_test,pred))
print('\n')
print(classification_report(y_test,pred))

# Agora com K = 23
knn = KNeighborsClassifier(n_neighbors=23)

knn.fit(X_train,y_train)
pred = knn.predict(X_test)

print('WITH K=23')
print('\n')
print(confusion_matrix(y_test,pred))
print('\n')
print(classification_report(y_test,pred))
#              precision    recall  f1-score   support
#           0       0.98      0.93      0.95       162
#           1       0.92      0.98      0.95       138
#    accuracy                           0.95       300
#   macro avg       0.95      0.95      0.95       300
#weighted avg       0.95      0.95      0.95       300

# Foi obtido um melhor desempenho do modelo, ajustando para um melhor valor K!
