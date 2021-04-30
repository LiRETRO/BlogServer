package net.meloli.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroTest {

    @Test
    public void login() {
//        IniSecurityManagerFactory securityManagerFactory = new IniSecurityManagerFactory("classpath:user.ini");
//        SecurityManager securityManager = securityManagerFactory.getInstance();
//        SecurityUtils.setSecurityManager(securityManager);
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("litianji", "170101");
//        try {
//            subject.login(usernamePasswordToken);
//        } catch (AuthenticationException e) {
//            System.out.println(e.getMessage());
//            System.out.println("登陆失败！");
//        }
//        Assert.assertEquals(true, subject.isAuthenticated());
    }
}
