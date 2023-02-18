package cn.lqy.springboot.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 方法一: 通过@Value注入读取配置文件
    @Value("${name}")
    private String name;
    @Value("${person.name}")
    private String name1;
    @Value("${address[0]}")
    private String address1;
    @Value("${msg1}")
    private String msg1;
    @Value("${msg2}")
    private String msg2;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println(name);
        System.out.println(name1);
        System.out.println(address1);
        System.out.println(msg1);
        System.out.println(msg2);
        return "Hello SpringBoot !";
    }

    // 方法二：使用Environment读取配置文件
    @Autowired
    private Environment env;

    @RequestMapping("/hello1")
    public String hello2(){
        System.out.println(env.getProperty("name"));
        System.out.println(env.getProperty("person.age"));
        System.out.println(env.getProperty("address[0]"));
        return "Hello SpringBoot!";
    }

    // 方法三：使用@ConfigurationProperties，配置文件和具体的类绑定
    @Autowired
    private Person person;

    @RequestMapping("/hello2")
    public String hello3(){
        System.out.println(person); //这里定义了就好，都不用getBean了

        return "Hello SpringBoot!";
    }
}
