package screen

import javax.swing.JLabel
import main.Action
import java.awt.Graphics

class Button(onClick : Action) : JLabel(){
    
    private var action : Action = {}
    
    init{
        this.action = onClick
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
        g!!.fillRect(0, 0, bounds.width, 5)
        g!!.fillRect(0, 0, 5, bounds.height)
        g!!.fillRect(bounds.width - 5, 0, bounds.width, bounds.height)
        g!!.fillRect(0, bounds.height - 5, bounds.width, bounds.height)
    }

}
