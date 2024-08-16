package ru.neoflex.jd.mapping;

import org.mapstruct.Mapper;
import ru.neoflex.jd.dto.AccountDto;
import ru.neoflex.jd.entity.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto toDto(Account account);

    Account toEntity(AccountDto accountDto);
}
