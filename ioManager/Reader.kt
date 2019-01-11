package ioManager

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

public fun readBestScores(n : Int) : ArrayList<Int>{
    val file : File = File("$SCORES_FOLDER_NAME\\${n}b") //must exist if this is called
    val reader : BufferedReader = BufferedReader(FileReader(file))
    var result : ArrayList<Int> = ArrayList<Int>()
    for(line : String in reader.lines()){
        result.add(line.toInt())
    }
    return result
}

public fun readLastScores(n : Int) : ArrayList<Int>{
    val file : File = File("$SCORES_FOLDER_NAME\\${n}l") //must exist if this is called
    val reader : BufferedReader = BufferedReader(FileReader(file))
    var result : ArrayList<Int> = ArrayList<Int>()
    for(line : String in reader.lines()){
        result.add(line.toInt())
    }
    return result
}


