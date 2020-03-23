package com.ice.cusipprice.repository;


import com.ice.cusipprice.model.Cusip;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;



@RunWith(SpringRunner.class)
@DataJpaTest
public class CusipRepositoryTest {

    @Autowired
    private CusipRepository repository;

    @Test
    public void testSaveAndFindCusip() {

        Cusip cusipToSave = new Cusip("CUSIP00A", 1.00);
        repository.save(cusipToSave);
        Optional<Cusip> cusipToGet = repository.findById("CUSIP00A");
        assertNotNull(cusipToSave);
        assertEquals(cusipToSave.getCusipId(), cusipToGet.get().getCusipId());
        assertEquals(cusipToSave.getPrice(), cusipToGet.get().getPrice());
    }

    @Test
    public void testDeleteCusip() {
        Cusip cusip = new Cusip("CUSIP00B", 2.00);
        repository.save(cusip);
        assertNotNull(repository.findById("CUSIP00B"));
        repository.deleteById("CUSIP00B");
        assertNull(repository.findById("CUSIP00B"));
    }

}