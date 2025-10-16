class Board(val rows: Int, val columns: Int) {
    private val grid = Array(rows) { Array(columns) { Token.EMPTY } }

    fun printBoard(){
        println()
        println("╔" + "═══╦".repeat(columns - 1) + "═══╗")
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

}