package manager

import main.mainFrame
import screen.startMenu
import screen.gameLaunchingScreen

public class ScreenManager {
    public companion object{
        @JvmStatic
        public fun start(){
            mainFrame.setContentPane(startMenu);
        }
        
        @JvmStatic
        public fun gameLaunchMenu(){
            mainFrame.setContentPane(gameLaunchingScreen);
        }
    }
}