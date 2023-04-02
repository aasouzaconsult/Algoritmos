# Previsão de Vendas com ML
# Base de um Supermercado

#Pensando no cenário de um supermercado... como podemos estimar o VOLUME DE VENDAS de determinados produtos? 

#Quais os fatores que influenciam na venda de um produto?
# - Localização e tamanho da loja.
# - Visibilidade do produto.
# - Preço.
# - Ofertas e descontos.
# - Disponibilidade.
# - ...

# Modelos simples.
# Média de vendas dos ultimos dias, meses, semanas.. 

# Média de vendas por localização da loja.
# E como avaliamos os erros?
# - Estimativa alta, muito gasto em estoque.
# - Estimativa baixa, perda de vendas.

# Medindo o erro
# - Diferença entre o valor predito e o valor real.

# Regressão Linear
# - Simples técnica estatística para modelagem preditiva. Estima um valor númerico.

# - Regressão Linear simples (Com apenas uma feature)

# - Objetivo - minimizar erro
# -- Função Custo - Gradiente descendente (mínimo local)

# ### Importando as bibliotecas necessárias
import numpy as np
import pandas as pd
from pandas import Series, DataFrame
from sklearn.model_selection import train_test_split

#from google.colab import drive
#drive.mount('/content/drive')

# ### Carregando a base de dados
df = pd.read_csv('reg/train.csv')

df.head()

# Visualizar o registro de indices 2
df.loc[2]

# 'Item_Identifier', 'Item_Weight', 'Item_Fat_Content', 'Item_Visibility', Item_Type', 'Item_MRP', 'Outlet_Identifier', 'Outlet_Establishment_Year', 'Outlet_Size', 'Outlet_Location_Type', 'Outlet_Type', 'Item_Outlet_Sales'

# Item_Outlet_Sales (prever)

### Selecionando os atributos
# Outlet_Establishment_Year - Ano do estabelecimento
# Item_MRP - Volume em Estoque
# Item_Outlet_Sales - Volume de vendas do produto por loja

df[['Outlet_Establishment_Year','Item_MRP','Item_Outlet_Sales']][:5]

X = df[['Outlet_Establishment_Year','Item_MRP']]
# y - Variavel alvo (Item_Outlet_Sales)

#### Separando os conjuntos de treino e teste
x_train, x_test, y_train, y_test = train_test_split( X, df.Item_Outlet_Sales, test_size=0.3)

#### Verificando o shape dos dados
x_train.shape, y_train.shape
x_test.shape, y_test.shape

### Instânciando a Regressão Linear
from sklearn.linear_model import LinearRegression
lreg = LinearRegression()

### Treinando o modelo
lreg.fit(x_train,y_train)

###  Predizendo os valores para o conjunto de teste
pred = lreg.predict(x_test)

###  Calculando o MSE (Mean Square Error)
mse = np.mean((pred - y_test)**2)
mse
# 1976181.8304153893 (minimizar esse número - objetivo)

### Calculando os Coeficientes
# Corresponde aos pesos atribuido aos atributos (teta)
coeff = DataFrame(x_train.columns)

coeff['Coeficientes'] = Series(lreg.coef_)
coeff

### Calculando o r-squared
# Qual nível de informação que dá pra fazer a previsão
lreg.score(x_test,y_test)
# 0.3252613315360605
# 32% de informações necessárias pra estimar o volume de vendas (baixo)

##########################################
### Regressão Linear com mais variáveis. #
##########################################

#### Verificando o atributo Item Weight
df['Item_Weight'].head()

#### Verificando e tratando registros nulos
df['Item_Weight'].isnull().sum()
# 1463 nulos

# Preenche os nulos com a média da coluna
df['Item_Weight'].fillna((df['Item_Weight'].mean()), inplace=True)

#### Selecionando novamente os 3 atributos
# X = df.loc[:,['Outlet_Establishment_Year','Item_MRP','Item_Weight']]
X = df[['Outlet_Establishment_Year','Item_MRP', 'Item_Weight']]

#### Separando os conjuntos de treino e teste
x_train, x_test, y_train, y_test = train_test_split( X, df.Item_Outlet_Sales, test_size=0.3)

#### Treinando novamente o modelo
lreg.fit(x_train,y_train)

#### Executando a predição e calculando o MSE
pred = lreg.predict(x_test)

# MSE (Erro médio Quadrático)
mse = np.mean((pred - y_test)**2)
mse
# 1937424.4889892852 (diminuiu um pouco, muito pouco)
# variavel não contrinuiu

