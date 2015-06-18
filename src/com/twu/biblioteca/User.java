package com.twu.biblioteca;

public class User {
    private String name;
    private String libraryID;
    private String phoneNo;
    private String emaidID;
    private String password;
    private boolean isLibraian;

    public User(String name, String libraryID, String phoneNo, String emaidID, String password, boolean isLibraian) {
        this.name = name;
        this.libraryID = libraryID;
        this.phoneNo = phoneNo;
        this.password = password;
        this.emaidID=emaidID;
        this.isLibraian = isLibraian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (isLibraian != user.isLibraian) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (libraryID != null ? !libraryID.equals(user.libraryID) : user.libraryID != null) return false;
        if (phoneNo != null ? !phoneNo.equals(user.phoneNo) : user.phoneNo != null) return false;
        if (emaidID != null ? !emaidID.equals(user.emaidID) : user.emaidID != null) return false;
        return !(password != null ? !password.equals(user.password) : user.password != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (libraryID != null ? libraryID.hashCode() : 0);
        result = 31 * result + (phoneNo != null ? phoneNo.hashCode() : 0);
        result = 31 * result + (emaidID != null ? emaidID.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (isLibraian ? 1 : 0);
        return result;
    }

    public boolean validate(String libraryID, String password) {

        if (libraryID.equals(this.libraryID) && password.equals(this.password)) {
            return true;
        }

        return false;
    }
}
