# https://feedly.com/i/my/me

# Base de Treinamento
#https://globoesporte.globo.com/index/feed/pagina-2000.ghtml (2 a 2000)
#https://g1.globo.com/politica/index/feed/pagina-1000.ghtml (2 a 320)
#https://g1.globo.com/economia/tecnologia/index/feed/pagina-607.ghtml (2 a 65)
#https://g1.globo.com/economia/index/feed/pagina-1000.ghtml (2 a 500)
#https://g1.globo.com/educacao/index/feed/pagina-690.ghtml (2 a 110)
#https://g1.globo.com/economia/agronegocios/index/feed/pagina-2.ghtml (2 a 365)
#https://g1.globo.com/ciencia-e-saude/index/feed/pagina-1.ghtml (2 a 1020) # 799

import requests
from bs4 import BeautifulSoup
import json
import pickle

#X = []
#y = []
#z = []

# Recuperando...
X = pickle.load(open('data/nao_pp/g1_X_new.ipy', 'rb'))
y = pickle.load(open('data/nao_pp/g1_y_new.ipy', 'rb'))
z = pickle.load(open('data/nao_pp/g1_z_new.ipy', 'rb'))

##################################
## Criando as funções de Crawler #
##################################

def print_headlines_esp(response_text):
    soup = BeautifulSoup(response_text, 'html.parser')
    headlines   = soup.find_all('div', attrs={"class": "feed-post-body-resumo"})
    
    news_category = "esporteNews"
    for headline in headlines:
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

def print_headlines_pol(response_text):
    soup = BeautifulSoup(response_text, 'html.parser')
    headlines   = soup.find_all('div', attrs={"class": "feed-post-body-resumo"})
    
    news_category = "politicaNews"
    for headline in headlines:
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

def print_headlines_tec(response_text):
    soup = BeautifulSoup(response_text, 'html.parser')
    headlines   = soup.find_all('div', attrs={"class": "feed-post-body-resumo"})
    
    news_category = "tecnologiaNews"
    for headline in headlines:
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

def print_headlines_fin(response_text):
    soup = BeautifulSoup(response_text, 'html.parser')
    headlines   = soup.find_all('div', attrs={"class": "feed-post-body-resumo"})
    
    news_category = "financaPessoal"
    for headline in headlines:
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

def print_headlines_edu(response_text):
    soup = BeautifulSoup(response_text, 'html.parser')
    headlines   = soup.find_all('div', attrs={"class": "feed-post-body-resumo"})
    
    news_category = "educacaonews"
    for headline in headlines:
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

#def print_headlines_agro(response_text):
#    soup = BeautifulSoup(response_text, 'html.parser')
#    headlines   = soup.find_all('div', attrs={"class": "feed-post-body-resumo"})
#    
#    news_category = "agronews"
#    for headline in headlines:
#        X.append(headline.text)
#        y.append(news_category)
#        z.append(headline.text)

def print_headlines_sau(response_text):
    soup = BeautifulSoup(response_text, 'html.parser')
    headlines   = soup.find_all('div', attrs={"class": "feed-post-body-resumo"})
    
    news_category = "ciencianaturezasaudenews"
    for headline in headlines:
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

########################################################################
# Baixar as notícias curtas (Treinamento - última carga em 26/02/2020) #
########################################################################
a = 2
b = 100 # 2000 (Fiz 199)

for x in range(a, b):
   url = "https://globoesporte.globo.com/index/feed/pagina-%d.ghtml" % (x)
   print(url)
    
   response = requests.get(url) 
   print_headlines_esp(response.text)

##################################################################################
a = 2
b = 250 # 320 (fiz 249)

for x in range(a, b):
   url = "https://g1.globo.com/politica/index/feed/pagina-%d.ghtml" % (x) # 640
   print(url)
    
   response = requests.get(url) 
   print_headlines_pol(response.text)

##################################################################################
a = 2
b = 66 # 65 (todos)

for x in range(a, b):
   url = "https://g1.globo.com/economia/tecnologia/index/feed/pagina-%d.ghtml" % (x) # 720
   print(url)
    
   response = requests.get(url) 
   print_headlines_tec(response.text)
   
##################################################################################
a = 2
b = 150 # 500 (Fiz 149)

