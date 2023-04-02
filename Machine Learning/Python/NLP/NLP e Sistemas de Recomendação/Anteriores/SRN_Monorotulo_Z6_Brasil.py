# Média de termos por documento: 15.34

###############################################
print ("Importando Bibliotecas e Classes...") #
###############################################

from time import time
from tabulate import tabulate
import matplotlib.pyplot as plt
import seaborn as sns
import pandas as pd
import numpy as np
import gensim
import pickle
from gensim.models.word2vec import Word2Vec
from gensim.models import FastText
from collections import Counter, defaultdict
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.neighbors import KNeighborsClassifier
from sklearn.multiclass import OneVsRestClassifier
from sklearn.pipeline import Pipeline
from sklearn.svm import SVC # https://scikit-learn.org/stable/modules/generated/sklearn.svm.SVC.html
from sklearn import tree    # https://scikit-learn.org/stable/modules/tree.html#
from sklearn.model_selection import train_test_split
from sklearn.model_selection import StratifiedShuffleSplit
from sklearn.metrics import classification_report
from sklearn.metrics import accuracy_score, f1_score, precision_score, recall_score, classification_report, confusion_matrix
from sklearn.metrics import average_precision_score
from sklearn import metrics
from sklearn.preprocessing import label_binarize
from sklearn.utils.fixes import signature
from sklearn.ensemble import RandomForestClassifier

####################################
print ("Classes Embeddings Médio") #
####################################
# Calcula a média dos vetores de cada uma das palavras do documento - para cada um dos documentos

class E2V_AVG(object):
    def __init__(self, word2vec):
        self.w2v = word2vec
        self.dimensao = 300
    
    def fit(self, X, y):
        return self 

    def transform(self, X):
        return np.array([
            np.mean([self.w2v[word] for word in words if word in self.w2v] or [np.zeros(self.dimensao)], axis=0)
            for words in X
        ])

###################################################
print ("Classe da Abordagem Proposta - E2V-IDF*") #
###################################################

class E2V_IDF(object):
    def __init__(self, word2vec):
        self.w2v = word2vec
        self.wIDF = None # IDF da palavra na colecao
        self.dimensao = 300
        
    def fit(self, X, y):
        tfidf = TfidfVectorizer(analyzer=lambda x: x)
        tfidf.fit(X)
        maximo_idf = max(tfidf.idf_) # Uma palavra que nunca foi vista (rara) então o IDF padrão é o máximo de idfs conhecidos (exemplo: 9.2525763918954524)
        self.wIDF = defaultdict(
            lambda: maximo_idf, 
            [(word, tfidf.idf_[i]) for word, i in tfidf.vocabulary_.items()])
        return self
    
    # Gera um vetor de 300 dimensões, para cada documento, com a média dos vetores (embeddings) dos termos * IDF, contidos no documento.
    def transform(self, X):
        return np.array([
                np.mean([self.w2v[word] * self.wIDF[word] for word in words if word in self.w2v] or [np.zeros(self.dimensao)], axis=0)
                for words in X
            ])

##############################################################
print ("Importando a coleção de documento - G1 Notícias...") #
##############################################################

# Stemmed
X = pickle.load(open('data/g1_X_pp_new.ipy', 'rb'))
y = pickle.load(open('data/g1_y_pp_new.ipy', 'rb'))
z = pickle.load(open('data/g1_z_pp_new.ipy', 'rb'))

X, y = np.array(X), np.array(y)

print ("Total de Notícias - G1: %s" % len(y))
#Total de Notícias - G1 (new): 22177

