
# Abrindo o arquivo credito.xlsx, aqui vocês precisam mudar o diretorio.

library(readxl)
credito <- read_excel("D:/Zoom_aula_IA/Regressão Logística/credito.xlsx")
View(credito)

# Função attach é para setar o arquivo.
attach(credito)

#install.packages(c("glme","ResourceSelection","ROCR"))
# glm2 - biblioteca para criar o modelo
# ResourceSelection - para testar a hipotese
  # H0 = valores observados "y" = valores previsto para "y", ou seja quero aceitar H0.
  # H1 = valores observados "y" != diferente valores previstos.
# ROCR biblioteca para criar a curva roc, um indicador de quanto nosso modelo está conseguindo,
  # discriminar o bom do mal pagador.

library(glm2) 
library(ResourceSelection)
library(ROCR)

# Função names - exibe os nomes das variáveis.
# Função table - exibe a quantidade de registros dentro de cada categoria
names(credito)
table(default)
table(qtd_emprestimos)

# A função glm cria o modelo logistico.
# A função ~ busca uma relação entre as preditoras (x) para com (y) variável resposta
# A Função family = binomial - estou dizendo que o modelo é binário (0,1).
Logistica <-glm(credito$default  ~  idade + atraso_pag + valor + 
                  qtd_emprestimos + cartao_credito, family = binomial)


# Função summary - exibe os betas do modelo e sua significãncia.
# P_valor > 0.05 significa que a variável não tem importância para o modelo.
# P_valor < 0.05 variável é significante para o modelo.
summary(Logistica) 

# Função credito$probabilidade - significa que estou criando uma coluna chamada probabilidade e adicionando ela no arquivo.
# Logistica é o nome do meu modelo.
# type determina o armazenamento do objeto.
credito$probabilidade <-predict(Logistica, credito, type = "response")

# Função View - invoca um visizlizador de dados
View(credito)

#install.packages("ResourceSelection")
#library(ResourceSelection)
# Essa linha 52 está usando a função hosle.test da biblioteca ResourceSelection
# g = 10 é o grau de liberdade, vide ppt.
# A função hoslem.test é um teste de hipotese, sempre é bom Aceitar H0 aqui.
bondade_ajuste <- hoslem.test (credito$default,credito$probabilidade, g=10)
bondade_ajuste

# A função ifelse cria uma coluna chamada previsao a partir da coluna probabilidade criada na linha 44.
# se a probabilidade for >= 0.5 classifica o registro como 1 - inadimplente, caso contrário cliente Adimplente.
credito$previsao <- ifelse(credito$probabilidade >= 0.5,1,0)

# Função head - exibe as 5 primeiras linhas do arquivo.
head(credito)

# Attachando o arquivo novamente.
attach(credito)

# função table, uma tabela cruzada entre default - y contra a minha previsão. Exibe a tabela de classificação ou confusão como é chamada.
# Na linha 70 estou criando um objeto chamado resumo, para depois fazer o calculo.
# Objeto tx_acerto está somando o acerto na categoria 0 e acerto na categoria 1. Depois divide por todo mundo, esse é acerto geral do modelo.
table(credito$default, credito$previsao)
resumo <-table(credito$default, credito$previsao)
tx_acerto <-(resumo[1]+resumo[4])/sum(resumo)
tx_acerto


#install.packages("ROCR")
#library(ROCR)
# Código para criar a curva ROC.
# Função unlist vai mostrar o valor sobre a curva. Esperamos acima de 70, significa disciminação satisfatoria, modelo está indo bem.
pred <- prediction(predictions = credito$probabilidade, labels = credito$default)
perf <- performance(pred, measure = "tpr", x.measure = "fpr")
plot(perf, main = "probabilidade", col = "blue", lwd = 3)
abline(a = 0, b = 1, lwd = 2, lty = 2)
perf.auc <- performance(pred, measure = "auc")
unlist(perf.auc@y.values)


######################## Previsão em novos dados - essa é a logica ######

# Estou chamando um novo arqruivo - credito_novos - é o mesmo dado, pore´m sem a coluna default.
library(readxl)
credito_novos <- read_excel("D:/Zoom_aula_IA/Regressão Logística/credito_novos.xlsx")
View(credito_novos)

attach(credito_novos)

# Criando uma probabilidade atraves do modelo logistico e acrescentando essa probabilidade no novo arquivo
# Criando uma variável 0,1 de previsão de bom e mal pagador. Todo mundo que for classificado como 1 será tratado como Inadimplente.
credito_novos$prob <- predict(Logistica, credito_novos, type = "response")
credito_novos$previsao <- ifelse(credito_novos$prob >= 0.5,1,0)

table(credito_novos$previsao)



