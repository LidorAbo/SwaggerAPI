package com.H2DbPersistence.repository;
import com.H2DbPersistence.model.Item;
import com.H2DbPersistence.model.ItemId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
    @Repository
    public interface ItemRep extends CrudRepository<Item, ItemId>{

    }

