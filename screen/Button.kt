package screen

import java.awt.Graphics
import javax.swing.JLabel
import main.Action
import main.mainFrame

open class Button(onClick : Action, xPos : Int, yPos : Int, name : String = "") : JLabel(){
    
    private var action : Action = onClick
    protected var xPos : Int = xPos
    protected var yPos : Int = yPos
    private var txt : String = name

    init{
        font = DEFAULT_BUTTON_FONT
        var fm = mainFrame.contentPane.graphics.getFontMetrics(DEFAULT_BUTTON_FONT)
        var width = fm.stringWidth(txt) + 14
        var height = fm.maxAscent + fm.maxDescent
        setBounds(xPos - width / 2, yPos - height / 2, width, height)
    }

    public fun click(){
        action.invoke()
    }
    
    public fun focus(){
        foreground = FOCUS_BUTTON_TEXT_COLOR
    }
    
    public fun unfocus(){
        foreground = UNFOCUS_BUTTON_TEXT_COLOR
    }

    public override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        g!!.color = foreground
        g!!.drawString(txt, 7, bounds.height - 7)
        g!!.fillRect(0, 0, bounds.width, 5)
        g!!.fillRect(0, 0, 5, bounds.height)
        g!!.fillRect(bounds.width - 5, 0, bounds.width, bounds.height)
        g!!.fillRect(0, bounds.height - 5, bounds.width, bounds.height)
    }

}