#############################
print ("Treinado na coleção"
#############################

print("-> Word2Vec - GENSIM") # (GENSIM) - https://radimrehurek.com/gensim/models/word2vec.html
model = Word2Vec(X, size=300, window=5, sg=1, workers=4) # sg=1 Skip Gram
w2v = {w: vec for w, vec in zip(model.wv.index2word, model.wv.syn0)}       # 8713

print("-> FastText - GENSIM") # (GENSIM) - https://radimrehurek.com/gensim/models/fasttext.html
model_ft = FastText(X, size=300, window=5, sg=1, workers=4) # sg=1 Skip Gram
ft  = {w: vec for w, vec in zip(model_ft.wv.index2word, model_ft.wv.syn0)} # 8713

###############################################
print ("EMBEDDINGS - PT-Br (Pré - Treinado)") #
###############################################

print("-> Word2Vec e FastText - Corpora STIL 2017") # http://nilc.icmc.usp.br/embeddings

## 300 dimensões
# from gensim.models import KeyedVectors
# model = KeyedVectors.load_word2vec_format('skip_s300.txt')         # Skip Gram
# w2v   = {w: vec for w, vec in zip(model.wv.index2word, model.wv.syn0)}

# model_ft = KeyedVectors.load_word2vec_format('skip_s300_fast.txt') # Skip Gram - fastText
# ft       = {w: vec for w, vec in zip(model_ft.wv.index2word, model_ft.wv.syn0)}

## Exportando o Word2Vec (300 dimensões)
# pickle.dump(w2v, open('data/emb_stil_ptb_sg_300_word2vec.ipy', 'wb'), pickle.HIGHEST_PROTOCOL)
# pickle.dump( ft, open('data/emb_stil_ptb_sg_300_fasttext.ipy', 'wb'), pickle.HIGHEST_PROTOCOL)

## Recuperando... (300 dimensões)
w2v = pickle.load(open('data/emb_stil_ptb_sg_300_word2vec.ipy', 'rb')) # 929606 (ship-gram - 300)
ft  = pickle.load(open('data/emb_stil_ptb_sg_300_fasttext.ipy', 'rb')) # 929605 (ship-gram - 300 - fastText)

# ---------------------------------------------
#print("-> Word2Vec - WIKI 2019 (pré-treinado)")
#w2v_wiki = pickle.load(open('data/emb_wiki_sg_300_word2vec.ipy', 'rb')) # 1494957 (ship-gram - 300)

#print("-> FastText - WIKI 2019 (pré-treinado)")
#ft_wiki  = pickle.load(open('data/emb_wiki_sg_300_fasttext.ipy', 'rb')) # 1494957 (ship-gram - 300 - fastText)

#####################
print ("PIPELINES") #
#####################

#-----------------#
print ("-> Pure") #
#-----------------#
# SVM + RBF (Support Vector Machine + Radial Basis Function)
# y = gamma (grau da Curva, < + reto e > - reto ) | C = largura da margem do Hiperplano
svm_rbf_bow   = Pipeline([("count_vectorizer", CountVectorizer(analyzer=lambda x: x)), ("svm rbf bow"  , OneVsRestClassifier(SVC(kernel="rbf", gamma=0.01, C=1.0)))])
svm_rbf_tfidf = Pipeline([("tfidf_vectorizer", TfidfVectorizer(analyzer=lambda x: x)), ("svm rbf tfidf", OneVsRestClassifier(SVC(kernel="rbf", gamma=0.01, C=1.0)))])
# com n_jobs=-1 - ValueError: WRITEBACKIFCOPY base is read-only

# KNN - K-Nearest Neighbors
knn_bow   = Pipeline([("count_vectorizer", CountVectorizer(analyzer=lambda x: x)), ("knn bow"  , OneVsRestClassifier(KNeighborsClassifier(n_neighbors=5, p=2)))])
knn_tfidf = Pipeline([("tfidf_vectorizer", TfidfVectorizer(analyzer=lambda x: x)), ("knn tfidf", OneVsRestClassifier(KNeighborsClassifier(n_neighbors=5, p=2)))])
# p - distancia (1 = manhattan, 2 = euclidean* e 3 = minkowski...)

# Decision Tree
dt_bow   = Pipeline([("count_vectorizer", CountVectorizer(analyzer=lambda x: x)), ("dt bow"  , OneVsRestClassifier(tree.DecisionTreeClassifier(min_samples_split=40), n_jobs=-1))])
dt_tfidf = Pipeline([("tfidf_vectorizer", TfidfVectorizer(analyzer=lambda x: x)), ("dt tfidf", OneVsRestClassifier(tree.DecisionTreeClassifier(min_samples_split=40), n_jobs=-1))])

# Random Forest (teste)
rf_bow   = Pipeline([("count_vectorizer", CountVectorizer(analyzer=lambda x: x)), ("rf bow"  , OneVsRestClassifier(RandomForestClassifier(min_samples_split=40, n_estimators=10, n_jobs=-1), n_jobs=-1))])
rf_tfidf = Pipeline([("tfidf_vectorizer", TfidfVectorizer(analyzer=lambda x: x)), ("rf tfidf", OneVsRestClassifier(RandomForestClassifier(min_samples_split=40, n_estimators=10, n_jobs=-1), n_jobs=-1))])

#----------------------------------#
print ("-> Embeddings - Word2Vec") #
#----------------------------------#
svm_rbf_w2v     = Pipeline([("w2v", E2V_AVG(w2v))    , ("svm rbf w2v",     OneVsRestClassifier(SVC(kernel="rbf", gamma=0.01, C=1.0), n_jobs=-1))])
svm_rbf_w2v_idf = Pipeline([("w2v-idf", E2V_IDF(w2v)), ("svm rbf w2v-idf", OneVsRestClassifier(SVC(kernel="rbf", gamma=0.01, C=1.0), n_jobs=-1))])

knn_w2v         = Pipeline([("w2v", E2V_AVG(w2v))    , ("knn w2v",     OneVsRestClassifier(KNeighborsClassifier(n_neighbors=5, p=2)))])
knn_w2v_idf     = Pipeline([("w2v-idf", E2V_IDF(w2v)), ("knn w2v-idf", OneVsRestClassifier(KNeighborsClassifier(n_neighbors=5, p=2)))])

dt_w2v       = Pipeline([("w2v", E2V_AVG(w2v))    , ("dt w2v",     OneVsRestClassifier(tree.DecisionTreeClassifier(min_samples_split=40), n_jobs=-1))])
dt_w2v_idf   = Pipeline([("w2v-idf", E2V_IDF(w2v)), ("dt w2v-idf", OneVsRestClassifier(tree.DecisionTreeClassifier(min_samples_split=40), n_jobs=-1))])

rf_w2v       = Pipeline([("w2v", E2V_AVG(w2v))    , ("rf w2v",     OneVsRestClassifier(RandomForestClassifier(min_samples_split=40, n_estimators=10, n_jobs=-1), n_jobs=-1))])
rf_w2v_idf   = Pipeline([("w2v-idf", E2V_IDF(w2v)), ("rf w2v-idf", OneVsRestClassifier(RandomForestClassifier(min_samples_split=40, n_estimators=10, n_jobs=-1), n_jobs=-1))])

##--------------------------------------------------------#
#print ("-> Embeddings - Word2Vec (Wiki - pré-treinado)") #
##--------------------------------------------------------#
#svm_rbf_w2v_wiki     = Pipeline([("w2v_wiki", E2V_AVG(w2v_wiki))    , ("svm rbf w2v_wiki",     OneVsRestClassifier(SVC(kernel="rbf", gamma=0.01, C=1.0), n_jobs=-1))])
#svm_rbf_w2v_idf_wiki = Pipeline([("w2v-idf_wiki", E2V_IDF(w2v_wiki)), ("svm rbf w2v-idf_wiki", OneVsRestClassifier(SVC(kernel="rbf", gamma=0.01, C=1.0), n_jobs=-1))])
#
#knn_w2v_wiki         = Pipeline([("w2v_wiki", E2V_AVG(w2v_wiki))    , ("knn w2v_wiki",     OneVsRestClassifier(KNeighborsClassifier(n_neighbors=5, p=2)))])
#knn_w2v_idf_wiki     = Pipeline([("w2v-idf_wiki", E2V_IDF(w2v_wiki)), ("knn w2v-idf_wiki", OneVsRestClassifier(KNeighborsClassifier(n_neighbors=5, p=2)))])
#
#dt_w2v_wiki       = Pipeline([("w2v_wiki", E2V_AVG(w2v_wiki))    , ("dt w2v_wiki",     OneVsRestClassifier(tree.DecisionTreeClassifier(min_samples_split=40), n_jobs=-1))])
#dt_w2v_idf_wiki   = Pipeline([("w2v-idf_wiki", E2V_IDF(w2v_wiki)), ("dt w2v-idf_wiki", OneVsRestClassifier(tree.DecisionTreeClassifier(min_samples_split=40), n_jobs=-1))])
#
#rf_w2v_wiki       = Pipeline([("w2v_wiki", E2V_AVG(w2v_wiki))    , ("rf w2v_wiki",     OneVsRestClassifier(RandomForestClassifier(min_samples_split=40, n_estimators=10, n_jobs=-1), n_jobs=-1))])
#rf_w2v_idf_wiki   = Pipeline([("w2v-idf_wiki", E2V_IDF(w2v_wiki)), ("rf w2v-idf_wiki", OneVsRestClassifier(RandomForestClassifier(min_samples_split=40, n_estimators=10, n_jobs=-1), n_jobs=-1))])

#----------------------------------#
print ("-> Embeddings - FastText") #
#----------------------------------#
svm_rbf_ft     = Pipeline([("ft", E2V_AVG(ft))    , ("svm rbf ft",     OneVsRestClassifier(SVC(kernel="rbf", gamma=0.01, C=1.0), n_jobs=-1))])
svm_rbf_ft_idf = Pipeline([("ft-idf", E2V_IDF(ft)), ("svm rbf ft-idf", OneVsRestClassifier(SVC(kernel="rbf", gamma=0.01, C=1.0), n_jobs=-1))])
                             
knn_ft         = Pipeline([("ft", E2V_AVG(ft))    , ("knn ft",     OneVsRestClassifier(KNeighborsClassifier(n_neighbors=5, p=2)))])
knn_ft_idf     = Pipeline([("ft-idf", E2V_IDF(ft)), ("knn ft-idf", OneVsRestClassifier(KNeighborsClassifier(n_neighbors=5, p=2)))])
                             
dt_ft       = Pipeline([("ft", E2V_AVG(ft))    , ("dt ft",     OneVsRestClassifier(tree.DecisionTreeClassifier(min_samples_split=40), n_jobs=-1))])
dt_ft_idf   = Pipeline([("ft-idf", E2V_IDF(ft)), ("dt ft-idf", OneVsRestClassifier(tree.DecisionTreeClassifier(min_samples_split=40), n_jobs=-1))])
                             
rf_ft       = Pipeline([("ft", E2V_AVG(ft))    , ("rf ft",     OneVsRestClassifier(RandomForestClassifier(min_samples_split=40, n_estimators=10, n_jobs=-1), n_jobs=-1))])
rf_ft_idf   = Pipeline([("ft-idf", E2V_IDF(ft)), ("rf ft-idf", OneVsRestClassifier(RandomForestClassifier(min_samples_split=40, n_estimators=10, n_jobs=-1), n_jobs=-1))])

##--------------------------------------------------------#
#print ("-> Embeddings - FastText (Wiki - pré-treinado)") #
##--------------------------------------------------------#
#svm_rbf_ft_wiki     = Pipeline([("ft_wiki", E2V_AVG(ft_wiki))    , ("svm rbf ft_wiki",     OneVsRestClassifier(SVC(kernel="rbf", gamma=0.01, C=1.0), n_jobs=-1))])
#svm_rbf_ft_idf_wiki = Pipeline([("ft-idf_wiki", E2V_IDF(ft_wiki)), ("svm rbf ft-idf_wiki", OneVsRestClassifier(SVC(kernel="rbf", gamma=0.01, C=1.0), n_jobs=-1))])
#                             
#knn_ft_wiki         = Pipeline([("ft_wiki", E2V_AVG(ft_wiki))    , ("knn ft_wiki",     OneVsRestClassifier(KNeighborsClassifier(n_neighbors=5, p=2)))])
#knn_ft_idf_wiki     = Pipeline([("ft-idf_wiki", E2V_IDF(ft_wiki)), ("knn ft-idf_wiki", OneVsRestClassifier(KNeighborsClassifier(n_neighbors=5, p=2)))])
#                             
#dt_ft_wiki       = Pipeline([("ft_wiki", E2V_AVG(ft_wiki))    , ("dt ft_wiki",     OneVsRestClassifier(tree.DecisionTreeClassifier(min_samples_split=40), n_jobs=-1))])
#dt_ft_idf_wiki   = Pipeline([("ft-idf_wiki", E2V_IDF(ft_wiki)), ("dt ft-idf_wiki", OneVsRestClassifier(tree.DecisionTreeClassifier(min_samples_split=40), n_jobs=-1))])
#                             
#rf_ft_wiki       = Pipeline([("ft_wiki", E2V_AVG(ft_wiki))    , ("rf ft_wiki",     OneVsRestClassifier(RandomForestClassifier(min_samples_split=40, n_estimators=10, n_jobs=-1), n_jobs=-1))])
#rf_ft_idf_wiki   = Pipeline([("ft-idf_wiki", E2V_IDF(ft_wiki)), ("rf ft-idf_wiki", OneVsRestClassifier(RandomForestClassifier(min_samples_split=40, n_estimators=10, n_jobs=-1), n_jobs=-1))])

all_models_svm = [
    ("SVM(RBF)+BoW", svm_rbf_bow),
    ("SVM(RBF)+TFIDF", svm_rbf_tfidf),
    ("SVM(RBF)+W2V", svm_rbf_w2v),
    ("SVM(RBF)+W2V-IDF", svm_rbf_w2v_idf),
    ("SVM(RBF)+FT", svm_rbf_ft),
    ("SVM(RBF)+FT-IDF", svm_rbf_ft_idf),
    # Wiki
    #("SVM(RBF)+W2V_WIKI", svm_rbf_w2v_wiki),
    #("SVM(RBF)+W2V-IDF_WIKI", svm_rbf_w2v_idf_wiki),
    #("SVM(RBF)+FT_WIKI", svm_rbf_ft_wiki),
    #("SVM(RBF)+FT-IDF_WIKI", svm_rbf_ft_idf_wiki),
]

all_models_knn = [
    ("KNN+BoW", knn_bow),
    ("KNN+TFIDF", knn_tfidf),
    ("KNN+W2V", knn_w2v),
    ("KNN+W2V-IDF", knn_w2v_idf),
    ("KNN+FT", knn_ft),
    ("KNN+FT-IDF", knn_ft_idf),
    # Wiki
    #("KNN+W2V_WIKI", knn_w2v_wiki),
    #("KNN+W2V-IDF_WIKI", knn_w2v_idf_wiki),
    #("KNN+FT_WIKI", knn_ft_wiki),
    #("KNN+FT-IDF_WIKI", knn_ft_idf_wiki),
]

all_models_dt = [
    ("DT+BoW", dt_bow),
    ("DT+TFIDF", dt_tfidf),
    ("DT+W2V", dt_w2v),
    ("DT+W2V-IDF", dt_w2v_idf),
    ("DT+FT", dt_ft),
    ("DT+FT-IDF", dt_ft_idf),
    # Wiki
    #("DT+W2V_WIKI", dt_w2v_wiki),
    #("DT+W2V-IDF_WIKI", dt_w2v_idf_wiki),
    #("DT+FT_WIKI", dt_ft_wiki),
    #("DT+FT-IDF_WIKI", dt_ft_idf_wiki),
]

all_models_rf = [
    ("RF+BoW", rf_bow),
    ("RF+TFIDF", rf_tfidf),
    ("RF+W2V", rf_w2v),
    ("RF+W2V-IDF", rf_w2v_idf),
    ("RF+TF", rf_ft),
    ("RF+TF-IDF", rf_ft_idf),
    # Wiki
    #("RF+W2V_WIKI", rf_w2v_wiki),
    #("RF+W2V-IDF_WIKI", rf_w2v_idf_wiki),
    #("RF+FT_WIKI", rf_ft_wiki),
    #("RF+FT-IDF_WIKI", rf_ft_idf_wiki),
]

###############################################################
print ("RESULTADOS - F1-Score, Acuracia, Precision e Recall") #
###############################################################

#------------------#
print ("F1-Score") #
#------------------#
from sklearn.model_selection import KFold
def benchmark_new_f1(model, X, y):
	scores = []
	kf = KFold(n_splits=10, random_state=66, shuffle=False)
	kf.get_n_splits(X, y)
	for train, test in kf.split(X, y):
		X_train, X_test = X[train], X[test]
		y_train, y_test = y[train], y[test]
		scores.append(f1_score(model.fit(X_train, y_train).predict(X_test), y_test, average = 'micro'))
		print (pd.DataFrame(scores)) # Guardar dados das 10 rodadas
	return np.mean(scores)

# ---------------------------------------------------------------------
table = []
t0 = time()
for name, model in all_models_svm:
	 print(name)
	 table.append({'model': name, 
				   'f1-score': benchmark_new_f1(model, X, y)})
	 print(table)

df_result_f1 = pd.DataFrame(table)
print(df_result_f1)
print("Resultados (SVM) - F1-Score - DONE in %0.3fs." % (time() - t0))

# -----------------------------
table = []
t0 = time()
for name, model in all_models_knn:
	 print(name)
	 table.append({'model': name, 
				   'f1-score': benchmark_new_f1(model, X, y)})
	 print(table)

df_result_f1 = pd.DataFrame(table)
print(df_result_f1)
print("Resultados (KNN) - F1-Score - DONE in %0.3fs." % (time() - t0))

# -----------------------------
table = []
t0 = time()
for name, model in all_models_dt:
	 print(name)
	 table.append({'model': name, 
				   'f1-score': benchmark_new_f1(model, X, y)})
	 print(table)

df_result_f1 = pd.DataFrame(table)
print(df_result_f1)
print("Resultados (Decision Tree) - F1-Score - DONE in %0.3fs." % (time() - t0))

# -----------------------------
table = []
t0 = time()
for name, model in all_models_rf:
	 print(name)
	 table.append({'model': name, 
				   'f1-score': benchmark_new_f1(model, X, y)})
	 print(table)

df_result_f1 = pd.DataFrame(table)
print(df_result_f1)
print("Resultados (Random Forest) - F1-Score - DONE in %0.3fs." % (time() - t0))

#------------------#
print ("Acuracia") #
#------------------#
from sklearn.model_selection import KFold
def benchmark_new(model, X, y):
    scores = []
    kf = KFold(n_splits=10, random_state=66, shuffle=False)
    kf.get_n_splits(X, y)
    for train, test in kf.split(X, y):
        X_train, X_test = X[train], X[test]
        y_train, y_test = y[train], y[test]
        scores.append(accuracy_score(model.fit(X_train, y_train).predict(X_test), y_test))
        print (pd.DataFrame(scores)) # Guardar dados das 10 rodadas
    return np.mean(scores)

# ---------------------------------------------------------------------
table = []
t0 = time()
for name, model in all_models_svm:
     print(name)
     table.append({'model': name, 
                   'accuracy': benchmark_new(model, X, y)})
     print(table)

df_result = pd.DataFrame(table)
print(df_result)
print("Results (SVM) - Accuracy - DONE in %0.3fs." % (time() - t0))

# -----------------------------
table = []
t0 = time()
for name, model in all_models_knn:
     print(name)
     table.append({'model': name, 
                   'accuracy': benchmark_new(model, X, y)})
     print(table)

df_result = pd.DataFrame(table)
print(df_result)
print("Results (KNN) - Accuracy - DONE in %0.3fs." % (time() - t0))

# -----------------------------
table = []
t0 = time()
for name, model in all_models_dt:
     print(name)
     table.append({'model': name, 
                   'accuracy': benchmark_new(model, X, y)})
     print(table)

df_result = pd.DataFrame(table)
print(df_result)
print("Results (Decision Tree) - Accuracy - DONE in %0.3fs." % (time() - t0))

# -----------------------------
table = []
t0 = time()
for name, model in all_models_rf:
     print(name)
     table.append({'model': name, 
                   'accuracy': benchmark_new(model, X, y)})
     print(table)

df_result = pd.DataFrame(table)
print(df_result)
print("Results (Random Forest) - Accuracy - DONE in %0.3fs." % (time() - t0))

##-------------------#
#print ("Precision") #
##-------------------#
#from sklearn.model_selection import KFold
#def benchmark_new_pr(model, X, y):
#    scores = []
#    kf = KFold(n_splits=10, random_state=66, shuffle=False)
#    kf.get_n_splits(X, y)
#    for train, test in kf.split(X, y):
#        X_train, X_test = X[train], X[test]
#        y_train, y_test = y[train], y[test]
#        scores.append(precision_score(model.fit(X_train, y_train).predict(X_test), y_test, average = 'micro'))
#    return np.mean(scores)
#
#table = []
#t0 = time()
#for name, model in all_models:
#     print(name)
#     table.append({'model': name, 
#                   'precision': benchmark_new_pr(model, X, y)})
##df_result_pr = pd.DataFrame(sorted(table, reverse=True))
#df_result_pr = pd.DataFrame(table)
#print(df_result_pr)
#print("Results - Precision - DONE in %0.3fs." % (time() - t0))
#
##----------------#
#print ("Recall") #
##----------------#
#from sklearn.model_selection import KFold
#def benchmark_new_rc(model, X, y):
#    scores = []
#    kf = KFold(n_splits=10, random_state=66, shuffle=False)
#    kf.get_n_splits(X, y)
#    for train, test in kf.split(X, y):
#        X_train, X_test = X[train], X[test]
#        y_train, y_test = y[train], y[test]
#        scores.append(recall_score(model.fit(X_train, y_train).predict(X_test), y_test, average = 'micro'))
#    return np.mean(scores)
#
#table = []
#t0 = time()
#for name, model in all_models:
#     print(name)
#     table.append({'model': name, 
#                   'recall..': benchmark_new_rc(model, X, y)})
##df_result_rc = pd.DataFrame(sorted(table, reverse=True))
#df_result_rc = pd.DataFrame(table)
#print(df_result_rc)
#print("Results - Recall - DONE in %0.3fs." % (time() - t0))

#####################################################################
print ("Graficos dos Classificadores por Colecao de Documentos...") #
#####################################################################
# -------- #
# Bar char #
# -------- #
# plt.figure(figsize=(15, 6))
# sns.barplot(x=[name for name, _ in scores], y=[score for _, score in scores])

# Função de Treinamento e Predição
from sklearn.model_selection import StratifiedShuffleSplit
def benchmark(model, X, y, n):
    test_size = 1 - (n / float(len(y)))
    scores = []
    sss = StratifiedShuffleSplit(n_splits=10, random_state=66, test_size=test_size)
    sss.get_n_splits(X, y)
    for train, test in sss.split(X, y):
        X_train, X_test = X[train], X[test]
        y_train, y_test = y[train], y[test]
        scores.append(accuracy_score(model.fit(X_train, y_train).predict(X_test), y_test))
    return np.mean(scores)

# ---------------------------
# Z5NewsBrasil (OK - https://drive.google.com/drive/folders/1cKdccd_oqpe3xPCmOS1V9w6qx3bdGZDE)
# 10hs de execução

train_sizes = [150, 500, 1500, 3000, 6000, 10000, 15000, 20000, 22000]
table = []
t0 = time()
for name, model in all_models:
    for n in train_sizes:
        table.append({'model': name, 
                      'accuracy': benchmark(model, X, y, n), 
                      'train_size': n})
df = pd.DataFrame(table)
print("Z5NewsBrasil - DataFrame - DONE in %0.3fs." % (time() - t0))

plt.figure(figsize=(15, 6))
fig = sns.pointplot(x='train_size', y='accuracy', hue='model', 
                    data=df[df.model.map(lambda x: x in ["SVM(RBF)+BoW", "SVM(RBF)+TFIDF", "RF+BoW", "RF+TFIDF", "SVM(RBF)+FT-IDF","SVM(RBF)+FT"])])
sns.set_context("notebook", font_scale=1.5)
fig.set(ylabel="accuracy")
fig.set(xlabel="labeled training examples")
fig.set(title="Z5NewsBrasil benchmark")
fig.set(ylabel="accuracy")

plt.show() # https://stackoverflow.com/questions/46917425/how-to-order-seaborn-pointplot

###########################################################
print ("Treinando e Predizendo - Melhor Classificador") ###
###########################################################

# Binarizes Labels
from sklearn.preprocessing import label_binarize

#Z5 - BR
name_labels = ['esporteNews', 'politicaNews', 'tecnologiaNews', 'financaPessoal', 'educacaonews']
Y = label_binarize(y, classes=['esporteNews', 'politicaNews', 'tecnologiaNews', 'financaPessoal', 'educacaonews'])

n_classes = Y.shape[1]

# -------------------------
# Training and Testing Sets
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=.2, random_state=66) # Train 80% e Test 20% # random_state - se informado, fica fixo para aquele random

