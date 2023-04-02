#########################################
# Regressão Linear (Simples e Múltipla) #
#########################################

# Importando os dados
# http://www.learnbymarketing.com/wp-content/uploads/2014/12/data-marketing-budget-12mo.csv
dataset = read.csv("Data/data-marketing-budget-12mo.csv", header=T, colClasses = c("numeric", "numeric", "numeric"))

# Vendo uma pequena amostra
head(dataset,5)

#### Regressao Simples ####
# Variavel dependente (prever): Sales
# Variavel independente: Spend (gastar)
# data - Fonte de dados
simple.fit = lm(Sales~Spend,data=dataset)
summary(simple.fit)

#### Regressao Multipla ####
# Variavel dependente (prever): Sales
# Variavel independente: Spend (gastar) + Month(Mês)
# data - Fonte de dados
multi.fit = lm(Sales~Spend+Month, data=dataset)
summary(multi.fit)

#-----------------------------------------
# Exemplo de Resultado - Regressão Simples
#-----------------------------------------
#Call:
#lm(formula = Sales ~ Spend, data = dataset)

#Residuals:
#  Min     1Q Median     3Q    Max 
#-3385  -2097    258   1726   3034 

#Coefficients:
#            Estimate Std. Error  t value Pr(>|t|)    
#(Intercept) 1383.4714  1255.2404   1.102    0.296    
#Spend         10.6222     0.1625  65.378 1.71e-14 ***
#---
#Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1

#Residual standard error: 2313 on 10 degrees of freedom
#Multiple R-squared:  0.9977,	Adjusted R-squared:  0.9974 
#F-statistic:  4274 on 1 and 10 DF,  p-value: 1.707e-14
#------------------------------------------------------

#################################
# Explicão Geral dos Resultados #
#################################
# Resíduos(Residuals): A secção resume os resíduos, o erro entre a predição do modelo e os resultados reais. Resíduos menores são melhores.
# Coeficientes (Coefficients): Para cada variável e a intercepção, um peso é produzido e que o peso tem outros atributos como o erro padrão, 
#um valor t-teste e a significância.
# - Estimate : Este é o peso dado à variável. No caso de regressão simples (uma variável mais a interceptação), para cada aumento de um dólar 
#em Gastar(Spend), o modelo prevê um aumento de US $10,6222.
# - Std. Error : Diz-lhe como precisamente foi medida a estimativa. É realmente útil apenas para o cálculo do t-values (valor t).
# - t-value e Pr(> [t]) : O t-value é calculado tomando o coeficiente (Estimate) dividido pelo Std. Error. 
# Em seguida, é utilizado para testar se ou não o coeficiente é significativamente diferente de zero. Se não for significativa, então 
#o coeficiente é realmente não acrescentar nada ao modelo e poderia ser derrubado ou investigada. 
# Pr(>|t|) é o nível de significância.

#As medidas de desempenho : Três conjuntos de medições são fornecidos.
#1. Residual Standard Error(Residual Erro Padrão): Este é o desvio padrão dos resíduos. Menor é melhor.

#2. Multiple / Adjusted R-Square(Multiple / Ajustado R-Quadrado) : Para uma variável, a distinção não importa realmente. 
#-- R-Square - mostra a quantidade de variância explicada pelo modelo. 
#-- Adjusted R-Square - leva em conta o número de variáveis e é mais útil para a regressão múltipla.

#3. F-Statistic : O F-test verifica se pelo menos um peso de variável é significativamente diferente de zero. Este é um teste global 
#para ajudar a avaliar um modelo. Se o p-value não for significante (por exemplo, superior a 0,05) do que o seu modelo, essencialmente, 
#não está fazendo nada.

#######################################
# Explicacão detalhada dos Resultados #
#######################################

# Regressão Simples
#------------------

#Call:
#lm(formula = Sales ~ Spend, data = dataset)

#Residuals:
#  Min     1Q Median     3Q    Max 
#-3385  -2097    258   1726   3034 
#Resíduos : Podemos ver que o modelo de regressão múltipla tem um alcance menor para os resíduos: -3385 a 3034 vs. -1793 a 1911. 
#Em segundo lugar a mediana da regressão múltipla é muito mais próximo de 0 do que o modelo de regressão simples.

#Coefficients:
#            Estimate Std. Error  t value Pr(>|t|)    
#(Intercept) 1383.4714  1255.2404   1.102    0.296    
#Spend         10.6222     0.1625  65.378 1.71e-14 ***
#---
#Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1

#Residual standard error: 2313 on 10 degrees of freedom
#Multiple R-squared:  0.9977,	Adjusted R-squared:  0.9974 
#F-statistic:  4274 on 1 and 10 DF,  p-value: 1.707e-14
#----------------------------------------------------------------

# Regressão Multipla
#-------------------
#Call:
#lm(formula = Sales ~ Spend + Month, data = dataset)

