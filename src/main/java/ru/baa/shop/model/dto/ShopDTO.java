package ru.baa.shop.model.dto;

import lombok.Getter;
import lombok.Setter;
import ru.baa.shop.model.ShopType;

import java.time.LocalDateTime;

@Getter
@Setter
public class ShopDTO {
	private Long id;
	private String name;
	private String address;
	private String phoneNumber;
	private String partner;
	private boolean haveCookRoom;
	private ShopType type;
	private String metro;
	private int priority;
	private String comment;
	private LocalDateTime creationDate;
}
