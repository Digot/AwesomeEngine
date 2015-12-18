package com.digotsoft.awesomeengine.util;

import org.newdawn.slick.util.LogSystem;

/**
 * @author Digot
 * @version 1.0
 */
public class NullLogSystem implements LogSystem {
    @Override
    public void error(String s, Throwable throwable) {

    }

    @Override
    public void error(Throwable throwable) {

    }

    @Override
    public void error(String s) {

    }

    @Override
    public void warn(String s) {

    }

    @Override
    public void warn(String s, Throwable throwable) {

    }

    @Override
    public void info(String s) {

    }

    @Override
    public void debug(String s) {

    }
}
