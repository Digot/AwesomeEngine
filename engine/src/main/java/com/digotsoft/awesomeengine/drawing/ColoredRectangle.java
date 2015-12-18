package com.digotsoft.awesomeengine.drawing;

import com.digotsoft.awesomeengine.math.Vector2D;
import com.digotsoft.awesomeengine.math.Rectangle;
import com.digotsoft.awesomeengine.util.Color;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author Digot
 * @version 1.0
 */
public class ColoredRectangle extends Rectangle {

    private Color color;

    public ColoredRectangle(Vector2D position, int width, int height, Color color) {
        super(position, width, height);
        this.color = color;
    }

    @Override
    public void render() {
        glBegin(GL_QUADS);

        //Set the color
        glColor3f(color.getR(), color.getG(), color.getB());

        //Draw the quad
        glVertex2d(getPosition().getX(), getPosition().getY());
        glVertex2d(getPosition().getX() + getWidth(), getPosition().getY());
        glVertex2d(getPosition().getX() + getWidth(), getPosition().getY() +  getHeight());
        glVertex2d(getPosition().getX(), getPosition().getY() + getHeight());

        //Reset the color
        glColor3f(1f, 1f, 1f);

        glEnd();
    }

    @Override
    public void dispose() {

    }
}
