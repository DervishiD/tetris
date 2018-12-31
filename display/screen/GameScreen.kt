package display.screen

import game.Game
import game.Grid
import main.*
import java.awt.Color
import java.awt.Graphics
import main.Key.*

public class GameScreen(game : Game) : Screen() {

    private var game : Game = game

    init{
        previousScreen = this
        startGameTimer()
    }

    public override fun reactTo(key: Key) {
        when(key){
            LEFT -> game.nmino?.moveLeft()
            RIGHT -> game.nmino?.moveRight()
            DOWN ->
                {game.nmino?.moveDown()
                 game.nmino?.moveDown()}
            ENTER -> game.nmino?.rotate()
            ESCAPE -> println("TODO -- PAUSE MENU")
        }
    }

    public override fun save() {
        //TODO
    }

    public override fun paintComponent(g: Graphics?) {
        g!!.color = backgroundColor
        g.fillRect(0, 0, FRAMEX, FRAMEY)
        drawGrid(game.grid, g)
    }

    private fun drawGrid(grid : Grid, g : Graphics){
        var x : Int = FRAMEX / 2 - grid.width * grid.squareSize / 2
        for(i : Int in 0 until grid.height){
            for(j : Int in 0 until grid.width){
                drawCell(x + grid.squareSize * j, grid.squareSize * i, grid.grid[i][j].color(), g)
            }
        }
    }

    private fun drawCell(x : Int, y : Int, c : Color?, g : Graphics){
        val squareSize : Int = game.grid.squareSize
        if(c == null){
            g.color = textColor
            g.drawRect(x, y, squareSize, squareSize)
        }else{
            g.color = c
            g.fillRect(x, y, squareSize, squareSize)
            g.color = if(distance(c, Color.BLACK) > distance(c, Color.WHITE)) Color.BLACK else if(nightMode) NIGHT_TEXT else Color.WHITE
            g.fillRect(x + squareSize * 2 / 3, y + squareSize / 6, squareSize / 6, squareSize * 2 / 3)
            g.fillRect(x + squareSize / 6, y + squareSize * 2 / 3, squareSize * 2 / 3, squareSize / 6)
        }
    }


}