package ru.neoflex.jd.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.jd.dto.AccountDto;
import ru.neoflex.jd.service.AccountRepositoryService;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/account")
@Tag(name = "Account service", description = "Сервис для создания/поиска аккаунта.")
public class AccountController {

    private final AccountRepositoryService accountRepositoryService;

    @Operation(summary = "Создание аккаунта.",
            description = "Поступает информация  для создания аккаунта, происходит валидации и сохранение в БД."
    )
    @PostMapping("/create")
    public void createProfile(@RequestBody @Valid AccountDto accountDto) {
        log.info("Invoke createProfile method. accountDto: {}", accountDto);
        accountRepositoryService.createAccount(accountDto);
        log.info("Method createProfile successfully finished.");
    }

    @Operation(summary = "Получение аккаунта.",
            description = "Получение информации о аккаунте по id."
    )
    @GetMapping("/get/{accountId}")
    public AccountDto getProfileById(@PathVariable("accountId") @Parameter(description = "ID профиля",
            example = "3fa85f64-5717-4562-b3fc-2c963f66afa6") String accountId) {
        log.info("Invoke getProfileById method. accountId: {}", accountId);
        AccountDto accountDto = accountRepositoryService.getAccountById(UUID.fromString(accountId));
        log.info("Method getProfileById return accountDto: {}", accountDto);
        return accountDto;
    }

    @Operation(summary = "Поиск аккаунта по значениям.",
            description = "Происходит поиск аккаунта по полям [фамилия, имя, отчество, телефон, email]"
    )
    @GetMapping("/search")
    public AccountDto searchProfile(@RequestBody AccountDto accountDto) {
        log.info("Invoke searchProfile method. accountDto: {}", accountDto);
        return null;
    }
}
