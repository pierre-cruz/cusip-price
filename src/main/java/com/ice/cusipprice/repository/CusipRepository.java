package com.ice.cusipprice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ice.cusipprice.model.Cusip;


@Repository
public interface CusipRepository extends CrudRepository<Cusip, String> {

}