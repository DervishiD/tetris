package screen

import javax.swing.JLabel
import javax.swing.JLabel.CENTER

//SCREENS-----------------------------------------

public val startMenu : MainMenuScreen by lazy{MainMenuScreen()}
public val newGameScreen : NewGameScreen by lazy{NewGameScreen()}
public val exitScreen : ExitScreen by lazy{ExitScreen()}

//BUTTONS-----------------------------------------

public val exitButton : Button by lazy{Button(EXIT_ACTION, EXIT_BUTTON_X, EXIT_BUTTON_Y, "X")}

public val newGameButton : Button by lazy{Button(NEW_GAME_ACTION, NEW_GAME_BUTTON_X, NEW_GAME_BUTTON_Y, "New Game")}
public val loadGameButton : Button by lazy{Button(LOAD_GAME_ACTION, LOAD_GAME_BUTTON_X, LOAD_GAME_BUTTON_Y, "Load Game")}
public val optionsButton : Button by lazy{Button(OPTIONS_ACTION, OPTIONS_BUTTON_X, OPTIONS_BUTTON_Y, "Options")}
public val statsButton : Button by lazy{Button(STATS_ACTION, STATS_BUTTON_X, STATS_BUTTON_Y, "Stats")}

public val backButton : Button by lazy{Button(BACK_ACTION, BACK_BUTTON_X, BACK_BUTTON_Y, "<-")}

public val confirmExitButton : Button by lazy{Button(CONFIRM_EXIT_ACTION, CONFIRM_EXIT_BUTTON_X, CONFIRM_EXIT_BUTTON_Y, "Confirm")}
public val dismissExitButton : Button by lazy{Button(BACK_ACTION, DISMISS_EXIT_BUTTON_X, DISMISS_EXIT_BUTTON_Y, "Dismiss")}

//SELECTORS-----------------------------------------

public val nSelector : Selector by lazy{Selector(N_SELECTOR_X, N_SELECTOR_Y, arrayListOf("4", "5", "6"))} //TODO -- REFACTOR LIST


//LABELS--------------------------------------------

public val titleLabel : JLabel by lazy{
    var result : JLabel = JLabel("TETRIS")
    result.font = TITLE_FONT
    result.foreground = TITLE_COLOR
    result.horizontalAlignment = CENTER
    result.verticalAlignment = CENTER
    result.setBounds(TITLE_X, TITLE_Y, TITLE_WIDTH, TITLE_HEIGHT)
    result
}

public val nQuestion : JLabel by lazy{
    var result : JLabel = JLabel("Number of blocks per polynomios")
    result.font = QUESTION_FONT
    result.foreground = QUESTION_COLOR
    result.horizontalAlignment = CENTER
    result.verticalAlignment = CENTER
    result.setBounds(N_QU_X, N_QU_Y, N_QU_WIDTH, N_QU_HEIGHT)
    result
}

public val exitQuestion : JLabel by lazy{
    var result : JLabel = JLabel("Are you sure you want to quit?")
    result.font = QUESTION_FONT
    result.foreground = QUESTION_COLOR
    result.horizontalAlignment = CENTER
    result.verticalAlignment = CENTER
    result.setBounds(EXIT_X, EXIT_Y, EXIT_WIDTH, EXIT_HEIGHT)
    result
}


