package org.springframework.samples.petclinic.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.model.UserAccount;
import org.springframework.samples.petclinic.repository.UserAccountRepository;
import org.springframework.samples.petclinic.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
@Service
public class UserAccountService {
    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Transactional
    public void saveUserAccount(UserAccount userAccount) throws DataAccessException {
        userAccount.setEnabled(true);
        userAccountRepository.save(userAccount);

    }

    public UserAccount findUserAccount(String username) {
        return userAccountRepository.findUserAccountByUsername(username);
    }
}