#Residuals:
#  Min          1Q   Median       3Q      Max 
#-1793.73 -1558.33    -1.73  1374.19  1911.58 

#Coefficients:
#             Estimate  Std. Error  t value Pr(>|t|)    
#(Intercept) -567.6098  1041.8836  -0.545   0.59913    
#Spend         10.3825     0.1328  78.159   4.65e-14 ***
#Month        541.3736   158.1660   3.423   0.00759 ** 
#---
#Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1

#Residual standard error: 1607 on 9 degrees of freedom
#Multiple R-squared:  0.999,	Adjusted R-squared:  0.9988 
#F-statistic:  4433 on 2 and 9 DF,  p-value: 3.368e-14
#----------------------------------------------------------------

# (Intercept) : A intercepção é a esquerda sobre quando você calcular a média da variável independente e dependente. Na análise de 
#regressão simples, vemos que a interceptação é significado muito maior do que há uma boa quantidade de sobra. Regressão múltipla mostra 
#uma interceptação negativo, mas é mais próximo de zero do que a saída de regressão simples.
# Spend: regressão simples e múltipla mostra que para cada dólar que você gasta, você deve esperar para receber cerca de 10 dólares em vendas.
# Mês: Quando acrescentamos na variável mês é multiplicar este vezes variáveis o valor numérico (ordinal) do mês. Assim, para cada mês você 
#está no ano, você adicionar um 541 adicionais em vendas. Assim fevereiro acrescenta $1.082, enquanto de Dezembro, introduz $6,492 na venda.
  
#Medidas de desempenho :
#- Residual Standard Error (Residual Erro Padrão): O modelo de regressão simples tem um erro de padrão muito mais elevado, ou seja, os resíduos 
#têm uma maior variância. Um erro padrão 2.313 é bastante elevado considerando a média de vendas é de $70.870.
#- Multiple / Adjusted R-Square (Multiple / Ajustado R-Quadrado) : O R-quadrado é muito elevado em ambos os casos. O Adjusted R-square leva 
#em conta o número de variáveis e por isso é mais útil para a análise de regressão múltipla.
#- F-Statistic(F-Estatística) : A F-test é estatisticamente significativa. Isto significa que ambos os modelos têm, pelo menos, uma variável 
#que é significativamente diferente de zero.

  
#############################################
# Analisando resíduos (Analyzing Residuals) #
#############################################
#Qualquer um pode ajustar um modelo linear em R. O verdadeiro teste está analisando os resíduos (o erro ou a  diferença entre os resultados 
#reais e previstos).
#Há quatro coisas que estamos procurando quando se analisa resíduos.
#- A média dos erros é zero (e a soma dos erros é zero)
#- A distribuição dos erros são normais.
#- Todos os erros são independentes.
#- Variância de erros é constante (homocedástico)

#Em R, você retira os resíduos referenciando o modelo e, em seguida, a resid variável dentro do modelo. Usando o modelo de regressão linear 
#simples ( simple.fit ) vamos traçar alguns gráficos para ajudar a ilustrar quaisquer problemas com o modelo.

#Simple Regression Residual Plots
layout(matrix(c(1,1,2,3),2,2,byrow=T))
#Spend x Residuals Plot
plot(simple.fit$resid~dataset$Spend[order(dataset$Spend)],
     main="Spend x Residuals\nfor Simple Regression",
     xlab="Marketing Spend", ylab="Residuals")
abline(h=0,lty=2)
#Histogram of Residuals
hist(simple.fit$resid, main="Histogram of Residuals",
     ylab="Residuals")
#Q-Q Plot
qqnorm(simple.fit$resid)
qqline(simple.fit$resid)

############################################
# Os resíduos são normalmente distribuídos #
############################################

# O histograma e QQ-plot são as maneiras de avaliar visualmente se o residual encaixar uma distribuição normal.
# - Se o histograma parece com um sino-curva ele pode ser distribuído normalmente.
# - Se o QQ-plot tem a grande maioria dos pontos sobre ou muito perto da linha, os resíduos podem ser distribuídos normalmente.
# As parcelas não parecem estar muito perto de uma distribuição normal, mas também podemos usar um teste estatístico.

# O teste de Jarque-Bera (na biblioteca fBasics, que verifica se a assimetria e curtose de seus resíduos são semelhantes ao de uma 
#distribuição normal.
#- A hipótese nula do teste de Jarque-Bera é que assimetria e curtose de seus dados são ambos iguais a zero (mesmo que a distribuição normal).

#Loading the necessary libraries
library(lmtest) #dwtest
library(fBasics) #JarqueBeraTest

#Testando suposições normais de distribuição e independência
jarqueberaTest(simple.fit$resid) #Test residuals for normality
#Null Hypothesis: Skewness and Kurtosis are equal to zero
# Hipótesis nula: Skewness e Kurtosis são iguais a zero

# RETORNO --------------------------------
# Title: Jarque - Bera Normalality Test

