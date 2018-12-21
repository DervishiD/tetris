package screen

import javax.swing.JLabel
import main.Action

class Button(onClick : Action) : JLabel(){
    
    private var action : Action = {};
    
    init{
        this.action = onClick;
    }
    
    public fun click(){
        action.invoke();
    }
    
    public fun focus(){
        //CHANGE IMAGE
    }
    
    public fun unfocus(){
        //CHANGE IMAGE
    }
    
}

public fun initExitButton() : Button{
    var result : Button = Button(EXIT_ACTION);
    result.setFont(DEFAULT_BUTTON_FONT);
    result.setBackground(DEFAULT_BUTTON_COLOR);
    result.setText("X");
    result.setBounds(EXIT_BUTTON_X, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
    return result;
}

public fun initStartButton() : Button{
    var result : Button = Button(START_ACTION);
    result.setFont(DEFAULT_BUTTON_FONT);
    result.setBackground(DEFAULT_BUTTON_COLOR);
    result.setText("Start");
    result.setBounds(START_BUTTON_X, START_BUTTON_Y, START_BUTTON_WIDTH, START_BUTTON_HEIGHT);
    return result;
}

public fun initOptionsButton() : Button{
    var result : Button = Button(OPTIONS_ACTION);
    result.setFont(DEFAULT_BUTTON_FONT);
    result.setBackground(DEFAULT_BUTTON_COLOR);
    result.setText("Options");
    result.setBounds(OPTIONS_BUTTON_X, OPTIONS_BUTTON_Y, OPTIONS_BUTTON_WIDTH, OPTIONS_BUTTON_HEIGHT);
    return result;
}

public fun initStatsButton() : Button{
    var result : Button = Button(STATS_ACTION);
    result.setFont(DEFAULT_BUTTON_FONT);
    result.setBackground(DEFAULT_BUTTON_COLOR);
    result.setText("Stats");
    result.setBounds(STATS_BUTTON_X, STATS_BUTTON_Y, STATS_BUTTON_WIDTH, STATS_BUTTON_HEIGHT);
    return result;
}





