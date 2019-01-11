package display.screen

import display.DEFAULT_BUTTON_FONT
import display.ScreenManager
import game.Block
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
            LEFT -> game.nmino.moveLeft()
            RIGHT -> game.nmino.moveRight()
            DOWN -> game.fastDescent = !(game.fastDescent)
            ENTER -> game.nmino.rotate()
            ESCAPE -> {game.pause()
                       ScreenManager.setScreen(PauseScreen(this))}
        }
    }

    public override fun save() {
        //NOTHING
    }

    public override fun paintComponent(g: Graphics?) {
        fillBackground(g!!)
        drawGrid(game.grid, g)
        drawNMino(g)
        drawScore(g)
    }

    private fun fillBackground(g : Graphics){
        g.color = backgroundColor
        g.fillRect(0, 0, FRAMEX, FRAMEY)
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
            drawBlock(x, y, squareSize, c, g)
        }
    }

    private fun drawBlock(x : Int, y : Int, s : Int, c : Color, g : Graphics){
        g.color = c
        g.fillRect(x, y, s, s)
        g.color = if(distance(c, Color.BLACK) > distance(c, Color.WHITE)) Color.BLACK else if(nightMode) NIGHT_TEXT else Color.WHITE
        g.fillRect(x + s * 2 / 3, y + s / 6, s / 6, s * 2 / 3)
        g.fillRect(x + s / 6, y + s * 2 / 3, s * 2 / 3, s / 6)
    }

    private fun drawNMino(g : Graphics){
        for(b : Block in game.nmino.blocks){
            drawBlock(FRAMEX / 2 - game.grid.width * game.grid.squareSize / 2 + b.j * game.grid.squareSize,
                    b.i * game.grid.squareSize,
                    game.grid.squareSize,
                    b.color,
                    g)
        }
    }

    private fun drawScore(g : Graphics){
        g.color = textColor
        g.font = DEFAULT_BUTTON_FONT
        g.drawString("Score : " + (game.score).toString(), 0, FRAMEY / 2)
        g.drawString("Tick : " + game.tick().toString() + " ms", 0, FRAMEY * 3 / 5)
    }

}