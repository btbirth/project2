package com.revature.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import javax.persistence.Table;

@Entity
@Table(name="READER")
public class Reader {
	@Id
	@Column(name="READER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="USERNAME", nullable=false, unique=true)
	private String username;
	
	@Column(name="EMAIL", nullable=false, unique=true)
	private String email;
	
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	@Column(name="CREDIT_CARD", nullable=false)
	private String CreditCardNumber;
	
	@ManyToMany
	@JoinTable(name="FAVORITES_TABLE")
	private List<Article> favorites;
	
	@OneToMany(mappedBy="reader")
	private List<Comment> comments;

	public Reader() {
		super();
	}

	public Reader(int id, String username, String email, String password, String creditCardNumber,
			List<Article> favorites, List<Comment> comments) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		CreditCardNumber = creditCardNumber;
		this.favorites = favorites;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreditCardNumber() {
		return CreditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		CreditCardNumber = creditCardNumber;
	}

	public List<Article> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Article> favorites) {
		this.favorites = favorites;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Reader [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", CreditCardNumber=" + CreditCardNumber + ", favorites=" + favorites + ", comments=" + comments
				+ "]";
	}
	
	
}
