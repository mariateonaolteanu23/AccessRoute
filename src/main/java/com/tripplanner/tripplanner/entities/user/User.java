package com.tripplanner.tripplanner.entities.user;

import com.tripplanner.tripplanner.entities.place.authority.Authority;
import com.tripplanner.tripplanner.entities.placeReview.PlaceReview;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String email;

    private String password;

    private String name;

    @ManyToMany(mappedBy = "users")
    private Set<Authority> authorities = new HashSet<>();

    @OneToMany
    private List<PlaceReview> placeReviews = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && email.equals(user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }
}
