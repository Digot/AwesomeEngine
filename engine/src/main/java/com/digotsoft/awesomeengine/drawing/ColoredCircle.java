package com.digotsoft.awesomeengine.drawing;

import com.digotsoft.awesomeengine.math.Circle;
import com.digotsoft.awesomeengine.math.Vector2D;
import com.digotsoft.awesomeengine.util.Color;
import lombok.Getter;
import lombok.Setter;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author Digot
 * @version 1.0
 */
@Getter
@Setter
public class ColoredCircle extends Circle {

    private Color color;

    public ColoredCircle(Vector2D position, float radius, Color color) {
        super(position, radius);
        this.color = color;
    }

    @Override
    public void render() {

        int i;
        int triangleAmount = 20; //# of triangles used to draw circle

        //GLfloat radius = 0.8f; //radius
        float twicePi = (float) (2.0f * Math.PI);

        glBegin(GL_TRIANGLE_FAN);
        glVertex2d(getPosition().getX(), getPosition().getY()); // center of circle
        for(i = 0; i <= triangleAmount;i++) {
            glVertex2d(
                    getPosition().getX() + (getRadius() * Math.cos(i *  twicePi / triangleAmount)),
                    getPosition().getY() + (getRadius() * Math.sin(i * twicePi / triangleAmount))
            );
        }
        glEnd();

    }

    @Override
    public void dispose() {

    }
}
