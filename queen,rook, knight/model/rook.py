from model.chesspiece import ChessPiece
from desk.occupation_type import OccupationType


class Rook(ChessPiece):
    def find_all_moves(self):
        for cell in self.chessboard.get_board:
            if self.x == cell.x_coordinate or self.y == cell.y_coordinate:
                if cell.occupation_type != OccupationType.occupied:
                    cell.occupation_type = OccupationType.attacked
