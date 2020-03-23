package com.ice.cusipprice.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ice.cusipprice.model.Cusip;

import java.util.List;

@Repository
public interface CusipRepository extends CrudRepository<Cusip, String> {

    Cusip findByCusipId(String cusipId);

//    Cusip saveCusip(Cusip cusip);
//    void deleteCusip(Cusip cusip);


}