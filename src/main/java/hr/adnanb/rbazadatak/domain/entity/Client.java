package hr.adnanb.rbazadatak.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;
    private String prezime;
    private String oib;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_kartice")
    private StatusKartice statusKartice;

}
