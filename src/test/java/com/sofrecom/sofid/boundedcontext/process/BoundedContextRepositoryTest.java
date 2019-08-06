package com.sofrecom.sofid.boundedcontext.process;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sofrecom.sofid.BoundedContextApp;
import com.sofrecom.sofid.boundedcontext.domain.BoundedContext;
import com.sofrecom.sofid.boundedcontext.repository.BoundedContextRepository;

/**
 * @author sofid@sofrecom.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BoundedContextApp.class)
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
