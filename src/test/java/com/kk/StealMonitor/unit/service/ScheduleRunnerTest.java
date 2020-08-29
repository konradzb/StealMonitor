package com.kk.StealMonitor.unit.service;

import com.kk.StealMonitor.service.PageLoader;
import com.kk.StealMonitor.service.product.ProductEditService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ScheduleRunnerTest {

    @MockBean
    private PageLoader pageLoader;

    @MockBean
    private ProductEditService productService;

}
