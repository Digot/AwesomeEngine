package com.digotsoft.awesomeengine.util;

import lombok.Getter;

/**
 * @author Digot
 * @version 1.0
 */
@Getter
public enum Color {

    BLUE(0f, 0f, 1f),
    RED(1f, 0f, 0f),
    GREEN(0f, 1f, 0f),
    BLACK(0f, 0f, 0f),
    WHITE(1f, 1f, 1f),
    ORANGE(1f,0.5f, 0f);

    private float r;
    private float g;
    private float b;
    private float alpha;

    Color(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.alpha = 1f;
    }

    Color(float r, float g, float b, float alpha) {
        this(r, g, b);
        this.alpha = alpha;
    }
}
