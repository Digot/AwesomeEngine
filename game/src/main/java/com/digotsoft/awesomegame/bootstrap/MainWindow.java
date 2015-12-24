package com.digotsoft.awesomegame.bootstrap;

import com.digotsoft.awesomeengine.drawing.TexturedRectangle;
import com.digotsoft.awesomeengine.exception.DisplayInitializationException;
import com.digotsoft.awesomeengine.game.GameWindow;
import com.digotsoft.awesomeengine.math.Rectangle;
import com.digotsoft.awesomeengine.math.Vector2D;
import com.digotsoft.awesomeengine.util.*;

/**
 * @author Digot
 * @version 1.0
 */
public class MainWindow extends GameWindow {

    private Rectangle coloredRectangle;

    public MainWindow() throws DisplayInitializationException {
        super("AwesomeGame!", 800, 600);
        Utils.log("Initializing!");
        initialize();
    }

    @Override
    protected void load() {
        Utils.log("Loading objects!");
        coloredRectangle = new TexturedRectangle(new Vector2D(100, 0), 100, 100, Assets.loadTexture("newgrass.png"));
        coloredRectangle.setRotation(0);
        setClearColor(Color.WHITE);
        addObject(coloredRectangle);

       // addObject(new ColoredRectangle(new Vector2D(0,0), 100, 100, Color.BLUE));
       // addObject(new ColoredRectangle(new Vector2D(200,0), 100, 100, Color.BLUE));
       // addObject(new ColoredCircle(new Vector2D(50,50), 100f, Color.BLUE));
    }

    @Override
    protected void render() {

    }

    @Override
    protected void update() {
        if(Input.isKeyDown(Keys.KEY_D)){

            coloredRectangle.setRotation(coloredRectangle.getRotation() + 5);

        }
    }

    @Override
    protected void unload() {

    }
}
