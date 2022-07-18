package com.techzar.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techzar.location.dto.Search;

public interface  SearchRepository extends JpaRepository<Search, Long>  {

}
