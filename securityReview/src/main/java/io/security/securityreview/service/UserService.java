package io.security.securityreview.service;

import io.security.securityreview.domain.AccountDto;

public interface UserService {
    void createUser(AccountDto accountDto);
}
