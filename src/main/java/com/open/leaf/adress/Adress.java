package com.open.leaf.adress;

public class Adress {
	
	
	private String id;
	private String userId;
	private String adress;
    private String country;
    private String city;
    private String postalCode;
    
	public Adress(String id, String userId, String adress, String country, String city, String postalCode) {
		super();
		this.id = id;
		this.userId = userId;
		this.adress = adress;
		this.country = country;
		this.city = city;
		this.postalCode = postalCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


    

	@Override
	public String toString() {
		return "Adress [id=" + id + ", user_id=" + userId + ", adress=" + adress + ", country=" + country + ", city="
				+ city + ", postal_code=" + postalCode + "]";
	}

}
