package com.example.peoplehazi.domain;

import com.example.peoplehazi.dto.incoming.PersonCommand;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String name;
    private String dept;
    @Column(name = "`rank`")
    private String rank;
    private String phone;
    private String room;

    public Person(PersonCommand command) {
        this.email = command.getEmail();
        this.name = command.getName();
        this.dept = command.getDept();
        this.rank = command.getRank();
        this.phone = command.getPhone();
        this.room = command.getRoom();
    }
}
