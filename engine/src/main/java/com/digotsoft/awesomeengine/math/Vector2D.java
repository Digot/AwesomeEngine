package com.digotsoft.awesomeengine.math;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Digot
 * @version 1.0
 */
@AllArgsConstructor
@Getter
public final class Vector2D implements Cloneable {

    private double x;
    private double y;

    public Vector2D add(Vector2D other){
        return new Vector2D(
                this.x + other.getX(),
                this.y + other.getY()
        );
    }

    public Vector2D subtract(Vector2D other){
        return new Vector2D(
                this.x - other.getX(),
                this.y - other.getY()
        );
    }

    public Vector2D multiply(Vector2D other){
        return new Vector2D(
                this.x * other.getX(),
                this.y * other.getY()
        );
    }

    public Vector2D divide(Vector2D other){
        return new Vector2D(
                this.x / other.getX(),
                this.y / other.getY()
        );
    }

    public Vector2D scalar(Vector2D other){
        return new Vector2D(
                this.x * other.getY(),
                this.y * other.getX()
        );
    }

    @Override
    public Vector2D clone(){
        return new Vector2D(x, y);
    }

}
