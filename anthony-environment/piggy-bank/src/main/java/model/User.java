package model;

public class User {
    private Integer id;
    private String email;
    private String passHash;
    private String passSalt;
    private String firstName;
    private String lastName;
    private String status;

    public User() {
    }

    public User(Integer id, String email, String passHash, String passSalt, String firstName, String lastName,
            String status) {
        super();
        this.id = id;
        this.email = email;
        this.passHash = passHash;
        this.passSalt = passSalt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    public Integer getUid() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassHash() {
        return passHash;
    }

    public String getPassSalt() {
        return passSalt;
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

    public void setUid(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public void setPassSalt(String passSalt) {
        this.passSalt = passSalt;
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
        User target = (User) obj;
        if (id == null) {
            if (target.id != null)
                return false;
        } else if (id.equals(target.id))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s (%s)", id, lastName, firstName, email);
    }
}
