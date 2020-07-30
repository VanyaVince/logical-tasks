from model.chesspiece import ChessPiece
from desk.occupation_type import OccupationType


class Queen(ChessPiece):

    def find_all_moves(self):
        for cell in self.chessboard.get_board:
            if self.x == cell.x_coordinate or self.y == cell.y_coordinate or abs(self.x - cell.x_coordinate) == abs(
                    self.y - cell.y_coordinate):
                if cell.occupation_type != OccupationType.occupied:
                    cell.occupation_type = OccupationType.attacked
