package com.kk.StealMonitor.integration;

import com.kk.StealMonitor.dao.page.PageDaoAccessService;
import com.kk.StealMonitor.model.Page;
import com.kk.StealMonitor.service.ScheduleRunner;
import com.kk.StealMonitor.service.product.ProductEditService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
@SpringBootTest
public class ScheduleRunnerTestIntgr {

    @Autowired
    private ScheduleRunner scheduleRunner;

    @Autowired
    private ProductEditService productService;

    @Autowired
    private PageDaoAccessService pageDaoAccessService;

    @Test
    public void load_XKom_HotShotTest() {
        Page page = pageDaoAccessService.getAllPages().get(0);

        String key = "xkom_hotshot";
        String key2 = "xkom_wakacyjnaPromocja";

        assertEquals(scheduleRunner.loadProductsToDataBaseAndSafeIDs(page, key), 1);
        //check terminal with "SELECT * FROM products;" if rows was actually added to DB
        assertNotNull(productService.getIdList(key));

        assertNull(productService.getIdList(key2));
        assertEquals(scheduleRunner.loadProductsToDataBaseAndSafeIDs(page, key2), 1);
        assertNotNull(productService.getIdList(key));
    }
    @Test
    public void updateProductsRemainingQuantityByIDsTest() {
        Page page = pageDaoAccessService.getAllPages().get(0);
        String key = "xkom_hotshot";

        assertEquals(scheduleRunner.loadProductsToDataBaseAndSafeIDs(page, key), 1);
        assertEquals(scheduleRunner.updateProductsRemainingQuantityByIDs(page, key), 1);
        assertNotNull(productService.getIdList(key));
    }

}
