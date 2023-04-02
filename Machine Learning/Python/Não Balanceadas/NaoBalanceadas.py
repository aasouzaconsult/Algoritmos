##################################
## Pima Indians Diabetes (Pima) ##
##################################
# Cada registro descreve os detalhes médicos de mulher e a previsão é o aparecimento de diabetes nos próximos cinco anos.

# Abaixo, fornece uma amostra das cinco primeiras linhas do conjunto de dados.
#6,148,72,35,0,33.6,0.627,50,1
#1,85,66,29,0,26.6,0.351,31,0
#8,183,64,0,0,23.3,0.672,32,1
#1,89,66,23,94,28.1,0.167,21,0
#0,137,40,35,168,43.1,2.288,33,1
#...

#O exemplo abaixo carrega e resume a discriminação de classe do conjunto de dados.

# Summarize the Pima Indians Diabetes dataset
from numpy import unique
from pandas import read_csv
# load the dataset
url = 'https://raw.githubusercontent.com/jbrownlee/Datasets/master/pima-indians-diabetes.csv'
dataframe = read_csv(url, header=None)
# get the values
values = dataframe.values
X, y = values[:, :-1], values[:, -1]
# gather details
n_rows = X.shape[0]
n_cols = X.shape[1]
classes = unique(y)
n_classes = len(classes)
# summarize
print('N Examples: %d' % n_rows)
print('N Inputs: %d' % n_cols)
print('N Classes: %d' % n_classes)
print('Classes: %s' % classes)
print('Class Breakdown:')
# class breakdown
breakdown = ''
for c in classes:
	total = len(y[y == c])
	ratio = (total / float(len(y))) * 100
	print(' - Class %s: %d (%.5f%%)' % (str(c), total, ratio))

##A execução do exemplo fornece a seguinte saída.
#N Examples: 768
#N Inputs: 8
#N Classes: 2
#Classes: [0. 1.]
#Class Breakdown:
# - Class 0.0: 500 (65.10417%)
# - Class 1.0: 268 (34.89583%)

###########################################
## Câncer de mama em Haberman (Haberman) ##
###########################################
# Cada registro descreve os detalhes médicos de um paciente e a previsão é se o paciente sobreviveu após cinco anos ou não.

# Abaixo, fornece uma amostra das cinco primeiras linhas do conjunto de dados.
#30,64,1,1
#30,62,3,1
#30,65,0,1
#31,59,2,1
#31,65,4,1
#...

## O exemplo abaixo carrega e resume a discriminação de classe do conjunto de dados.
# Summarize the Haberman Breast Cancer dataset
from numpy import unique
from pandas import read_csv
# load the dataset
url = 'https://raw.githubusercontent.com/jbrownlee/Datasets/master/haberman.csv'
dataframe = read_csv(url, header=None)
# get the values
values = dataframe.values
X, y = values[:, :-1], values[:, -1]
# gather details
n_rows = X.shape[0]
n_cols = X.shape[1]
classes = unique(y)
n_classes = len(classes)
# summarize
print('N Examples: %d' % n_rows)
print('N Inputs: %d' % n_cols)
print('N Classes: %d' % n_classes)
print('Classes: %s' % classes)
print('Class Breakdown:')
# class breakdown
breakdown = ''
for c in classes:
	total = len(y[y == c])
	ratio = (total / float(len(y))) * 100
	print(' - Class %s: %d (%.5f%%)' % (str(c), total, ratio))

#N Examples: 306
#N Inputs: 3
#N Classes: 2
#Classes: [1 2]
#Class Breakdown:
# - Class 1: 225 (73.52941%)
# - Class 2: 81 (26.47059%)

######################################################
## Crédito alemão (alemão) - German Credit (German) ##
######################################################
# Cada registro descreve os detalhes financeiros de uma pessoa e a previsão é se ela é um bom risco de crédito.

#Abaixo, fornece uma amostra das cinco primeiras linhas do conjunto de dados.

#A11,6,A34,A43,1169,A65,A75,4,A93,A101,4,A121,67,A143,A152,2,A173,1,A192,A201,1
#A12,48,A32,A43,5951,A61,A73,2,A92,A101,2,A121,22,A143,A152,1,A173,1,A191,A201,2
#A14,12,A34,A46,2096,A61,A74,2,A93,A101,3,A121,49,A143,A152,1,A172,2,A191,A201,1
#A11,42,A32,A42,7882,A61,A74,2,A93,A103,4,A122,45,A143,A153,1,A173,2,A191,A201,1
#A11,24,A33,A40,4870,A61,A73,3,A93,A101,4,A124,53,A143,A153,2,A173,2,A191,A201,2
#...

