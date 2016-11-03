package com.vnv.Entity;

import redis.clients.johm.Attribute;
import redis.clients.johm.Id;
import redis.clients.johm.Indexed;
import redis.clients.johm.Model;

import java.util.Arrays;
import java.util.Date;


/**
 * Created by Gabriel on 02.11.2016.
 */
@Model
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
    private byte[] hashedPw;
    @Attribute
    private byte[] salt;
    @Indexed
    @Attribute
    private String phone;
    @Attribute
    private Boolean phoneValid;
    @Attribute
    private long time = new Date().getTime();
    //@Attribute
    //private Date registrationDate = new Date();
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

    public byte[] getHashedPw() {
        return hashedPw;
    }

    public void setHashedPw(byte[] hashedPw) {
        this.hashedPw = hashedPw;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
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

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                ", mailValid=" + mailValid +
                ", hashedPw=" + Arrays.toString(hashedPw) +
                ", salt=" + Arrays.toString(salt) +
                ", phone='" + phone + '\'' +
                ", phoneValid=" + phoneValid +
                ", time=" + time +
                ", googleId='" + googleId + '\'' +
                ", facebookId='" + facebookId + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", confirmationLink='" + confirmationLink + '\'' +
                '}';
    }
}

