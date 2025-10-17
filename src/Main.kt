fun main(){

    val (name1, name2) = UI.greet()
    val (rows, columns) = UI.boardSize()

    val firstPlayer = Player(1, name1, Token.WHITE)
    val secondPlayer = Player(2, name2, Token.BLACK)
    val board = Board(rows, columns)
    val game = Game(board, firstPlayer, secondPlayer)

    board.printBoard()
    game.start()

}