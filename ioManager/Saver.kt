package ioManager

import game.Game
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

private const val SAVES_FOLDER_NAME : String = "saves"
private val SCORES_FILE_NAME : String = SAVES_FOLDER_NAME + "\\scores"
private val GAMES_FOLDER_NAME : String = SAVES_FOLDER_NAME + "\\games"

public fun save(score : Int){
    var file : File = File(SCORES_FILE_NAME)
    println(file.absolutePath)
    if(!(file.exists())){
        file.createNewFile()
    }
    var writer : BufferedWriter = BufferedWriter(FileWriter(SCORES_FILE_NAME, scoresFileExists()))
    if(file.length() != 0.toLong()){
        writer.newLine()
    }
    writer.write(score.toString())
    writer.flush()
    writer.close()
}

public fun save(game : Game){
    //TODO
}

public fun savesFolderExists() : Boolean{
    return File(SAVES_FOLDER_NAME).isDirectory
}

public fun scoresFileExists() : Boolean{
    return savesFolderExists() && File(SCORES_FILE_NAME).isFile
}

public fun gamesFolderExists() : Boolean{
    return savesFolderExists() && File(GAMES_FOLDER_NAME).isDirectory
}


