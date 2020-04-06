package com.example.mongo_db_week_09;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepoHybernate extends JpaRepository<User,Long> {
}
