# -*- coding: UTF-8 -*-
# Minimax com poda alpha-beta

from cell import *
from board import *

class Minimax:
	def __init__(self, board):
		self.board = board

	def move(self):
		return self.max_value(self.board, float('-inf'), float('inf'))[1]

	# Minimiza a jogada do oponente	
	def min_value(self, board, alfa, beta):
		if self.terminal_test(board):
			return [self.utility(board), None]
		v = [float("inf"), None]
		for move in self.legal_moves(board):
			self.make_move(move, board, Cell.CROSS)
			m = self.max_value(board, alfa, beta) 
			self.make_move(move, board, Cell.EMPTY)
			if m[0] < v[0]:
				v[0] = m[0]
				v[1] = move
			if v[0] <= alfa:
				return v
			beta = min(v[0], beta)	
		return v

	# Maximiza a jogada do PC	
	def max_value(self, board, alfa, beta):
		if self.terminal_test(board):
			return [self.utility(board), None]
		v = [float("-inf"), None]
		for move in self.legal_moves(board):
			self.make_move(move, board, Cell.NOUGHT)
			m = self.min_value(board, alfa, beta) 
			self.make_move(move, board, Cell.EMPTY)
			if m[0] > v[0]:
				v[0] = m[0]
				v[1] = move	
			if v[0] >= beta:
				return v
			alfa = max(v[0], alfa)	
		return v	

	# Executa a ação (a jogada)	
	def make_move(self, move, board, player):
		board.cells[move[0]][move[1]].content = player

	# Retorna uma lista de possiveis jogadas
	def legal_moves(self, board):
		moves = []
		for row in range(0, Board.ROWS):
			for col in range(0, Board.COLS):
				if board.cells[row][col].content == Cell.EMPTY:
					 moves.append([row, col])
		return moves

    # Retorna um valor para computador; 1 para vencer, -1 para perder, 0 em caso contrario.    
	def utility(self, board):
		if board.has_won(Cell.NOUGHT):
			return 1
		elif board.has_won(Cell.CROSS):
			return -1
		else:
			return 0	 	

	# Retorna verdadeiro caso tenha terminado o jogo 
	def terminal_test(self, board):
		return (board.is_draw() or board.has_won(Cell.NOUGHT) or board.has_won(Cell.CROSS))

