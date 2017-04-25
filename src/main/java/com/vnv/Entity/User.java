package com.vnv.Entity;

import org.json.JSONObject;
import redis.clients.johm.*;

@Model
@SupportAll
public class User {

    @Id
    private Long uid;
    @Indexed
    @Attribute
    private String firstName;
    @Indexed
    @Attribute
    private String lastName;
    private String name;
    @Indexed
    @Attribute
    private String mail;
    @Attribute
    private Boolean mailValid;
    @Attribute
    private String hashedPw;
    private String password;
    private String newPassword;
    @Attribute
    private String salt;
    @Indexed
    @Attribute
    private String phone;
    @Attribute
    private Boolean phoneValid;
    @Attribute
    private long time;
    @Attribute
    private String picPath;
    @Indexed
    @Attribute
    private String googleId;
    @Indexed
    @Attribute
    private String facebookId;
    @Indexed
    @Attribute
    private String sessionId;
    @Indexed
    @Attribute
    private String confirmationLink;
    @Indexed
    @Attribute
    private boolean findable = true;



    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        setName(firstName + " " + getLastName());
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        setName(getFirstName() + " "+ lastName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getMailValid() {
        return mailValid;
    }

    public void setMailValid(Boolean mailValid) {
        this.mailValid = mailValid;
    }

    public String getHashedPw() {
        return hashedPw;
    }

    public void setHashedPw(String hashedPw) {
        this.hashedPw = hashedPw;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getPhoneValid() {
        return phoneValid;
    }

    public void setPhoneValid(Boolean phoneValid) {
        this.phoneValid = phoneValid;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getConfirmationLink() {
        return confirmationLink;
    }

    public void setConfirmationLink(String confirmationLink) {
        this.confirmationLink = confirmationLink;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isFindable() {
        return findable;
    }

    public void setFindable(boolean findable) {
        this.findable = findable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!getUid().equals(user.getUid())) return false;
        if (!getFirstName().equals(user.getFirstName())) return false;
        if (!getLastName().equals(user.getLastName())) return false;
        return getMail().equals(user.getMail());
    }

    @Override
    public int hashCode() {
        int result = getUid().hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getMail().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                ", mailValid=" + mailValid +
                ", hashedPw='" + hashedPw + '\'' +
                ", password='" + password + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", salt='" + salt + '\'' +
                ", phone='" + phone + '\'' +
                ", phoneValid=" + phoneValid +
                ", time=" + time +
                ", picPath='" + picPath + '\'' +
                ", googleId='" + googleId + '\'' +
                ", facebookId='" + facebookId + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", confirmationLink='" + confirmationLink + '\'' +
                '}';
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject(this);
        json.remove("hashedPw");
        json.remove("salt");
        json.remove("password");
        json.remove("newPassword");
        json.remove("confirmationLink");
        json.remove("sessionId");
        json.remove("googleId");
        json.remove("facebookId");
        return json;
    }
}

