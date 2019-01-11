package ioManager

import game.Game
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.Date

internal const val SAVES_FOLDER_NAME : String = "saves"
internal const val SCORES_FOLDER_NAME : String = "$SAVES_FOLDER_NAME\\scores"
internal const val GAMES_FOLDER_NAME : String = "$SAVES_FOLDER_NAME\\games"

private const val MAX_LAST_SCORES : Int = 10000
private const val MAX_BEST_SCORES : Int = 10

public fun save(score : Int, n : Int){
    val scoresFolder : File = File(SCORES_FOLDER_NAME)
    if(!(scoresFolder.exists())){
        scoresFolder.mkdirs()
    }
    val nLastName : String = "$SCORES_FOLDER_NAME\\${n}l"
    val nBestName : String = "$SCORES_FOLDER_NAME\\${n}b"
    val nFileLast : File = File(nLastName).also { if(!(it.exists())) it.createNewFile() }
    val nFileBest : File = File(nBestName).also { if(!(it.exists())) it.createNewFile() }
    val nBest : ArrayList<Int> = readBestScores(n)
    val nLast : ArrayList<Int> = readLastScores(n)

    var placedInBest : Boolean = false
    for(i : Int in 0 until nBest.size){ //Insertion sort
        if(score >= nBest[i]){
            nBest.add(i, score)
            placedInBest = true
            break
        }
    }
    if(!placedInBest){
        nBest.add(score)
    }
    if(nBest.size > MAX_BEST_SCORES){
        nBest.remove(nBest[MAX_BEST_SCORES])
    }

    nLast.add(0, score)
    if(nLast.size > MAX_LAST_SCORES){
        nLast.remove(nLast[MAX_LAST_SCORES])
    }

    val bestWriter : BufferedWriter = BufferedWriter(FileWriter(nFileBest))
    val lastWriter : BufferedWriter = BufferedWriter(FileWriter(nFileLast))

    bestWriter.write(nBest[0].toString())
    for(i : Int in 1 until nBest.size){
        bestWriter.newLine()
        bestWriter.write(nBest[i].toString())
    }
    bestWriter.flush()
    bestWriter.close()

    lastWriter.write(nLast[0].toString())
    for(i : Int in 1 until nLast.size){
        lastWriter.newLine()
        lastWriter.write(nLast[i].toString())
    }
    lastWriter.flush()
    lastWriter.close()

}

public fun save(game : Game){
    val gamesFolder : File = File(GAMES_FOLDER_NAME)
    if(!(gamesFolder.exists())){
        gamesFolder.mkdirs()
    }
    val fileName = GAMES_FOLDER_NAME + "\\" + game.n + "-" + game.score + "-" + SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(Date())
    val file : File = File(fileName).also { it.createNewFile() }
    var writer : BufferedWriter = BufferedWriter(FileWriter(fileName, false))
    var notFirstOne : Boolean = false
    for(i : Int in 0 until game.grid.height){
        for(j : Int in 0 until game.grid.width){
            if(!(game.grid.grid[i][j].isEmpty())){
                if(notFirstOne){
                    writer.newLine()
                }else{
                    notFirstOne = true
                }
                writer.write(i.toString() + "-" + j.toString())
            }
        }
    }
    writer.flush()
    writer.close()
}


