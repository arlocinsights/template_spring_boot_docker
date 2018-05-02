package walletMonitor.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import walletMonitor.dto.UserDTO;

@Entity
@Table(name="users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @NotNull
  @Size(min = 3, max = 80)
  private String email;
  
  @NotNull
  @Size(min = 2, max = 80)
  private String name;
  
  @NotNull
  @Size(min = 2, max = 80)
  private String password;

  public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public User() { }


public User(UserDTO u) {
	this.id=u.getId();
	this.email = u.getEmail();
	this.name = u.getName();
	this.password = u.getPassword();
}

  public User(long id) { 
    this.id = id;
  }

  public User(String email, String name,String password) {
    this.email = email;
    this.name = name;
    this.password = password;
  }

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  public String getEmail() {
    return email;
  }
  
  public void setEmail(String value) {
    this.email = value;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String value) {
    this.name = value;
  }
  
} // class User
