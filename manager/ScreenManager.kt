package manager

import main.Key
import main.mainFrame
import screen.Screen
import screen.startMenu
import screen.gameLaunchingScreen

public class ScreenManager {
    public companion object{
        
        @JvmStatic
        private var currentScreen : Screen = startMenu;
        
        @JvmStatic
        public fun start(){
            mainFrame.setContentPane(startMenu);
            currentScreen = startMenu;
        }
        
        @JvmStatic
        public fun gameLaunchMenu(){
            setScreen(gameLaunchingScreen);
        }
        
        @JvmStatic
        private fun setScreen(screen : Screen){
            currentScreen.save();
            mainFrame.setContentPane(screen);
            currentScreen = screen;
        }
        
        @JvmStatic
        public fun reactToKey(code : Int){
            for(key : Key in Key.values()){
                if(key.correspondsTo(code)){
                    currentScreen.reactTo(key);
                    return;
                }
            }
        }
        
    }
}







