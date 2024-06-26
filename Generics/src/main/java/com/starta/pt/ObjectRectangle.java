package com.starta.pt;

public class ObjectRectangle {
    private Object width;
    private Object length;

    public ObjectRectangle(Object width, Object length) {
        this.width = width;
        this.length = length;
    }

    public Object getLength() {
        return length;
    }

    public void setLength(Object length) {
        this.length = length;
    }

    public Object getWidth() {
        return width;
    }

    public void setWidth(Object width) {
        this.width = width;
    }
}
