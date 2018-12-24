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

    override public fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        g!!.color = foreground
        g!!.fillRect(0, 0, bounds.width, 5)
        g!!.fillRect(0, 0, 5, bounds.height)
        g!!.fillRect(bounds.width - 5, 0, bounds.width, bounds.height)
        g!!.fillRect(0, bounds.height - 5, bounds.width, bounds.height)
    }

}

public fun initExitButton() : Button{
    var result : Button = Button(EXIT_ACTION)
    result.font = DEFAULT_BUTTON_FONT
    result.background = DEFAULT_BUTTON_COLOR
    result.horizontalAlignment = JLabel.CENTER
    result.verticalAlignment = JLabel.CENTER
    result.text = "X"
    result.setBounds(EXIT_BUTTON_X, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT)
    return result
}

public fun initStartButton() : Button{
    var result : Button = Button(START_ACTION)
    result.font = DEFAULT_BUTTON_FONT
    result.background = DEFAULT_BUTTON_COLOR
    result.horizontalAlignment = JLabel.CENTER
    result.verticalAlignment = JLabel.CENTER
    result.text = "Start"
    result.setBounds(START_BUTTON_X, START_BUTTON_Y, START_BUTTON_WIDTH, START_BUTTON_HEIGHT)
    return result
}

public fun initOptionsButton() : Button{
    var result : Button = Button(OPTIONS_ACTION)
    result.font = DEFAULT_BUTTON_FONT
    result.background = DEFAULT_BUTTON_COLOR
    result.horizontalAlignment = JLabel.CENTER
    result.verticalAlignment = JLabel.CENTER
    result.text = "Options"
    result.setBounds(OPTIONS_BUTTON_X, OPTIONS_BUTTON_Y, OPTIONS_BUTTON_WIDTH, OPTIONS_BUTTON_HEIGHT)
    return result
}

public fun initStatsButton() : Button{
    var result : Button = Button(STATS_ACTION)
    result.font = DEFAULT_BUTTON_FONT
    result.background = DEFAULT_BUTTON_COLOR
    result.horizontalAlignment = JLabel.CENTER
    result.verticalAlignment = JLabel.CENTER
    result.text = "Stats"
    result.setBounds(STATS_BUTTON_X, STATS_BUTTON_Y, STATS_BUTTON_WIDTH, STATS_BUTTON_HEIGHT)
    return result
}





