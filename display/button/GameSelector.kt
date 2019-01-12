package display.button

import ioManager.SEPARATOR
import ioManager.readGamesNames
import main.focusColor
import main.textColor
import java.awt.Graphics

class GameSelector(xPos : Int, yPos : Int) : Selector(xPos, yPos, readGamesNames()) {

    companion object {
        @JvmStatic private val DATE_SEPARATOR : String = "/"
        @JvmStatic private val TIME_SEPARATOR : String = ":"
        @JvmStatic private val DATE_TIME_SEPARATOR : String = " "
    }

    public override fun paintComponent(g: Graphics?) {
        val nameData : List<String> = selectedOption().split(SEPARATOR)
        val nString : String = nameData[0]
        val scoreString : String = nameData[1]
        val timeString : String =
            nameData[2] + DATE_SEPARATOR + nameData[3] + DATE_SEPARATOR + nameData[4] +
            DATE_TIME_SEPARATOR +
            nameData[5] + TIME_SEPARATOR + nameData[6] + TIME_SEPARATOR + nameData[7]
        fm = g!!.getFontMetrics(font)
        val width : Int = fm.stringWidth("         $timeString") + 14
        val height : Int = fm.maxAscent + fm.maxDescent + 2
        setBounds(xPos - width / 2 - arrowWidth,
                  yPos - 3 * height / 2,
               width + 2 * arrowWidth,
              3 * height)
        g.color = if(hasFocus) focusColor else textColor
        g.fillRect(arrowWidth, 0, width, 5)
        g.fillRect(arrowWidth, 0, 5, bounds.height)
        g.fillRect(bounds.width - 5 - arrowWidth, 0, 5, bounds.height)
        g.fillRect(arrowWidth, bounds.height - 5, width, bounds.height)
        g.drawString("Blocks : $nString", arrowWidth + 7, height - 3)
        g.drawString("Score  : $scoreString", arrowWidth + 7, 2 * (height - 3))
        g.drawString("Date   : $timeString" , arrowWidth + 7, 3 * (height - 3))
        if(isActivated){
            g.color = arrowColor()
            g.fillPolygon(
                intArrayOf(0, arrowWidth, arrowWidth),
                intArrayOf(height / 2, 0, height),
                3)
            g.fillPolygon(
                intArrayOf(bounds.width, arrowWidth + width, arrowWidth + width),
                intArrayOf(height / 2, 0, height),
                3)
        }
    }

}