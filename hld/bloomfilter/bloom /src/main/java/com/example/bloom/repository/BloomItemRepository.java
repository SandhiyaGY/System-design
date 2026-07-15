package com.example.bloom.repository;

import com.example.bloom.entity.BloomItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloomItemRepository
        extends JpaRepository<BloomItem, Long> {
}