package com.example.bloom.service;

import com.example.bloom.entity.BloomItem;
import com.example.bloom.repository.BloomItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.BitSet;
import jakarta.annotation.PostConstruct;

@Service
public class BloomFilterService {

    @Autowired
    private BloomItemRepository repository;

    private final int SIZE = 1000;
    private BitSet bitSet = new BitSet(SIZE);

    @PostConstruct
    public void loadDataToBloomFilter() {

        repository.findAll().forEach(item -> {
            bitSet.set(hash1(item.getValue()));
            bitSet.set(hash2(item.getValue()));
        });
    }

    private int hash1(String value) {
        return Math.abs(value.hashCode()) % SIZE;
    }

    private int hash2(String value) {
        return Math.abs((value.hashCode() * 31)) % SIZE;
    }

    public String add(BloomItem item) {

        repository.save(item);

        bitSet.set(hash1(item.getValue()));
        bitSet.set(hash2(item.getValue()));

        return "Added Successfully";
    }

    public String check(String value) {

        boolean exists =
                bitSet.get(hash1(value))
                        && bitSet.get(hash2(value));

        if (exists) {
            return "200 "+ value + " may exist";
        }

        return "404 "+value + " definitely does not exist";
    }
}