package be.ehb.enterpriseappbilalabazaoglu.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Titel is verplicht")
    private String title;

    @NotBlank(message = "Omschrijving is verplicht")
    private String description;

    @NotBlank(message = "Organisatie is verplicht")
    private String organisation;

    @NotBlank(message = "E-mail is verplicht")
    @Email(message = "Geef een geldig e-mailadres in")
    private String contactEmail;

    @NotNull(message = "Tijdstip is verplicht")
    private LocalDateTime date;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;

    public Event() {

    }

}
