package com.digotsoft.awesomeengine.drawing;

import com.digotsoft.awesomeengine.math.Vector2D;
import com.digotsoft.awesomeengine.object.GameObject;
import org.newdawn.slick.TrueTypeFont;

/**
 * @author Digot
 * @version 1.0
 */
public class Text implements GameObject {

    private TrueTypeFont backedFont;
    private FontStyle fontStyle;
    private String text;
    private Vector2D position;

    public Text(String text, Vector2D position, String fontName, int fontStyle, int size){
        this.text = text;
        this.position = position;
        this.backedFont = new TrueTypeFont(new java.awt.Font(fontName,fontStyle, size), true);
    }


    @Override
    public void render() {
        this.backedFont.drawString((float)position.getX(), (float)position.getY(), text);
    }

    @Override
    public void dispose() {

    }
}
