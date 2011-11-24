package com.vaadin.addon.jpacontainer.itest.fieldfactory.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Customer {
    
    @Id
    private String name;
    
    @ManyToMany
    private Set<CustomerGroup> customerGroups;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Set<CustomerGroup> getCustomerGroups() {
        return customerGroups;
    }

    public void setCustomerGroups(Set<CustomerGroup> groups) {
        this.customerGroups = groups;
    }

}