#### Verificando os coeficientes
coeff = DataFrame(x_train.columns)
coeff['Coeficientes'] = Series(lreg.coef_)
coeff
#                           0  Coeficientes
#0  Outlet_Establishment_Year    -10.514398
#1                   Item_MRP     15.838832
#2                Item_Weight      0.448824

#### Calculando o r-squared
lreg.score(x_test,y_test)
# 0.30876093074282474 (diminuiu)

###########################################################
### Pre-processamento nos dados para aplicar a Regressão ##
###########################################################

#### Tratando Missing Values
# Item_Visibility - tudo que tá zero, colocar a média
df['Item_Visibility']
df['Item_Visibility'] = df['Item_Visibility'].replace(0,np.mean(df['Item_Visibility']))

# Outlet_Establishment_Year - Transformando em inteiro
df['Outlet_Establishment_Year']
df['Outlet_Establishment_Year'] = 2013 - df['Outlet_Establishment_Year']

# Outlet_Size - Substituindo os faltantes por Small
df['Outlet_Size']
df['Outlet_Size'].fillna('Small',inplace=True)

# #### Convertendo atributos catégoricos em numéricos (não trabalha com dados catégoricos)
# Item_Fat_Content - Item contem Gordura (Informações de Gordura)
df.Item_Fat_Content.value_counts()
# Low Fat    5089
# Regular    2889
# LF          316
# reg         117
# low fat     112

# Tipo do Produto (categorias)
df.Item_Type.value_counts()
# Fruits and Vegetables    1232
# Snack Foods              1200
# Household                 910
# Frozen Foods              856
# Dairy                     682
# Canned                    649
# Baking Goods              648
# Health and Hygiene        520
# Soft Drinks               445
# Meat                      425
# Breads                    251
# Hard Drinks               214
# Others                    169
# Starchy Foods             148
# Breakfast                 110
# Seafood                    64
# Name: Item_Type, dtype: int64

# Tamanho da Loja
df.Outlet_Size.value_counts()
# Small     4798
# Medium    2793
# High       932

## Existem várias técnicas OneHotEncoder, LabelEncoder
#### Importando o LabelEncoder (usando por simplicidade, mas no dia a dia deve ser estudado)
from sklearn import preprocessing
le = preprocessing.LabelEncoder()

#### Função para aplicar o LabelEncoder em cada atributo que desejo
def generate_labelencoder(atts):
  for attr in atts:
    df[attr] = le.fit_transform(df[attr])
  return df

# Chamando a função (informando os atributos que desejo transformar)
df = generate_labelencoder(['Item_Fat_Content','Item_Type','Outlet_Size'])

df['Item_Fat_Content']
df['Item_Type']
df['Outlet_Size']

#### Verificando os dados após a transformação
df.head()

# #### Excluindo os atributos de identificador de item e quantidade de vendas
df.drop(['Item_Identifier', 'Outlet_Identifier', 'Outlet_Location_Type', 'Outlet_Type'], axis=1, inplace=True)
# Outlet_Type é um bom - testar

#### Verificando os dados após a Exclusão
df.head()

# exemplo de query
df.query('Item_Outlet_Sales > 2500').head()

# Passando para a variável X (excluindo a variavel Alvo)
X = df.drop(['Item_Outlet_Sales'], axis=1, inplace=False)

#### Separando os conjuntos de dados em treino e teste
x_train, x_test, y_train, y_test = train_test_split( X, df.Item_Outlet_Sales, test_size=0.3)

#### Treinando o modelo com os atributos selecionados e transformados
lreg = LinearRegression()
lreg.fit(x_train,y_train)

#### Realizando a predição e calculando as métricas
pred_cv = lreg.predict(x_test)

#### MSE (Erro quadratico médio)
mse = np.mean((pred_cv - y_test)**2)
mse
# 1835883.6651348085

# #### R - Squared
lreg.score(x_test,y_test)
# 0.3298204414099395 (quanto maior, melhor)

# Melhorar os resultados com a Otimização de valores

#####################
### Regularização ###
#####################
#### Verificando a magnitude dos coeficientes (pesos - teta)
predictors = x_train.columns
coef = Series(lreg.coef_,predictors).sort_values()
coef.plot(kind='bar', title='Modal Coefficients') 

########################
### Ridge Regression ###
########################
# Minimizar a discrepancia entre as magnitudes das variáveis

#### Importando e instânciando a classe Ridge
from sklearn.linear_model import Ridge
ridgeReg = Ridge(alpha=0.05, normalize=True)

#### Treinando o modelo
ridgeReg.fit(x_train,y_train)

#### Realizando a predição e calculando as métricas
pred = ridgeReg.predict(x_test)

