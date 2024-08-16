package ru.neoflex.jd.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.neoflex.jd.dto.AccountDto;
import ru.neoflex.jd.mapping.AccountMapper;
import ru.neoflex.jd.repository.AccountRepository;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountRepositoryService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public void createAccount(AccountDto accountDto) {
        log.info("Invoke AccountRepositoryService, method createAccount, accountDto: {}", accountDto);
        accountRepository.save(accountMapper.toEntity(accountDto));
        log.info("Account successfully created.");
    }

    public AccountDto getAccountById(UUID id) {
        log.info("Invoke AccountRepositoryService, method getAccountById, id: {}", id);
        AccountDto accountDto = accountMapper.toDto(accountRepository.findById(id).orElseThrow());
        log.info("Account successfully found.");
        return accountDto;
    }
}
