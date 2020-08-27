package com.kk.StealMonitor.dao.page;

import com.kk.StealMonitor.model.Page;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("PostgresPage")
public class PageDaoAccessService implements PageDao {

    @Override
    public List<Page> getAllPages() {
        return null;
    }

    @Override
    public Optional<Page> selectPageById(UUID id) {
        return Optional.empty();
    }
}
