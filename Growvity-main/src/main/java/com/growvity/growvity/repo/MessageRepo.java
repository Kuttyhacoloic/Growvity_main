package com.growvity.growvity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.growvity.growvity.model.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {

}
