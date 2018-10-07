package ru.baa.shop.root.repository.batch;

import java.util.Collection;

interface BatchOperations<E> {
	void batchCreate(Collection<E> collection);
	void batchUpdate(Collection<E> collection);
}
