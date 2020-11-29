package org.springframework.samples.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount,String> {

    UserAccount findUserAccountByUsername(String username);
}
