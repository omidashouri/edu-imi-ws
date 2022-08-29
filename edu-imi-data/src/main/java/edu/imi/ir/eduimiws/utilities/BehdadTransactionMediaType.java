package edu.imi.ir.eduimiws.utilities;

public enum BehdadTransactionMediaType {

    _CHQ("CHQ","چک دولتی"),
    _POR("","");

    final String code;
    final String title;

    BehdadTransactionMediaType(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
}
