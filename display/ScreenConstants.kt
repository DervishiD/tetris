package display

import display.ScreenManager.Companion.currentScreen
import display.button.GameSelector
import display.screen.GameScreen
import display.screen.LoadGameScreen
import display.screen.Screen
import game.Game
import ioManager.hasSavedGames
import ioManager.readGame
import ioManager.save
import main.*
import java.awt.Font
import java.awt.Font.BOLD
import java.awt.event.WindowEvent
import java.awt.event.WindowEvent.WINDOW_CLOSING

public val NEW_GAME_BUTTON_X : Int = FRAMEX / 3
public val NEW_GAME_BUTTON_Y : Int = FRAMEY * 3 / 5

public val LOAD_GAME_BUTTON_X : Int = FRAMEX * 2 / 3
public val LOAD_GAME_BUTTON_Y : Int = NEW_GAME_BUTTON_Y

public val EXIT_BUTTON_X : Int = FRAMEX - 14 //HARDCODED
public const val EXIT_BUTTON_Y : Int = 14 //HARDCODED

public val OPTIONS_BUTTON_X : Int = NEW_GAME_BUTTON_X
public val OPTIONS_BUTTON_Y : Int = FRAMEY * 4 / 5

public val STATS_BUTTON_X : Int = LOAD_GAME_BUTTON_X
public val STATS_BUTTON_Y : Int = OPTIONS_BUTTON_Y

public val BACK_BUTTON_X : Int = FRAMEX - 20 //HARDCODED
public const val BACK_BUTTON_Y : Int = 14 //HARDCODED

public const val TITLE_WIDTH : Int = 150
public const val TITLE_HEIGHT : Int = 100
public val TITLE_X : Int = FRAMEX / 2 - TITLE_WIDTH / 2
public val TITLE_Y : Int = FRAMEY / 3 - TITLE_HEIGHT / 2

public val EXIT_WIDTH : Int = FRAMEX
public const val EXIT_HEIGHT : Int = 100
public const val EXIT_X : Int = 0
public val EXIT_Y : Int = FRAMEY / 5

public val CONFIRM_EXIT_BUTTON_X : Int = FRAMEX / 4
public val CONFIRM_EXIT_BUTTON_Y : Int = FRAMEY * 3 / 5

public val DISMISS_EXIT_BUTTON_X : Int = FRAMEX * 3 / 4
public val DISMISS_EXIT_BUTTON_Y : Int = CONFIRM_EXIT_BUTTON_Y

public val DEFAULT_BUTTON_FONT : Font = Font("Monospaced", BOLD, 24)

public val TITLE_FONT : Font = Font("Monospaced", BOLD, 40)

public val QUESTION_FONT : Font = Font("Monospaced", BOLD, 32)

public val N_QU_WIDTH : Int = FRAMEX
public const val N_QU_HEIGHT : Int = 100
public const val N_QU_X : Int = 0
public val N_QU_Y : Int = FRAMEY / 4

public val N_SELECTOR_X : Int = FRAMEX / 2
public val N_SELECTOR_Y : Int = FRAMEY / 3

public val START_BUTTON_X : Int = N_SELECTOR_X
public val START_BUTTON_Y : Int = FRAMEY / 2

public val OPTIONS_LABEL_WIDTH : Int = FRAMEX
public const val OPTIONS_LABEL_HEIGHT : Int = 100
public const val OPTIONS_LABEL_X : Int = 0
public val OPTIONS_LABEL_Y : Int = FRAMEY / 9

public val R_LABEL_WIDTH : Int = FRAMEX
public const val R_LABEL_HEIGHT : Int = 100
public const val R_LABEL_X : Int = 0
public val R_LABEL_Y : Int = FRAMEY / 3

public val G_LABEL_WIDTH : Int = FRAMEX
public const val G_LABEL_HEIGHT : Int = 100
public const val G_LABEL_X : Int = 0
public val G_LABEL_Y : Int = FRAMEY * 5 / 9

public val B_LABEL_WIDTH : Int = FRAMEX
public const val B_LABEL_HEIGHT : Int = 100
public const val B_LABEL_X : Int = 0
public val B_LABEL_Y : Int = FRAMEY * 7 / 9

