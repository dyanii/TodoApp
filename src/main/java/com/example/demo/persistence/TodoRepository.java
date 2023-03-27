package com.example.demo.persistence;

import com.example.demo.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
    //@Query(value="select * from ", nativeQuery = true)
    List<TodoEntity> findByUserId(String userId); //한 사람이 여러 아이디를 쓸 수 있으니까 리스트 사용
}
