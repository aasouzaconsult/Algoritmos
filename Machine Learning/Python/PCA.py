# Análise do componente principal (Principal Component Analysis - PCA)
# Uma vez que este não é exatamente um algoritmo de Machine Learning completo, mas apenas um algoritmo de aprendizagem não supervisionado, teremos apenas uma palestra sobre este assunto, mas nenhum projeto completo de Machine Learning (embora possamos trabalhar no conjunto de câncer com PCA).

# Revisão de PCA
# Certifique-se de assistir ao de vídeo de apresentação teórica para uma visão geral completa da PCA!
# Lembre-se de que o PCA é apenas uma transformação dos seus dados e tenta descobrir quais recursos explicam a maior variação em seus dados. Por exemplo:

# Bibliotecas
import matplotlib.pyplot as plt
import pandas as pd
import numpy as np
import seaborn as sns

# Os dados
# Vamos trabalhar com o conjunto de dados de câncer, pois ele tem muitos atributos.
from sklearn.datasets import load_breast_cancer
cancer = load_breast_cancer()
cancer.keys()

print(cancer['DESCR'])

df = pd.DataFrame(cancer['data'],columns=cancer['feature_names'])
df.head()

# Visualização de PCA
# Como observamos antes, é difícil visualizar dados com muitas dimensões. Podemos usar o PCA para encontrar os dois primeiros componentes principais e visualizar os dados neste novo espaço bidimensional, com um único espaço de dispersão. Antes de fazer isso, precisamos escalar nossos dados para que cada parâmetro tenha uma variância unitária.

from sklearn.preprocessing import StandardScaler

scaler = StandardScaler()
scaler.fit(df)

scaled_data = scaler.transform(df)

# O PCA com o Scikit Learn usa um processo muito semelhante a outras funções de pré-processamento que acompanham o SciKit Learn. Nós instanciamos um objeto PCA, localizamos os componentes principais usando o método de ajuste e, em seguida, aplicamos a rotação e a redução da dimensionalidade chamando transform().

# Também podemos especificar quantos componentes queremos manter ao criar o objeto PCA.

from sklearn.decomposition import PCA
pca = PCA(n_components=2)
pca.fit(scaled_data)

# Agora, podemos transformar esses dados em seus dois primeiros componentes principais.
x_pca = pca.transform(scaled_data)
scaled_data.shape

x_pca.shape

# Ótimo! Reduzimos 30 dimensões para apenas 2! Vamos oplotar essas duas dimensões.

plt.figure(figsize=(8,6))
plt.scatter(x_pca[:,0],x_pca[:,1],c=cancer['target'],cmap='plasma')
plt.xlabel('First principal component')
plt.ylabel('Second Principal Component')


# Claramente, usando esses dois componentes, podemos separar facilmente essas duas classes.

## Interpretando os componentes
# Infelizmente, com este grande poder de redução da dimensionalidade, vem o custo de poder entender o que esses componentes representam.

# Os componentes correspondem a combinações dos recursos originais. Os próprios componentes são armazenados como um atributo do objeto PCA ajustado:

pca.components_

# Nessa matriz numérica, cada linha representa um componente principal e cada coluna se relaciona com os recursos originais. podemos visualizar esta relação com um mapa de calor:
df_comp = pd.DataFrame(pca.components_,columns=cancer['feature_names'])

plt.figure(figsize=(12,6))
sns.heatmap(df_comp,cmap='plasma',)