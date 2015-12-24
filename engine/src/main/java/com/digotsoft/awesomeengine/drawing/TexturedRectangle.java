package com.digotsoft.awesomeengine.drawing;

import com.digotsoft.awesomeengine.math.Vector2D;
import com.digotsoft.awesomeengine.math.Rectangle;
import static org.lwjgl.opengl.GL11.*;

/**
 * @author Digot
 * @version 1.0
 */
public class TexturedRectangle extends Rectangle {

    private Texture texture;

    public TexturedRectangle(Vector2D position, int width, int height, Texture texture) {
        super(position, width, height, 0);
        this.texture = texture;
    }

    @Override
    public void render() {
        //prepare the texture
        glEnable(GL_TEXTURE_2D);
        glBindTexture(GL_TEXTURE_2D, texture.getTextureID());

        //Rotate
        glPushMatrix();
        glTranslatef((float) getPosition().getX() + getWidth() * 0.5f, (float) getPosition().getY() + getHeight() * 0.5f, 0f); // move to the proper position
        glRotatef((float) getRotation(), 0, 0, 1);

        glBegin(GL_QUADS);

        //Draw the quad
        glTexCoord2f(0, 0);
        glVertex2d(-getWidth() * 0.5, -getHeight() * 0.5);
        glTexCoord2f(1, 0);
        glVertex2d(getWidth() * 0.5, -getHeight() * 0.5);
        glTexCoord2f(1, 1);
        glVertex2d(getWidth() *0.5, getHeight() * 0.5);
        glTexCoord2f(0, 1);
        glVertex2d(-getWidth() * 0.5, getHeight() * 0.5);

        glEnd();

        //Reset the rotation
        glPopMatrix();

        //TODO Maybe remove  - may cause bugs
        glBindTexture(GL_TEXTURE_2D, 0);
        glDisable(GL_TEXTURE_2D);


    }

    @Override
    public void dispose() {
        this.texture.dispose();
    }
}
