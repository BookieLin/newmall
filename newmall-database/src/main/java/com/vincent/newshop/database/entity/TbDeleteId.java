package com.vincent.newshop.database.entity;

import javax.persistence.*;

@Table(name = "tb_delete_id")
public class TbDeleteId {
    @Id
    @Column(name = "delete_id")
    private Long deleteId;

    /**
     * @return delete_id
     */
    public Long getDeleteId() {
        return deleteId;
    }

    /**
     * @param deleteId
     */
    public void setDeleteId(Long deleteId) {
        this.deleteId = deleteId;
    }
}