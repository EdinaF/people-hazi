package com.example.peoplehazi.dto.outgoing;

import com.example.peoplehazi.domain.Person;
import lombok.Data;

@Data
public class PersonDetailsListItem {
    private String email;
    private String name;
    private String dept;
    private String rank;
    private String phone;
    private String room;

    public PersonDetailsListItem(Person person) {
        this.email = person.getEmail();
        this.name = person.getName();
        this.dept = person.getDept();
        this.rank = person.getRank();
        this.phone = person.getPhone();
        this.room = person.getRoom();
    }

}