# Training
svm_rbf_w2v_idf.fit(X_train, Y_train) # 

# Prediction
predictions = svm_rbf_w2v_idf.predict(X_test)

# Reports
print ("Precision: %s" %precision_score(Y_test, predictions, average="micro"))
print ("Recall...: %s" %recall_score(Y_test, predictions, average="micro"))
print ("F1-Score.: %s" %f1_score(Y_test, predictions, average="micro"))
print ("Accuracy.: %s" %accuracy_score(Y_test, predictions))

print (classification_report(predictions,Y_test))

# Previsões - https://github.com/matheusfacure/nlp-oxford/blob/master/text_class.ipynb
# Gráficos  - https://scikit-plot.readthedocs.io/en/stable/metrics.html

#----------------------------- #
#          Gráfico 1           #
# ---------------------------- #
# - Curve Precision - Recall - #
# ---------------------------- #

# Curva - Precision - Recall
y_score = svm_rbf_w2v_idf.decision_function(X_test)

from sklearn.metrics import precision_recall_curve
from sklearn.metrics import average_precision_score

# For each class
precision = dict()
recall = dict()
average_precision = dict()
for i in range(n_classes):
    precision[i], recall[i], _ = precision_recall_curve(Y_test[:, i], y_score[:, i])
    average_precision[i] = average_precision_score(Y_test[:, i], y_score[:, i])

