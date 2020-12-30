package com.r92ad8.practice;

import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringMybatisDemoApplicationTest.class})
//@ActiveProfiles("local")
@AutoConfigureMockMvc
public class SpringMybatisDemoApplicationTest {

}