for x in range(a, b):
   url = "https://g1.globo.com/economia/index/feed/pagina-%d.ghtml" % (x)
   print(url)
    
   response = requests.get(url) 
   print_headlines_fin(response.text)
   
##################################################################################
a = 2
b = 111 # 110 (todos)
for x in range(a, b):
   url = "https://g1.globo.com/educacao/index/feed/pagina-%d.ghtml" % (x)
   print(url)
    
   response = requests.get(url) 
   print_headlines_edu(response.text)

##################################################################################
#a = 2
#b = 366 # 365 (todos)
#
#for x in range(a, b):
#   url = "https://g1.globo.com/economia/agronegocios/index/feed/pagina-%d.ghtml" % (x)
#   print(url)
#    
#   response = requests.get(url) 
#   print_headlines_agro(response.text)

##################################################################################
a = 2
b = 799 # 1020 (Fiz 798)

for x in range(a, b):
   url = "https://g1.globo.com/ciencia-e-saude/index/feed/pagina-%d.ghtml" % (x)
   print(url)
    
   response = requests.get(url) 
   print_headlines_sau(response.text)

##################################################################################
##################################################################################

# Tamanho: 49041
y.count('esporteNews')              # 8013
y.count('politicaNews')             # 7901
y.count('tecnologiaNews')           # 6564
y.count('financaPessoal')           # 7953
y.count('educacaonews')             # 7129
#y.count('agronews')                # 3632
y.count('ciencianaturezasaudenews') # 7849

# Salvando a coleção
#pickle.dump(X, open('data/nao_pp/g1_X_new.ipy', 'wb'), pickle.HIGHEST_PROTOCOL)
#pickle.dump(y, open('data/nao_pp/g1_y_new.ipy', 'wb'), pickle.HIGHEST_PROTOCOL)
#pickle.dump(z, open('data/nao_pp/g1_z_new.ipy', 'wb'), pickle.HIGHEST_PROTOCOL)

###############################################################################################################
# Importação e Pré-Processando 
###############################################################################################################
# https://medium.com/@pemagrg/pre-processing-text-in-python-ad13ea544dae
# https://medium.com/@datamonsters/text-preprocessing-in-python-steps-tools-and-examples-bf025f872908

import nltk
from nltk.corpus import stopwords
from nltk.stem import SnowballStemmer
from nltk.stem import WordNetLemmatizer
from string import punctuation
from unidecode import unidecode

stopword = stopwords.words('portuguese')
stopword.append('g1')
stopword.append('globo.com')
stopword.append('“')
stopword.append('”')
stopword.append('€')
stopword.append('ª')
stopword.append('–')
stopword.append('º')
stopword.append('’')
stopword.append(']')
stopword.append('[')
stopword.append('—')

stopword.append('é')
stopword.append('a')
stopword.append('b')
stopword.append('c')
stopword.append('d')
stopword.append('e')
stopword.append('f')
stopword.append('g')
stopword.append('h')
stopword.append('i')
stopword.append('j')
stopword.append('l')
stopword.append('m')
stopword.append('n')
stopword.append('o')
stopword.append('p')
stopword.append('q')
stopword.append('r')
stopword.append('s')
stopword.append('t')
stopword.append('u')
stopword.append('v')
stopword.append('x')
stopword.append('z')
stopword.append('w')
stopword.append('y')

snowball_stemmer = SnowballStemmer('portuguese')
#wordnet_lemmatizer = WordNetLemmatizer()

def strip_punctuation(s):
    return ''.join(c for c in s if c not in punctuation)

Xa = []
Xa = X

X = []

for i in range(0,len(Xa)):
    text               = strip_punctuation(unidecode(Xa[i])) # remove pontuacao e acentuacao
    text               = ''.join(c for c in text if not c.isdigit()) # remove numeros
    word_tokens        = nltk.word_tokenize(text.lower()) # tokenize
    removing_stopwords = [word for word in word_tokens if word not in stopword] # stopwords
    stemmed_word       = [snowball_stemmer.stem(word) for word in removing_stopwords] # stemmed
    X.append(stemmed_word)
   #lemmatized_word    = [wordnet_lemmatizer.lemmatize(word) for word in removing_stopwords] # lemmatized
   #X.append(lemmatized_word)

# Apagar menor que 10 tokens
for x in range(0, len(X)):
    if len(X[x]) <= 10:
        print(x)
        del X[x]
        del y[x]
        del z[x]