# MSE
mse = np.mean((pred - y_test)**2)
mse
# 1830063.1039307553

# R - Squared
ridgeReg.score(x_test,y_test)
# 0.33

### Verificação do impacto nos coeficientes de forma gráfica
# Função pra testar vários alphas
def plot_coeficientes_ridge(alpha):
  ridgeReg = Ridge(alpha=alpha, normalize=True)
  ridgeReg.fit(x_train,y_train)
  predictors = x_train.columns
  coef = Series(ridgeReg.coef_,predictors).sort_values()
  print(coef)
  coef.plot(kind='bar', title='Ridge Coefficients')

# #### alpha = 0.01 (penalização)
plot_coeficientes_ridge(0.01)

# #### alpha = 0.5
plot_coeficientes_ridge(0.5)

# #### alpha = 10
plot_coeficientes_ridge(10)

# ### Pontos Importantes
# *   O parametro alpha controla a penalização e consequentemente a magnitude dos coeficientes é reduzida.
# *   Encolhendo os coeficientes temos uma redução na complexidade do modelo.

########################
### Lasso Regression ###
########################
#### Importando e instânciando a classe Lasso
# mais agressiva (seleção de features natural)
# minimiza a zero as menores
# maximiza os maiores

from sklearn.linear_model import Lasso
lassoReg = Lasso(alpha=0.05, normalize=True)

# #### Treinando o modelo
lassoReg.fit(x_train,y_train)

# #### Realizando a predição e calculando as métricas
pred = lassoReg.predict(x_test)

#MSE
mse = np.mean((pred - y_test)**2)
mse
# 0.18...

#R-Square
lassoReg.score(x_test,y_test)
# 0.33

#### Verificação do impacto nos coeficientes de forma gráfica
def plot_coeficientes_lasso(alpha):
  lassoReg = Lasso(alpha=alpha, normalize=True)
  lassoReg.fit(x_train,y_train)
  predictors = x_train.columns
  coef = Series(lassoReg.coef_,predictors).sort_values()
  print(coef)
  coef.plot(kind='bar', title='Lasso Coefficients')

# #### alpha = 0.01
plot_coeficientes_lasso(0.01)

# #### alpha = 0.5
plot_coeficientes_lasso(0.5)

# #### alpha = 1
plot_coeficientes_lasso(1)

### Pontos Importantes
# *   Mesmo com pequenos valores de alpha a magnitude dos coeficientes diminui muito.
# *   O Lasso seleciona alguns atributos enquanto outros são reduzidos a zero (Feature Selection).

#############################
### Elastic Net Regression ##
#############################
# meio termo entre os 2 acima
# bases esparças

#### Importando o objeto da ElasticNet
from sklearn.linear_model import ElasticNet

#### Instanciando a classe e treinando o modelo
# alpha    - penalização
# l1_ratio - 
ENreg = ElasticNet(alpha=1, l1_ratio=0.5, normalize=False)
ENreg.fit(x_train,y_train)

#### Realizando as predicoes e calculando as métricas
pred = ENreg.predict(x_test)

#MSE
mse = np.mean((pred - y_test)**2)
mse
# 1881590.1818357194

#R-Square
ENreg.score(x_test,y_test)
# 0.31313552080792717

### Pontos Importantes
# *   A ElasticNet trabalha como uma combinacao entre a Ridge e a Lasso.
# *   É interessante quando temos um grande dataset
def plot_coeficientes_elastic(alpha,l1):
  ENreg = ElasticNet(alpha=alpha, l1_ratio=l1, normalize=False)
  ENreg.fit(x_train,y_train)
  predictors = x_train.columns
  coef = Series(ENreg.coef_,predictors).sort_values()
  print(coef)
  coef.plot(kind='bar', title='Elastic Coefficients')

# Harmonizar
plot_coeficientes_elastic(1,0.5)

# Diminui um pouco mais a discrepancia
plot_coeficientes_elastic(1,1) 

### Verificando de forma grafica os resultados
#### Importando as bibliotecas
import matplotlib.pyplot as plt
import pandas as pd

#get_ipython().magic(u'matplotlib inline')
predicoes = pd.DataFrame(pred[:100])

y_teste2= pd.DataFrame(y_test.values[:100])

plt.style.use("ggplot")
plt.figure(figsize=(12,8))
plt.xlabel('..')
plt.ylabel('Valor de Vendas')
plt.title('Valores reais vs preditos')

plt.plot(y_teste2.index,predicoes)
plt.plot(y_teste2.index,y_teste2)

plt.legend(['Predições','Valores Reais'])
plt.show()