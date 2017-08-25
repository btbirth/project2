package com.revature.beans;

import java.sql.Blob;
import java.util.List;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@Column(name="TITLE", nullable=false)
	private String title;
	
	@Column(name="ARTICLE_BODY", nullable=false)
	private String body;
	
	@ManyToOne
	@JoinColumn(nullable=false, name="AUTHOR_ID")
	private Author author;
	
	@Column(name="IMAGE",nullable=true)
	private Blob image;
	
	@ManyToMany(mappedBy="favorites")
	private List<Reader> readers;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_CREATED", nullable=false)
	private Date created;
	
	@OneToMany(mappedBy="article")
	private List<Comment> comments;

	public Article() {
		super();
	}

	public Article(int id, String title, String body, Author author, Blob image, List<Reader> readers,
			Date created, List<Comment> comments) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.author = author;
		this.image = image;
		this.readers = readers;
		this.created = created;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public List<Reader> getReaders() {
		return readers;
	}

	public void setReaders(List<Reader> readers) {
		this.readers = readers;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", body=" + body + ", image=" + image
				+ ", created=" + created + ", comments=" + comments + "]";
	}
	
	
	
	
}
