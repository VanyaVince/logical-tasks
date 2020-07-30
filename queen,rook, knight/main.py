import coordinate_converter
from desk.chessboard import Chessboard
from model.chesspiece import ChessPiece
from model.knight import Knight
from desk.occupation_type import OccupationType
from model.queen import Queen
from model.rook import Rook


def count_moves(chess_piece: ChessPiece):
    chess_piece.find_all_moves()


locations = input("write locations ").split(" ")

pieces = [
    Queen(coordinate_converter.coordinate.get(locations[0][1]), int(locations[0][0])),
    Rook(coordinate_converter.coordinate.get(locations[1][1]), int(locations[1][0])),
    Knight(coordinate_converter.coordinate.get(locations[2][1]), int(locations[2][0]))
]

for piece in pieces:
    piece.find_all_moves()

print("\n--------------------------------")

count = 0
for cell in Chessboard().get_board:
    if cell.occupation_type == OccupationType.attacked:
        count += 1

print(f"There are {count} cells under attacked")
print("--------------------------------")
print(Chessboard().print())
