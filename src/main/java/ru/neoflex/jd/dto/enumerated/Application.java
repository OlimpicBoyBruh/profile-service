package ru.neoflex.jd.dto.enumerated;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Application {
    MOBILE("mobile"),
    EMAIL("email"),
    GOSUSLUGI("gosuslugi"),
    BANK("bank");

    private final String applicationValue;
    }
