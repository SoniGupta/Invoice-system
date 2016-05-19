package com.example.dao;

import com.example.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface InvoiceDao extends JpaRepository<InvoiceEntity,Integer> {
    InvoiceEntity findByInvoiceId( Integer invoice_id);


    InvoiceEntity findTopByOrderByInvoiceNoDesc();


}
