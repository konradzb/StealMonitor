package com.kk.StealMonitor.dao.page;

import com.kk.StealMonitor.model.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PageDao {
    List<Page> getAllPages();

    Optional<Page> selectPageById(UUID id);
}
