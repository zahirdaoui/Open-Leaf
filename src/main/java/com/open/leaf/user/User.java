package com.open.leaf.user;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.open.leaf.adress.Adress;
import com.open.leaf.engagement.Engagement;



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
    private boolean emailVerified;
    private String profilePictureUrl;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private List<Adress> adress;
    
    
	public User(String id, String firstName, String lastName, String email, String phoneNumber, String password,
			LocalDate dateOfBirth, boolean enabled, boolean locked, boolean emailVerified, String profilePictureUrl,
			LocalDateTime createdDate, LocalDateTime lastModifiedDate, List<Adress> adress,
			List<Engagement> engagement) {
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
		this.emailVerified = emailVerified;
		this.profilePictureUrl = profilePictureUrl;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.adress = adress;
		this.engagement = engagement;
	}


    
    
    
    public List<Adress> getAdress() {
		return adress;
	}





	public void setAdress(List<Adress> adress) {
		this.adress = adress;
	}





	public List<Engagement> getEngagement() {
		return engagement;
	}





	public void setEngagement(List<Engagement> engagement) {
		this.engagement = engagement;
	}

	private List<Engagement> engagement;

    
	public User() {
		super();
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

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", password=" + password + ", dateOfBirth=" + dateOfBirth
				+ ", enabled=" + enabled + ", locked=" + locked + ", emailVerified=" + emailVerified
				+ ", profilePictureUrl=" + profilePictureUrl + ", createdDate=" + createdDate + ", lastModifiedDate="
				+ lastModifiedDate + ", adress=" + adress + ", engagement=" + engagement + "]";
	}
}