#Test Results:
#  STATISTIC:
#  X-squared: 0.9575
#P VALUE:
#  Asymptotic p Value: 0.6195
# ----------------------------------------

# Com um valor de p (p value) de 0,6195, não rejeitamos a hipótese nula de que a assimetria e curtose dos resíduos são estatisticamente 
#iguais a zero.

##########################################################
# Resíduos são independentes (Residuals are independent) #
##########################################################
# O teste de Durbin-Watson é usado em análise de séries temporais para testar se há uma tendência nos dados com base em casos anteriores - 
# por exemplo, uma tendência sazonal ou uma tendência a cada outro ponto de dados.

#Usando a biblioteca lmtest, podemos chamar a função "dwtest" no modelo para verificar se os resíduos são independentes uns dos outros.
#- A hipótese nula do teste de Durbin-Watson é que os erros são serialmente não correlacionadas.

dwtest(simple.fit) #Test for independence of residuals
#Null Hypothesis: Errors are serially UNcorrelated
#Hipótesis nula: os erros são serialmente não correlacionados

# RETORNO --------------------------------
#Durbin-Watson test

#data:  simple.fit
#DW = 1.1347, p-value = 0.03062
#alternative hypothesis: true autocorrelation is greater than 0
# ----------------------------------------

#Com base nos resultados, podemos rejeitar a hipótese nula de que os erros são serialmente não correlacionados. 
#Isso significa que temos mais trabalho a fazer.

##################################################################################
# Vamos tentar passar por esses movimentos para o modelo de regressão múltipla.  #
##################################################################################

############################### REGRESSÃO MÚLTIPLA ###############################

layout(matrix(c(1,2,3,4),2,2,byrow=T))
plot(multi.fit$fitted, rstudent(multi.fit),
     main="Multi Fit Studentized Residuals",
     xlab="Predictions",ylab="Studentized Resid",
     ylim=c(-2.5,2.5))
abline(h=0, lty=2)
plot(dataset$Month, multi.fit$resid,
     main="Residuals by Month",
     xlab="Month",ylab="Residuals")
abline(h=0,lty=2)
hist(multi.fit$resid,main="Histogram of Residuals")
qqnorm(multi.fit$resid)
qqline(multi.fit$resid)

############################################
# Os resíduos são normalmente distribuídos #
############################################
#- Histograma dos resíduos não parece distribuídos normalmente.
#- No entanto, o QQ-Plot mostra apenas um punhado de pontos fora da linha normal.
#- Nós não rejeitamos a hipótese nula de Jarque-Bera (p-value = 0.5059)

jarqueberaTest(multi.fit$resid) #Test residuals for normality
#Null Hypothesis: Skewness and Kurtosis are equal to zero
#Residuals X-squared: 1.3627 p Value: 0.5059

##########################################################
# Resíduos são independentes (Residuals are independent) #
##########################################################
#- Nós não conseguimos rejeitar a hipótese nula do teste de Durbin-Watson (p-value 0.3133)

library(lmtest) #dwtest
dwtest(multi.fit) #Test for independence of residuals
#Null Hypothesis: Errors are serially UNcorrelated
#Results: DW = 2.1077, p-value = 0.3133

#######################################################################
# Resíduos têm variância constante (Residuals have constant variance) #
#######################################################################
#Variância constante pode ser verificado olhando para os resíduos “studentized” - normalizados com base no desvio padrão. 
#“Studentizing” permite comparar resíduos através modelos.

# A trama multi Fit studentized Resíduos mostra que não existem quaisquer valores atípicos óbvios. Se um ponto é bem além dos outros 
#pontos da plot("trama"?), então você pode querer investigar. Com base no gráfico acima, eu acho que estamos bem para assumir o 
#pressuposto de variância constante. Mais dados definitivamente ajudariam a preencher algumas lacunas.

#####################
# Recap / Destaques #
#####################
#- Regressão é uma ferramenta poderosa para a previsão de valores numéricos.
#- De R  lm função cria um modelo de regressão.
#- Use o resumo função para rever os pesos e medidas de desempenho.
#- Os resíduos podem ser examinados puxando a resid $ variável do seu modelo.
#- Você precisa verificar seus resíduos contra estes quatro pressupostos.
#-- A média dos erros é zero (ea soma dos erros é zero).
#-- A distribuição dos erros são normais.
#-- Todos os erros são independentes.
#-- Variância de erros é constante (homocedástico)

# --------------------------------------------------------------------------
# Links - Auxiliares
# http://www.learnbymarketing.com/tutorials/linear-regression-in-r/
# http://www.learnbymarketing.com/tutorials/explaining-the-lm-summary-in-r/
# https://www.youtube.com/watch?v=TLlzToeIpGc (Vídeo explicativo - Valor, Tamanho e Idade Prédio)
# Regressão Linear - Explicações 
#   I - https://www.youtube.com/watch?v=uoZqwLDlJb0
## II - https://www.youtube.com/watch?v=7w7LODmYzy4
#####################
