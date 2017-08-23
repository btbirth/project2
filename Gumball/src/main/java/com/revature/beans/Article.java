package com.revature.beans;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ARTICLE")
public class Article {
	@Id
	@Column(name="ARTICLE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="ARTICLE_BODY")
	private String body;
	@Column(name="")
	private Author writer;
	@Column(name="IMAGE")
	private Blob image;
	@ManyToMany
	private ArrayList<Reader> readers;
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_CREATED")
	private Date created;
	@OneToMany(mappedBy="article")
	private ArrayList<Comment> comments;
	
}
