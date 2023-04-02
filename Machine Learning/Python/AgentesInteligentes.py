# Estudo de Agentes Inteligentes

################################
# Reativo Simples
P = [1,1,0,1]
A = ['walk','stop']
def agent(P):
  for i in P:
    if (i==1):
       print(A[0])
    else:
       print(A[1])

#Executar
print(agent(P))

################################
# Reativo Simples - Spam
a = 'This is test'
b = 'Another test'
c = 'A third'
word = 'test'
P= []
P.append(a)
P.append(b)
P.append(c)
A = ['spam','not spam']
for i in P:
   print(i)
   if word in i:
      print (A[0])
   else:
      print (A[1])

'''
Referências
http://www.revistabw.com.br/revistabw/ia-agentes-inteligentes/
https://github.com/aimacode/aima-python
'''