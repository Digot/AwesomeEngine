package com.digotsoft.awesomeengine.math;

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
public abstract class Circle implements GameObject {

    private Vector2D position;
    private double radius;

}
