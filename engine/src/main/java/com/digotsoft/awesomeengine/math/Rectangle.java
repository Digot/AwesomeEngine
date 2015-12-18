package com.digotsoft.awesomeengine.math;

import com.digotsoft.awesomeengine.math.Vector2D;
import com.digotsoft.awesomeengine.object.GameObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Digot
 * @version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
public abstract class Rectangle implements GameObject {

    private Vector2D position;
    private int width;
    private int height;

}
