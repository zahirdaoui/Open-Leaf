package com.open.leaf.user;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class User implements UserDetails{
	
	
	private String id;
	private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private LocalDate dateOfBirth;
    private boolean enabled;
    private boolean locked;
    private boolean credentialsExpired;
    private boolean emailVerified;
    private String profilePictureUrl;
    private boolean phoneVerified;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    
    
    
    
	public User() {
		super();
	}





	public User(String firstName, String lastName, String email, String phoneNumber, String password,
			LocalDate dateOfBirth, boolean enabled, boolean locked, boolean credentialsExpired, boolean emailVerified,
			String profilePictureUrl, boolean phoneVerified, LocalDateTime createdDate,
			LocalDateTime lastModifiedDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.enabled = enabled;
		this.locked = locked;
		this.credentialsExpired = credentialsExpired;
		this.emailVerified = emailVerified;
		this.profilePictureUrl = profilePictureUrl;
		this.phoneVerified = phoneVerified;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	
	
	
	public User(String id, String firstName, String lastName, String email, String phoneNumber, String password,
			LocalDate dateOfBirth, boolean enabled, boolean locked, boolean credentialsExpired, boolean emailVerified,
			String profilePictureUrl, boolean phoneVerified, LocalDateTime createdDate,
			LocalDateTime lastModifiedDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.enabled = enabled;
		this.locked = locked;
		this.credentialsExpired = credentialsExpired;
		this.emailVerified = emailVerified;
		this.profilePictureUrl = profilePictureUrl;
		this.phoneVerified = phoneVerified;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	
    
    
    @Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", password=" + password + ", dateOfBirth=" + dateOfBirth
				+ ", enabled=" + enabled + ", locked=" + locked + ", credentialsExpired=" + credentialsExpired
				+ ", emailVerified=" + emailVerified + ", profilePictureUrl=" + profilePictureUrl + ", phoneVerified="
				+ phoneVerified + ", createdDate=" + createdDate + ", lastModifiedDate=" + lastModifiedDate + "]";
	}

	
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}

	public boolean isPhoneVerified() {
		return phoneVerified;
	}

	public void setPhoneVerified(boolean phoneVerified) {
		this.phoneVerified = phoneVerified;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public void setPassword(String password) {
		this.password = password;
	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}
