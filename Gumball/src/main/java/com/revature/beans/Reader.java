package com.revature.beans;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.JoinTable;
=======
>>>>>>> d00292207c02a4d2a1e24293e8d99ca4ab6d2625
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="READER")
public class Reader {
	@Id
	@Column(name="READER_ID")
<<<<<<< HEAD
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reader")
=======
	@GeneratedValue(strategy=GenerationType.AUTO)
>>>>>>> d00292207c02a4d2a1e24293e8d99ca4ab6d2625
	private int id;
	
	@Column(name="USERNAME", nullable=false, unique=true)
	private String username;
	
	@Column(name="EMAIL", nullable=false, unique=true)
	private String email;
	
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	@Column(name="CREDIT_CARD", nullable=false)
	private String CreditCardNumber;
<<<<<<< HEAD
	
	@ManyToMany
	@JoinTable(name="FAVORITES_TABLE")
	private ArrayList<Article> favorites;
	
=======
	@ManyToMany(mappedBy="reader")
	private ArrayList<Article> favorites;
>>>>>>> d00292207c02a4d2a1e24293e8d99ca4ab6d2625
	@OneToMany(mappedBy="reader")
	private ArrayList<Comment> comments;

	public Reader() {
		super();
	}

	public Reader(int id, String username, String email, String password, String creditCardNumber,
			ArrayList<Article> favorites, ArrayList<Comment> comments) {
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

	public ArrayList<Article> getFavorites() {
		return favorites;
	}

	public void setFavorites(ArrayList<Article> favorites) {
		this.favorites = favorites;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Reader [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", CreditCardNumber=" + CreditCardNumber + ", favorites=" + favorites + ", comments=" + comments
				+ "]";
	}
	
	
}
