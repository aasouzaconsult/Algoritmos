# Fonte e direitos: https://www.udemy.com/course/nlp-natural-language-processing-with-python

# Dataset sobre críticas de Filmes - Positivas ou Negativas

# # Text Classification Assessment
# This assessment is very much like the Text Classification Project we just completed, and the dataset is very similar.
# 
# The **moviereviews2.tsv** dataset contains the text of 6000 movie reviews. 3000 are positive, 3000 are negative, and the text has been preprocessed as a tab-delimited file. As before, labels are given as `pos` and `neg`. 
# 
# We've included 20 reviews that contain either `NaN` data, or have strings made up of whitespace.
# 
# For more information on this dataset visit http://ai.stanford.edu/~amaas/data/sentiment/

# ### Task #1: Perform imports and load the dataset into a pandas DataFrame
# For this exercise you can load the dataset from `'../TextFiles/moviereviews2.tsv'`.

import numpy as np
import pandas as pd

df = pd.read_csv('moviereviews2.tsv', sep='\t')
df.head()
  
#  label                                             review
#0   pos  I loved this movie and will watch it again. Or...
#1   pos  A warm, touching movie that has a fantasy-like...
#2   pos  I was not expecting the powerful filmmaking ex...
#3   neg  This so-called "documentary" tries to tell tha...
#4   pos  This show has been my escape from reality for ...

# ### Task #2: Check for missing values:
# Check for NaN values:
df.isnull().sum()

# Check for whitespace strings (it's OK if there aren't any!):
blanks = []  # start with an empty list

for i,lb,rv in df.itertuples():  # iterate over the DataFrame
    if type(rv)==str:            # avoid NaN values
        if rv.isspace():         # test 'review' for whitespace
            blanks.append(i)     # add matching index numbers to the list
        
len(blanks)

# ### Task #3:  Remove NaN values:
df.dropna(inplace=True)

# ### Task #4: Take a quick look at the `label` column:
df['label'].value_counts()
#neg    2990
#pos    2990
#Name: label, dtype: int64

# ### Task #5: Split the data into train & test sets:
# You may use whatever settings you like. To compare your results to the solution notebook, use `test_size=0.33, random_state=42`

from sklearn.model_selection import train_test_split

X = df['review']
y = df['label']

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.33, random_state=42)

# ### Task #6: Build a pipeline to vectorize the date, then train and fit a model
# You may use whatever model you like. To compare your results to the solution notebook, use `LinearSVC`.

from sklearn.pipeline import Pipeline
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.svm import LinearSVC

text_clf = Pipeline([('tfidf', TfidfVectorizer()),
                     ('clf', LinearSVC()),
])

# Feed the training data through the pipeline
text_clf.fit(X_train, y_train)  

#Pipeline(memory=None,
#         steps=[('tfidf',
#                 TfidfVectorizer(analyzer='word', binary=False,
#                                 decode_error='strict',
#                                 dtype=<class 'numpy.float64'>,
#                                 encoding='utf-8', input='content',
#                                 lowercase=True, max_df=1.0, max_features=None,
#                                 min_df=1, ngram_range=(1, 1), norm='l2',
#                                 preprocessor=None, smooth_idf=True,
#                                 stop_words=None, strip_accents=None,
#                                 sublinear_tf=False,
#                                 token_pattern='(?u)\\b\\w\\w+\\b',
#                                 tokenizer=None, use_idf=True,
#                                 vocabulary=None)),
#                ('clf',
#                 LinearSVC(C=1.0, class_weight=None, dual=True,
#                           fit_intercept=True, intercept_scaling=1,
#                           loss='squared_hinge', max_iter=1000,
#                           multi_class='ovr', penalty='l2', random_state=None,
#                           tol=0.0001, verbose=0))],
#         verbose=False)

# ### Task #7: Run predictions and analyze the results

# Form a prediction set
predictions = text_clf.predict(X_test)
# array(['neg', 'pos', 'pos', ..., 'pos', 'pos', 'pos'], dtype=object)

# Report the confusion matrix
from sklearn import metrics
print(metrics.confusion_matrix(y_test,predictions))
#[[900  91]
# [ 63 920]]

# Print a classification report
print(metrics.classification_report(y_test,predictions))

#              precision    recall  f1-score   support
#         neg       0.93      0.91      0.92       991
#         pos       0.91      0.94      0.92       983
#    accuracy                           0.92      1974
#   macro avg       0.92      0.92      0.92      1974
#weighted avg       0.92      0.92      0.92      1974

# Print the overall accuracy
print(metrics.accuracy_score(y_test,predictions))
#0.9219858156028369