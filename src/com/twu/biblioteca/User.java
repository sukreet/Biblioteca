package com.twu.biblioteca;

public class User implements  MenuOperations{
    private String name;
    private String libraryID;
    private String phoneNo;
    private String emailID;
    private String password;
    private boolean isLibrarian;

    public User(String name, String libraryID, String phoneNo, String emailID, String password, boolean isLibrarian) {
        this.name = name;
        this.libraryID = libraryID;
        this.phoneNo = phoneNo;
        this.password = password;
        this.emailID = emailID;
        this.isLibrarian = isLibrarian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (isLibrarian != user.isLibrarian) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (libraryID != null ? !libraryID.equals(user.libraryID) : user.libraryID != null) return false;
        if (phoneNo != null ? !phoneNo.equals(user.phoneNo) : user.phoneNo != null) return false;
        if (emailID != null ? !emailID.equals(user.emailID) : user.emailID != null) return false;
        return !(password != null ? !password.equals(user.password) : user.password != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (libraryID != null ? libraryID.hashCode() : 0);
        result = 31 * result + (phoneNo != null ? phoneNo.hashCode() : 0);
        result = 31 * result + (emailID != null ? emailID.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (isLibrarian ? 1 : 0);
        return result;
    }

    public boolean validate(String libraryID, String password) {

        if (libraryID.equals(this.libraryID) && password.equals(this.password)) {
            return true;
        }

        return false;
    }

    public boolean userIsLibrarian() {
        return this.isLibrarian;
    }

    public String nameOfUser() {
        return name;
    }

    @Override
    public String action() {
        return libraryID + '\t' + name + '\t' + phoneNo + '\t' + emailID + '\n';
    }
}
