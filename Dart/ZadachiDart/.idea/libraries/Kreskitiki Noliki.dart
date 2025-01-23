class Player {
  String name;

  Player(this.name);
}

class Game {
  List<List<String>> board = [
    ["", "", ""],
    ["", "", ""],
    ["", "", ""]
  ];

  void makeMove(Player player, int row, int col) {
    if (board[row][col] == "") {
      board[row][col] = player.name == "Игрок 1" ? "X" : "O";
      print("${player.name} поставил ${player.name == "Игрок 1" ? "X" : "O"} в позицию ($row, $col)");
    } else {
      print("Эта клетка уже занята!");
    }
  }

  void displayBoard() {
    for (var row in board) {
      print(row);
    }
  }
}

void main() {
  Player player1 = Player("Игрок 1");
  Player player2 = Player("Игрок 2");
  Game game = Game();

  game.makeMove(player1, 0, 0);
  game.makeMove(player2, 1, 1);
  game.makeMove(player1, 2, 2);
  game.displayBoard();
}