# Visualizar coleção
for x in range(0, 60):
   #print(x)
    print(X[x])

def pesquise(lista, valor):
    for x, e in enumerate(lista):
        if e == valor:
            print(x)
            del X[x]
            del y[x]
            del z[x]
    return None

pesquise(y, 'agronews')

# Tamanho: 34327 (pré-processado)
y.count('esporteNews')              # 5228
y.count('politicaNews')             # 6929
y.count('tecnologiaNews')           # 5137
y.count('financaPessoal')           # 5170
y.count('educacaonews')             # 5601
#y.count('agronews')                # 2617
y.count('ciencianaturezasaudenews') # 6262

# exportar - Stemmed
pickle.dump(X, open('data/z6News_X.ipy', 'wb'), protocol=2)
pickle.dump(y, open('data/z6News_y.ipy', 'wb'), protocol=2)
pickle.dump(z, open('data/z6News_z.ipy', 'wb'), protocol=2)

# Importando
import pickle
X = pickle.load(open('data/z6News_X.ipy', 'rb'))
y = pickle.load(open('data/z6News_y.ipy', 'rb'))
z = pickle.load(open('data/z6News_z.ipy', 'rb'))

################################################################################################################
################################# BASE DE TESTES - OUTRAS FONTES ###############################################
################################################################################################################
# ABRIR NOVA SEÇÃO! #
#####################
# Teste - 1 dia #
#################

# Base de Teste - Várias fontes (UOL):
# - Folha de S. Paulo
# - Estadão Conteúdo - Política
# - UOL Notícias - Política
# - UOL Notícias - Internacional
# - UOL Notícias - Educação
# - BBC News Brasil
# - BBC News Brasil - Internacional
# - Globo Esporte 
# - Lance
# - Canaltech
# - MacMagazine
# - Olhar Digital
# - Gizmodo
# - Reuters Brasil
# - Bloomberg
# - Brasil Escola
# - Agência Brasil

import requests
from bs4 import BeautifulSoup
import json
import pickle

X = []
y = []
z = []

# Recuperando...
#X = pickle.load(open('data/test/nao_pp/uol_X_test_new.ipy', 'rb'))
#y = pickle.load(open('data/test/nao_pp/uol_y_test_new.ipy', 'rb'))
#z = pickle.load(open('data/test/nao_pp/uol_z_test_new.ipy', 'rb'))

def print_headlines_pol(response_text):
    soup = BeautifulSoup(response_text, 'lxml')
    headlines   = soup.find_all('div', attrs={"class": "thumb-caption"})
    
    news_category = "politicaNews"
    for headline in headlines:
        print(headline.text)
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

def print_headlines_esp(response_text):
    soup = BeautifulSoup(response_text, 'lxml')
    headlines   = soup.find_all('div', attrs={"class": "thumb-caption"})
    
    news_category = "esporteNews"
    for headline in headlines:
        print(headline.text)
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

def print_headlines_tec(response_text):
    soup = BeautifulSoup(response_text, 'lxml')
    headlines   = soup.find_all('div', attrs={"class": "thumb-caption"})
    
    news_category = "tecnologiaNews"
    for headline in headlines:
        print(headline.text)
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

def print_headlines_fin(response_text):
    soup = BeautifulSoup(response_text, 'lxml')
    headlines   = soup.find_all('div', attrs={"class": "thumb-caption"})
    
    news_category = "financaPessoal"
    for headline in headlines:
        print(headline.text)
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

def print_headlines_edu(response_text):
    soup = BeautifulSoup(response_text, 'lxml')
    headlines   = soup.find_all('div', attrs={"class": "thumb-caption"})
    
    news_category = "educacaonews"
    for headline in headlines:
        print(headline.text)
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

#def print_headlines_agro(response_text):
#    soup = BeautifulSoup(response_text, 'lxml')
#    headlines   = soup.find_all('div', attrs={"class": "thumb-caption"})
#    
#    news_category = "agronews"
#    for headline in headlines:
#        print(headline.text)
#        X.append(headline.text)
#        y.append(news_category)
#        z.append(headline.text)

