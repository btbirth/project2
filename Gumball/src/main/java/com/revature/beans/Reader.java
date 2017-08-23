package com.revature.beans;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="READER")
public class Reader {
	@Id
	@Column(name="READER_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reader")
	@SequenceGenerator(name="reader", sequenceName="READER_SEQUENCE")
	private int id;
	@Column(name="USERNAME")
	private String username;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="CREDIT_CARD")
	private String CreditCardNumber;
	private ArrayList<Article> favorites;
	private ArrayList<Comment> comments;
}
