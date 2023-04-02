# Fonte e direitos: https://www.udemy.com/course/nlp-natural-language-processing-with-python

# Estudo de Classificação de SPAM

# Perform imports and load the dataset:
import numpy as np
import pandas as pd

df = pd.read_csv('../TextFiles/smsspamcollection.tsv', sep='\t')
df.head()

# ## Check for missing values: (verifica se tem algum valor nulo)
# Always a good practice.
df.isnull().sum()

# ## Take a quick look at the *ham* and *spam* `label` column:
df['label'].value_counts()

# 4825 out of 5572 messages, or 86.6%, are ham. This means that any text classification model we create has to perform **better than 86.6%** to beat random chance.

# ## Split the data into train & test sets:

from sklearn.model_selection import train_test_split

X = df['message']  # this time we want to look at the text
y = df['label']

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.33, random_state=42)

# ## Build a Pipeline com TF-IDF e Classificador SVM
# Remember that only our training set has been vectorized into a full vocabulary. In order to perform an analysis on our test set we'll have to submit it to the same procedures. Fortunately scikit-learn offers a [**Pipeline**](https://scikit-learn.org/stable/modules/generated/sklearn.pipeline.Pipeline.html) class that behaves like a compound classifier.

from sklearn.pipeline import Pipeline
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.svm import LinearSVC

text_clf = Pipeline([('tfidf', TfidfVectorizer()),
                     ('clf', LinearSVC()),
])

# Feed the training data through the pipeline
text_clf.fit(X_train, y_train)

# ## Test the classifier and display results
# Form a prediction set
predictions = text_clf.predict(X_test)

# Report the confusion matrix
from sklearn import metrics
print(metrics.confusion_matrix(y_test,predictions))

# Print a classification report
print(metrics.classification_report(y_test,predictions))

#               precision    recall  f1-score   support
#          ham       0.99      1.00      0.99      1593
#         spam       0.97      0.95      0.96       246
#     accuracy                           0.99      1839
#    macro avg       0.98      0.97      0.98      1839
# weighted avg       0.99      0.99      0.99      1839

# Print the overall accuracy
print(metrics.accuracy_score(y_test,predictions))
# 0.989668297988037

# Using the text of the messages, our model performed exceedingly well; it correctly predicted spam **98.97%** of the time!