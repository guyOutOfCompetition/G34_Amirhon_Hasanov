package Commerce.application.domain;

import Commerce.application.enums.UserRole;

public class User {

    private static Integer sequence = 0;

    {
        sequence++;
    }
    private Integer id = sequence;
    private String name;
    private String password;
    private Integer purchases = 10;
    private UserRole role = UserRole.CUSTOMER;
    public User() {
    }

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, UserRole role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPurchases() {
        return purchases;
    }

    public void setPurchases(Integer purchases) {
        this.purchases = purchases;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("Name = %s, Id = %s,",name,id);
    }
}