#O exemplo abaixo carrega e resume a discriminação de classe do conjunto de dados.
# Summarize the German Credit dataset
from numpy import unique
from pandas import read_csv
# load the dataset
url = 'https://raw.githubusercontent.com/jbrownlee/Datasets/master/german.csv'
dataframe = read_csv(url, header=None)
# get the values
values = dataframe.values
X, y = values[:, :-1], values[:, -1]
# gather details
n_rows = X.shape[0]
n_cols = X.shape[1]
classes = unique(y)
n_classes = len(classes)
# summarize
print('N Examples: %d' % n_rows)
print('N Inputs: %d' % n_cols)
print('N Classes: %d' % n_classes)
print('Classes: %s' % classes)
print('Class Breakdown:')
# class breakdown
breakdown = ''
for c in classes:
	total = len(y[y == c])
	ratio = (total / float(len(y))) * 100
	print(' - Class %s: %d (%.5f%%)' % (str(c), total, ratio))

#N Examples: 1000
#N Inputs: 20
#N Classes: 2
#Classes: [1 2]
#Class Breakdown:
# - Class 1: 700 (70.00000%)
# - Class 2: 300 (30.00000%)

#Conjuntos de dados de classificação multiclasse
# Multiclass Classification Datasets
#Problemas de modelagem preditiva de classificação multiclasse são aqueles com mais de duas classes.

#Normalmente, problemas desequilibrados de classificação multiclasse descrevem vários eventos diferentes, alguns significativamente mais comuns que outros.

#Nesta seção, examinaremos mais de perto três conjuntos de dados de aprendizado de máquina de classificação multiclasse padrão com um desequilíbrio de classe. Esses são conjuntos de dados pequenos o suficiente para caber na memória e foram bem estudados, fornecendo a base da investigação em muitos trabalhos de pesquisa.

#Os nomes desses conjuntos de dados são os seguintes:
#- Identificação de vidro (Vidro)
#- E-coli (Ecoli)
#- Glândula Tireóide (Tireóide)

#Nota : é comum em trabalhos de pesquisa transformar problemas desequilibrados de classificação multiclasse em problemas desequilibrados de classificação binária, agrupando todas as classes majoritárias em uma classe e deixando a menor classe minoritária.

#Cada conjunto de dados será carregado e a natureza do desequilíbrio da classe será resumida.

###################################################################
## Identificação de vidro (Vidro) - Glass Identification (Glass) ##
###################################################################

#Cada registro descreve o conteúdo químico do vidro e a previsão envolve o tipo de vidro.

#Abaixo, fornece uma amostra das cinco primeiras linhas do conjunto de dados.

#1.52101,13.64,4.49,1.10,71.78,0.06,8.75,0.00,0.00,1
#1.51761,13.89,3.60,1.36,72.73,0.48,7.83,0.00,0.00,1
#1.51618,13.53,3.55,1.54,72.99,0.39,7.78,0.00,0.00,1
#1.51766,13.21,3.69,1.29,72.61,0.57,8.22,0.00,0.00,1
#1.51742,13.27,3.62,1.24,73.08,0.55,8.07,0.00,0.00,1
#...

#A primeira coluna representa um identificador de linha e pode ser removida.
#O exemplo abaixo carrega e resume a discriminação de classe do conjunto de dados.

# Summarize the Glass Identification dataset
from numpy import unique
from pandas import read_csv
# load the dataset
url = 'https://raw.githubusercontent.com/jbrownlee/Datasets/master/glass.csv'
dataframe = read_csv(url, header=None)
# get the values
values = dataframe.values
X, y = values[:, :-1], values[:, -1]
# gather details
n_rows = X.shape[0]
n_cols = X.shape[1]
classes = unique(y)
n_classes = len(classes)
# summarize
print('N Examples: %d' % n_rows)
print('N Inputs: %d' % n_cols)
print('N Classes: %d' % n_classes)
print('Classes: %s' % classes)
print('Class Breakdown:')
# class breakdown
breakdown = ''
for c in classes:
	total = len(y[y == c])
	ratio = (total / float(len(y))) * 100
	print(' - Class %s: %d (%.5f%%)' % (str(c), total, ratio))

#N Examples: 214
#N Inputs: 9
#N Classes: 6
#Classes: [1. 2. 3. 5. 6. 7.]
#Class Breakdown:
#- Class 1.0: 70 (32.71028%)
#- Class 2.0: 76 (35.51402%)
#- Class 3.0: 17 (7.94393%)
#- Class 5.0: 13 (6.07477%)
#- Class 6.0: 9 (4.20561%)
#- Class 7.0: 29 (13.55140%)

