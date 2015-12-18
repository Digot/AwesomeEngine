package com.digotsoft.awesomeengine.util;

import org.lwjgl.input.Keyboard;

/**
 * @author Digot
 * @version 1.0
 */
public class Input {

    public static boolean isKeyDown(int key){
        return Keyboard.isKeyDown(key);
    }

}
