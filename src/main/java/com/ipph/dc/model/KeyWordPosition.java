package com.ipph.dc.model;

/**
 * Created with IntelliJ IDEA.
 * User: ZRC
 * Date Time: 2019/8/7 14:57
 * Description: No Description
 */

public class KeyWordPosition {
    private int start;
    private int end;

    public KeyWordPosition(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