# A "micro-average": quantifying score on all classes jointly
step_kwargs = ({'step': 'post'}
               if 'step' in signature(plt.fill_between).parameters
               else {})

precision["micro"], recall["micro"], _ = precision_recall_curve(Y_test.ravel(), y_score.ravel())
average_precision["micro"] = average_precision_score(Y_test, y_score, average="micro")
print('Average precision score, micro-averaged over all classes: {0:0.2f}'.format(average_precision["micro"]))

plt.figure()
plt.step(recall['micro'], precision['micro'], color='b', alpha=0.2, where='post')
plt.fill_between(recall["micro"], precision["micro"], alpha=0.2, color='b', **step_kwargs)

plt.xlabel('Recall')
plt.ylabel('Precision')
plt.ylim([0.0, 1.05])
plt.xlim([0.0, 1.0])
plt.title('Average precision score, micro-averaged over all classes: AP={0:0.2f}'.format(average_precision["micro"]))

# Average precision score, micro-averaged over all classes: 0.83

#------------------------ #
#       Gráfico 2
# ----------------------- #
# ------ Curve ROC ------ #
# ----------------------- #
fpr = dict()
tpr = dict()
roc_auc = dict()
for i in range(n_classes):
    fpr[i], tpr[i], _ = metrics.roc_curve(Y_test[:, i], y_score[:, i])
    roc_auc[i] = metrics.auc(fpr[i], tpr[i])

