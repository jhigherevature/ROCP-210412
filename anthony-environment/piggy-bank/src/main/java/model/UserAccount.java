package model;

public class UserAccount {
    private Integer uid;
    private String email;
    private String passHash;
    private String firstName;
    private String lastName;
    private String status;

    public UserAccount() {
    }

    public UserAccount(Integer uid, String email, String passHash, String firstName, String lastName, String status) {
        super();
        this.uid = uid;
        this.email = email;
        this.passHash = passHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    public Integer getUid() {
        return uid;
    }

    public String getEmail() {
        return email;
    }

    public String getPassHash() {
        return passHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserAccount target = (UserAccount) obj;
        if (uid == null) {
            if (target.uid != null)
                return false;
        } else if (uid.equals(target.uid))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s (%s)", uid, lastName, firstName, email);
    }
}
