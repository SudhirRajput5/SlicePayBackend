package com.slice.SlicePay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slice.SlicePay.Beans.Stocks;

public interface StocksRepository extends JpaRepository<Stocks, Integer> {

}
