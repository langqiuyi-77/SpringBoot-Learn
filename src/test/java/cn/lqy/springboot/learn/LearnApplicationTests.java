package cn.lqy.springboot.learn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//3.编写测试方法

@SpringBootTest(classes = UserService.class)
//这里加不加classes取决于当前测试类(UserService)所在包的位置：
// 在引导类所在包的子包或同级则不需要加(会自动找引导类)，否则要加
class LearnApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        userService.add();
    }

}
