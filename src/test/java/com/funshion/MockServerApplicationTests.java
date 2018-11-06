package com.funshion;

import com.funshion.dao.ItemDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockServerApplicationTests {

    @Autowired
    private ItemDao itemDao;
    @Test
    public void contextLoads() {

        System.out.println(itemDao.findByPath("/t"));
    }

}
