package com.hsx.springcloud.dao;

import com.hsx.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int creat(Payment payment);
    public Payment getPaymentById(@Param("id") Integer id);
}
