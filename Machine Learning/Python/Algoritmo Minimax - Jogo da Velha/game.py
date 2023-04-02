# -*- coding: UTF-8 -*-

from cell import *
from board import *
from minimax import *

# Constantes para representar varios estados do jogo, vai para variavel game_state
class Game:
	PLAYING = 0
	DRAW = 1
	CROSS_WON = 2
	NOUGHT_WON = 3

	def __init__(self):
		self.board = Board()
		self.computer = Minimax(self.board)

	# Método que dá inicio ao jogo em si	
	def play(self):
		self.init_game()
		self.board.show()
		while self.game_state == self.PLAYING:
			self.player_move(self.current_player)
			self.board.show()
			self.update_game(self.current_player)
			self.show_game_status(self.game_state)	
			self.current_player = Cell.NOUGHT if self.current_player == Cell.CROSS else Cell.CROSS

	# faz as inicializações no jogo		
	def init_game(self):
		print ("\n*** Olá, vamos começar a jogar. ***\n")
		self.current_player = self.choose_player()
		self.game_state = self.PLAYING

	# Verifica se uma jogada válida	
	def is_valid_input(self, row, col):
		return ((row >= 0) and (row < Board.ROWS) and (col >= 0) and (col < Board.COLS) and 
			(self.board.cells[row][col].content == Cell.EMPTY))

	# Verifica se o campo digitado foi x/X
	def is_cross(self, value):
		return value == 'x' or value == 'X'	

	# verifica se o campo digitado foi o/O	
	def is_nought(self, value):
		return value == 'o' or value == 'O'	

	# Método para escolher quem começa X ou O
	def choose_player(self):
		while(True):
			print ("Escolha quem começa X ou O (x/o): ")
			player = str(raw_input())
			if self.is_cross(player):
				return Cell.CROSS
			elif self.is_nought(player):
				return Cell.NOUGHT	
			else:
				print ("Opção inválida!")

	# O jogador do estado atual executa seu movimento
	def player_move(self, player):
		if player == Cell.CROSS:
			print ("Jogador 'X', entre com sua jogada (linha[1-3] coluna[1-3]): ")
			valid_input = False
			while not valid_input:
				row = int(raw_input())-1
				col = int(raw_input())-1

				if self.is_valid_input(row, col):
					self.board.cells[row][col].content = player	
					valid_input = True		
				else:
					print ("Movimento inválido! Tente novamente: ")
		else:
			print ("Jogador 'O'(PC): ")
			move = self.computer.move()
			self.board.cells[move[0]][move[1]].content = player	

	# Atualiza o estado do jogo  		
	def update_game(self, player):
		if(self.board.has_won(player)):
			self.game_state = self.CROSS_WON if player == Cell.CROSS else self.NOUGHT_WON
		elif(self.board.is_draw()):
			self.game_state = self.DRAW

	# Exibe o estado do jogo em caso de termino (por empate ou vecendor)		
	def show_game_status(self, game_state):
		if game_state == self.NOUGHT_WON:
			print ("Vencedor O!\n\n*** Fim de Jogo! ***")
		elif game_state == self.CROSS_WON:
			print ("Vencedor X!\n\n*** Fim de Jogo! ***")
		elif game_state == self.DRAW:	
			print ("Empate!\n\n*** Fim de Jogo! ***")
							

# ------------- Jogo ----------------------------
g = Game()	
g.play()