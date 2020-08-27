package com.kk.StealMonitor.dao.page;

import com.kk.StealMonitor.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("PostgresPage")
public class PageDaoAccessService implements PageDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PageDaoAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Page> getAllPages() {
        return null;
    }

    @Override
    public Optional<Page> selectPageById(UUID id) {
        return Optional.empty();
    }
}
