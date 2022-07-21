package com.example.demo.Registration.token;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import com.example.demo.appuser.AppUser;
@Entity
public class ConfirmationToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private int uid;
	
	@Column(nullable =false)
	private String token;
	
	@Column(nullable =false)
	private LocalDateTime createdat;
	
	@Column(nullable =false)
	private LocalDateTime expiredat;
	
	private LocalDateTime confirmedat;
	
	@ManyToOne(fetch = FetchType.LAZY,   cascade = CascadeType.ALL)
	@JoinColumn(name="USER_ID")    
	private AppUser appUser;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getCreatedat() {
		return createdat;
	}

	public void setCreatedat(LocalDateTime createdat) {
		this.createdat = createdat;
	}

	public LocalDateTime getExpiredat() {
		return expiredat;
	}

	public void setExpiredat(LocalDateTime expiredat) {
		this.expiredat = expiredat;
	}

	public LocalDateTime getConfirmedat() {
		return confirmedat;
	}

	public void setConfirmedat(LocalDateTime confirmedat) {
		this.confirmedat = confirmedat;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	
	public ConfirmationToken(String token, LocalDateTime createdat, LocalDateTime expiredat, AppUser appUser) {
		super();
		this.token = token;
		this.createdat = createdat;
		this.expiredat = expiredat;
		this.appUser = appUser;
	}

	public ConfirmationToken(int uid, String token, LocalDateTime createdat, LocalDateTime expiredat,
			LocalDateTime confirmedat, AppUser appUser) {
		super();
		this.uid = uid;
		this.token = token;
		this.createdat = createdat;
		this.expiredat = expiredat;
		this.confirmedat = confirmedat;
		this.appUser = appUser;
	}

	public ConfirmationToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ConfirmationToken [uid=" + uid + ", token=" + token + ", createdat=" + createdat + ", expiredat="
				+ expiredat + ", confirmedat=" + confirmedat + ", appUser=" + appUser + "]";
	}

	public void save(ConfirmationToken confirmationToken) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
