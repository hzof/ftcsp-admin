package com.cloudht;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.cloudht.*.dao")
@SpringBootApplication
@EnableCaching
public class FtcspApplication {
    public static void main(String[] args) {
        SpringApplication.run(FtcspApplication.class, args);
        System.out.println("ヾ(◍°∇°◍)ﾉﾞ    ftcsp启动成功      ヾ(◍°∇°◍)ﾉﾞ\n");
    }
}
