from abc import ABC, abstractmethod

from desk.chessboard import Chessboard
from desk.occupation_type import OccupationType


class ChessPiece(ABC):
    chessboard = Chessboard()

    def __init__(self, x, y):
        self._x = x
        self._y = y
        self._set_chess_piece_on_chessboard(x, y)

    @property
    def x(self):
        return self._x

    @property
    def y(self):
        return self._y

    def _set_chess_piece_on_chessboard(self, x: int, y: int):
        for cell in self.chessboard.get_board:
            if x == cell.x_coordinate and y == cell.y_coordinate:
                cell.occupation_type = OccupationType.occupied

    @abstractmethod
    def find_all_moves(self):
        pass
