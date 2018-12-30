package display.screen

import game.Game
import game.Grid
import main.*
import java.awt.Color
import java.awt.Graphics

public class GameScreen(game : Game) : Screen() {

    private var game : Game = game

    init{
        previousScreen = this
    }

    public override fun reactTo(key: Key) {
        //TODO
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
            g.color = if(distance(c, Color.WHITE) >= distance(c, Color.BLACK)) Color.WHITE else Color.BLACK
            g.fillRect(x + squareSize * 2 / 3, y + squareSize / 6, squareSize / 6, squareSize * 2 / 3)
            g.fillRect(x + squareSize / 6, y + squareSize * 2 / 3, squareSize * 2 / 3, squareSize / 6)
        }
    }


}