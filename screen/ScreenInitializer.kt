package screen

import javax.swing.JLabel.CENTER

public val startMenu : MainMenuScreen by lazy{MainMenuScreen()}
public val newGameScreen : NewGameScreen by lazy{NewGameScreen()}
public val exitScreen : ExitScreen by lazy{ExitScreen()}

public val exitButton : Button by lazy{initExitButton()}
public val newGameButton : Button by lazy{initNewGameButton()}
public val loadGameButton : Button by lazy{initLoadGameButton()}
public val optionsButton : Button by lazy{initOptionsButton()}
public val statsButton : Button by lazy{initStatsButton()}

public val backButton : Button by lazy{initBackButton()}

public val confirmExitButton : Button by lazy{initConfirmExitButton()}
public val dismissExitButton : Button by lazy{initDismissExitButton()}

public fun initExitButton() : Button{
    var result : Button = Button(EXIT_ACTION)
    result.font = DEFAULT_BUTTON_FONT
    result.background = DEFAULT_BUTTON_COLOR
    result.horizontalAlignment = CENTER
    result.verticalAlignment = CENTER
    result.text = "X"
    result.setBounds(EXIT_BUTTON_X, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT)
    return result
}

public fun initNewGameButton() : Button{
    var result : Button = Button(NEW_GAME_ACTION)
    result.font = DEFAULT_BUTTON_FONT
    result.background = DEFAULT_BUTTON_COLOR
    result.horizontalAlignment = CENTER
    result.verticalAlignment = CENTER
    result.text = "New Game"
    result.setBounds(NEW_GAME_BUTTON_X, NEW_GAME_BUTTON_Y, NEW_GAME_BUTTON_WIDTH, NEW_GAME_BUTTON_HEIGHT)
    return result
}

public fun initLoadGameButton() : Button{
    var result : Button = Button(LOAD_GAME_ACTION)
    result.font = DEFAULT_BUTTON_FONT
    result.background = DEFAULT_BUTTON_COLOR
    result.horizontalAlignment = CENTER
    result.verticalAlignment = CENTER
    result.text = "Load Game"
    result.setBounds(LOAD_GAME_BUTTON_X, LOAD_GAME_BUTTON_Y, LOAD_GAME_BUTTON_WIDTH, LOAD_GAME_BUTTON_HEIGHT)
    return result
}

public fun initOptionsButton() : Button{
    var result : Button = Button(OPTIONS_ACTION)
    result.font = DEFAULT_BUTTON_FONT
    result.background = DEFAULT_BUTTON_COLOR
    result.horizontalAlignment = CENTER
    result.verticalAlignment = CENTER
    result.text = "Options"
    result.setBounds(OPTIONS_BUTTON_X, OPTIONS_BUTTON_Y, OPTIONS_BUTTON_WIDTH, OPTIONS_BUTTON_HEIGHT)
    return result
}

public fun initStatsButton() : Button{
    var result : Button = Button(STATS_ACTION)
    result.font = DEFAULT_BUTTON_FONT
    result.background = DEFAULT_BUTTON_COLOR
    result.horizontalAlignment = CENTER
    result.verticalAlignment = CENTER
    result.text = "Stats"
    result.setBounds(STATS_BUTTON_X, STATS_BUTTON_Y, STATS_BUTTON_WIDTH, STATS_BUTTON_HEIGHT)
    return result
}

public fun initBackButton() : Button{
    var result : Button = Button(BACK_ACTION)
    result.font = DEFAULT_BUTTON_FONT
    result.background = DEFAULT_BUTTON_COLOR
    result.horizontalAlignment = CENTER
    result.verticalAlignment = CENTER
    result.text = "<-"
    result.setBounds(BACK_BUTTON_X, BACK_BUTTON_Y, BACK_BUTTON_WIDTH, BACK_BUTTON_HEIGHT)
    return result
}

public fun initConfirmExitButton() : Button{
    var result : Button = Button(CONFIRM_EXIT_ACTION)
    result.font = DEFAULT_BUTTON_FONT
    result.background = DEFAULT_BUTTON_COLOR
    result.horizontalAlignment = CENTER
    result.verticalAlignment = CENTER
    result.text = "Confirm"
    result.setBounds(CONFIRM_EXIT_BUTTON_X, CONFIRM_EXIT_BUTTON_Y, CONFIRM_EXIT_BUTTON_WIDTH, CONFIRM_EXIT_BUTTON_HEIGHT)
    return result
}

public fun initDismissExitButton() : Button{
    var result : Button = Button(BACK_ACTION)
    result.font = DEFAULT_BUTTON_FONT
    result.background = DEFAULT_BUTTON_COLOR
    result.horizontalAlignment = CENTER
    result.verticalAlignment = CENTER
    result.text = "Dismiss"
    result.setBounds(DISMISS_EXIT_BUTTON_X, DISMISS_EXIT_BUTTON_Y, DISMISS_EXIT_BUTTON_WIDTH, DISMISS_EXIT_BUTTON_HEIGHT)
    return result
}





