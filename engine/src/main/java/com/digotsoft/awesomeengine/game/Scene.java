package com.digotsoft.awesomeengine.game;

import com.digotsoft.awesomeengine.object.GameObject;
import com.digotsoft.awesomeengine.util.Disposable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Digot
 * @version 1.0
 */
public abstract class Scene {

    private Set<GameObject> gameObjects;

    public Scene(){
        this.gameObjects = new HashSet<>();
    }

    public void preRender() {
        for (GameObject gameObject : gameObjects) {
            gameObject.render();
        }
    }

    protected void addObject(GameObject gameObject){
        this.gameObjects.add(gameObject);
    }

    protected void removeObject(GameObject gameObject){
        if(gameObjects.contains(gameObject)) gameObjects.remove(gameObject);
    }

    public void unloadScene(){
        for (GameObject gameObject : gameObjects) {
            gameObject.dispose();
        }

        this.unload();
    }

    protected abstract void load();
    protected abstract void render();
    protected abstract void update();
    protected abstract void unload();

}
