package com.batch80.pointofsalebatch80.repo;

import com.batch80.pointofsalebatch80.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {
}
