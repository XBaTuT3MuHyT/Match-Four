class Game(val board: Board, firstPlayer: Player, secondPlayer: Player) {

    var currentPlayer = firstPlayer


    fun makeTurn(currentPlayer: Player){
        println("${currentPlayer.name}, выбирай ряд: ")

    }
}