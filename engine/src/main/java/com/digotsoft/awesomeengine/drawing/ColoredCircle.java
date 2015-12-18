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

    public ColoredCircle(Vector2D position, double radius, Color color) {
        super(position, radius);
        this.color = color;
    }

    @Override
    public void render() {
        glBegin(GL_LINE_LOOP);

        for(int i =0; i <= 300; i++){
            double angle = 2 * Math.PI * i / 300;
            double x = Math.cos(angle);
            double y = Math.sin(angle);
            glVertex2d(x,y);
        }

        glEnd();
    }

    @Override
    public void dispose() {

    }
}
