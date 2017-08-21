package org.dnstv.botcontroller;

import java.io.OutputStream;

/**
 * Created by paulv on 8/21/2017.
 */

public class DataHolder {
    private OutputStream data;
    public OutputStream getData() {return data;}
    public void setData(OutputStream data) {this.data = data;}

    private static final DataHolder holder = new DataHolder();
    public static DataHolder getInstance() {return holder;}
}