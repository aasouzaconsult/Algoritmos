############################
# Regressão Linear Simples #
############################

gerentes = read.table("Data/gerentes.txt",header=T)
attach(gerentes)

summary(gerentes) # resumos
summary(gerentes$Experiencia) # resumos da Experiencia

var(gerentes) # variancia
var(gerentes$Salario) # variancia do Salario

sd(gerentes)  # desvio padrao
sd(gerentes$Salario)  # desvio padrao

# Diagrama de Dispersão
# Para verificar a existência de alguma relação entre Salário e Experiência, deve-se construir um Diagrama de Dispersão para as duas variáveis:
plot(Experiencia,Salario)

# Coeficiente de Correlação Linear de Pearson
cor(Experiencia,Salario)

# Teste de Hipóteses
cor.test(Experiencia,Salario)
# Como o Valor P do teste (p-value < 2.2e-16) é bem pequeno, conclui-se que o valor do Coeficiente de Correlação Linear de Pearson tem significância Estatística.

# Regressão Linear Simples
# Sejam X e Y, respectivamente, as variáveis Experiência (explicativa) e Salário (resposta). Propõe-se um modelo de regressão linear de primeira ordem, 
# dado pela equação: Y = B0 + B1X + e, onde B0 e B1 são parâmetros desconhecidos e: "e" é o erro aleatório.
ajuste=lm(Salario ~ Experiencia)
# Note que função lm() é chamada com o formato lm(y ˜ x), ou seja, a variável resposta é y e a preditora é x, sempre nessa ordem.
# O R retorna o valor dos coeficientes de B^0 e B^1 estimados via Método de Mínimos Quadrados. Logo, a equação da reta ajustada é dada por ^Y = 1.8063 + 0.1008Xi.

summary(ajuste)
# Da execução desse comando, pode-se obter, por exemplo, os erros-padrão (Std. Error) das estimativas dos coeficientes de regressão: EP(B^0) = 0.081610 e EP(B^1) = 0.005014. 
# Além disso, obtém-se o valor do Coeficiente de Determinação (Multiple R-Squared), R2 = 0.9417.

# Tabela da Análise de Variância:
anova(ajuste)
# Da tabela ANOVA, obtém-se o Quadrado Médio (Mean Sq) Residual, que é uma estimativa para a variância dos erros (alfa^2), ou seja, s2 = 0,04.

# Desenhando a reta
abline(lm(Salario ~ Experiencia))

# Intervalos de Confiança para B0 e B1
confint(ajuste)

# Análise dos Resíduos
# Para avaliar as suposições de que os erros possuem variância constante e são não correlacionados entre si, construa os gráficos de “Resíduos versus Valores Ajustados da 
# Variável Resposta” e “Resíduos versus Valores da Variável Explicativa":
windows()
plot(fitted(ajuste),residuals(ajuste),xlab="Valores Ajustados",ylab="Resíduos")
abline(h=0)
windows()
plot(Experiencia,residuals(ajuste),xlab="Experiência",ylab="Resíduos")
abline(h=0)

###################################################
# Regressão Linear Múltipla - Variável Indicadora #
###################################################

gerentes = read.table("Data/gerentes1.txt",header=T)
attach(gerentes)
Sexo = factor(Sexo)
gerentes

#Para construir um diagrama de dispersão com marcadores diferentes para a variável Sexo:
par(mfrow=c(1,1))
plot(Experiencia[Sexo==1],Salario[Sexo==1],xlab="Experiência",ylab="Salário")
points(Experiencia[Sexo==0],Salario[Sexo==0], pch = 19)

# Sejam as variáveis explicativas Experiência (X, em anos), Sexo (Z: 0, feminino; 1, masculino) e a variável resposta Salário (Y, em mil reais).
# Y = B0 + B1X + a1Z + y1XZ + e;
ajuste = lm(Salario ~ Experiencia + Sexo + Experiencia*Sexo)

# Logo, a equação da reta ajustada é dada por ^Y = 1.95 + 0.727Xi + 0.0311Zi + 0.02551XiZi.
anova(ajuste) # 0.0132

# Para exibir o valor do Coeficiente de Determinação Ajustado:
ajuste_s = summary(ajuste)
ajuste_s$adj.r.squared

# Análise de Resíduos
# Considere os seguintes gráficos para a Análise dos Resíduos:
windows()
plot(fitted(ajuste),residuals(ajuste),xlab="ValoresAjustados",ylab="Resíduos")
abline(h=0)

windows()
plot(Experiencia,residuals(ajuste),xlab="Experiencia",ylab="Resíduos")
abline(h=0)

windows()
boxplot(residuals(ajuste)~ Sexo)

windows()
qqnorm(residuals(ajuste), ylab="Resíduos")
qqline(residuals(ajuste))

# Observe, nestes gráficos (Figura 10), que há indicativos de que a variância dos erros é constante, não
# há evidências de que os erros não sigam a distribuição Normal e percebe-se de que os erros não são
# correlacionados entre si.
