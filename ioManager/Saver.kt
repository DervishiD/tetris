package ioManager

import game.Game
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.Date
//TODO -- REDO SCORE SAVING TO SAVE ONLY GIVEN MAX NUMBER OF SCORES AND NOT SORT THEM.
//TODO -- OR ACTUALLY SAVE THE BEST SCORES SOMEWHERE AND THE LAST N SCORES SOMEWHERE ELSE.
//TODO -- THAT WOULD BE A GOOD IDEA. DO THAT.
private const val SAVES_FOLDER_NAME : String = "saves"
private const val SCORES_FILE_NAME : String = "$SAVES_FOLDER_NAME\\scores"
private const val GAMES_FOLDER_NAME : String = "$SAVES_FOLDER_NAME\\games"

public fun save(score : Int, n : Int){
    var file : File = File(SCORES_FILE_NAME)
    if(!(file.exists())){
        file.createNewFile()
    }
    var writer : BufferedWriter = BufferedWriter(FileWriter(SCORES_FILE_NAME, scoresFileExists()))
    if(file.length() != 0.toLong()){
        writer.newLine()
    }
    writer.write(n.toString() + "-" + score.toString())
    writer.flush()
    writer.close()
}

public fun save(game : Game){
    if(!(gamesFolderExists())){
        File(GAMES_FOLDER_NAME).mkdir()
    }
    val fileName = GAMES_FOLDER_NAME + "\\" + game.n + "-" + game.score + "-" + SimpleDateFormat("-yyyy/MM/dd-HH:mm:ss").format(Date())
    val file : File = File(fileName).also { it.createNewFile() }
    var writer : BufferedWriter = BufferedWriter(FileWriter(fileName, false))
    for(i : Int in 0 until game.grid.height){
        for(j : Int in 0 until game.grid.width){
            if(!(game.grid.grid[i][j].isEmpty())){
                if(file.length() != 0.toLong()){
                    writer.newLine()
                }
                writer.write(i.toString() + "-" + j.toString())
            }
        }
    }
    writer.flush()
    writer.close()
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


