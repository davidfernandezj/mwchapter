package com.ing.mwchapter.services;

import javax.validation.constraints.NotNull;

public interface IKeyboardService {

    int entryTime(@NotNull String code, @NotNull String keypad);

}
