class Account(object):

    counter = 0

    def __init__(self, holder, number, balance, credit_line=1500):
        self.holder = holder
        self.number = number
        self.balance = balance
        self.credit_line = credit_line
        Account.counter += 1

    def __del__(self):
        Account.counter -= 1

    def transfer(self, target, amount):
        if(amount > self.balance + self.credit_line):
            # coverage insufficient
            return False
        self.balance -= amount
        target.balance += amount
        return True

    def deposit(self, amount):
        self.balance += amount

    def withdraw(self, amount):
        if(amount > self.balance + self.credit_line):
            # coverage insufficient
            return False
        else:
            self.balance -= amount
            return True

    def balance(self):
        return self.balance


if __name__ == "__main__":
    print Account.counter
    apple = Account('a', 1234, 5000)
    print Account.counter
    del apple
    print Account.counter