def print_headlines_sau(response_text):
    soup = BeautifulSoup(response_text, 'lxml')
    headlines   = soup.find_all('div', attrs={"class": "thumb-caption"})
    
    news_category = "ciencianaturezasaudenews"
    for headline in headlines:
        print(headline.text)
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

#------------------------------------------------------
url = "https://noticias.uol.com.br/politica/"
print(url)
response = requests.get(url) 
print_headlines_pol(response.text)

#------------------------------------------------------
url = "https://esporte.uol.com.br/futebol/ultimas"
print(url)
response = requests.get(url) 
print_headlines_esp(response.text)

#------------------------------------------------------
url = "https://noticias.uol.com.br/tecnologia/ultimas"
print(url)
response = requests.get(url) 
print_headlines_tec(response.text)

#------------------------------------------------------
url = "https://economia.uol.com.br/noticias//index.htm"
print(url)
response = requests.get(url) 
print_headlines_fin(response.text)

#------------------------------------------------------
url = "https://educacao.uol.com.br/ultimas"
print(url)
response = requests.get(url) 
print_headlines_edu(response.text)

#------------------------------------------------------
#url = "https://economia.uol.com.br/agronegocio/ultimas"
#print(url)
#response = requests.get(url) 
#print_headlines_agro(response.text)

#------------------------------------------------------
url = "https://noticias.uol.com.br/saude"
print(url)
response = requests.get(url) 
print_headlines_sau(response.text)

# Visualizando...
for x in range(0, len(X)):
    print(X[x])

# 351
y.count('esporteNews')    # 51
y.count('politicaNews')   # 51
y.count('tecnologiaNews') # 48
y.count('financaPessoal') # 51
y.count('educacaonews')   # 48
#y.count('agronews')      # 51
y.count('ciencianaturezasaudenews')   # 51

# Salvando
pickle.dump(X, open('data/test/nao_pp/uol_X_test_new.ipy', 'wb'), protocol=2)
pickle.dump(y, open('data/test/nao_pp/uol_y_test_new.ipy', 'wb'), protocol=2)
pickle.dump(z, open('data/test/nao_pp/uol_z_test_new.ipy', 'wb'), protocol=2)

# Importando
#import pickle
#X = pickle.load(open('data/test/nao_pp/uol_X_test_new.ipy', 'rb'))
#y = pickle.load(open('data/test/nao_pp/uol_y_test_new.ipy', 'rb'))
#z = pickle.load(open('data/test/nao_pp/uol_z_test_new.ipy', 'rb'))

###############################################################################################################
# Importação e Pré-Processando
###############################################################################################################
import nltk
from nltk.corpus import stopwords
from nltk.stem import SnowballStemmer
from nltk.stem import WordNetLemmatizer
from string import punctuation
from unidecode import unidecode

stopword = stopwords.words('portuguese')
stopword.append('g1')
stopword.append('globo.com')
stopword.append('“')
stopword.append('”')
stopword.append('€')
stopword.append('ª')
stopword.append('–')
stopword.append('º')
stopword.append('’')
stopword.append(']')
stopword.append('[')
stopword.append('—')

stopword.append('é')
stopword.append('a')
stopword.append('b')
stopword.append('c')
stopword.append('d')
stopword.append('e')
stopword.append('f')
stopword.append('g')
stopword.append('h')
stopword.append('i')
stopword.append('j')
stopword.append('l')
stopword.append('m')
stopword.append('n')
stopword.append('o')
stopword.append('p')
stopword.append('q')
stopword.append('r')
stopword.append('s')
stopword.append('t')
stopword.append('u')
stopword.append('v')
stopword.append('x')
stopword.append('z')
stopword.append('w')
stopword.append('y')

