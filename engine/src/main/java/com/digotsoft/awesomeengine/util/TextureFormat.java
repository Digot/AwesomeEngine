package com.digotsoft.awesomeengine.util;

/**
 * @author Digot
 * @version 1.0
 */
public enum  TextureFormat {

    PNG, JPG, JPEG;

    public static TextureFormat getByFileName(String path){
        for (TextureFormat textureFormat : values()) {
            String extension = "";

            int i = path.lastIndexOf('.');
            if (i > 0) {
                extension = path.substring(i+1);
                if(extension.equalsIgnoreCase(extension)) return textureFormat;
            }
        }

        return null;
    }

}
