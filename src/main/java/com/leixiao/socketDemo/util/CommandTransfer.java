package com.leixiao.socketDemo.util;

import java.io.Serializable;

public class CommandTransfer implements Serializable {

    private static final long serialVersionUID = 2238978914539701617L;

    //传输数据
    private Object data;
    //返回结果
    private String result;
    //操作是否成功
    private boolean flag;
    //操作指令
    private String cmd;

    public CommandTransfer(){
        super();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public String toString() {
        return "CommandTransfer [data=" + data + ",result="
                + result + ",flag=" + flag + ",cmd=" + cmd +"]";
    }
}
