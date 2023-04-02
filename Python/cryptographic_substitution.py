##################################
###	Cryptographic Substitution ###
##################################

# This algorithm shuffles a ciper key and encrypts plaintext as input.
# Decrypt is done with the same ciper key

import random

plain = 'abcdefghijklmnopqrstuvwxyz'
ciper = 'HETJWOPSQYAZIVMBDUKNRGLCXF'
plain_key = []
ciper_key = []

# Convert to lists
for item in plain:
	plain_key.append(item)
for item in ciper:
	ciper_key.append(item)

# Shuffle ciper_key
random.shuffle(ciper_key)
print ciper_key

# 
clear_text = 'this is the best day of my life'
encrypt_text = ''

for alphabet in clear_text:
	if alphabet != ' ':
		for index in range(len(plain_key)):
			if alphabet == plain_key[index]:
				encrypt_text += ciper_key[index]
				break
	else:
		encrypt_text += ' '
print encrypt_text