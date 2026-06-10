package be.ehb.enterpriseappbilalabazaoglu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Naam is verplicht")
    private String name;

    @NotBlank(message = "Adres is verplicht")
    private String address;

    @Min(value = 1, message = "Capaciteit moet minstens 1 zijn")
    private int capacity;

    public Location() {
    }
}
