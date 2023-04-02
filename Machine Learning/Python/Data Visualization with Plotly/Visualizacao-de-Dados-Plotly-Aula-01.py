#https://www.youtube.com/watch?v=SmYl0Asr6lY&feature=youtu.be

# ## Visualização de dados com Plot.ly##
# `Cufflinks conecta o pandas ao plot.ly`
# 
# `Instalação do Plot.ly e Cufflinks`
get_ipython().system(u'pip install plotly')

get_ipython().system(u'pip install cufflinks --upgrade')

# `Importando o cufflinks e o plot.ly`
import cufflinks as cf
from plotly.offline import plot, iplot
import pandas as pd
import numpy as np

# ## Visualização de dados reais ##

# **Lembre-se de habilitar o modo offline do plotly**
import cufflinks as cf
cf.go_offline()

# **Importe o pandas**
import pandas as pd

# **Dataset de Vendas da Olist**

# - O dataset já está disponível no diretório datasets. Não é necessário download.
# - Se quiser conhecer mais sobre esse dataset, segue o link https://www.kaggle.com/olistbr/brazilian-ecommerce/version/2
df = pd.read_csv('datasets/olist_classified_public_dataset.csv')

# **Visualizando a base de dados**
df.head()

df.info()


# ## Perguntas aos dados

# - Quais a distribuicao dos status dos pedidos?
# - Quais os meses do ano houve mais vendas?
# - Qual a quantidade de items de um pedido? (medio)
# - Qual a quantidade de vendedores em um pedido ? (medio)
# - O valor do frete tende aumentar com o preco do produto?
# - Qual o tempo medio de entrega?
# - Como foi as vendas por mês?
# - Quais meses superaram a meta de vendas?
# - Como foi a venda por mês se comparado ao ano de 2016?

# In[22]:

df.order_status.value_counts().iplot(kind='bar')


# **Transformando colunas para o formato datetime**

# In[23]:

df.order_purchase_timestamp = pd.to_datetime(df.order_purchase_timestamp)


# **Visualizando as colunas agora em Datetime**

# In[24]:

df.info()


# - Use o metodo to_periodo() com o ´M´ para obter informações no formato de meses
# - Criando a coluna order_purchase_month

# In[25]:

df.order_purchase_timestamp.dt.to_period('M')


# In[26]:

df['order_purchase_month'] = df.order_purchase_timestamp.dt.to_period('M').astype(str)


# In[27]:

df.order_purchase_month.head()


# **Visualizando a nova coluna no dataframe**

# In[28]:

df.head()


# **Cria a variável `vendas_por_mes` que é a soma do valor dos produtos agrupados por mês**

# In[29]:

vendas_por_mes = df.groupby(by='order_purchase_month').order_products_value.sum()


# **visualizando os valores de vendas por mês**

# In[30]:

vendas_por_mes.head()


# In[31]:

vendas_por_mes.index.item


# In[32]:

vendas_por_mes.values


# **Pontos importantes a lembrar:**
# - init_notebook_mode()
# - plotly.offline.iplot()

# **Importando o plotly**

# In[33]:

import plotly
import plotly.graph_objs as go
import plotly.offline as py


# In[34]:

# habilita o modo offline
plotly.offline.init_notebook_mode(connected=True)


# **Vendas por mês**

# - **por padrão o iplot() plota um gráfico de linha, da sentido de valor acumulado**

# In[35]:

import plotly.graph_objs as go

data = [go.Scatter(x=vendas_por_mes.index,
                   y=vendas_por_mes.values)]

py.iplot(data)


# **Gráfico de Barras**

# - **Customizando graficos de barras: titulos e labels dos eixos**

# In[36]:

import plotly.offline as py
import plotly.graph_objs as go

data = [go.Bar(x=vendas_por_mes.index,
               y=vendas_por_mes.values,
               marker = {'color': 'lightblue'})]

# Criando Layout
configuracoes_layout = go.Layout(title='Vendas no Periodo',
                                 yaxis={'title':'Valores em Vendas'},
                                 xaxis={'title': 'Periodo'})

# Objeto figura

fig = go.Figure(data=data, layout=configuracoes_layout)

# plotando o grafico
py.iplot(fig)


# **Definindo ajustes em linhas e cores**

# - **Parâmetro opacity e width**

# In[37]:

import plotly.offline as py
import plotly.graph_objs as go

data = [go.Bar(x=vendas_por_mes.index,
               y=vendas_por_mes.values,
               marker = {'color': 'lightblue',
                         'line': {'color': '#333',
                                  'width': 2}
                        },
               opacity= 0.7
              )
       ]

# Criando Layout
configuracoes_layout = go.Layout(title='Vendas no Periodo',
                                 yaxis={'title':'Valores em Vendas'},
                                 xaxis={'title':'Periodo'})

