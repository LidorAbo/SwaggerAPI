package com.H2DbPersistence.model;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import javax.persistence.*;
@Entity
@IdClass(ItemId.class)
public class Item {
    public Item(){};
    @Id private long itemno;
    @Id private String inventory_code;
    private String name;
    private Integer amount;
    @JsonSetter("itemno")
    public void setItemNo(long itemno){this.itemno = itemno;}
    @JsonSetter("name")
    public void SetName(String name){
        this.name = name;
    }
    @JsonSetter("amount")
    public void SetAmount(Integer amount){
        this.amount = amount;
    }
    @JsonSetter("inventory_code")
    public void SetInventoryCode(String inventory_code){
        this.inventory_code = inventory_code;
    }
    @JsonGetter("itemno")
    public Long GetId(){
        return this.itemno;
    }
    @JsonGetter("name")
    public String GetName(){
        return this.name;
    }
    @JsonGetter("amount")
    public Integer GetAmount(){
        return this.amount;
    }
    @JsonGetter("inventory_code")
    public String GetInverntoryCode(){
        return this.inventory_code;
    }

}