# Compute micro-average ROC curve and ROC area
fpr["micro"], tpr["micro"], _ = metrics.roc_curve(Y_test.ravel(), y_score.ravel())
roc_auc["micro"] = metrics.auc(fpr["micro"], tpr["micro"])

plt.figure()
lw = 2
plt.plot(fpr[2], tpr[2], color='darkorange',
         lw=lw, label='ROC curve (area = %0.2f)' % roc_auc[2])
plt.plot([0, 1], [0, 1], color='navy', lw=lw, linestyle='--')
plt.xlim([0.0, 1.0])
plt.ylim([0.0, 1.05])
plt.xlabel('False Positive Rate')
plt.ylabel('True Positive Rate')
plt.title('Receiver operating characteristic (Curve ROC)')
plt.legend(loc="lower right") # legenda
plt.show()

# ------------------------------------ #
#              Gráfico 3
# ------------------------------------ #
# ------ Curve ROC - Multiclass ------ #
# ------------------------------------ #
# Plot ROC curves for the multiclass problem

from itertools import cycle 
# Compute macro-average ROC curve and ROC area
# First aggregate all false positive rates
all_fpr = np.unique(np.concatenate([fpr[i] for i in range(n_classes)]))

# Then interpolate all ROC curves at this points
mean_tpr = np.zeros_like(all_fpr)
for i in range(n_classes):
    mean_tpr += np.interp(all_fpr, fpr[i], tpr[i])

# Finally average it and compute AUC
mean_tpr /= n_classes

fpr["macro"] = all_fpr
tpr["macro"] = mean_tpr
roc_auc["macro"] = metrics.auc(fpr["macro"], tpr["macro"])

# Plot all ROC curves
plt.figure()
plt.plot(fpr["micro"], tpr["micro"],
         label='micro-average ROC curve (area = {0:0.2f})'
               ''.format(roc_auc["micro"]),
         color='deeppink', linestyle=':', linewidth=4)

plt.plot(fpr["macro"], tpr["macro"],
         label='macro-average ROC curve (area = {0:0.2f})'
               ''.format(roc_auc["macro"]),
         color='blue', linestyle=':', linewidth=4)

colors = cycle(['aqua', 'darkorange', 'cornflowerblue', 'red', 'green', 'brown', 'gray', 'purple'])
for i, color in zip(range(n_classes), colors):
    plt.plot(fpr[i], tpr[i], color=color, lw=lw,
             label='ROC curve of category {0} (area = {1:0.2f})'
            #''.format(i, roc_auc[i]))
             ''.format(name_labels[i], roc_auc[i]))

plt.plot([0, 1], [0, 1], 'k--', lw=lw)
plt.xlim([0.0, 1.0])
plt.ylim([0.0, 1.05])
plt.xlabel('False Positive Rate')
plt.ylabel('True Positive Rate')
plt.title('Some extension of Receiver operating characteristic to multi-labels')
plt.tight_layout()
#plt.legend(loc="lower right")
plt.legend(loc='lower right', ncol=2, borderaxespad=0, frameon=False)
plt.show()

#######################################################################################
############################ TESTE COM OUTRAS FONTES (SRN) ############################
#######################################################################################

###################################################
print ("Importando as coleções de documentos...") #
###################################################

# Stemmed
X = pickle.load(open('data/g1_X_pp_new.ipy', 'rb'))
y = pickle.load(open('data/g1_y_pp_new.ipy', 'rb'))
z = pickle.load(open('data/g1_z_pp_new.ipy', 'rb'))

X, y, z = np.array(X), np.array(y), np.array(z)

print ("Z5NewsBrasil - Total de notícias curtas - Train: %s" % len(y))

# Test - Diversas fontes (agregador - UOL) - Termos: 17.141768292682926
###################################################
# Stemmed
Xt = pickle.load(open('data/g1_X_test_pp_new.ipy', 'rb'))
yt = pickle.load(open('data/g1_y_test_pp_new.ipy', 'rb'))
zt = pickle.load(open('data/g1_z_test_pp_new.ipy', 'rb'))