stopword.append('reinaldo')
stopword.append('azevedo')
stopword.append('uol')
stopword.append('notícias')
stopword.append('política')
stopword.append('estadão')
stopword.append('conteúdo')
stopword.append('tales')
stopword.append('faria')
stopword.append('bbc')
stopword.append('news')
stopword.append('brasil')
stopword.append('hospício')
stopword.append('sigilo')
stopword.append('macmagazine')
stopword.append('canaltech')
stopword.append('adrenaline')
stopword.append('olhar')
stopword.append('digital')
stopword.append('gizmodo')
stopword.append('gesner')
stopword.append('oliveira')
stopword.append('reuters')
stopword.append('folha')
stopword.append('blog')
stopword.append('joão')
stopword.append('antônio')
stopword.append('motta')
stopword.append('todos')
stopword.append('bordo')
stopword.append('escola')
stopword.append('agência')
stopword.append('cult')
stopword.append('gv')
stopword.append('educação')
stopword.append('kids')
stopword.append('descomplique')
stopword.append('jc')
stopword.append('online')
stopword.append('angela')
stopword.append('moon')
stopword.append('plano')
stopword.append('carreira')
stopword.append('luciano')
stopword.append('costa')
stopword.append('marcelo')
stopword.append('rochabrun')
stopword.append('andressa')
stopword.append('pellanda')
stopword.append('sheila')
stopword.append('dang')
stopword.append('akanksha')
stopword.append('rana')
stopword.append('hilary')
stopword.append('russ')
stopword.append('ayhan')
stopword.append('uyanik')
stopword.append('paul')
stopword.append('lienert')
stopword.append('ankit')
stopword.append('ajmera')
stopword.append('jeffrey')
stopword.append('dastin')
stopword.append('heather')
stopword.append('somerville')
stopword.append('cotidiano')
stopword.append('tom')
stopword.append('wilson')
stopword.append('Dan')
stopword.append('williams')
stopword.append('margaryta')
stopword.append('chornokondratenko')
stopword.append('makiko')
stopword.append('yamazaki')
stopword.append('bharath')
stopword.append('manjeshr')
stopword.append('aparajita')
stopword.append('saxena')
stopword.append('sam')
stopword.append('nussey')
stopword.append('ficadica')
stopword.append('nick')
stopword.append('carey')
stopword.append('biologianet')
stopword.append('kate')
stopword.append('holton')
stopword.append('joshua')
stopword.append('franklin')
stopword.append('paresh')
stopword.append('dave')
stopword.append('uday')
stopword.append('sampath')
stopword.append('kumar')
 
snowball_stemmer = SnowballStemmer('portuguese')
#wordnet_lemmatizer = WordNetLemmatizer()

def strip_punctuation(s):
    return ''.join(c for c in s if c not in punctuation)

Xa = []
Xa = X

X = []

for i in range(0,len(Xa)):
    text               = strip_punctuation(unidecode(Xa[i])) # remove pontuacao
    text               = ''.join(c for c in text if not c.isdigit()) # remove numeros
    word_tokens        = nltk.word_tokenize(text.lower()) # tokenize
    removing_stopwords = [word for word in word_tokens if word not in stopword] # stopwords
    stemmed_word       = [snowball_stemmer.stem(word) for word in removing_stopwords] # stemmed
    X.append(stemmed_word)

# Apagar menor que 10 tokens 
for x in range(0, len(X)):
	if len(X[x]) < 10:
		print(x)
		del X[x]
		del y[x]
		del z[x]

for x in range(0, 60):
    print(X[x])

y.count('esporteNews')              # 46
y.count('politicaNews')             # 47
y.count('tecnologiaNews')           # 48
y.count('financaPessoal')           # 42
y.count('educacaonews')             # 48
#y.count('agronews')                # 46
y.count('ciencianaturezasaudenews') # 48

# Salvando
pickle.dump(X, open('data/test/z6News_X_test_uol.ipy', 'wb'), protocol=2)
pickle.dump(y, open('data/test/z6News_y_test_uol.ipy', 'wb'), protocol=2)
pickle.dump(z, open('data/test/z6News_z_test_uol.ipy', 'wb'), protocol=2)

# Recuperando...
import pickle
X = pickle.load(open('data/test/z6News_X_test_uol.ipy', 'rb'))
y = pickle.load(open('data/test/z6News_y_test_uol.ipy', 'rb'))
z = pickle.load(open('data/test/z6News_z_test_uol.ipy', 'rb'))

# https://esporte.uol.com.br/futebol/ultimas
# https://noticias.uol.com.br/politica/
# https://noticias.uol.com.br/tecnologia/ultimas
# https://economia.uol.com.br/noticias//index.htm
# https://educacao.uol.com.br/ultimas
# https://economia.uol.com.br/agronegocio
# https://noticias.uol.com.br/saude

###############################################################################################################
################################# BASE DE TESTES - MESMA FONTES ###############################################
###############################################################################################################
# ABRIR NOVA SEÇÃO! #
#####################

