package org.cinjug.integration.domain;

/**
 * User: tkaufman
 * Date: Jun 17, 2008
 */
public class Customer {

    private Long id;
    private Integer number;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
