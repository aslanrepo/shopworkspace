package ru.baa.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import ru.baa.shop.root.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class ShopType extends BaseEntity {
	private String name;

	public ShopType() {
	}

	@JsonIgnore
	@OneToMany(mappedBy = "type")
	private Set<Shop> shops;

	public ShopType(String name) {
		this.name = name;
	}
}

