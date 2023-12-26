package Commerce.application.enums;

public enum UserRole {
    OWNER(1),
    CUSTOMER(2);
    private Integer index;
    UserRole() {
    }
    UserRole(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public static UserRole getUserRoleByIndex(Integer index){
        UserRole[] roles = UserRole.values();
        for(UserRole role: roles){
            if(index == role.index){
                return role;
            }
        }
        return CUSTOMER;
    }
    public static void printUserRoles(){
        UserRole[] roles = UserRole.values();
        for(UserRole role: roles){
            System.out.println(role.index + ". " + role);
        }
    }
}
