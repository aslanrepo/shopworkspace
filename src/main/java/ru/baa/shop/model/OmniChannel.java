package ru.baa.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Setter
@Getter
public class OmniChannel {
    @Id
    private String name;



    public OmniChannel() {
    }

    public OmniChannel(String name) {
        this.name = name;
    }

}
