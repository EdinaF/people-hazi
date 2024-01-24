package com.example.peoplehazi.dto.incoming;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class PersonCommand {

    @NotNull(message = "Az email nem lehet üres.")
    @Email(message = "Érvénytelen e-mail cím.")
    private String email;
    @NotNull(message = "A név nem lehet üres.")
    private String name;
    @NotNull(message = "Az osztály nem lehet üres.")
    private String dept;
    @NotNull(message = "A rank nem lehet üres.")
    private String rank;
    @NotNull(message = "A telefonszám nem lehet üres.")
    @Pattern(regexp = "^\\+36 \\(1\\) 666-\\d{4,}$", message = "Érvénytelen telefonszám")
    private String phone;
    private String room;
}
