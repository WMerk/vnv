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
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

        if (getTime() != user.getTime()) return false;
        if (isFindable() != user.isFindable()) return false;
        if (!getUid().equals(user.getUid())) return false;
        if (!getFirstName().equals(user.getFirstName())) return false;
        if (!getLastName().equals(user.getLastName())) return false;
        if (!getMail().equals(user.getMail())) return false;
        if (getMailValid() != null ? !getMailValid().equals(user.getMailValid()) : user.getMailValid() != null)
            return false;
        if (getHashedPw() != null ? !getHashedPw().equals(user.getHashedPw()) : user.getHashedPw() != null)
            return false;
        if (getSalt() != null ? !getSalt().equals(user.getSalt()) : user.getSalt() != null) return false;
        if (getPhone() != null ? !getPhone().equals(user.getPhone()) : user.getPhone() != null) return false;
        if (getPhoneValid() != null ? !getPhoneValid().equals(user.getPhoneValid()) : user.getPhoneValid() != null)
            return false;
        if (getPicPath() != null ? !getPicPath().equals(user.getPicPath()) : user.getPicPath() != null) return false;
        if (getGoogleId() != null ? !getGoogleId().equals(user.getGoogleId()) : user.getGoogleId() != null)
            return false;
        if (getFacebookId() != null ? !getFacebookId().equals(user.getFacebookId()) : user.getFacebookId() != null)
            return false;
        //if (getSessionId() != null ? !getSessionId().equals(user.getSessionId()) : user.getSessionId() != null)
        //    return false;
        return getConfirmationLink() != null ? getConfirmationLink().equals(user.getConfirmationLink()) : user.getConfirmationLink() == null;
    }

    @Override
    public int hashCode() {
        int result = getUid().hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getMail().hashCode();
        result = 31 * result + (getMailValid() != null ? getMailValid().hashCode() : 0);
        result = 31 * result + (getHashedPw() != null ? getHashedPw().hashCode() : 0);
        result = 31 * result + (getSalt() != null ? getSalt().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getPhoneValid() != null ? getPhoneValid().hashCode() : 0);
        result = 31 * result + (int) (getTime() ^ (getTime() >>> 32));
        result = 31 * result + (getPicPath() != null ? getPicPath().hashCode() : 0);
        result = 31 * result + (getGoogleId() != null ? getGoogleId().hashCode() : 0);
        result = 31 * result + (getFacebookId() != null ? getFacebookId().hashCode() : 0);
        result = 31 * result + (isFindable() ? 1 : 0);
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

