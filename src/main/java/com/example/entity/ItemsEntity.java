package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "items")
public class ItemsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Integer itemId;

    @NotNull
    @Column(name = "item_detail")
    private String itemDetail;


    @NotNull
    @Column(name = "item_quantity")
    private Double quantity;

    @NotNull
    @Column(name = "unit_price")
    private Double unitPrice;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "invoice_id")
    private InvoiceEntity invoice;

    public ItemsEntity() {

    }

    public ItemsEntity(String itemDetail, Double unitPrice, Double quantity, InvoiceEntity invoice) {
        this.itemDetail = itemDetail;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.invoice = invoice;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public InvoiceEntity getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntity invoice) {
        this.invoice = invoice;
    }
}