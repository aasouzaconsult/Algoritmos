def check_braces(expressions):
    # Write your code here
    # To print results to the standard output you can use print
    # Example print "Hello world!"
    push_chars = "([{"
    pop_chars = ")]}"
    for item in expressions:
        stack1 = []
        for a in item:
            if a in push_chars:
                stack1.append(a)
            elif a in pop_chars:
                if not len(stack1):
                    print 0
                else:
                    top = stack1.pop()
                    balance = push_chars[pop_chars.index(a)]
                    if top != balance:
                        print 0
            else:
                print 0
        if len(stack1) < 1:
            print 1
        else:
            print 0

if __name__ == "__main__":
    expressions = [")(){}", "[]({})", "([])", "{()[]}", "([)]"]
    check_braces(expressions)
