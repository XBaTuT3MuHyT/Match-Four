class Game(val board: Board, val firstPlayer: Player, val secondPlayer: Player) {

    var currentPlayer = firstPlayer


    fun start(){
//        game@ while (true){
            while (true){
                makeTurn(currentPlayer)
                if (checkWin(currentPlayer.token)){
                    println("Игрок ${currentPlayer.name} победил !!!")
                    break
                }
                changePlayer()
            }
//            while (true){
//                println("еще по одной? ( Y / n )")
//                val input = readln().trim()
//                when(input){
//                    "Y" -> continue@game
//                    "n" -> break@game
//                    else -> println("не то вводишь !")
//                }
//            }
//        }

    }
    fun makeTurn(currentPlayer: Player){

        while (true){
            println("${currentPlayer.name}, выбирай ряд: ")
            var input = readln().trim()
            var number = input.toIntOrNull() ?: -1
            if (board.setToken(number, currentPlayer.token)) break
        }

        board.printBoard()
    }
//много перебора
    fun checkWin(token: Token): Boolean {
        val grid = board.getGrid()
        for (r in 0 until board.rows)
            for (c in 0 until board.columns)
                if (checkDirection(grid, r, c, token)) return true
        return false
    }

    fun checkDirection(grid: Array<Array<Token>>, r: Int, c: Int, token: Token): Boolean{
        val dirs = listOf(1 to 0, 0 to 1, 1 to 1, 1 to -1)
        return dirs.any {(dr, dc) ->
            (0..3).all {i ->
                val nr = r + dr * i
                val nc = c + dc * i
                nr in grid.indices && nc in grid[0].indices && grid[nr][nc] == token
            }
        }
    }

    fun changePlayer(){
        currentPlayer = if (currentPlayer == firstPlayer) secondPlayer else firstPlayer
    }
}