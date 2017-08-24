package com.revature.beans;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AUTHOR")
public class Author {
	@Id
	@Column(name="AUTHOR_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="USERNAME", nullable=false, unique=true)
	private String Username;
	
	@Column(name="EMAIL", nullable=false, unique=true)
	private String email;
	
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	@OneToMany(mappedBy="author")
	private ArrayList<Article> articles;

	public Author() {
		super();
	}

	public Author(int id, String username, String email, String password, ArrayList<Article> articles) {
		super();
		this.id = id;
		Username = username;
		this.email = email;
		this.password = password;
		this.articles = articles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
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

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", Username=" + Username + ", email=" + email + ", password=" + password
				+ ", articles=" + articles + "]";
	}
	
	
	
}
