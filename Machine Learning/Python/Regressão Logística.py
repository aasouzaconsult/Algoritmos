# Regressão Logística
# Conjunto de dados do Titanic da Kaggle](https://www.kaggle.com/c/titanic). Este é um conjunto de dados muito famoso e muitas vezes é o primeiro passo em Machine Learning!
# Vamos montar um algoritmo de classificação sobrevivente ou falecido utilizando regressão logística no Python.
# Usaremos uma versão "semi-limpa" do conjunto de dados do Titanic. Se você usar o conjunto de dados hospedado diretamente no Kaggle, talvez seja necessário fazer uma limpeza adicional não mostrada neste notebook.

# Importar bibliotecas
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

# Os dados
# Vamos começar lendo o arquivo titanic_train.csv em um DataFrame pandas.
train = pd.read_csv('titanic_train.csv')
train.head()

# Análise de dados exploratórios
# Vamos começar algumas análises de dados exploratórios. Começaremos por verificar os dados que faltam!

# Dados ausentes
# Podemos usar seaborn para criar um mapa de calor simples para ver onde estamos perdendo dados!
sns.heatmap(train.isnull(),yticklabels=False,cbar=False,cmap='viridis')

# Aproximadamente 20% dos dados de idade estão faltando. A proporção de idade que falta é provavelmente pequena o suficiente para que possamos fazer uma substituição razoável com alguma forma de imputação de dados. Olhando para a coluna Cabin, porém, parece que estamos perdendo muito desses dados para fazermos o mesmo. Provavelmente vamos descartar isso mais tarde ou mudá-lo para outro "Cabin Conhecido: 1 ou 0"

# Continuemos visualizando mais alguns dos dados! Confira o vídeo para obter explicações completas sobre esses gráficos, este código é apenas para servir como referência.

sns.set_style('whitegrid')
sns.countplot(x='Survived',data=train,palette='RdBu_r')
plt.show()

sns.set_style('whitegrid')
sns.countplot(x='Survived',hue='Sex',data=train,palette='RdBu_r')
plt.show()

sns.set_style('whitegrid')
sns.countplot(x='Survived',hue='Pclass',data=train,palette='rainbow')
plt.show()

# Histograma de idade
train['Age'].hist(bins=30,color='darkred',alpha=0.7)
plt.show()

sns.distplot(train['Age'].dropna(),kde=False,color='darkred',bins=30)

sns.countplot(x='SibSp',data=train)

train['Fare'].hist(color='green',bins=40,figsize=(8,4))

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

# Ótimo! Vamos seguir em frente e deletar a coluna Cabin e a linha em Embarked que falta dado.
train.drop('Cabin',axis=1,inplace=True)
train.head()

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

# Não foi tão ruim! Você pode querer explorar outros recursos no outro arquivo titanic_text.csv. Algumas sugestões:
# 
# * Tente pegar o título (Dr., Sr., Sra., Etc.) do nome como parâmetro.
# * Talvez a cabine possa ser uma característica.
# * Existe alguma informação que você pode obter do bilhete?