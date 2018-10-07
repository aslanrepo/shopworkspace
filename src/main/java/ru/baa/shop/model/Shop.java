package ru.baa.shop.model;

import lombok.Getter;
import lombok.Setter;
import ru.baa.shop.root.model.AbstractEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Shop extends AbstractEntity {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String address;
	private String phoneNumber;
	private String partner;
	private boolean haveCookRoom;

	@Enumerated(EnumType.STRING)
	private Shop.Type type;
	private String metro;
	private int priority;
	@Setter

	private LocalDateTime creationDate;

	@Lob
	private String comment;

	public Shop() {
	}

	public Shop(String name, String address, int priority) {
		this.name = name;
		this.address = address;
		this.priority = priority;
	}

	//TODO убрать хардкор
	public enum Type {
		NORMAL("Продуктовый"),
		SUPERMARKET("Минимаркет");

		String name;

		Type(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}