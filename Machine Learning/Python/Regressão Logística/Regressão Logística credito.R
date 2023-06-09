
# Abrindo o arquivo credito.xlsx, aqui voc�s precisam mudar o diretorio.

library(readxl)
credito <- read_excel("D:/Zoom_aula_IA/Regress�o Log�stica/credito.xlsx")
View(credito)

# Fun��o attach � para setar o arquivo.
attach(credito)

#install.packages(c("glme","ResourceSelection","ROCR"))
# glm2 - biblioteca para criar o modelo
# ResourceSelection - para testar a hipotese
  # H0 = valores observados "y" = valores previsto para "y", ou seja quero aceitar H0.
  # H1 = valores observados "y" != diferente valores previstos.
# ROCR biblioteca para criar a curva roc, um indicador de quanto nosso modelo est� conseguindo,
  # discriminar o bom do mal pagador.

library(glm2) 
library(ResourceSelection)
library(ROCR)

# Fun��o names - exibe os nomes das vari�veis.
# Fun��o table - exibe a quantidade de registros dentro de cada categoria
names(credito)
table(default)
table(qtd_emprestimos)

# A fun��o glm cria o modelo logistico.
# A fun��o ~ busca uma rela��o entre as preditoras (x) para com (y) vari�vel resposta
# A Fun��o family = binomial - estou dizendo que o modelo � bin�rio (0,1).
Logistica <-glm(credito$default  ~  idade + atraso_pag + valor + 
                  qtd_emprestimos + cartao_credito, family = binomial)


# Fun��o summary - exibe os betas do modelo e sua signific�ncia.
# P_valor > 0.05 significa que a vari�vel n�o tem import�ncia para o modelo.
# P_valor < 0.05 vari�vel � significante para o modelo.
summary(Logistica) 

# Fun��o credito$probabilidade - significa que estou criando uma coluna chamada probabilidade e adicionando ela no arquivo.
# Logistica � o nome do meu modelo.
# type determina o armazenamento do objeto.
credito$probabilidade <-predict(Logistica, credito, type = "response")

# Fun��o View - invoca um visizlizador de dados
View(credito)

#install.packages("ResourceSelection")
#library(ResourceSelection)
# Essa linha 52 est� usando a fun��o hosle.test da biblioteca ResourceSelection
# g = 10 � o grau de liberdade, vide ppt.
# A fun��o hoslem.test � um teste de hipotese, sempre � bom Aceitar H0 aqui.
bondade_ajuste <- hoslem.test (credito$default,credito$probabilidade, g=10)
bondade_ajuste

# A fun��o ifelse cria uma coluna chamada previsao a partir da coluna probabilidade criada na linha 44.
# se a probabilidade for >= 0.5 classifica o registro como 1 - inadimplente, caso contr�rio cliente Adimplente.
credito$previsao <- ifelse(credito$probabilidade >= 0.5,1,0)

# Fun��o head - exibe as 5 primeiras linhas do arquivo.
head(credito)

# Attachando o arquivo novamente.
attach(credito)

# fun��o table, uma tabela cruzada entre default - y contra a minha previs�o. Exibe a tabela de classifica��o ou confus�o como � chamada.
# Na linha 70 estou criando um objeto chamado resumo, para depois fazer o calculo.
# Objeto tx_acerto est� somando o acerto na categoria 0 e acerto na categoria 1. Depois divide por todo mundo, esse � acerto geral do modelo.
table(credito$default, credito$previsao)
resumo <-table(credito$default, credito$previsao)
tx_acerto <-(resumo[1]+resumo[4])/sum(resumo)
tx_acerto


#install.packages("ROCR")
#library(ROCR)
# C�digo para criar a curva ROC.
# Fun��o unlist vai mostrar o valor sobre a curva. Esperamos acima de 70, significa discimina��o satisfatoria, modelo est� indo bem.
pred <- prediction(predictions = credito$probabilidade, labels = credito$default)
perf <- performance(pred, measure = "tpr", x.measure = "fpr")
plot(perf, main = "probabilidade", col = "blue", lwd = 3)
abline(a = 0, b = 1, lwd = 2, lty = 2)
perf.auc <- performance(pred, measure = "auc")
unlist(perf.auc@y.values)


######################## Previs�o em novos dados - essa � a logica ######

# Estou chamando um novo arqruivo - credito_novos - � o mesmo dado, pore�m sem a coluna default.
library(readxl)
credito_novos <- read_excel("D:/Zoom_aula_IA/Regress�o Log�stica/credito_novos.xlsx")
View(credito_novos)

attach(credito_novos)

# Criando uma probabilidade atraves do modelo logistico e acrescentando essa probabilidade no novo arquivo
# Criando uma vari�vel 0,1 de previs�o de bom e mal pagador. Todo mundo que for classificado como 1 ser� tratado como Inadimplente.
credito_novos$prob <- predict(Logistica, credito_novos, type = "response")
credito_novos$previsao <- ifelse(credito_novos$prob >= 0.5,1,0)

table(credito_novos$previsao)



