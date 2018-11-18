public class User {
    private String userName;
    private String password;

    public User(){}
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof User)) return false;
        User user = (User)obj;
        if(this.userName.equals(user.userName) && this.password.equals(user.password))
            return true;
        else
            return false;
    }
}