Xt, yt, zt = np.array(Xt), np.array(yt), np.array(zt)

print ("Z5NewsBrasil (Test) - Total de notícias curtas: %s" % len(yt))

# Training and Testing Sets
#################################################################
#Z5 - BR
name_labels = ['esporteNews', 'politicaNews', 'tecnologiaNews', 'financaPessoal', 'educacaonews']
Y           = label_binarize(y,  classes=['esporteNews', 'politicaNews', 'tecnologiaNews', 'financaPessoal', 'educacaonews'])
Yt          = label_binarize(yt, classes=['esporteNews', 'politicaNews', 'tecnologiaNews', 'financaPessoal', 'educacaonews'])
n_classes = Y.shape[1]

X_train = X
Y_train = Y
Z_train = z

X_test  = Xt
Y_test  = Yt
Z_test  = zt

#####################
print ("Treinamento")
#####################

print ("rf_bow")
print ("Treinamento...")
t0 = time()
rf_bow.fit(X_train, Y_train)
print("Treinamento realizado em %0.3fs." % (time() - t0))

print ("Predição...")
predictions = rf_bow.predict(X_test)

print ("Calculando métricas...")
print ("Precision: %s" %precision_score(Y_test, predictions, average="micro"))
print ("Recall...: %s" %recall_score(Y_test, predictions, average="micro"))
print ("F1-Score.: %s" %f1_score(Y_test, predictions, average="micro"))
print ("Accuracy.: %s" %accuracy_score(Y_test, predictions))

print (classification_report(predictions,Y_test))

# RMSE
from sklearn.metrics import mean_squared_error
from math import sqrt

# for i in range(0,769): print("Error in value number",i,(Y_test[i]-predictions2[i]))

rmse = sqrt(mean_squared_error(Y_test, predictions))
print("RMSE: ",rmse)

# rf_bow
# Treinamento...
# Treinamento realizado em 4.434s.
# Predição...
# Calculando métricas...
# Precision: 0.8042635658914729
# Recall...: 0.6326219512195121
# F1-Score.: 0.7081911262798635
# Accuracy.: 0.5975609756097561
#               precision    recall  f1-score   support
#            0       0.77      0.89      0.83       117
#            1       0.73      0.64      0.68       120
#            2       0.70      0.81      0.75       124
#            3       0.19      0.76      0.30        34
#            4       0.81      0.89      0.85       121
#    micro avg       0.63      0.80      0.71       516
#    macro avg       0.64      0.80      0.68       516
# weighted avg       0.71      0.80      0.74       516
#  samples avg       0.63      0.61      0.62       516

# RMSE:  0.32290601215048137

#####################
print ("svm_rbf_ft_idf")
print ("Treinamento...")
t0 = time()
svm_rbf_ft_idf.fit(X_train, Y_train)
print("Treinamento realizado em %0.3fs." % (time() - t0))

print ("Predição...")
predictions4 = svm_rbf_ft_idf.predict(X_test)

print ("Calculando métricas...")
print ("Precision: %s" %precision_score(Y_test, predictions4, average="micro"))
print ("Recall...: %s" %recall_score(Y_test, predictions4, average="micro"))
print ("F1-Score.: %s" %f1_score(Y_test, predictions4, average="micro"))
print ("Accuracy.: %s" %accuracy_score(Y_test, predictions4))

print (classification_report(predictions4,Y_test))

# RMSE
from sklearn.metrics import mean_squared_error
from math import sqrt

# for i in range(0,769): print("Error in value number",i,(Y_test[i]-predictions2[i]))

rmse = sqrt(mean_squared_error(Y_test, predictions4))
print("RMSE: ",rmse)

# svm_rbf_ft_idf
# Treinamento...
# Treinamento realizado em 276.939s.
# Predição...
# Calculando métricas...
# Precision: 0.845360824742268
# Recall...: 0.625
# F1-Score.: 0.7186678352322524
# Accuracy.: 0.625
#               precision    recall  f1-score   support
#            0       0.79      0.95      0.86       113
#            1       0.78      0.70      0.74       119
#            2       0.81      0.84      0.82       137
#            3       0.19      0.90      0.31        29
#            4       0.59      0.91      0.71        87
#    micro avg       0.62      0.85      0.72       485
#    macro avg       0.63      0.86      0.69       485
# weighted avg       0.72      0.85      0.76       485
#  samples avg       0.62      0.62      0.62       485

# RMSE:  0.3128351860941102

# Na coleção
# Treinamento...
# Treinamento realizado em 122.504s.
# Predição...
# Calculando métricas...
# Precision: 0.8308270676691729
# Recall...: 0.6737804878048781
# F1-Score.: 0.744107744107744
# Accuracy.: 0.6737804878048781
#               precision    recall  f1-score   support
#            0       0.87      0.92      0.89       127
#            1       0.81      0.66      0.73       131
#            2       0.79      0.80      0.79       140
#            3       0.17      0.88      0.28        26
#            4       0.78      0.96      0.86       108
#    micro avg       0.67      0.83      0.74       532
#    macro avg       0.68      0.85      0.71       532
# weighted avg       0.78      0.83      0.79       532
#  samples avg       0.67      0.67      0.67       532
# RMSE:  0.3044387078366815

#####################
print ("svm_rbf_w2v_idf")
print ("Treinamento...")
t0 = time()
svm_rbf_w2v_idf.fit(X_train, Y_train)
print("Treinamento realizado em %0.3fs." % (time() - t0))

print ("Predição...")
predictions5 = svm_rbf_w2v_idf.predict(X_test)

print ("Calculando métricas...")
print ("Precision: %s" %precision_score(Y_test, predictions5, average="micro"))
print ("Recall...: %s" %recall_score(Y_test, predictions5, average="micro"))
print ("F1-Score.: %s" %f1_score(Y_test, predictions5, average="micro"))
print ("Accuracy.: %s" %accuracy_score(Y_test, predictions5))

print (classification_report(predictions5,Y_test))

# RMSE
from sklearn.metrics import mean_squared_error
from math import sqrt

# for i in range(0,769): print("Error in value number",i,(Y_test[i]-predictions2[i]))

rmse = sqrt(mean_squared_error(Y_test, predictions5))
print("RMSE: ",rmse)

# svm_rbf_w2v_idf
# Treinamento...
# Treinamento realizado em 194.366s.
# Predição...
# Calculando métricas...
# Precision: 0.8029978586723768
# Recall...: 0.5716463414634146
# F1-Score.: 0.667853962600178
# Accuracy.: 0.5655487804878049
#               precision    recall  f1-score   support
#            0       0.72      0.88      0.79       110
#            1       0.74      0.61      0.67       127
#            2       0.73      0.80      0.76       128
#            3       0.13      0.86      0.23        21
#            4       0.59      0.98      0.73        81
#    micro avg       0.57      0.80      0.67       467
#    macro avg       0.58      0.83      0.64       467
# weighted avg       0.68      0.80      0.72       467
#  samples avg       0.57      0.57      0.57       467

