package com.digotsoft.awesomeengine.util;

import com.digotsoft.awesomeengine.drawing.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.LogSystem;

import java.io.File;
import java.io.InputStream;

/**
 * @author Digot
 * @version 1.0
 */
public class Assets {

    static{
        Log.setLogSystem(new NullLogSystem());
    }

    public static InputStream load(String filePath){
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return classloader.getResourceAsStream(filePath);
    }

    public static Texture loadTexture(String filePath){
        return new Texture(load(filePath), TextureFormat.getByFileName(filePath));
    }

}
