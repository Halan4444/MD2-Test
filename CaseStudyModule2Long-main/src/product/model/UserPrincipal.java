package product.model;

import java.util.Set;

import static java.lang.String.valueOf;

public class UserPrincipal {
    private int id;
    private String name;
    private String username;
    private String password;
    private Set<Role> roleSet;
    private RoleName roleName;

    public UserPrincipal() {
    }

    public UserPrincipal(int id, String name, String username, String password, Set<Role> roleSet) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roleSet = roleSet;
//        this.roleName = roleName;
    }

    public UserPrincipal(String raw) {
        String [] strings = raw.split(",");
        this.id = Integer.parseInt(strings[0]);
        this.username = strings[1];
        this.password = strings[2];
        this.name = strings[3];
        this.roleName = RoleName.valueOf(strings[4]);
//        this.roleSet = Set<Role>.valueOf(strings[5]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public String toString() {
        return id + "," + username + "," + password + "," + name + "," +roleName ;
    }

}
