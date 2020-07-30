from model.chesspiece import ChessPiece
from desk.occupation_type import OccupationType


class Knight(ChessPiece):
    def find_all_moves(self):
        for cell in self.chessboard.get_board:
            if abs(self.x - cell.x_coordinate) * abs(self.y - cell.y_coordinate) == 2:
                if cell.occupation_type != OccupationType.occupied:
                    cell.occupation_type = OccupationType.attacked
