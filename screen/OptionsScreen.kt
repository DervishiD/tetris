package screen

import main.FRAMEX
import main.FRAMEY
import main.Key

class OptionsScreen : Screen() {

    init{
        this.setBounds(0, 0, FRAMEX, FRAMEY)
        this.layout = null
    }

    public override fun reactTo(key: Key) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    public override fun save() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}