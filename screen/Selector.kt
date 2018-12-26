package screen

import main.Action
import main.TEXT_COLOR
import java.awt.FontMetrics
import java.awt.Graphics

class Selector(xPos : Int, yPos : Int, onClick: Action, options : ArrayList<String>) : Button(onClick) {

    private var options : ArrayList<String> = options
    private var currentOption = 0

    private lateinit var fm : FontMetrics
    private var xPos : Int = xPos
    private var yPos : Int = yPos

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

    public override fun paintComponent(g: Graphics?) {
        super.paintComponent(g) //TODO
        fm = g!!.getFontMetrics(font)
        var s : String = selectedOption()
        var width : Int = fm.stringWidth(s) + 14
        var height : Int = fm.maxAscent + fm.maxDescent + 14
        setBounds(xPos - width / 2, yPos - height / 2, width, height)
        g!!.color = TEXT_COLOR
        g!!.drawString(s, 7, height - 7)
        g!!.color = foreground
        g!!.fillRect(0, 0, bounds.width, 5)
        g!!.fillRect(0, 0, 5, bounds.height)
        g!!.fillRect(bounds.width - 5, 0, bounds.width, bounds.height)
        g!!.fillRect(0, bounds.height - 5, bounds.width, bounds.height)
    }

}