# RMSE:  0.3372232379227771

# Treinado na Coleção
# Treinamento...
# Treinamento realizado em 123.804s.
# Predição...
# Calculando métricas...
# Precision: 0.8258527827648114
# Recall...: 0.7012195121951219
# F1-Score.: 0.7584501236603463
# Accuracy.: 0.6951219512195121
#               precision    recall  f1-score   support
#            0       0.89      0.93      0.91       129
#            1       0.85      0.66      0.74       137
#            2       0.82      0.79      0.80       147
#            3       0.19      0.81      0.30        32
#            4       0.81      0.96      0.88       112
#    micro avg       0.70      0.83      0.76       557
#    macro avg       0.71      0.83      0.73       557
# weighted avg       0.80      0.83      0.80       557
#  samples avg       0.70      0.70      0.70       557
# RMSE:  0.2988800232412379

#####################
print ("svm_rbf_tfidf")
print ("Treinamento...")
t0 = time()
svm_rbf_tfidf.fit(X_train, Y_train)
print("Treinamento realizado em %0.3fs." % (time() - t0))

print ("Predição...")
predictions2 = svm_rbf_tfidf.predict(X_test)

print ("Calculando métricas...")
print ("Precision: %s" %precision_score(Y_test, predictions2, average="micro"))
print ("Recall...: %s" %recall_score(Y_test, predictions2, average="micro"))
print ("F1-Score.: %s" %f1_score(Y_test, predictions2, average="micro"))
print ("Accuracy.: %s" %accuracy_score(Y_test, predictions2))

print (classification_report(predictions2,Y_test))

# svm_rbf_tfidf
# Treinamento...
# Treinamento realizado em 241.811s.
# Predição...
# Calculando métricas...
# Precision: 0.8641975308641975
# Recall...: 0.10670731707317073
# F1-Score.: 0.18995929443690637
# Accuracy.: 0.10670731707317073
#               precision    recall  f1-score   support
#            0       0.09      1.00      0.16        12
#            1       0.26      0.74      0.39        38
#            2       0.00      0.00      0.00         0
#            3       0.00      0.00      0.00         0
#            4       0.22      0.97      0.36        31
#    micro avg       0.11      0.86      0.19        81
#    macro avg       0.12      0.54      0.18        81
# weighted avg       0.22      0.86      0.35        81
#  samples avg       0.11      0.11      0.11        81



############################         TESTE - 1 DIA         ############################
#######################################################################################
############################ TESTE COM OUTRAS FONTES (SRN) ############################
#######################################################################################

###################################################
print ("Importando as coleções de documentos...") #
###################################################

# Stemmed
X = pickle.load(open('data/g1_X_pp_new.ipy', 'rb'))
y = pickle.load(open('data/g1_y_pp_new.ipy', 'rb'))
z = pickle.load(open('data/g1_z_pp_new.ipy', 'rb'))

X, y, z = np.array(X), np.array(y), np.array(z)

print ("Z5NewsBrasil - Total de notícias curtas - Train: %s" % len(y))

# Test - Diversas fontes (agregador - UOL)
###################################################
# Stemmed
Xt = pickle.load(open('data/g1_X_test_pp_new_1d.ipy', 'rb'))
yt = pickle.load(open('data/g1_y_test_pp_new_1d.ipy', 'rb'))
zt = pickle.load(open('data/g1_z_test_pp_new_1d.ipy', 'rb'))

Xt, yt, zt = np.array(Xt), np.array(yt), np.array(zt)

print ("Z5NewsBrasil (Test 1d) - Total de notícias curtas: %s" % len(yt))

# Training and Testing Sets
#################################################################
#Z5 - BR
name_labels = ['esporteNews', 'politicaNews', 'tecnologiaNews', 'financaPessoal', 'educacaonews']
Y           = label_binarize(y,  classes=['esporteNews', 'politicaNews', 'tecnologiaNews', 'financaPessoal', 'educacaonews'])
Yt          = label_binarize(yt, classes=['esporteNews', 'politicaNews', 'tecnologiaNews', 'financaPessoal', 'educacaonews'])
n_classes = Y.shape[1]

X_train = X
Y_train = Y
Z_train = z

X_test  = Xt
Y_test  = Yt
Z_test  = zt

#####################
print ("Treinamento")
#####################

print ("rf_bow")
print ("Treinamento...")
t0 = time()
rf_bow.fit(X_train, Y_train)
print("Treinamento realizado em %0.3fs." % (time() - t0))

print ("Predição...")
predictions = rf_bow.predict(X_test)

print ("Calculando métricas...")
print ("Precision: %s" %precision_score(Y_test, predictions, average="micro"))
print ("Recall...: %s" %recall_score(Y_test, predictions, average="micro"))
print ("F1-Score.: %s" %f1_score(Y_test, predictions, average="micro"))
print ("Accuracy.: %s" %accuracy_score(Y_test, predictions))

print (classification_report(predictions,Y_test))

# RMSE
from sklearn.metrics import mean_squared_error
from math import sqrt

rmse = sqrt(mean_squared_error(Y_test, predictions))
print("RMSE: ",rmse)

# rf_bow
# Treinamento...
# Treinamento realizado em 9.779s.
# Predição...
# Calculando métricas...
# Precision: 0.756578947368421
# Recall...: 0.6084656084656085
# F1-Score.: 0.6744868035190615
# Accuracy.: 0.5608465608465608

#               precision    recall  f1-score   support
#            0       0.90      0.97      0.94        39
#            1       0.74      0.52      0.61        48
#            2       0.57      0.93      0.70        27
#            3       0.15      0.67      0.24         9
#            4       0.72      0.72      0.72        29
#    micro avg       0.61      0.76      0.67       152
#    macro avg       0.62      0.76      0.64       152
# weighted avg       0.71      0.76      0.71       152
#  samples avg       0.61      0.58      0.59       152

# RMSE:  0.34272484219898247

#####################
print ("svm_rbf_ft_idf")
print ("Treinamento 1d...")
t0 = time()
svm_rbf_ft_idf.fit(X_train, Y_train)
print("Treinamento realizado em %0.3fs." % (time() - t0))

print ("Predição...")
predictions4 = svm_rbf_ft_idf.predict(X_test)

print ("Calculando métricas...")
print ("Precision: %s" %precision_score(Y_test, predictions4, average="micro"))
print ("Recall...: %s" %recall_score(Y_test, predictions4, average="micro"))
print ("F1-Score.: %s" %f1_score(Y_test, predictions4, average="micro"))
print ("Accuracy.: %s" %accuracy_score(Y_test, predictions4))

print (classification_report(predictions4,Y_test))

# RMSE
from sklearn.metrics import mean_squared_error
from math import sqrt

rmse = sqrt(mean_squared_error(Y_test, predictions4))
print("RMSE: ",rmse)

