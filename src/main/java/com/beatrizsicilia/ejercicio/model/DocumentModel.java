package com.beatrizsicilia.ejercicio.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("DOCUMENTS")
public class DocumentModel {
   @Id
   @Column("DOC_ID")
   private Long doc_id; 

   @Column("DOC")
   private String doc; 

   @Column("USER_ID")
   private Long user_id;

public Long getDoc_id() {
    return doc_id;
}

public void setDoc_id(Long doc_id) {
    this.doc_id = doc_id;
}

public String getDoc() {
    return doc;
}

public void setDoc(String doc) {
    this.doc = doc;
}

public Long getUser_id() {
    return user_id;
}

public void setUser_id(Long user_id) {
    this.user_id = user_id;
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((doc_id == null) ? 0 : doc_id.hashCode());
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
    DocumentModel other = (DocumentModel) obj;
    if (doc_id == null) {
        if (other.doc_id != null)
            return false;
    } else if (!doc_id.equals(other.doc_id))
        return false;
    return true;
} 

}
