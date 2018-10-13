package ru.baa.shop.model;

import lombok.Getter;
import lombok.Setter;
import ru.baa.shop.root.model.CreationDateEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Shop extends CreationDateEntity {

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String address;
	private String phoneNumber;
	private String partner;
	private boolean haveCookRoom;

	@ManyToOne
	@JoinTable(name = "shop_and_types",
			joinColumns = {@JoinColumn(name = "shop_id")},
			inverseJoinColumns = {@JoinColumn(name = "type_id")})
	private ShopType type;
	//TODO добавить сущности метро
	private String metro;
	private int priority;
	@Lob
	private String comment;

	public Shop() {
	}

	public Shop(String name, String address, int priority) {
		this.name = name;
		this.address = address;
		this.priority = priority;
	}
}