# Objeto figura

fig = go.Figure(data=data, layout=configuracoes_layout)

# plotando o grafico
py.iplot(fig)


# **Destacando uma barras**

# In[38]:

cores = []


# In[39]:

vendas_por_mes.index


# In[40]:

vendas_por_mes


# **Valor de média para ser testado**

# In[41]:

media = vendas_por_mes.values.mean()


# In[42]:

media


# **Alimentando a lista de cores**

# In[43]:

# se o valor de vendas do mês for menor que a média a lista de cor será vermelha, senão azul.
for x in vendas_por_mes.values:
    if x < media:
        cores.append('red')
    else:
        cores.append('lightblue')


# **Visualizando a lista de cores**

# In[44]:

cores


# **Gráficos de Vendas no Periodo**

# In[45]:

import plotly.offline as py
import plotly.graph_objs as go

data = [go.Bar(x=vendas_por_mes.index,
               y=vendas_por_mes.values,
               marker = {'color': cores,  #lista de cores
                         'line': {'color': '#333',
                                  'width': 2}
                        },
               opacity= 0.7
              )
       ]

# Criando Layout
configuracoes_layout = go.Layout(title='Vendas no Periodo',
                                 yaxis={'title':'Valores em Vendas'},
                                 xaxis={'title':'Periodo'})

# Objeto figura

fig = go.Figure(data=data, layout=configuracoes_layout)

# plotando o grafico
py.iplot(fig, filename='Meses que nao superaram a meta de vendas')


# **Destaca a barra com o maior valor e minimiza a visao de todas as outras**

# In[46]:

maximo_de_vendas = vendas_por_mes.values.max()


# In[47]:

maximo_de_vendas


# **Alimenta a lista de cores**

# In[48]:

cores = []
for x,y in zip(vendas_por_mes.values, vendas_por_mes.index):
    if x == maximo_de_vendas:
        mes_maximo_de_vendas = y
        cores.append('blue')
    else:
        cores.append('lightgray')


# In[49]:

mes_maximo_de_vendas


# In[50]:

cores


# **Plota o gráfico de vendas com um destaque de cor e anotação para o mês que teve mais vendas**

# In[51]:

import plotly.offline as py
import plotly.graph_objs as go

data = [go.Bar(x=vendas_por_mes.index,
               y=vendas_por_mes.values,
               marker = {'color': cores,
                         'line': {'color': '#333',
                                 'width': 2}
                        },
               opacity= 0.7
              )
       ]

# Criando Layout
configuracoes_layout = go.Layout(title='Vendas no Periodo',
                                 yaxis={'title':'Valores em Vendas'},
                                 xaxis={'title': 'Periodo'},
                                 # texto na barra de destaque
                                 annotations = [{'text':'Mês destaque de vendas',
                                                'x':mes_maximo_de_vendas,
                                                'y':maximo_de_vendas}
                                               ]
                                                                                              
                                )

# Objeto figura

fig = go.Figure(data=data, layout=configuracoes_layout)

# plotando o grafico
py.iplot(fig, filename='Mes destaque de vendas')


# **Visualizando duas informações no mesmo gráfico**

# - `Vamos definir alguns valores ficticios para vendas do ano anterior`

# In[52]:

vendas_ano_anterior = vendas_por_mes - 10000.00


# **Gráfico de barras aninhadas**

# In[53]:

import plotly.offline as py
import plotly.graph_objs as go

data = [go.Bar(x=vendas_por_mes.index,
               y=vendas_por_mes.values,
               marker = {'color': cores,
                         'line': {'color': '#333',
                                  'width': 2}
                        },
               opacity= 0.7,
               name='2017'
              ),
# definindo outro plot de barras com valores dos meses passados
        
        go.Bar(x=vendas_ano_anterior.index,
               y=vendas_ano_anterior.values,
               name='2016',
               marker = {'color': 'lightgreen',
                         'line': {'color': '#333',
                                  'width': 2}
                        },
               opacity= 0.7
              )
              
       ]

# Criando Layout
configuracoes_layout = go.Layout(title='Vendas no Periodo',
                                 yaxis={'title':'Valores em Vendas'},
                                 xaxis={'title': 'Periodo'},
                                 annotations = [{'text':'Mês destaque de vendas',
                                                'x':mes_maximo_de_vendas,
                                                'y':maximo_de_vendas}
                                               ]                       
                                
                                )

# Objeto figura

fig = go.Figure(data=data, layout=configuracoes_layout)

# plotando o grafico
py.iplot(fig, filename='Vendas no periodo 2017 e 2016')


# **Vendas por categorias de produtos**
# - **Conta quantos produtos por categoria e coloca dentro da variável vendas_produto_por_categoria**

