package com.kk.StealMonitor.unit.service;

import com.kk.StealMonitor.service.ProductLoader;
import com.kk.StealMonitor.service.product.ProductEditService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ScheduleRunnerTest {

    @MockBean
    private ProductLoader productsLoader;

    @MockBean
    private ProductEditService productService;

}
