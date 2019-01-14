package ru.baa.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
public class Feature {
    @Id
    private String name;
    private Boolean isGlobalScope;


    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "feature_channel",
            joinColumns = @JoinColumn(name = "feature"),
            inverseJoinColumns = @JoinColumn(name = "channel"))
    private List<OmniChannel> omniChannels;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "feature_client",
            joinColumns = {@JoinColumn(name = "feature")},
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private Set<Client> clients;

    public Feature() {
    }

    public Feature(String name, Boolean isGlobalScope) {
        this.name = name;
        this.isGlobalScope = isGlobalScope;
    }

    public Feature(String name, Boolean isGlobalScope, Set<Client> clients, List<OmniChannel> omniChannels) {
        this.name = name;
        this.isGlobalScope = isGlobalScope;
        this.clients = clients;
        this.omniChannels = omniChannels;
    }
}
