package com.offcn.po;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//@Getter
//@Setter
@Data    // 替代get和set
@AllArgsConstructor    // 所有参数的有参构造函数
@NoArgsConstructor     //无参数构造函数
public class Car {
    private Integer id;
    private String name;
    private Double price;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date createDate;

}
