package display.button

import java.awt.Graphics
import main.FRAMEX
import main.FRAMEY
import main.focusColor
import main.textColor

public class Slider(yPos : Int, options : ArrayList<String>) : Selector(FRAMEX / 2, yPos, options) {

    companion object {
        @JvmStatic private val WIDTH = FRAMEX / 2
        @JvmStatic private val HEIGHT = FRAMEY / 10
    }

    private val size = options.size //Not zero by Selector init
    private val cellWidth = WIDTH / size
    private val baseX = FRAMEX / 4

    init{
        setBounds(baseX - arrowWidth, yPos - HEIGHT / 2, WIDTH + 2 * arrowWidth, HEIGHT)
    }

    public override fun paintComponent(g: Graphics?) {
        g!!.color = if(hasFocus) focusColor else textColor
        for(i : Int in 0..currentOption){
            g!!.fillRect(arrowWidth + i * cellWidth, 0, cellWidth, bounds.height - 1)
        }
        for(i : Int in currentOption + 1 until size){
            g!!.drawRect(arrowWidth + i * cellWidth, 0, cellWidth, bounds.height - 1)
        }
        if(isActivated){
            g!!.color = ARROW_COLOR
            g!!.fillPolygon(
                    intArrayOf(0, arrowWidth, arrowWidth),
                    intArrayOf(bounds.height / 2, 0, bounds.height),
                    3)
            g!!.fillPolygon(
                    intArrayOf(arrowWidth + WIDTH, arrowWidth + WIDTH, bounds.width),
                    intArrayOf(0, bounds.height, bounds.height / 2),
                    3)
        }
    }

}