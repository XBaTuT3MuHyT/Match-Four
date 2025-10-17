import javax.swing.text.Position

class Board(val rows: Int, val columns: Int) {
    private val grid = Array(rows) { Array(columns) { Token.EMPTY } }

    fun printBoard(){
        println()
//        println("╔" + "═══╦".repeat(columns - 1) + "═══╗")
        for (r in 0 until rows) {
            print("║")
            for (c in 0 until columns) {
                print(" ${grid[r][c].symbol} ║")
            }
            println()
            if (r != rows - 1)
                println("╠" + "═══╬".repeat(columns - 1) + "═══╣")
        }
        println("╚" + "═══╩".repeat(columns - 1) + "═══╝")
        println("  " + (0 until columns).joinToString("   ") { it.toString() })
        println()
    }

    fun setToken(column: Int, token: Token): Boolean{
        if (column !in 0..columns-1){
            println("За пределами доски ! ")
            return false
        }
        for (i in rows-1 downTo 0){
            if (grid[i][column] == Token.EMPTY){
                grid[i][column] = token
                return true
            }
        }
        println("Столбец полностью забит !")
        return false
    }

    fun getGrid(): Array<Array<Token>> {
        return grid
    }

}