package screen

import javax.swing.JLabel
import main.Action

class Button(a : Action) : JLabel(){
    
    private var action : Action = {};
    
    init{
        this.action = a;
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





