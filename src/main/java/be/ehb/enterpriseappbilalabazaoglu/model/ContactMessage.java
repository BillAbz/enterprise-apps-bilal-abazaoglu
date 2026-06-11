package be.ehb.enterpriseappbilalabazaoglu.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContactMessage {

    @NotBlank(message = "Naam is verplicht")
    private String name;

    @NotBlank(message = "E-mail is verplicht")
    @Email(message = "Geef een geldig e-mailadres in")
    private String email;

    @NotBlank(message = "Bericht is verplicht")
    private String message;
}
