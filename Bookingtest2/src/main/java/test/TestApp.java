package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import web.mem.dao.MemDao;
import web.mem.vo.MemVo;


public class TestApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MemDao memDao = applicationContext.getBean(MemDao.class);

        MemVo memVo = new MemVo();
        memVo.setMemName("oop");
        memVo.setMemPid("f129998384");
        memVo.setMemPh("099998384");
        memVo.setMemGender((byte)1);
        memVo.setMemEmail("dkjfa@gmail.com");
        memVo.setMemPwd("dkjfagmacom");
        memVo.setMemAddress("tomcat");
        memVo.setMemAuth((byte)1);
        memVo.setMemVio((byte)1);

        System.out.println(memDao.insert(memVo));
    }
}
