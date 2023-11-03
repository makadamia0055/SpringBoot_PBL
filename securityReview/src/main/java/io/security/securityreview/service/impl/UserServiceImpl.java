package io.security.securityreview.service.impl;

import io.security.securityreview.domain.Account;
import io.security.securityreview.domain.AccountDto;
import io.security.securityreview.repository.UserRepository;
import io.security.securityreview.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    private Account mapAccount(AccountDto accountDto){
        ModelMapper modelMapper = new ModelMapper();
        Account account = modelMapper.map(accountDto, Account.class);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return account;
    }

    @Transactional
    @Override
    public void createUser(AccountDto accountDto) {

        userRepository.save(mapAccount(accountDto));
    }
}
