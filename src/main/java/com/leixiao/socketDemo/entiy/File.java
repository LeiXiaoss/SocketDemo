package com.leixiao.socketDemo.entiy;

import java.io.Serializable;

public class File implements Serializable {
    //
    private static final long serialVersionUID = -6771458716922241739L;

    private int fId;
    private String fName;
    private byte[] fContent;

    public File(){}

    public File(int fId, String fName, byte[] fContent) {
        this.fId = fId;
        this.fName = fName;
        this.fContent = fContent;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public byte[] getfContent() {
        return fContent;
    }

    public void setfContent(byte[] fContent) {
        this.fContent = fContent;
    }
}
