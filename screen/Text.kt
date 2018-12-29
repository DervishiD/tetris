package screen

import main.textColor
import java.awt.Font
import java.awt.Graphics
import javax.swing.JLabel

class Text(name : String, f : Font, x : Int, y : Int, w : Int, h : Int) : JLabel() {

    init{
        this.text = name
        this.font = f
        this.foreground = textColor
        this.horizontalAlignment = CENTER
        this.verticalAlignment = CENTER
        this.setBounds(x, y, w, h)
    }

    public override fun paintComponent(g: Graphics?) {
        this.foreground = textColor
        super.paintComponent(g)
    }

}