# svm_rbf_ft_idf
# Treinamento 1d...
# Treinamento realizado em 269.499s.
# Predição...
# Calculando métricas...
# Precision: 0.8028169014084507
# Recall...: 0.6031746031746031
# F1-Score.: 0.6888217522658611
# Accuracy.: 0.5925925925925926
#               precision    recall  f1-score   support
#            0       0.79      0.97      0.87        34
#            1       0.74      0.60      0.66        42
#            2       0.64      0.85      0.73        33
#            3       0.12      0.62      0.21         8
#            4       0.79      0.92      0.85        25
#    micro avg       0.60      0.80      0.69       142
#    macro avg       0.62      0.79      0.66       142
# weighted avg       0.70      0.80      0.73       142
#  samples avg       0.60      0.60      0.60       142
# 
# RMSE:  0.33014346729067495

# Treinado na coleção
# Treinamento 1d...
# Treinamento realizado em 123.599s.
# Predição...
# Calculando métricas...
# Precision: 0.8125
# Recall...: 0.6878306878306878
# F1-Score.: 0.7449856733524355
# Accuracy.: 0.6825396825396826
#               precision    recall  f1-score   support
#            0       0.98      0.98      0.98        42
#            1       0.85      0.57      0.68        51
#            2       0.75      0.89      0.81        37
#            3       0.07      0.60      0.13         5
#            4       0.83      0.96      0.89        25
#    micro avg       0.69      0.81      0.74       160
#    macro avg       0.70      0.80      0.70       160
# weighted avg       0.83      0.81      0.81       160
#  samples avg       0.69      0.69      0.69       160
# RMSE:  0.3068874291656375

#####################
print ("svm_rbf_w2v_idf")
print ("Treinamento 1d...")
t0 = time()
svm_rbf_w2v_idf.fit(X_train, Y_train)
print("Treinamento realizado em %0.3fs." % (time() - t0))

print ("Predição...")
predictions5 = svm_rbf_w2v_idf.predict(X_test)

print ("Calculando métricas...")
print ("Precision: %s" %precision_score(Y_test, predictions5, average="micro"))
print ("Recall...: %s" %recall_score(Y_test, predictions5, average="micro"))
print ("F1-Score.: %s" %f1_score(Y_test, predictions5, average="micro"))
print ("Accuracy.: %s" %accuracy_score(Y_test, predictions5))

print (classification_report(predictions5,Y_test))

# RMSE
from sklearn.metrics import mean_squared_error
from math import sqrt

rmse = sqrt(mean_squared_error(Y_test, predictions5))
print("RMSE: ",rmse)

# svm_rbf_w2v_idf
# Treinamento 1d...
# Treinamento realizado em 225.224s.
# Predição...
# Calculando métricas...
# Precision: 0.7899159663865546
# Recall...: 0.4973544973544973
# F1-Score.: 0.6103896103896104
# Accuracy.: 0.49206349206349204
#               precision    recall  f1-score   support
#            0       0.64      0.96      0.77        28
#            1       0.68      0.61      0.64        38
#            2       0.50      0.76      0.60        29
#            3       0.05      0.67      0.09         3
#            4       0.69      0.95      0.80        21
#    micro avg       0.50      0.79      0.61       119
#    macro avg       0.51      0.79      0.58       119
# weighted avg       0.61      0.79      0.68       119
#  samples avg       0.50      0.49      0.50       119
# 
# RMSE:  0.3563483225498992

# Treinado na coleção
# Treinamento 1d...
# Treinamento realizado em 124.703s.
# Predição...
# Calculando métricas...
# Precision: 0.8
# Recall...: 0.6772486772486772
# F1-Score.: 0.7335243553008597
# Accuracy.: 0.6772486772486772
#               precision    recall  f1-score   support
#            0       0.98      0.98      0.98        42
#            1       0.85      0.56      0.67        52
#            2       0.70      0.91      0.79        34
#            3       0.07      0.50      0.13         6
#            4       0.83      0.92      0.87        26
#    micro avg       0.68      0.80      0.73       160
#    macro avg       0.69      0.77      0.69       160
# weighted avg       0.82      0.80      0.79       160
#  samples avg       0.68      0.68      0.68       160
# RMSE:  0.3137079827047734

#####################
print ("svm_rbf_bow")
print ("Treinamento 1d...")

t0 = time()
svm_rbf_bow.fit(X_train, Y_train)
print("Treinamento realizado em %0.3fs." % (time() - t0))

print ("Predição...")
predictions1 = svm_rbf_bow.predict(X_test)

print ("Calculando métricas...")
print ("Precision: %s" %precision_score(Y_test, predictions1, average="micro"))
print ("Recall...: %s" %recall_score(Y_test, predictions1, average="micro"))
print ("F1-Score.: %s" %f1_score(Y_test, predictions1, average="micro"))
print ("Accuracy.: %s" %accuracy_score(Y_test, predictions1))

print (classification_report(predictions1,Y_test))

# RMSE
from sklearn.metrics import mean_squared_error
from math import sqrt

rmse = sqrt(mean_squared_error(Y_test, predictions1))
print("RMSE: ",rmse)

# svm_rbf_bow
# Treinamento 1d...
# Treinamento realizado em 187.465s.
# Predição...
# Calculando métricas...
# Precision: 0.7697368421052632
# Recall...: 0.6190476190476191
# F1-Score.: 0.6862170087976539
# Accuracy.: 0.6031746031746031
#               precision    recall  f1-score   support
#            0       0.86      0.95      0.90        38
#            1       0.85      0.55      0.67        53
#            2       0.52      0.88      0.66        26
#            3       0.12      0.71      0.21         7
#            4       0.83      0.86      0.84        28
#    micro avg       0.62      0.77      0.69       152
#    macro avg       0.64      0.79      0.66       152
# weighted avg       0.76      0.77      0.73       152
#  samples avg       0.62      0.61      0.61       152

# RMSE:  0.336492961631463

#####################################################################

# Gráfico - Gráfico de curvas de calibração
# https://scikit-learn.org/stable/auto_examples/calibration/plot_calibration_curve.html#
# https://scikit-plot.readthedocs.io/en/stable/metrics.html
# pip install scikit-plot
import scikitplot as skplt

svm_rbf_bow_prob     = svm_rbf_bow.fit(X_train, Y_train).decision_function(X_test)
svm_rbf_tfidf_prob   = svm_rbf_tfidf.fit(X_train, Y_train).decision_function(X_test)
svm_rbf_w2v_prob     = svm_rbf_w2v.fit(X_train, Y_train).decision_function(X_test)
svm_rbf_w2v_idf_prob = svm_rbf_w2v_idf.fit(X_train, Y_train).decision_function(X_test)
svm_rbf_ft_prob      = svm_rbf_ft.fit(X_train, Y_train).decision_function(X_test)
svm_rbf_ft_idf_prob  = svm_rbf_ft_idf.fit(X_train, Y_train).decision_function(X_test)

#lr_probas = lr.fit(X_train, Y_train).predict_proba(X_test)

probas_list = [svm_rbf_bow_prob, svm_rbf_tfidf_prob, svm_rbf_w2v_prob, svm_rbf_w2v_idf_prob, svm_rbf_ft_prob, svm_rbf_ft_idf_prob]

clf_names = ['SVM BoW', 'SVM TFIDF', 'SVM W2V', 'SVM W2V E2V', 'SVM FT', 'SVM FT E2V']
skplt.metrics.plot_calibration_curve(Y_test, probas_list, clf_names)
plt.show()