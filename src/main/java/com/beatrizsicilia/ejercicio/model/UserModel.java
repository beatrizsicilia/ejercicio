package com.beatrizsicilia.ejercicio.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("USERS")

public class UserModel {
  @Id
  @Column("USER_ID")
  private Long user_id; 

  @Column("USER")
  private String user; 

  @Column("COMMENT")
  private String comment;

public Long getUser_id() {
    return user_id;
}

public void setUser_id(Long user_id) {
    this.user_id = user_id;
}

public String getUser() {
    return user;
}

public void setUser(String user) {
    this.user = user;
}

public String getComment() {
    return comment;
}

public void setComment(String comment) {
    this.comment = comment;
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    UserModel other = (UserModel) obj;
    if (user_id == null) {
        if (other.user_id != null)
            return false;
    } else if (!user_id.equals(other.user_id))
        return false;
    return true;
} 



}

