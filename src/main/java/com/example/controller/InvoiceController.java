package com.example.controller;

import com.example.controller.dto.InvoiceCreateDto;
import com.example.dao.CustomerDao;
import com.example.dao.InvoiceDao;
import com.example.dao.ItemsDao;
import com.example.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    ItemsDao itemsDao;

    @RequestMapping(value = "/addinvoice", method = RequestMethod.POST)
    public InvoiceEntity addInvoice(@RequestBody InvoiceCreateDto invoiceCreateDto) {
        CustomerEntity customerEntity=customerDao.findByPhone(invoiceCreateDto.getCustomerPhone());
        if(customerEntity==null){
            customerEntity=new CustomerEntity();
        }


        customerEntity.setPhone(invoiceCreateDto.getCustomerPhone());
        customerEntity.setName(invoiceCreateDto.getCustomerName());
        customerEntity.setEmail(invoiceCreateDto.getCustomerEmail());
        customerEntity.setAddress(invoiceCreateDto.getCustomerAddress());
        customerDao.save(customerEntity);



        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setInvoiceNo(invoiceCreateDto.getInvoiceNo());
        invoiceEntity.setInvoiceDate(invoiceCreateDto.getInvoiceDate());
        invoiceEntity.setCustomerEntity(customerEntity);

        invoiceEntity = invoiceDao.save(invoiceEntity);


        List<ItemsEntity> itemsEntityList = invoiceCreateDto.getItems();

        for (ItemsEntity itemsEntity : itemsEntityList) {
            itemsEntity.setInvoice(invoiceEntity);
        }
        itemsEntityList = itemsDao.save(itemsEntityList);

        invoiceEntity.setItemsEntities(itemsEntityList);


        return invoiceEntity;


    }

    @RequestMapping("/invoices")
    public List<InvoiceEntity> show() {
        List<InvoiceEntity> invoiceList;
        invoiceList = invoiceDao.findAll();
        return invoiceList;

    }

    @RequestMapping(value = "/customer")
    @ResponseBody
    public List<CustomerEntity> disp() {
        List<CustomerEntity> customerList;
        customerList = customerDao.findAll();
        return customerList;
    }
    
    @RequestMapping(value = "/deleteinvoice")
    @ResponseBody
    public String deleteinvoice(Integer invoiceId) {
        InvoiceEntity invoice=new InvoiceEntity(invoiceId);
        invoiceDao.delete(invoice);

        return "User succesfully deleted!";
    }


    @RequestMapping(value="/invoicedetails")
    @ResponseBody

    public InvoiceEntity findinvoice(Integer invoice_id){
        InvoiceEntity invoiceEntity=invoiceDao.findByInvoiceId(invoice_id);
        return invoiceEntity;
    }

    @RequestMapping(value="/lastinvoice")
    @ResponseBody
    public InvoiceEntity lastinvoice(){
        InvoiceEntity invoiceEntity=invoiceDao.findTopByOrderByInvoiceNoDesc();
        return invoiceEntity;
    }

}


