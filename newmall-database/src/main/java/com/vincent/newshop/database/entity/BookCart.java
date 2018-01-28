package com.vincent.newshop.database.entity;

import javax.persistence.*;

@Table(name = "book_cart")
public class BookCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    private Integer number;

    @Column(name = "user_id")
    private Long userId;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return book_id
     */
    public Long getBookId() {
        return bookId;
    }

    /**
     * @param bookId
     */
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    /**
     * @return number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}