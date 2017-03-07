package com.safety.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tb_user")
public class User {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Set<MonitoringItem> items;
	@Id
	@GenericGenerator(name="generator",strategy="increment")
	@GeneratedValue(generator = "generator")
	@Column(name="ID",length=11)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="username",length=20)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="password",length=32)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="userId")
	public Set<MonitoringItem> getItems() {
		return items;
	}
	public void setItems(Set<MonitoringItem> items) {
		this.items = items;
	}
	
}
