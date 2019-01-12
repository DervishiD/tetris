package display.button

import main.*
import java.awt.Color
import java.awt.FontMetrics
import java.awt.Graphics

public open class Selector(xPos : Int, yPos : Int, options : ArrayList<String>) : Button({}, xPos, yPos) {

    companion object {
        @JvmStatic protected val C1 : Color = Color(0, 100, 128)
        @JvmStatic protected val C2 : Color = Color(128, 100, 0)
        @JvmStatic protected val C_NIGHT : Color = textColor
        @JvmStatic protected val arrowWidth : Int = 20
        @JvmStatic protected fun arrowColor() : Color{
            return if(nightMode){
                C_NIGHT
            }else{
                if(distance(backgroundColor, C1) > distance(backgroundColor, C2)){
                    C1
                }else C2
            }
        }
    }

    private val options : ArrayList<String> = options
    protected var currentOption : Int = 0

    protected lateinit var fm : FontMetrics
    protected var isActivated : Boolean = false

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
        val s : String = selectedOption()
        val width : Int = fm.stringWidth(s) + 14
        val height : Int = fm.maxAscent + fm.maxDescent
        setBounds(xPos - width / 2 - arrowWidth, yPos - height / 2, width + 2 * arrowWidth, height)
        g.color = if(hasFocus) focusColor else textColor
        g.drawString(s, 7 + arrowWidth, height - 7)
        g.fillRect(arrowWidth, 0, width, 5)
        g.fillRect(arrowWidth, 0, 5, bounds.height)
        g.fillRect(bounds.width - 5 - arrowWidth, 0, 5, bounds.height)
        g.fillRect(arrowWidth, bounds.height - 5, width, bounds.height)
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