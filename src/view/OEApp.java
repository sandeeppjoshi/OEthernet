package view;

import java.applet.Applet;
import java.awt.*;

public class OEApp extends Applet{

    Button button = new Button("Some Button");

    public void init(){
        setLayout(new BorderLayout());
        Panel panel = new Panel();
        add(panel,"Center");

    }
    public void stop(){

    }

    public void paint(Graphics graphics){
        graphics.drawString("Hello",20,10);
    }

}
