package com.digotsoft.awesomegame.bootstrap;

import com.digotsoft.awesomeengine.drawing.Texture;
import com.digotsoft.awesomeengine.drawing.TexturedRectangle;
import com.digotsoft.awesomeengine.exception.DisplayInitializationException;
import com.digotsoft.awesomeengine.game.GameWindow;
import com.digotsoft.awesomeengine.math.Vector2D;
import com.digotsoft.awesomeengine.drawing.ColoredRectangle;
import com.digotsoft.awesomeengine.util.*;
import org.lwjgl.input.Keyboard;

import javax.rmi.CORBA.Util;

/**
 * @author Digot
 * @version 1.0
 */
public class MainWindow extends GameWindow {

    public MainWindow() throws DisplayInitializationException {
        super("AwesomeGame!", 800, 600);
        Utils.log("Initializing!");
        initialize();
    }

    @Override
    protected void load() {
        Utils.log("Loading objects!");
        addObject(new TexturedRectangle(new Vector2D(0, 0), 100, 100, Assets.loadTexture("newgrass.png")));
    }

    @Override
    protected void render() {

    }

    @Override
    protected void update() {

    }

    @Override
    protected void unload() {

    }
}