import requests
from bs4 import BeautifulSoup
import json
import pickle

X = []
y = []
z = []

# Recuperando...
#X = pickle.load(open('data/test/nao_pp/g1_X_test_new.ipy', 'rb'))
#y = pickle.load(open('data/test/nao_pp/g1_y_test_new.ipy', 'rb'))
#z = pickle.load(open('data/test/nao_pp/g1_z_test_new.ipy', 'rb'))

##################################
## Criando as funções de Crawler #
##################################

def print_headlines_esp(response_text):
    soup = BeautifulSoup(response_text, 'html.parser')
    headlines   = soup.find_all('div', attrs={"class": "feed-post-body-resumo"})
    
    news_category = "esporteNews"
    for headline in headlines:
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

def print_headlines_pol(response_text):
    soup = BeautifulSoup(response_text, 'html.parser')
    headlines   = soup.find_all('div', attrs={"class": "feed-post-body-resumo"})
    
    news_category = "politicaNews"
    for headline in headlines:
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

def print_headlines_tec(response_text):
    soup = BeautifulSoup(response_text, 'html.parser')
    headlines   = soup.find_all('div', attrs={"class": "feed-post-body-resumo"})
    
    news_category = "tecnologiaNews"
    for headline in headlines:
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

def print_headlines_fin(response_text):
    soup = BeautifulSoup(response_text, 'html.parser')
    headlines   = soup.find_all('div', attrs={"class": "feed-post-body-resumo"})
    
    news_category = "financaPessoal"
    for headline in headlines:
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

def print_headlines_edu(response_text):
    soup = BeautifulSoup(response_text, 'html.parser')
    headlines   = soup.find_all('div', attrs={"class": "feed-post-body-resumo"})
    
    news_category = "educacaonews"
    for headline in headlines:
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

#def print_headlines_agro(response_text):
#    soup = BeautifulSoup(response_text, 'html.parser')
#    headlines   = soup.find_all('div', attrs={"class": "feed-post-body-resumo"})
#    
#    news_category = "agronews"
#    for headline in headlines:
#        X.append(headline.text)
#        y.append(news_category)
#        z.append(headline.text)

def print_headlines_sau(response_text):
    soup = BeautifulSoup(response_text, 'html.parser')
    headlines   = soup.find_all('div', attrs={"class": "feed-post-body-resumo"})
    
    news_category = "ciencianaturezasaudenews"
    for headline in headlines:
        X.append(headline.text)
        y.append(news_category)
        z.append(headline.text)

########################################################################
# Baixar as notícias curtas (Treinamento - última carga em 26/02/2020) #
########################################################################
a = 1
b = 2

for x in range(a, b):
   url = "https://globoesporte.globo.com/index/feed/pagina-%d.ghtml" % (x)
   print(url)
    
   response = requests.get(url) 
   print_headlines_esp(response.text)

##################################################################################
a = 1
b = 2

for x in range(a, b):
   url = "https://g1.globo.com/politica/index/feed/pagina-%d.ghtml" % (x) # 640
   print(url)
    
   response = requests.get(url) 
   print_headlines_pol(response.text)

##################################################################################
a = 1
b = 2

for x in range(a, b):
   url = "https://g1.globo.com/economia/tecnologia/index/feed/pagina-%d.ghtml" % (x) # 720
   print(url)
    
   response = requests.get(url) 
   print_headlines_tec(response.text)
   
##################################################################################
a = 1
b = 2

for x in range(a, b):
   url = "https://g1.globo.com/economia/index/feed/pagina-%d.ghtml" % (x)
   print(url)
    
   response = requests.get(url) 
   print_headlines_fin(response.text)
   
##################################################################################
a = 1
b = 2
for x in range(a, b):
   url = "https://g1.globo.com/educacao/index/feed/pagina-%d.ghtml" % (x)
   print(url)
    
   response = requests.get(url) 
   print_headlines_edu(response.text)

##################################################################################
#a = 1
#b = 2
#
#for x in range(a, b):
#   url = "https://g1.globo.com/economia/agronegocios/index/feed/pagina-%d.ghtml" % (x)
#   print(url)
#    
#   response = requests.get(url) 
#   print_headlines_agro(response.text)

##################################################################################
a = 1
b = 2

