package com.offcn.controller;

import com.offcn.po.Car;

import com.offcn.po.TestUser;
import com.offcn.po.UserBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
@EnableConfigurationProperties({UserBody.class, TestUser.class})
public class DemoController {
    @Value("${offcn_ip}")
    public String ip;

    @Value("${offcn_port}")
    public Integer port;

    @Autowired
    private UserBody userBody;

     @Autowired
     private TestUser testUser;
     // 获取自定义属性
    @RequestMapping("/getip")
    public String getip(){
        return ip+":"+port;
    }
    @RequestMapping("/getUserBody")
    public String getUserBody(){
        return userBody.toString();
    }
//  自定义配置文件读取
    @RequestMapping("/getTestUser")
    public String getTestUser(){
        return testUser.toString();
    }
    @RequestMapping("/hello")
    public String hello(){
        return "hellowenwen";
    }
    @RequestMapping("/findcar")
    public Car findCar(){
        Car car = new Car(1, "红旗", 8888.66D,new Date());
        return car;
    }
    @RequestMapping("/findall")
    public List<Car> findAll(){
        List list = new ArrayList();
        Car car1 = new Car(1, "红旗", 88881.6D, new Date());
        Car car2 = new Car(1, "长城", 88882.6D, new Date());
        Car car3 = new Car(1, "哈弗", 88883.6D, new Date());
        Car car4 = new Car(1, "玛莎拉蒂", 8888888.6D, new Date());
        list.add(car1);
        list.add(car2);
        list.add(car3);
        list.add(car4);
        return list;
    }
    // 参数传递方式1
    @RequestMapping("/findOne")
    public Car findOne(@RequestParam Integer id){
        Car car =new Car();
        car.setId(id);
        car.setName("test001");
        car.setPrice(1111.1D);
        car.setCreateDate(new Date());
        return car;
    }
    // 参数传递方式2  路径用斜杠隔开
    @RequestMapping("/findPath/{id}/{name}")
    public String findPath(@PathVariable("id") Integer id,@PathVariable("name") String name){

        return id+name;
    }
    // 3   接收的json 格式    前端通过什么样的方法将json数据传输到后台  ajax
    @RequestMapping("findCarToJson")
    public Car findCarToJson(@RequestBody Car car){
        return car;    // PostMan

    }
    //  自动封装
    @RequestMapping("/findCar2")
    public Car findCar2(Car car){
        return car;
    }
    // 日期当字符串处理了    springMVC 自动封装  将字符串转日期格式  转换器  xml
    //  增加一个自动封装参数的转换器  参数类型进行转换
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }
}
