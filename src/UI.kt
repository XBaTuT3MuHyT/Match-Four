object UI {
    fun greet(): Pair<String, String>{
        println("_Четыре в ряд_")
        println("Первый боец: ")
        val a_player_name = readLine().toString()
        println("Второй боец: ")
        val b_player_name = readLine().toString()

        return a_player_name to b_player_name
    }

    fun boardSize(): Pair<Int, Int>{
        var rows = 6
        var columns = 7

        while (true){

            println("Размер поля в формате a X b, в пределах 5 - 9, оставьте поле пустым для стандартной настройки 6Х7 ")
            val input = readln().trim()

            if(input.isEmpty()) break

            val pattern = Regex("""^(\d+)\s*[xX]\s*(\d+)$""")
            val match = pattern.matchEntire(input)

            if (match == null){
                println("не то вводишь")
                continue
            }

            val (rStr, cStr) = match.destructured

            if (rStr.toInt() in 5..9){
                rows = rStr.toInt()
            }else{
                println("размеры от 5 до 9 !")
                continue
            }

            if (cStr.toInt() in 5..9){
                columns = cStr.toInt()
            }else{
                println("размеры от 5 до 9 !")
                continue
            }

            break
        }

        return rows to columns
    }

    fun info(a_player: Player, b_player: Player, board: Board){

        println("${a_player.name} VS ${b_player.name}")
        println("поле: ${board.rows} на ${board.columns}")
    }
}