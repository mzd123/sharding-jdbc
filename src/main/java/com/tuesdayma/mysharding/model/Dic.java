package com.tuesdayma.mysharding.model;

public class Dic {
    private Long id;

    private String dicDesc;

    private String dicType;

    private String dicName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDicDesc() {
        return dicDesc;
    }

    public void setDicDesc(String dicDesc) {
        this.dicDesc = dicDesc == null ? null : dicDesc.trim();
    }

    public String getDicType() {
        return dicType;
    }

    public void setDicType(String dicType) {
        this.dicType = dicType == null ? null : dicType.trim();
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName == null ? null : dicName.trim();
    }
}