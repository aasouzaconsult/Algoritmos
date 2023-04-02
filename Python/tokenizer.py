# http://cl.ly/image/2k3t3I0K1Q2W
# input = 'ab  cd  "ef gh"'
# output = ['ab', 'cd', 'ef gh']

import unittest
import re


def tokenize(a_string):
    # test for null string
    if len(a_string) < 1:
        return
    # convert all alphabets in string to lowercases
    a_string = a_string.lower()

    tokens = []
    token = ""
    # check for 2 consecutive quotation mark.
    closed_quotation = True

    for item in a_string:
        # is a quotation
        if ord(item) == 34:
            if not closed_quotation:
                if token != "":
                    tokens.append(token)
                    token = ""
                closed_quotation = True
            else:
                closed_quotation = False
        # is an alphabet
        elif ord(item) >= 97 and ord(item) <= 122:
            token += item
        # is a space
        elif ord(item) == 32:
            # string outside quotation
            if closed_quotation:
                if token != "":
                    tokens.append(token)
                    token = ""
            else:  # string inside quotation
                token += item
    # cater for last input
    if token != "":
        if not closed_quotation:
            token = token.strip()
        tokens.append(token)
    return tokens


def tokenize2(a_string):
    pattern = re.compile(r'(\w+)|"(.+?)"')
    matches = pattern.findall(a_string)
    tokens = []
    for item in matches:
        for part in item:
            if part != '':
                tokens.append(part)
    return tokens


class TokenizeTestCase(unittest.TestCase):
    """

    tokenize method testcase

    """
    def setUp(self):
        pass

    def test_tokenize(self):
        self.assertEqual(tokenize2('ab  cd  "ef gh"'), ['ab', 'cd', 'ef gh'])
        self.assertEqual(tokenize2('"a""b"" c'), ['a', 'b', 'c'])

if __name__ == "__main__":
    unittest.main()
