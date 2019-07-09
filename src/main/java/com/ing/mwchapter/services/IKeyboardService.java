package com.ing.mwchapter.services;

import javax.validation.constraints.NotNull;

public interface IKeyboardService {

    /**
     *
     * @param code The string to type
     * @param keypad A string of 9 digits where each group of 3 digits represents a
     * row on the keypad of the day, in order
     * @return minimum amount of time it takes to type the code
     */
    int entryTime(@NotNull String code, @NotNull String keypad);

}
