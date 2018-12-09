package manager

import main.mainFrame
import screen.startMenu

public class ScreenManager {
    public companion object{
        @JvmStatic
        public fun start(){
            mainFrame.setContentPane(startMenu);
        }
    }
}