for x in range(a, b):
   url = "https://g1.globo.com/ciencia-e-saude/index/feed/pagina-%d.ghtml" % (x)
   print(url)
    
   response = requests.get(url) 
   print_headlines_sau(response.text)

##################################################################################
##################################################################################

# Tamanho:57
y.count('esporteNews')              # 8
y.count('politicaNews')             # 4
y.count('tecnologiaNews')           # 10
y.count('financaPessoal')           # 7
y.count('educacaonews')             # 10
#y.count('agronews')                # 8
y.count('ciencianaturezasaudenews') # 10

# Salvando a coleção
#pickle.dump(X, open('data/test/nao_pp/g1_X_test_new.ipy', 'wb'), protocol=2)
#pickle.dump(y, open('data/test/nao_pp/g1_y_test_new.ipy', 'wb'), protocol=2)
#pickle.dump(z, open('data/test/nao_pp/g1_z_test_new.ipy', 'wb'), protocol=2)

# Recuperando...
#import pickle
#X = pickle.load(open('data/test/nao_pp/g1_X_test_new.ipy', 'rb'))
#y = pickle.load(open('data/test/nao_pp/g1_y_test_new.ipy', 'rb'))
#z = pickle.load(open('data/test/nao_pp/g1_z_test_new.ipy', 'rb'))

###############################################################################################################
# Importação e Pré-Processando 
###############################################################################################################
import nltk
from nltk.corpus import stopwords
from nltk.stem import SnowballStemmer
from nltk.stem import WordNetLemmatizer
from string import punctuation
from unidecode import unidecode

stopword = stopwords.words('portuguese')
stopword.append('g1')
stopword.append('globo.com')
stopword.append('“')
stopword.append('”')
stopword.append('€')
stopword.append('ª')
stopword.append('–')
stopword.append('º')
stopword.append('’')
stopword.append(']')
stopword.append('[')
stopword.append('—')

stopword.append('é')
stopword.append('a')
stopword.append('b')
stopword.append('c')
stopword.append('d')
stopword.append('e')
stopword.append('f')
stopword.append('g')
stopword.append('h')
stopword.append('i')
stopword.append('j')
stopword.append('l')
stopword.append('m')
stopword.append('n')
stopword.append('o')
stopword.append('p')
stopword.append('q')
stopword.append('r')
stopword.append('s')
stopword.append('t')
stopword.append('u')
stopword.append('v')
stopword.append('x')
stopword.append('z')
stopword.append('w')
stopword.append('y')

snowball_stemmer = SnowballStemmer('portuguese')

def strip_punctuation(s):
    return ''.join(c for c in s if c not in punctuation)

Xa = []
Xa = X

X = []

for i in range(0,len(Xa)):
    text               = strip_punctuation(unidecode(Xa[i])) # remove pontuacao
    text               = ''.join(c for c in text if not c.isdigit()) # remove numeros
    word_tokens        = nltk.word_tokenize(text.lower()) # tokenize
    removing_stopwords = [word for word in word_tokens if word not in stopword] # stopwords
    stemmed_word       = [snowball_stemmer.stem(word) for word in removing_stopwords] # stemmed
    X.append(stemmed_word)

# Apagar menor que 10 tokens
for x in range(0, len(X)):
    if len(X[x]) <= 10:
        print(x)
        del X[x]
        del y[x]
        del z[x]

# Tamanho: 41 (pré-processado)
y.count('esporteNews')              # 6
y.count('politicaNews')             # 3
y.count('tecnologiaNews')           # 7
y.count('financaPessoal')           # 5
y.count('educacaonews')             # 10
#y.count('agronews')                # 5
y.count('ciencianaturezasaudenews') # 5

# exportar - Stemmed
pickle.dump(X, open('data/test/z6News_X_test_g1.ipy', 'wb'), protocol=2)
pickle.dump(y, open('data/test/z6News_y_test_g1.ipy', 'wb'), protocol=2)
pickle.dump(z, open('data/test/z6News_z_test_g1.ipy', 'wb'), protocol=2)

# Importando
#X = pickle.load(open('data/test/z6News_X_test_g1.ipy', 'rb'))
#y = pickle.load(open('data/test/z6News_y_test_g1.ipy', 'rb'))
#z = pickle.load(open('data/test/z6News_z_test_g1.ipy', 'rb'))