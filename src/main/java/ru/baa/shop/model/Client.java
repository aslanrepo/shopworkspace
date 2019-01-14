package ru.baa.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Setter
@Getter
public class Client {
    @Id
    private String id;

    @ManyToMany(mappedBy = "clients", fetch = FetchType.EAGER)
    private Set<Feature> features;

    public Client() {
    }

    public Client(String id) {
        this.id = id;
    }
}
