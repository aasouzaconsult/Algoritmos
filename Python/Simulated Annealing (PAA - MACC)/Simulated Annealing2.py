import random

def annealing():
    solutions = generateSolutions()
    random_index = random.randint(0, len(solutions) - 1)
    T = 1.0
    T_accept = 0.0000001
    alpha = .99
    s = solutions[random_index]
    while T > T_accept:
        s_new = randomNeighbor(s, solutions)
        beta = betaFunc(cost(s), cost(s_new), T)
        if cost(s_new) < cost(s):
            s = s_new
        else:
            if beta:
                s = s_new
        T = T * alpha
    return s

def randomNeighbor(sln, solutions):
    currentIndex = solutions.index(sln)
    randomStep = random.randint(1, 2)
    if randomStep == 1:
        if currentIndex > 0:
            return solutions[currentIndex - 1]
        else:
            return solutions[currentIndex + 1]
    elif randomStep == 2:
        if currentIndex < len(solutions) - 1:
            return solutions[currentIndex + 1]
        else:
            return solutions[currentIndex - 1]

def cost(sln):
    return abs(401 - sln)

def betaFunc(oldCost, newCost, T):
    rand = random.random()
    if T < 0.4:
        if rand > 0.2:
            return False
        return True
    else:
        if rand > 0.4:
            return False
        return True

def generateSolutions():
    nums = []
    for a in range(1, 500, 2):
        nums.append(a)
    for a in range(0, 499, 2):
        nums.append(500 - a)
    return nums