####################
## E-coli (Ecoli) ##
####################
#Cada registro descreve o resultado de diferentes testes e a previsão envolve o nome do site de localização da proteína.

#Abaixo, fornece uma amostra das cinco primeiras linhas do conjunto de dados.

#0.49,0.29,0.48,0.50,0.56,0.24,0.35,cp
#0.07,0.40,0.48,0.50,0.54,0.35,0.44,cp
#0.56,0.40,0.48,0.50,0.49,0.37,0.46,cp
#0.59,0.49,0.48,0.50,0.52,0.45,0.36,cp
#0.23,0.32,0.48,0.50,0.55,0.25,0.35,cp
#...

#A primeira coluna representa um identificador de linha ou nome e pode ser removida.
#O exemplo abaixo carrega e resume a discriminação de classe do conjunto de dados.

# Summarize the Ecoli dataset
from numpy import unique
from pandas import read_csv
# load the dataset
url = 'https://raw.githubusercontent.com/jbrownlee/Datasets/master/ecoli.csv'
dataframe = read_csv(url, header=None)
# get the values
values = dataframe.values
X, y = values[:, :-1], values[:, -1]
# gather details
n_rows = X.shape[0]
n_cols = X.shape[1]
classes = unique(y)
n_classes = len(classes)
# summarize
print('N Examples: %d' % n_rows)
print('N Inputs: %d' % n_cols)
print('N Classes: %d' % n_classes)
print('Classes: %s' % classes)
print('Class Breakdown:')
# class breakdown
breakdown = ''
for c in classes:
	total = len(y[y == c])
	ratio = (total / float(len(y))) * 100
	print(' - Class %s: %d (%.5f%%)' % (str(c), total, ratio))

#N Examples: 336
#N Inputs: 7
#N Classes: 8
#Classes: ['cp' 'im' 'imL' 'imS' 'imU' 'om' 'omL' 'pp']
#Class Breakdown:
# - Class cp: 143 (42.55952%)
# - Class im: 77 (22.91667%)
# - Class imL: 2 (0.59524%)
# - Class imS: 2 (0.59524%)
# - Class imU: 35 (10.41667%)
# - Class om: 20 (5.95238%)
# - Class omL: 5 (1.48810%)
# - Class pp: 52 (15.47619%)

############################################################
## Glândula Tireóide (Tireóide) - Thyroid Gland (Thyroid) ##
############################################################
#Cada registro descreve o resultado de diferentes testes em uma tireóide e a previsão envolve o diagnóstico médico da tireóide.

#Abaixo, fornece uma amostra das cinco primeiras linhas do conjunto de dados.
#107,10.1,2.2,0.9,2.7,1
#113,9.9,3.1,2.0,5.9,1
#127,12.9,2.4,1.4,0.6,1
#109,5.3,1.6,1.4,1.5,1
#105,7.3,1.5,1.5,-0.1,1
#...

#O exemplo abaixo carrega e resume a discriminação de classe do conjunto de dados.
# Summarize the Thyroid Gland dataset
from numpy import unique
from pandas import read_csv
# load the dataset
url = 'https://raw.githubusercontent.com/jbrownlee/Datasets/master/new-thyroid.csv'
dataframe = read_csv(url, header=None)
# get the values
values = dataframe.values
X, y = values[:, :-1], values[:, -1]
# gather details
n_rows = X.shape[0]
n_cols = X.shape[1]
classes = unique(y)
n_classes = len(classes)
# summarize
print('N Examples: %d' % n_rows)
print('N Inputs: %d' % n_cols)
print('N Classes: %d' % n_classes)
print('Classes: %s' % classes)
print('Class Breakdown:')
# class breakdown
breakdown = ''
for c in classes:
	total = len(y[y == c])
	ratio = (total / float(len(y))) * 100
	print(' - Class %s: %d (%.5f%%)' % (str(c), total, ratio))

#N Examples: 215
#N Inputs: 5
#N Classes: 3
#Classes: [1. 2. 3.]
#Class Breakdown:
# - Class 1.0: 150 (69.76744%)
# - Class 2.0: 35 (16.27907%)
# - Class 3.0: 30 (13.95349%)
 
############################################
## Competição e outros conjuntos de dados ##
############################################
#Esta seção lista conjuntos de dados adicionais usados ​​em trabalhos de pesquisa que são menos usados, maiores ou conjuntos de dados usados ​​como base de competições de aprendizado de máquina.

