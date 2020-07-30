from desk.cell import Cell
from desk.occupation_type import OccupationType


class Chessboard:
    # _instance = None
    _field = None

    def __init__(self):
        if not Chessboard._field:
            self._init_chessboard()

    def _init_chessboard(self):
        Chessboard._field = []
        for x in range(1, 9):
            for y in range(1, 9):
                self._field.append(Cell(y, x, OccupationType.empty))

    @property
    def get_board(self) -> []:
        return self._field

    def print(self):

        i = 0

        while i < len(self._field):

            if i % 8 == 0 and i != 0:
                print("")

            print(f"[{self._field[i].occupation_type.value}] ", end="")

            i += 1
        print("")
