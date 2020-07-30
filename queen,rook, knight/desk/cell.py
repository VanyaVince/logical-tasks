class Cell:

    # TODO write function to validate input coordinate values
    def __init__(self, x_coordinate, y_coordinate, occupation_type):
        self._x_coordinate = x_coordinate
        self._y_coordinate = y_coordinate
        self.occupation_type = occupation_type

    @property
    def x_coordinate(self) -> int:
        return self._x_coordinate

    @property
    def y_coordinate(self) -> int:
        return self._y_coordinate

    @property
    def occupation_type(self):
        return self.__occupation_type

    @occupation_type.setter
    def occupation_type(self, v):
        self.__occupation_type = v

    def print_coordinates(self) -> str:
        return f"{self.x_coordinate},{self.y_coordinate}"