#Os nomes desses conjuntos de dados são os seguintes:
#- Fraude no cartão de crédito (crédito) # Credit Card Fraud (Credit)
#- Porto Seguro Auto Insurance Claim (Porto Seguro) #Porto Seguro Auto Insurance Claim (Porto Seguro)

#Cada conjunto de dados será carregado e a natureza do desequilíbrio da classe será resumida.

###########################################
## Fraude no cartão de crédito (crédito) ##
###########################################
#Cada registro descreve uma tradução de cartão de crédito e é classificada como fraude.
#Esses dados são cerca de 144 megabytes não compactados ou 66 megabytes compactados.
#Download (https://www.kaggle.com/mlg-ulb/creditcardfraud)

#Abaixo, fornece uma amostra das cinco primeiras linhas do conjunto de dados.

#"Time","V1","V2","V3","V4","V5","V6","V7","V8","V9","V10","V11","V12","V13","V14","V15","V16","V17","V18","V19","V20","V21","V22","V23","V24","V25","V26","V27","V28","Amount","Class"
#0,-1.3598071336738,-0.0727811733098497,2.53634673796914,1.37815522427443,-0.338320769942518,0.462387777762292,0.239598554061257,0.0986979012610507,0.363786969611213,0.0907941719789316,-0.551599533260813,-0.617800855762348,-0.991389847235408,-0.311169353699879,1.46817697209427,-0.470400525259478,0.207971241929242,0.0257905801985591,0.403992960255733,0.251412098239705,-0.018306777944153,0.277837575558899,-0.110473910188767,0.0669280749146731,0.128539358273528,-0.189114843888824,0.133558376740387,-0.0210530534538215,149.62,"0"
#0,1.19185711131486,0.26615071205963,0.16648011335321,0.448154078460911,0.0600176492822243,-0.0823608088155687,-0.0788029833323113,0.0851016549148104,-0.255425128109186,-0.166974414004614,1.61272666105479,1.06523531137287,0.48909501589608,-0.143772296441519,0.635558093258208,0.463917041022171,-0.114804663102346,-0.183361270123994,-0.145783041325259,-0.0690831352230203,-0.225775248033138,-0.638671952771851,0.101288021253234,-0.339846475529127,0.167170404418143,0.125894532368176,-0.00898309914322813,0.0147241691924927,2.69,"0"
#1,-1.35835406159823,-1.34016307473609,1.77320934263119,0.379779593034328,-0.503198133318193,1.80049938079263,0.791460956450422,0.247675786588991,-1.51465432260583,0.207642865216696,0.624501459424895,0.066083685268831,0.717292731410831,-0.165945922763554,2.34586494901581,-2.89008319444231,1.10996937869599,-0.121359313195888,-2.26185709530414,0.524979725224404,0.247998153469754,0.771679401917229,0.909412262347719,-0.689280956490685,-0.327641833735251,-0.139096571514147,-0.0553527940384261,-0.0597518405929204,378.66,"0"
#1,-0.966271711572087,-0.185226008082898,1.79299333957872,-0.863291275036453,-0.0103088796030823,1.24720316752486,0.23760893977178,0.377435874652262,-1.38702406270197,-0.0549519224713749,-0.226487263835401,0.178228225877303,0.507756869957169,-0.28792374549456,-0.631418117709045,-1.0596472454325,-0.684092786345479,1.96577500349538,-1.2326219700892,-0.208037781160366,-0.108300452035545,0.00527359678253453,-0.190320518742841,-1.17557533186321,0.647376034602038,-0.221928844458407,0.0627228487293033,0.0614576285006353,123.5,"0"
#...

#O exemplo abaixo carrega e resume a discriminação de classe do conjunto de dados.
# Summarize the Credit Card Fraud dataset
from numpy import unique
from pandas import read_csv
# load the dataset
dataframe = read_csv('creditcard.csv')
# get the values
values = dataframe.values
X, y = values[:, :-1], values[:, -1]
# gather details
n_rows = X.shape[0]
n_cols = X.shape[1]
classes = unique(y)
n_classes = len(classes)
# summarize
print('N Examples: %d' % n_rows)
print('N Inputs: %d' % n_cols)
print('N Classes: %d' % n_classes)
print('Classes: %s' % classes)
print('Class Breakdown:')
# class breakdown
breakdown = ''
for c in classes:
	total = len(y[y == c])
	ratio = (total / float(len(y))) * 100
	print(' - Class %s: %d (%.5f%%)' % (str(c), total, ratio))

#N Examples: 284807
#N Inputs: 30
#N Classes: 2
#Classes: [0. 1.]
#Class Breakdown:
# - Class 0.0: 284315 (99.82725%)
# - Class 1.0: 492 (0.17275%)

