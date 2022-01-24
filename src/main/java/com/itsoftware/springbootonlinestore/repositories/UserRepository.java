package com.itsoftware.springbootonlinestore.repositories;

import com.itsoftware.springbootonlinestore.beans.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
