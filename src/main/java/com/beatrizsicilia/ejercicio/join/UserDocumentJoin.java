package com.beatrizsicilia.ejercicio.join;

public class UserDocumentJoin {
    private Long user_id; 
    private String user; 
    private String comment; 
    private Long doc_id; 
    private String doc;
    
    public UserDocumentJoin(Long user_id, String user, String comment, Long doc_id, String doc) {
        this.user_id = user_id;
        this.user = user;
        this.comment = comment;
        this.doc_id = doc_id;
        this.doc = doc;
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((doc_id == null) ? 0 : doc_id.hashCode());
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
        UserDocumentJoin other = (UserDocumentJoin) obj;
        if (doc_id == null) {
            if (other.doc_id != null)
                return false;
        } else if (!doc_id.equals(other.doc_id))
            return false;
        if (user_id == null) {
            if (other.user_id != null)
                return false;
        } else if (!user_id.equals(other.user_id))
            return false;
        return true;
    } 

    
}
