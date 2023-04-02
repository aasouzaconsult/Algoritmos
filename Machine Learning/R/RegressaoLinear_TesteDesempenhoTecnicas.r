# Crio então um conjunto de dados simulados com 20 milhões de casos. Uma variável dependente (y), três variáveis independentes (x1, x2, x3) e os pesos amostrais.

# Fixa o gerador de números aleatórios
# (passo necessário para a replicação completa)
set.seed(1234)
 
# Número de casos
n = 20000000
 
# Construindo os dados
x1 = rnorm(n)
x2 = rnorm(n)^2
x3 = rbinom(n,10,.3)
y = 10 + .5*x1 + .2*x2 +.7*x3 + 10*runif(n)
weight = runif(n) + 1

Para a utilizar o comando lm, salvo esses dados num data.frame.

# Dados como data.frame
data = data.frame(y,x1,x2,x3,weight)

# Para a utilizar os comando lm.wfit e C_Cdqrls, salvo os dados numa matriz.
# Dados como matrix
# (exceto a variável dependente [y] e o peso[weight])
X = model.matrix(~ x1 + x2 +x3)

#Deleto os objetos auxiliares (notem o uso da função garbage can!!):
# Removendo objetos auxiliares
rm(x1,x2,x3,weight, n)
gc() #função garbage can - libera a memória não utilizada

# Executo modelos idênticos a partir dos cinco métodos. Reparem que a função C_Cdqrls não permite pesos amostrais… Por isso é necessária uma transformação dos dados: 
#multiplicar o vetor y e a matriz X pela raiz quadrada dos pesos… Trata-se de uma estimação por Weighted Least Squares (que, na realidade é a mesma técnica aplicada 
#quando usamos lm ou lm.wfit, mas de forma automática). Neste post, no entanto, não vou entrar nos detalhes sobre como isso funciona. Mas adianto que qualquer livro 
#de Econometria ensina como fazer isso. A mesma lógica foi aplicada aos métodos 4 e 5, que se baseiam apenas na multiplicação de matrizes.

# MÉTODO 1
# OLS usando lm
system.time(lm(y ~ x1 + x2 +x3, weight=weight, data=data))
 
# MÉTODO 2
# OLS usando lm.fit
system.time(lm.wfit(x=X, y=y, w=data$weight))
 
# MÉTODO 3
# OLS usando C_Cdqrls
# Usa weighted least squares (WLS)
wts = sqrt(data$weight) #peso para WLS
system.time(.Call(stats:::C_Cdqrls, X*wts, y*wts, tol=1e-7))
 
# MÉTODO 4
# OLS com multiplicação de matrizes: [X'X]^1[X'y]
# X e y são multiplicados pela raiz dos pesos
# (apenas coeficientes)
system.time(solve(t(wts*X)%*%(wts*X))%*%(t(wts*X))%*%(wts*y))
 
# MÉTODO 5
# OLS com multiplicação de matrizes: função crossprod
# (apenas coeficientes)
system.time(solve( crossprod(wts*X), crossprod(wts*X, wts*y))) 
