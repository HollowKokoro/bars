package com.example.barsserver.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    Date created;
    Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(id, contract.id) && Objects.equals(created, contract.created) && Objects.equals(updated, contract.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, updated);
    }
}
