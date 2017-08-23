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
	@Column(name="USERNAME")
	private String Username;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PASSWORD")
	private String password;
	@OneToMany(mappedBy="author")
	private ArrayList<Article> articles;
}
