package org.example.demobuoi1.configs;

import org.example.demobuoi1.entities.SanPham;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//
@Configuration
public class DemoConfigBean {
    @Bean(name ="bean1")
    public SanPham getSanPham1(){
        SanPham sp = new SanPham();
        sp.setMa("PJ1");
        sp.setTen("Iphone 12");
        sp.setTrangThai(1);
        return sp;
    }

    @Bean(name ="bean2")
    public SanPham getSanPham2(){
        SanPham sp = new SanPham();
        sp.setMa("PJ3");
        sp.setTen("Iphone 13");
        sp.setTrangThai(0);
        return sp;
    }

}
