package ru.baa.shop.root.repository.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

/**
 * This repository is needed to execute batch operations
 *
 * @param <E> Entity
 */
@Repository
@Transactional
public class BatchRepository<E> implements BatchOperations<E> {
	private final EntityManager em;

	@Value("#{${project.settings.jpa.batch-size:100}}")
	private int batchSize;

	@Autowired
	public BatchRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public void batchCreate(Collection<E> collection) {
		int count = 0;
		for (E entity : collection) {
			em.persist(entity);
			if (batchSize == ++count) {
				em.clear();
				em.flush();
			}
		}
	}

	@Override
	public void batchUpdate(Collection<E> collection) {
		int count = 0;
		for (E entity : collection) {
			em.merge(entity);
			if (batchSize == ++count) {
				em.clear();
				em.flush();
			}
		}
	}
}
