package com.example.AuthSystem.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.UniqueConstraint;


//@Getter
//@Setter
@Entity

@Table(
        name = "client",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username")
        }
)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "cant be empty")
    private String username;
    @NotBlank
    @Pattern(
            regexp = "^[a-zA-Z ]+$",
            message = "only letters allowed"
    )
    private String name;
    @NotBlank
    @Pattern(
            regexp = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$"
    )
    private String email;
    private String occupation;

    private String password;
    @NotBlank
    @Pattern(
            regexp = "^[6-9]\\d{9}$"
    )
    private String mobile;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Client() {
    }
}
