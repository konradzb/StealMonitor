package com.kk.StealMonitor.unit.dao;

import com.kk.StealMonitor.dao.page.FakePageDaoAccessService;
import com.kk.StealMonitor.dao.page.PageDaoAccessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.Assert.*;

@SpringBootTest
public class PageDaoTest {

    @Autowired
    private FakePageDaoAccessService pageDao;

    @Autowired
    public PageDaoAccessService pageDaoAccessService;

    @Test
    public void selectByIdTest() {
//        UUID id = UUID.fromString("61c91a42-3204-4603-b554-1cf5bd72f3d1");
//
//        pageDao.selectPageById(id);
//        assertEquals(pageDao.selectPageById(id).get().getId(), UUID.fromString("61c91a42-3204-4603-b554-1cf5bd72f3d1"));
    }

    @Test
    public void getAllPages() {
        assertNotNull(pageDaoAccessService.getAllPages());
        assertNotEquals(pageDaoAccessService.getAllPages().size(), 0);

    }
}