######################################################
## Porto Seguro Auto Insurance Claim (Porto Seguro) ##
######################################################
# Cada registro descreve os detalhes do seguro de carro e a previsão envolve se a pessoa fará ou não uma reivindicação de seguro.

#Esses dados são cerca de 42 megabytes compactados.
#- Download e informações adicionais (https://www.kaggle.com/c/porto-seguro-safe-driver-prediction/data)
#Faça o download do conjunto de dados e descompacte-o no diretório de trabalho atual.

#Abaixo, fornece uma amostra das cinco primeiras linhas do conjunto de dados.

#id,target,ps_ind_01,ps_ind_02_cat,ps_ind_03,ps_ind_04_cat,ps_ind_05_cat,ps_ind_06_bin,ps_ind_07_bin,ps_ind_08_bin,ps_ind_09_bin,ps_ind_10_bin,ps_ind_11_bin,ps_ind_12_bin,ps_ind_13_bin,ps_ind_14,ps_ind_15,ps_ind_16_bin,ps_ind_17_bin,ps_ind_18_bin,ps_reg_01,ps_reg_02,ps_reg_03,ps_car_01_cat,ps_car_02_cat,ps_car_03_cat,ps_car_04_cat,ps_car_05_cat,ps_car_06_cat,ps_car_07_cat,ps_car_08_cat,ps_car_09_cat,ps_car_10_cat,ps_car_11_cat,ps_car_11,ps_car_12,ps_car_13,ps_car_14,ps_car_15,ps_calc_01,ps_calc_02,ps_calc_03,ps_calc_04,ps_calc_05,ps_calc_06,ps_calc_07,ps_calc_08,ps_calc_09,ps_calc_10,ps_calc_11,ps_calc_12,ps_calc_13,ps_calc_14,ps_calc_15_bin,ps_calc_16_bin,ps_calc_17_bin,ps_calc_18_bin,ps_calc_19_bin,ps_calc_20_bin
#7,0,2,2,5,1,0,0,1,0,0,0,0,0,0,0,11,0,1,0,0.7,0.2,0.7180703307999999,10,1,-1,0,1,4,1,0,0,1,12,2,0.4,0.8836789178,0.3708099244,3.6055512755000003,0.6,0.5,0.2,3,1,10,1,10,1,5,9,1,5,8,0,1,1,0,0,1
#9,0,1,1,7,0,0,0,0,1,0,0,0,0,0,0,3,0,0,1,0.8,0.4,0.7660776723,11,1,-1,0,-1,11,1,1,2,1,19,3,0.316227766,0.6188165191,0.3887158345,2.4494897428,0.3,0.1,0.3,2,1,9,5,8,1,7,3,1,1,9,0,1,1,0,1,0
#13,0,5,4,9,1,0,0,0,1,0,0,0,0,0,0,12,1,0,0,0.0,0.0,-1.0,7,1,-1,0,-1,14,1,1,2,1,60,1,0.316227766,0.6415857163,0.34727510710000004,3.3166247904,0.5,0.7,0.1,2,2,9,1,8,2,7,4,2,7,7,0,1,1,0,1,0
#16,0,0,1,2,0,0,1,0,0,0,0,0,0,0,0,8,1,0,0,0.9,0.2,0.5809475019,7,1,0,0,1,11,1,1,3,1,104,1,0.3741657387,0.5429487899000001,0.2949576241,2.0,0.6,0.9,0.1,2,4,7,1,8,4,2,2,2,4,9,0,0,0,0,0,0
#...

#O exemplo abaixo carrega e resume a discriminação de classe do conjunto de dados.
# Summarize the Porto Seguro’s Safe Driver Prediction dataset
from numpy import unique
from pandas import read_csv
# load the dataset
dataframe = read_csv('train.csv')
# get the values
values = dataframe.values
X, y = values[:, :-1], values[:, -1]
# gather details
n_rows = X.shape[0]
n_cols = X.shape[1]
classes = unique(y)
n_classes = len(classes)
# summarize
print('N Examples: %d' % n_rows)
print('N Inputs: %d' % n_cols)
print('N Classes: %d' % n_classes)
print('Classes: %s' % classes)
print('Class Breakdown:')
# class breakdown
breakdown = ''
for c in classes:
	total = len(y[y == c])
	ratio = (total / float(len(y))) * 100
	print(' - Class %s: %d (%.5f%%)' % (str(c), total, ratio))

#N Examples: 595212
#N Inputs: 58
#N Classes: 2
#Classes: [0. 1.]
#Class Breakdown:
# - Class 0.0: 503955 (84.66815%)
# - Class 1.0: 91257 (15.33185%)