package kr.nexparan.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.nexparan.blog.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
