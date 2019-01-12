package display

import display.screen.Screen
import main.Key
import main.mainFrame

public class ScreenManager {
    public companion object{
        
        @JvmStatic private var currentScreen : Screen = startMenu

        @JvmStatic private var previousScreen : Screen = startMenu

        @JvmStatic public fun start(){
            mainFrame.contentPane = startMenu
            currentScreen = startMenu
        }

        @JvmStatic public fun toPreviousScreen(){
            currentScreen.save()
            currentScreen = currentScreen.previousScreen()
            previousScreen = currentScreen.previousScreen()
            mainFrame.contentPane = currentScreen
        }

        @JvmStatic public fun setScreen(screen : Screen){
            currentScreen.save()
            previousScreen = currentScreen.previousScreen()
            currentScreen = screen
            mainFrame.contentPane = currentScreen
        }

        @JvmStatic public fun currentScreen() : Screen{
            return currentScreen
        }

        @JvmStatic public fun reactToKey(code : Int){
            for(key : Key in Key.values()){
                if(key.correspondsTo(code)){
                    currentScreen.reactTo(key)
                    return
                }
            }
        }
        
    }
}







