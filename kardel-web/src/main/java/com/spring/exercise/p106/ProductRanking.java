package com.spring.exercise.p106;

import com.spring.exercise.p91.Product;
import lombok.Data;

import java.util.Date;

/**
 * Created by dennis on 2018/12/17.
 */
@Data
public class ProductRanking {

    private Product bestSeller;

    private Date fromDate;

    private Date toDate;
}
