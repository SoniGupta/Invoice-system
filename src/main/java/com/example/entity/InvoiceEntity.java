package com.example.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "invoice")
public class InvoiceEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invoice_id")
    private Integer invoiceId;

    @NotNull
    @Column(name = "invoice_no")
    private Integer invoiceNo;

    @NotNull
    @Column(name = "invoice_date")
    private String invoiceDate;


//    @NotNull
//    @Column(name = "phone")
//    private String phone;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "phone")
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemsEntity> itemsEntities;

    public InvoiceEntity() {

    }

    public InvoiceEntity(Integer invoiceNo, String invoiceDate, CustomerEntity customerEntity) {
        this.invoiceNo = invoiceNo;
        this.invoiceDate = invoiceDate;
        this.customerEntity=customerEntity;

    }

    public InvoiceEntity(Integer invoiceId) {
        this.invoiceId=invoiceId;
    }


    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(Integer invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;

    }

    public List<ItemsEntity> getItemsEntities() {
        return itemsEntities;
    }

    public void setItemsEntities(List<ItemsEntity> itemsEntities) {
        this.itemsEntities = itemsEntities;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }
}

