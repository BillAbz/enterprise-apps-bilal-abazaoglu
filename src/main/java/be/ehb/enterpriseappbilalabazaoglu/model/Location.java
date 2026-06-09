package be.ehb.enterpriseappbilalabazaoglu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Naam is verplicht")
    private String naam;

    @NotBlank(message = "Adres is verplicht")
    private String adres;

    @Min(value = 1, message = "Capaciteit moet minstens 1 zijn")
    private int capaciteit;
}
