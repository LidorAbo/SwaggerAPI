package com.H2DbPersistence.model;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;

public class ItemId implements Serializable {
    private long itemno = 0;
    private String inventory_code;
    public ItemId(){};
    public ItemId(Long itemno, String inventory_code){
        this.itemno = itemno;
        this.inventory_code = inventory_code;
    }
}
