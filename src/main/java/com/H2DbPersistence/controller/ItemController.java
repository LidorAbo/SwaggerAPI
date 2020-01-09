package com.H2DbPersistence.controller;
import com.H2DbPersistence.model.Item;
import com.H2DbPersistence.model.ItemId;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.H2DbPersistence.repository.ItemRep;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
    @Autowired
    private ItemRep item_rep;
    @GetMapping(value = "/showall")
    public  List<Item> ReturnItems() throws JsonProcessingException {
      return (List<Item>) item_rep.findAll();
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String AddItem(@RequestBody Item item) {
        try {
            item_rep.save(item);
            return "The item added to db successfully";
        } catch (Exception exception) {
            return "The Adding item to db is failed";
        }
    }
        @GetMapping(value = "/show/item")
        public Optional<Item> ShowItem(@RequestParam Long itemno, @RequestParam String inventory_code ){
            try{
                return item_rep.findById(new ItemId(itemno, inventory_code));
            }
            catch (Exception exception){
                return null;
            }
        }
        @DeleteMapping(value = "/delete/item")
        public String DeleteItem(@RequestParam Long itemno, @RequestParam String inventory_code)
        {
            try {
                item_rep.deleteById(new ItemId(itemno, inventory_code));
                return "Item deleted successfully";
            }
            catch(Exception exception) {
                return "Deleting item is failed";
        }
        }
        @PutMapping(value = "/update/item/setamount")
        public String UpdateItem(@RequestParam Long itemno, @RequestParam String inventory_code, @RequestParam int amount){
            try{
                Item item_to_change = (item_rep.findById(new ItemId(itemno, inventory_code)).get());
                item_to_change.SetAmount(amount);
                item_rep.save(item_to_change);
                return "Amount of item with itemno: " + itemno + " and inventory code: " + inventory_code + " updated to " + amount;
            }
            catch (Exception exception){
               return "Amount of item with itemno: " + itemno + " and inventory code: " + inventory_code + " not updated";
            }
        }




}
