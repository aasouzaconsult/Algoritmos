# Support Vector Machines
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

# Obter dados
# Conjunto de dados de câncer de mama incorporado da Scikit Learn. Podemos obter com a função load:
from sklearn.datasets import load_breast_cancer
cancer = load_breast_cancer()

# O conjunto de dados é apresentado em uma forma de dicionário:
cancer.keys()

# Podemos pegar informações e arrays deste dicionário para configurar nosso dataframe e entender os recursos:
print(cancer['DESCR'])
cancer['feature_names']

# Configurando o DataFrame
df_feat = pd.DataFrame(cancer['data'],columns=cancer['feature_names'])
df_feat.info()

cancer['target']
df_target = pd.DataFrame(cancer['target'],columns=['Cancer'])

# Agora vamos verificar o dataframe:
df.head()

# Análise de dados exploratórios
# Nós ignoraremos a parte Data Viz para esta leitura, pois existem tantos parâmetros que são difíceis de interpretar se você não tem conhecimento e domínio de câncer ou células tumorais. No seu projeto você terá mais oportunidades para visualizar os dados.

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