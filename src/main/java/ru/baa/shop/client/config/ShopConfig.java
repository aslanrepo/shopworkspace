package ru.baa.shop.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.baa.shop.root.config.EntityConfig;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Here is Shop Configs
 */
@Component
public class ShopConfig implements EntityConfig {
	private Sort sort;

	@Value("#{${project.settings.shop.sort-by:{priority: 'desc', creationDate: 'desc'}}}")
	private Map<String, String> sortBy;

	@Value("#{${project.settings.pageSize:50}}")
	private int pageSize;

	public ShopConfig() {
		this.sort = Sort.unsorted();
	}

	@Override
	public Pageable getPageConfig(int page) {
		return PageRequest.of(page, pageSize, sort);
	}

	@PostConstruct
	private void initProperties() {
		for (Map.Entry<String, String> sortProp : sortBy.entrySet()) {
			this.sort = sort.and(Sort.by(Sort.Direction.valueOf(sortProp.getValue().toUpperCase()), sortProp.getKey()));
		}
		this.sort = sort.and(Sort.by(Sort.Direction.ASC, "id"));
	}
}
