package com.zz.we.enums;

public enum Comment_enum {
    UNPASS("1","未通过"),PASS("2","已通过");

    private String code;

    private String msg;

    Comment_enum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String Code() {
        return code;
    }

    public String Msg() {
        return msg;
    }
}
