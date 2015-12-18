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
        super(position, width, height);
        this.texture = texture;
    }

    @Override
    public void render() {
        //prepare the texture
        glEnable(GL_TEXTURE_2D);
        glBindTexture(GL_TEXTURE_2D, texture.getTextureID());

        glBegin(GL_QUADS);

        //Draw the quad
        glTexCoord2f(0, 0);
        glVertex2d(getPosition().getX(), getPosition().getY());
        glTexCoord2f(1, 0);
        glVertex2d(getPosition().getX() + getWidth(), getPosition().getY());
        glTexCoord2f(1, 1);
        glVertex2d(getPosition().getX() + getWidth(), getPosition().getY() + getHeight());
        glTexCoord2f(0, 1);
        glVertex2d(getPosition().getX(), getPosition().getY() + getHeight());

        glEnd();

        //TODO Maybe remove  - may cause bugs
        glBindTexture(GL_TEXTURE_2D, 0);
        glDisable(GL_TEXTURE_2D);


    }

    @Override
    public void dispose() {
        this.texture.dispose();
    }
}
