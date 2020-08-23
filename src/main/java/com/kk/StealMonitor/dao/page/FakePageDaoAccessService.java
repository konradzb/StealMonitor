package com.kk.StealMonitor.dao.page;

import com.kk.StealMonitor.model.Page;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakePageDao")
public class FakePageDaoAccessService implements PageDao{

    private List<Page> pages = new ArrayList<>();

    @Override
    public List<Page> getAllPages() {
        return pages;
    }

    @Override
    public Optional<Page> selectPageById(UUID id) {
        pages.add(new Page(UUID.fromString("61c91a42-3204-4603-b554-1cf5bd72f3d1"), "sd", "ds", "ds", "sd", "sd"));
        return pages.stream().filter(page -> page.getId().equals(id)).findFirst();
    }
}
