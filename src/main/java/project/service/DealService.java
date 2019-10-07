package project.service;

import project.persistence.entities.Deal;

import java.util.List;

public interface DealService {

    /**
     * Get all {@link Deal}s
     * @return A list of {@link Deal}s
     */
    List<Deal> findAll();

    /**
     * Find a {@link Deal} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link Deal} with {@link Long id}
     */
    Deal findOne(Long id);
}
