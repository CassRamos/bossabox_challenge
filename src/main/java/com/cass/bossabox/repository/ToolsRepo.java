package com.cass.bossabox.repository;

import com.cass.bossabox.entity.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToolsRepo extends JpaRepository<Tools, Long> {

    @Query(value =
            "SELECT * FROM tools WHERE tags like %:tag%",
            nativeQuery = true)
    List<Tools> findToolsByTag(@Param("tag") String tag);
}
