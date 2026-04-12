package com.fisslink.backend.data.repositories;

import com.fisslink.backend.data.models.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepository extends JpaRepository<URL, Long> {
    URL findByShortCode(String shortCode);
    URL findByOriginalUrl(String originalUrl);
    boolean existsByOriginalUrl(String originalUrl);
    boolean existsByShortCode(String shortCode);
}
