package ioManager

import game.Game
import game.Grid
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

public fun readBestScores(n : Int) : ArrayList<Int>{
    val file : File = File("$SCORES_FOLDER_NAME\\$n$BEST_INDICATOR") //must exist if this is called
    val reader : BufferedReader = BufferedReader(FileReader(file))
    var result : ArrayList<Int> = ArrayList<Int>()
    for(line : String in reader.lines()){
        result.add(line.toInt())
    }
    return result
}

public fun readLastScores(n : Int) : ArrayList<Int>{
    val file : File = File("$SCORES_FOLDER_NAME\\$n$LAST_INDICATOR") //must exist if this is called
    val reader : BufferedReader = BufferedReader(FileReader(file))
    var result : ArrayList<Int> = ArrayList<Int>()
    for(line : String in reader.lines()){
        result.add(line.toInt())
    }
    return result
}

public fun readGame(name : String) : Game{
    val iValues : ArrayList<Int> = ArrayList<Int>()
    val jValues : ArrayList<Int> = ArrayList<Int>()
    val nameData : List<String> = name.split(SEPARATOR)
    val n : Int = nameData[0].toInt()
    val score : Int = nameData[1].toInt()
    val file : File = File(GAMES_FOLDER_NAME + "\\$name")
    val reader : BufferedReader = BufferedReader(FileReader(file))
    for(line : String in reader.lines()){
        val separatorIndex : Int = line.indexOf(SEPARATOR)
        iValues.add(line.substring(0, separatorIndex).toInt())
        jValues.add(line.substring(separatorIndex + 1, line.length).toInt())
    }
    val grid : Grid = Grid(n, iValues, jValues)
    reader.close()
    file.delete()
    return Game(n, score, grid)
}

public fun readGamesNames() : ArrayList<String>{
    val result : ArrayList<String> = ArrayList<String>()
    for(f : File in File(GAMES_FOLDER_NAME).listFiles()){
        result.add(f.name)
    }
    return result
}

public fun hasSavedGames() : Boolean{
    return readGamesNames().size != 0
}
