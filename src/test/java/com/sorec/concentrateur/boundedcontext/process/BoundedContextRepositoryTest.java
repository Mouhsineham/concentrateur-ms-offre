package com.sorec.concentrateur.boundedcontext.process;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sorec.concentrateur.OffreApp;
import com.sorec.concentrateur.offre.domain.BoundedContext;
import com.sorec.concentrateur.offre.repository.BoundedContextRepository;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = OffreApp.class)
@AutoConfigureMockMvc
public class BoundedContextRepositoryTest {

    @Autowired
    BoundedContextRepository boundedContextRepository;

    /**
     * Test with one import code
     */
    @Test
    public void testGet(){
        BoundedContext value = boundedContextRepository.getOne(1);
        Assert.assertEquals(Integer.valueOf(1),value.getId());
    }
    
}
