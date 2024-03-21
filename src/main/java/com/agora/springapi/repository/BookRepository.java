package com.agora.springapi.repository;

import com.agora.springapi.entity.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {

    Page<Books> findByCategory(Pageable pageable, String category);
}
