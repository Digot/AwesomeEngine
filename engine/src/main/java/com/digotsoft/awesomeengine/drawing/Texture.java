package com.digotsoft.awesomeengine.drawing;

import com.digotsoft.awesomeengine.util.Disposable;
import com.digotsoft.awesomeengine.util.TextureFormat;
import org.newdawn.slick.opengl.TextureLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Digot
 * @version 1.0
 */
public class Texture implements Disposable{

    private org.newdawn.slick.opengl.Texture backedTexture;

    public Texture(String filePath, TextureFormat format){
        try {
            this.backedTexture = TextureLoader.getTexture(format.name(), new FileInputStream(new File(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Texture(InputStream inputStream, TextureFormat format){
        try {
            this.backedTexture = TextureLoader.getTexture(format.name(), inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getTextureID(){
        return this.backedTexture.getTextureID();
    }

    @Override
    public void dispose() {
        this.backedTexture.release();
    }
}
