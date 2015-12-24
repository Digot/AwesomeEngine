package com.digotsoft.awesomeengine.game;

import com.digotsoft.awesomeengine.exception.DisplayInitializationException;
import com.digotsoft.awesomeengine.util.Color;
import com.digotsoft.awesomeengine.util.Utils;
import lombok.Getter;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.util.HashSet;
import java.util.Set;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author Digot
 * @version 1.0
 */
@Getter
public abstract class GameWindow extends Scene {

    private String title;
    private int width;
    private int height;
    private int targetFramerate = 60;
    private Color clearColor;

    private Scene currentScene;
    private Set<Scene> registeredScenes;

    public GameWindow(String title, int width, int height) throws DisplayInitializationException {
        this.title = title;
        this.width = width;
        this.height = height;
        this.currentScene = this;
        this.registeredScenes = new HashSet<>();
    }

    public GameWindow(String title, int width, int height, int targetFramerate) throws DisplayInitializationException {
        this(title,width, height);
        this.targetFramerate = targetFramerate;
    }

    public void setClearColor(Color color){
        glClearColor(color.getR(), color.getG(), color.getB(), color.getAlpha());
    }

    protected void initialize() throws DisplayInitializationException {
        try {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.setTitle(title);
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
            throw new DisplayInitializationException("Failed to initialize window: " + Utils.stackTraceToString(e));
        }

        this.initGL();
        //load content from all scenes
        this.registeredScenes.add(this);

        for (Scene registeredScene : registeredScenes) {
            registeredScene.load();
        }

        //start game load
        this.startGameLoop();

        //dispose all objects
        for (Scene registeredScene : registeredScenes) {
            registeredScene.unloadScene();
        }
    }

    private void initGL(){
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, width, height, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
    }

    private void startGameLoop(){
        while (!Display.isCloseRequested()) {
            //Clear the screen
            glClear(GL_COLOR_BUFFER_BIT);

            // While no attempt to close the display is made..
            //Rendering
            this.currentScene.preRender();
            this.currentScene.render();
            //Input handling
            this.currentScene.update();
            //Update display
            Display.update();
            // Refresh the display and poll input.
            Display.sync(targetFramerate);
            // Wait until 16.67 milliseconds have passed. (Maintain 60 frames-per-second)
        }
    }


    public void registerScene(Scene scene){
        this.registeredScenes.add(scene);
    }

    public void switchScene(Scene scene){
        this.currentScene = scene;
    }
}
