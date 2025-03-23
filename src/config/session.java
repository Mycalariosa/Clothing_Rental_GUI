
package config;


import javax.swing.JDesktopPane;


import javax.swing.JDesktopPane;

public class session {
    
    private static session instance;
    private int userId;
    private String lname;
    private String fname;
    private String contact;
    private String username;
    private String email;
    private String status;
    private String userType;
    private JDesktopPane mainDesktop;

    private session() {} 

    public static session getInstance() {
        if (instance == null) {
            instance = new session();
        }
        return instance;
    }

    public void setUser(int userId, String fname, String lname, String contact, String username, String email) {
        this.userId = userId;
        this.fname = fname;
        this.lname = lname;
        this.contact = contact;
        this.username = username;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void clearSession() {
        this.userId = 0;
        this.fname = null;
        this.lname = null;
        this.contact = null;
        this.username = null;
        this.email = null;
        this.status = null;
        this.userType = null;
        this.mainDesktop = null;
    }
}
