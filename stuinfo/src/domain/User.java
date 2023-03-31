package domain;

public class User {
    private long roleID;
    private String roleName;
    private String password;
    private int keyRole;

    public long getRoleID() {
        return roleID;
    }

    public void setRoleID(long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getKeyRole() {
        return keyRole;
    }

    public void setKeyRole(int keyRole) {
        this.keyRole = keyRole;
    }

    @Override
    public String toString() {
        return "Student：" +
                "roleID='" + roleID + '\'' +
                ", roleName=" + roleName + '\'' +
                ", keyRole='" + keyRole + '\'';
    }
}
