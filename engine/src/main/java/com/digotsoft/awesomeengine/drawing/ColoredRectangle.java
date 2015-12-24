package com.digotsoft.awesomeengine.drawing;

import com.digotsoft.awesomeengine.math.Vector2D;
import com.digotsoft.awesomeengine.math.Rectangle;
import com.digotsoft.awesomeengine.util.Color;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author Digot
 * @version 1.0
 */
public class ColoredRectangle extends Rectangle {

    private Color color;

    public ColoredRectangle(Vector2D position, int width, int height, Color color) {
        super(position, width, height, 0);
        this.color = color;
    }

    @Override
    public void render() {
        //Set the color
        glColor3f(color.getR(), color.getG(), color.getB());

        //Rotate
        glPushMatrix();
        glTranslatef((float) getPosition().getX() + getWidth() * 0.5f, (float) getPosition().getY() + getHeight() * 0.5f, 0f); // move to the proper position
        glRotatef((float) getRotation(), 0, 0, 1);

        //Draw the quad
        glBegin(GL_QUADS);

            glVertex2d(-getWidth() * 0.5, -getHeight() * 0.5);
            glVertex2d(getWidth() * 0.5, -getHeight() * 0.5);
            glVertex2d(getWidth() *0.5, getHeight() * 0.5);
            glVertex2d(-getWidth() * 0.5, getHeight() * 0.5);

        glEnd();

        //Reset the rotation
        glPopMatrix();

        //Reset the color
        glColor3f(1f, 1f, 1f);
    }

    @Override
    public void dispose() {

    }
}
