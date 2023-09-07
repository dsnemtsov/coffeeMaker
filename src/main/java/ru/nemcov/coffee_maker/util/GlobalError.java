package ru.nemcov.coffee_maker.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalError {
    @NonNull
    private String error;
}
