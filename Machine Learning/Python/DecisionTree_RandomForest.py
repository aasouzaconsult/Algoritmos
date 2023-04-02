# Árvores de decisão e florestas aleatórias

# Este é o código para o vídeo da conferência que aborda sobre os métodos de árvores de decisões em Python. Consulte o vídeo para uma explicação completa.

# Importando bibliotecas
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

# Obtendo os dados
df = pd.read_csv('kyphosis.csv')
df.head()

# Vamos observar um simples pairplot para este pequeno conjunto de dados.
sns.pairplot(df,hue='Kyphosis',palette='Set1')

# Divisão treino-teste
# Vamos dividir os dados em um conjunto de treinamento e um conjunto de testes!
from sklearn.model_selection import train_test_split

X = df.drop('Kyphosis',axis=1)
y = df['Kyphosis']

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.30)

# Árvores de decisão
# Começaremos apenas treinando uma única árvore de decisão.
from sklearn.tree import DecisionTreeClassifier
dtree = DecisionTreeClassifier()
dtree.fit(X_train,y_train)


# Previsão e Avaliação
# Vamos avaliar a nossa árvore de decisão.
predictions = dtree.predict(X_test)

from sklearn.metrics import classification_report,confusion_matrix
print(classification_report(y_test,predictions))
print(confusion_matrix(y_test,predictions))

# Visualização de árvore
# O Scikit learn possui alguns recursos de visualização incorporados para árvores de decisão. Você não usará isso com freqüência e requer que você instale a biblioteca pydot, mas aqui está um exemplo do código para executar isso:

from IPython.display import Image  
from sklearn.externals.six import StringIO  
from sklearn.tree import export_graphviz
import pydot 

features = list(df.columns[1:])
features

dot_data = StringIO()  
export_graphviz(dtree, out_file=dot_data,feature_names=features,filled=True,rounded=True)

graph = pydot.graph_from_dot_data(dot_data.getvalue())  
Image(graph[0].create_png())  


## Florestas aleatórias
# Agora vamos comparar o modelo da árvore de decisão com uma floresta aleatória.

from sklearn.ensemble import RandomForestClassifier
rfc = RandomForestClassifier(n_estimators=100)
rfc.fit(X_train, y_train)

rfc_pred = rfc.predict(X_test)

print(confusion_matrix(y_test,rfc_pred))
print(classification_report(y_test,rfc_pred))