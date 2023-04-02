def Fibonacci(n):
    # casos particulares
    if n <= 1: return n
    # Sequência de Fibonacci
    return Fibonacci(n - 1) + Fibonacci(n - 2)

# Teste
Fibonacci(6)