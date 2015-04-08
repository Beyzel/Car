package Car.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "Admin")
public class Admin {

    @Id
    @Column(name = "User_id")
    @NotEmpty
    private int User_id;

    @OneToOne(mappedBy = "admin")
    private User user;

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
