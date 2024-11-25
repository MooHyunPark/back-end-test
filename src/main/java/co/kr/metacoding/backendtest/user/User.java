package co.kr.metacoding.backendtest.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "user_tb")
@Entity
@Setter
public class User {
    @Id
    private String id;
    private String name;
}