public val NIGHT_COLOR_X : Int = FRAMEX / 2
public val NIGHT_COLOR_Y : Int = FRAMEY * 2 / 9

public val R_SELECTOR_Y : Int = FRAMEY * 4 / 9
public val G_SELECTOR_Y : Int = FRAMEY * 2 / 3
public val B_SELECTOR_Y : Int = FRAMEY * 8 / 9

public val COLOR_ARGUMENTS : ArrayList<String> = arrayListOf("16", "32", "48", "64",
                                                             "80", "96", "112", "128",
                                                             "144", "160", "176", "192",
                                                             "208", "224", "240", "255")

public val RESUME_BUTTON_X : Int = FRAMEX / 3
public val RESUME_BUTTON_Y : Int = FRAMEY * 2 / 3

public val SAVE_QUIT_BUTTON_X : Int = FRAMEX * 2 / 3
public val SAVE_QUIT_BUTTON_Y : Int = RESUME_BUTTON_Y

public const val PAUSE_LABEL_X : Int = 0
public val PAUSE_LABEL_Y : Int = FRAMEY / 3
public val PAUSE_LABEL_WIDTH : Int = FRAMEX
public const val PAUSE_LABEL_HEIGHT : Int = 100

public val BACK_TO_MAIN_MENU_X : Int = FRAMEX / 2
public val BACK_TO_MAIN_MENU_Y : Int = FRAMEY * 3 / 4

public val GAME_SELECTOR_X : Int = FRAMEX / 2
public val GAME_SELECTOR_Y : Int = FRAMEY / 2

public const val LOAD_GAME_LABEL_X : Int = 0
public val LOAD_GAME_LABEL_Y : Int = FRAMEY / 4
public val LOAD_GAME_LABEL_WIDTH : Int = FRAMEX
public const val LOAD_GAME_LABEL_HEIGHT : Int = 100

public val LOAD_BUTTON_X : Int = FRAMEX / 2
public val LOAD_BUTTON_Y : Int = FRAMEY * 4 / 5

public val STATS_SELECTOR_X : Int = FRAMEX / 2
public val STATS_SELECTOR_Y : Int = FRAMEY / 3

public const val STATS_LABEL_X : Int = 0
public val STATS_LABEL_Y : Int = FRAMEY / 6
public val STATS_LABEL_WIDTH : Int = FRAMEX
public const val STATS_LABEL_HEIGHT : Int = 100

public val RESUME_ACTION : Action = {
    ScreenManager.toPreviousScreen()
    Game.currentGame!!.resume()
}

public val SAVE_QUIT_ACTION : Action = {
    ScreenManager.setScreen(startMenu)
    save(Game.currentGame!!)
    Game.currentGame = null
}

public val EXIT_ACTION : Action = {
    ScreenManager.setScreen(exitScreen)
}

public val NEW_GAME_ACTION : Action = {
    ScreenManager.setScreen(newGameScreen)
}

public val LOAD_GAME_ACTION : Action = {
    if(hasSavedGames()){
        ScreenManager.setScreen(LoadGameScreen())
    }
}

public val OPTIONS_ACTION : Action = {
    ScreenManager.setScreen(optionsScreen)
}

public val STATS_ACTION : Action = {
    statsScreen.refreshData()
    ScreenManager.setScreen(statsScreen)
}

public val BACK_ACTION : Action = {
    ScreenManager.toPreviousScreen()
}

public val CONFIRM_EXIT_ACTION : Action = {
    mainFrame.isVisible = false
    mainFrame.dispatchEvent(WindowEvent(mainFrame, WINDOW_CLOSING))
}

public val START_ACTION : Action = {
    Game.currentGame = Game(nSelector.selectedOption().toInt())
    ScreenManager.setScreen(GameScreen(Game.currentGame!!))
}

public val NIGHT_COLOR_ACTION : Action = {
    backgroundColor = NIGHT_BACKGROUND
    textColor = NIGHT_TEXT
    focusColor = NIGHT_FOCUS
    nightMode = true
    BACK_ACTION.invoke()
}

public val LOAD_BUTTON_ACTION : Action = {
    Game.currentGame = readGame((currentScreen() as LoadGameScreen).selectedGame())
    ScreenManager.setScreen(GameScreen(Game.currentGame!!))
}


