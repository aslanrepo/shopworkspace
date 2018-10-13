package ru.baa.shop.root.repository.batch;

import java.util.Collection;

interface BatchOperations {
	void batchCreate(Collection<?> collection);
	void batchUpdate(Collection<?> collection);
}