# In[54]:

vendas_produto_por_categoria =  df.groupby(by='product_category_name').id.count()


# In[55]:

vendas_produto_por_categoria


# **Filtra categorias com quantidade de vendas maiores que 100**

# In[56]:

vendas_produto_por_categoria = vendas_produto_por_categoria.loc[vendas_produto_por_categoria.values>100]


# **Ordena valores do maior para o menor**

# In[57]:

vendas_produto_por_categoria.sort_values(ascending=False,inplace=True)


# **Plota gráfico de barras verticais**

# In[59]:

import plotly.offline as py
import plotly.graph_objs as go

trace0 = go.Bar(y=vendas_produto_por_categoria.values,
                x=vendas_produto_por_categoria.index,
                marker = {'color': '#00FF2A'},
                orientation='v'
              )

data = [trace0]

# Criando Layout
configuracoes_layout = go.Layout(title='Vendas por categoria de Produtos',
                   xaxis=dict(
                         titlefont=dict(size=50,color='lightgrey'),
                         tickangle=75),
                   yaxis={'title': 'Quantidade vendida'},
                   font=dict(size=8)
                   )

# Objeto figura

fig = go.Figure(data=data, layout=configuracoes_layout)

# plotando o grafico
py.iplot(fig)


# **Alterando Faixa de valores dos eixos somando 10% ao valor máximo**

# In[60]:

max(vendas_produto_por_categoria.values)


# In[61]:

max(vendas_produto_por_categoria.values) * 1.10


# In[63]:

import plotly.offline as py
import plotly.graph_objs as go

trace0 = go.Bar(y=vendas_produto_por_categoria.values,
                x=vendas_produto_por_categoria.index,
                marker = {'color': '#00FF2A'},
                orientation='v'
              )

data = [trace0]

# Criando Layout
configuracoes_layout = go.Layout(  title='Vendas por categoria de Produtos',
                                   xaxis=dict(
                                         titlefont=dict(
                                                        color='lightgrey'),
                                                        tickangle=75),

                                   # valor maximo da faixa + 10%
                                   yaxis={'title': 'Quantidade vendida',
                                          'range':[0,max(vendas_produto_por_categoria.values) * 1.10]
                                         },
                                   font=dict(size=7)
                                )

# Objeto figura

fig = go.Figure(data=data, layout=configuracoes_layout)
                   
# plotando o grafico
py.iplot(fig, filename='Vendas por categoria de Produtos')


# **Valor de Frete vs Valor de Produto: Existe alguma tendencia?**

# In[64]:

# Criando gráfico
trace = go.Scatter(x = df['order_freight_value'],
                   y = df['order_products_value'],
                   mode = 'markers',
                   marker = {'color':'#941229'}
                  )
# Armazenando gráfico em uma lista
data = [trace]

# Criando Layout
layout = go.Layout(title='Valor de Frete x Valor de Produto',
                   yaxis={'title':'Valor do Produto'},
                   xaxis={'title': 'Valor do Frete'})

# Criando figura que será exibida
fig = go.Figure(data=data, layout=layout)

py.iplot(fig)


# **Usando o parâmetro text na visualização (parâmetro hover)**

# In[65]:

# Criando gráfico
trace = go.Scatter(x = df['order_freight_value'],
                   y = df['order_products_value'],
                   mode = 'markers',
                   # customização do texto a ser exibido no hover
                   text = 'Status do pedido: '+ df['order_status'] +
                           '<br>' + 'Classe: '+ df['most_voted_class']
                   ,
                   # exibição do hover
                   hoverinfo='text+x+y',
                   marker = {'color':'#941229'}
                  )
# Armazenando gráfico em uma lista
data = [trace]

# Criando Layout
layout = go.Layout(title='Valor de Frete x Valor de Produto',
                   yaxis={'title':'Valor do Produto'},
                   xaxis={'title': 'Valor do Frete'})

# Criando figura que será exibida
fig = go.Figure(data=data, layout=layout)

py.iplot(fig)


# **Customizacao dos eixos com formato em reais R$**

# In[66]:

# Criando gráfico
trace = go.Scatter(x = df['order_freight_value'],
                   y = df['order_products_value'],
                   mode = 'markers',
                   # customização do texto a ser exibido no hover
                   text = 'Status do pedido: '+ df['order_status'] +
                           '<br>' + 'Classe: '+ df['most_voted_class']
                   ,
                   # exibição do hover
                   hoverinfo='text+x+y',
                   marker = {'color':'#941229'}
                  )
# Armazenando gráfico em uma lista
data = [trace]

