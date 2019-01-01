package display.button

import main.focusColor
import main.textColor
import java.awt.FontMetrics
import java.awt.Graphics

public open class Selector(xPos : Int, yPos : Int, options : ArrayList<String>) : Button({}, xPos, yPos) {

    companion object {
        @JvmStatic
        protected val arrowWidth : Int = 20
        @JvmStatic
        protected val ARROW_COLOR : java.awt.Color = java.awt.Color(150, 100, 30) // TODO -- HARDCODED COLOUR
    }

    private var options : ArrayList<String> = options
    protected var currentOption = 0

    private lateinit var fm : FontMetrics
    protected var isActivated = false

    init{
        if(options.isEmpty())
            throw IllegalArgumentException("A Selector must select something. This Selector is empty.")
    }

    public fun next(){
        if(currentOption == options.size - 1){
            currentOption = 0
        }else{
            ++currentOption
        }
    }

    public fun previous(){
        if(currentOption == 0){
            currentOption = options.size - 1
        }else{
            --currentOption
        }
    }

    public fun selectedOption() : String{
        return options[currentOption]
    }

    public fun activate(){
        isActivated = true
    }

    public fun deactivate(){
        isActivated = false
    }

    public fun reset(){
        currentOption = 0
    }

    public override fun paintComponent(g: Graphics?) {
        fm = g!!.getFontMetrics(font)
        var s : String = selectedOption()
        var width : Int = fm.stringWidth(s) + 14
        var height : Int = fm.maxAscent + fm.maxDescent
        setBounds(xPos - width / 2 - arrowWidth, yPos - height / 2, width + 2 * arrowWidth, height)
        g!!.color = if(hasFocus) focusColor else textColor
        g!!.drawString(s, 7 + arrowWidth, height - 7)
        g!!.fillRect(arrowWidth, 0, width, 5)
        g!!.fillRect(arrowWidth, 0, 5, bounds.height)
        g!!.fillRect(bounds.width - 5 - arrowWidth, 0, 5, bounds.height)
        g!!.fillRect(arrowWidth, bounds.height - 5, width, bounds.height)
        if(isActivated){
            g!!.color = ARROW_COLOR
            g!!.fillPolygon(
                    intArrayOf(0, arrowWidth, arrowWidth),
                    intArrayOf(height / 2, 0, height),
                    3)
            g!!.fillPolygon(
                    intArrayOf(bounds.width, arrowWidth + width, arrowWidth + width),
                    intArrayOf(height / 2, 0, height),
                    3)
        }
    }

}