# Criando Layout
layout = go.Layout(title='Valor de Frete x Valor de Produto',

                   # Definindo exibicao dos eixos x e y
                   yaxis={'title':'Valor do Produto', 
                          'tickformat':'.', 
                          'tickprefix':'R$ '},
                   xaxis={'title': 'Valor do Frete',
                          'tickformat':'.', 
                          'tickprefix':'R$ '})

# Criando figura que será exibida
fig = go.Figure(data=data, layout=layout)

py.iplot(fig)


# **Valor de Frete vs Valor de Produto por status de entrega**

# In[68]:

df.iplot(x='order_freight_value',
         y='order_products_value', 
         categories='most_voted_subclass',
         title='Valor de Frete vs Valor de Produto',
         xTitle='Valor de Frete',
         yTitle='Valor Produto')


# **Quantidade em média de items de um pedido**

# In[69]:

data = [go.Histogram(x=df.order_items_qty)]

layout = go.Layout(title='Quantidade média de itens de um pedido')

fig = go.Figure(data=data, layout=layout)

py.iplot(fig)


# **Quantidade média de vendedores de um pedido**

# In[70]:

trace1 = go.Histogram(x=df.order_items_qty,
                     name='itens',
                     opacity=0.75)

trace2 = go.Histogram(x=df.order_sellers_qty,
                     name='vendedores',
                     opacity=0.75)

layout = go.Layout(title='Quantidade de itens e Vendedores por pedido',
                   barmode='overlay'
                  )

dados = [trace1, trace2]

fig = go.Figure(data=dados, layout=layout)

py.iplot(fig, filename='Quantidade de itens e vendedores por pedido')


# **Plotando um gráfico de pizzaa**
# - **Qual a distribuição da classificação dos pedidos pelos clientes?**

# In[71]:

df.order_status.value_counts()


# In[72]:

classes_mais_votadas = df.groupby(by='most_voted_class').id.count()


# In[73]:

classes_mais_votadas


# In[76]:

# Criando gráfico

trace = go.Pie(labels = classes_mais_votadas.index,
               values = classes_mais_votadas.values
              )

# Armazenando gráfico em uma lista

data = [trace]

# Criando Layout

layout = go.Layout(title='Classificação de Clientes sobre Pedidos')

# Criando figura que será exibida
fig = go.Figure(data=data, layout=layout)

py.iplot(fig)


# **Parametro direction**

# In[77]:

# Criando gráfico

trace = go.Pie(labels = classes_mais_votadas.index,
               values = classes_mais_votadas.values,
               direction='clockwise'
              )

# Armazenando gráfico em uma lista

data = [trace]

# Criando Layout

layout = go.Layout(title='Classificação de Clientes sobre Pedidos')

# Criando figura que será exibida
fig = go.Figure(data=data, layout=layout)

py.iplot(fig)


# **Customizando gráficos de pizza**

# In[78]:

# Criando gráfico

cores = ['#96D38C','#FEBFB3','#E1396C']


trace = go.Pie(labels = classes_mais_votadas.index,
               values = classes_mais_votadas.values,
               marker = {'colors': cores},
               direction='clockwise'
              )

# Armazenando gráfico em uma lista

data = [trace]

# Criando Layout

layout = go.Layout(title='Classificação de Clientes sobre Pedidos')

# Criando figura que será exibida
fig = go.Figure(data=data, layout=layout)

py.iplot(fig)


# **Adicionando linha de contorno, cores**

# In[79]:

# Criando gráfico

cores = ['#96D38C','#FEBFB3','#E1396C']


trace = go.Pie(labels = classes_mais_votadas.index,
               values = classes_mais_votadas.values,
               marker = {'colors': cores, 
                         'line' : {'color':'#000000','width':2}
                        },
               hoverinfo='label+percent+value',
               direction='clockwise'
              )

# Armazenando gráfico em uma lista

data = [trace]

# Criando Layout

layout = go.Layout(title='Classificação de Clientes sobre Pedidos')

# Criando figura que será exibida
fig = go.Figure(data=data, layout=layout)

py.iplot(fig)


# **Destacando porções do gráfico**

# In[80]:

# Criando gráfico

cores = ['#96D38C','#FEBFB3','#E1396C']


trace = go.Pie(labels = classes_mais_votadas.index,
               values = classes_mais_votadas.values,
               marker = {'colors': cores, 
                         'line' : {'color':'#000000','width':2}
                        },
               hoverinfo='label+percent+value',
               pull=[0,0,0.1],
               direction='clockwise'
              )

# Armazenando gráfico em uma lista

data = [trace]

# Criando Layout

layout = go.Layout(title='Classificação de Clientes sobre Pedidos')

# Criando figura que será exibida
fig = go.Figure(data=data, layout=layout)

py.iplot(fig)


# In[74]:

df.most_voted_class.value_counts()

