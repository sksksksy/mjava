package zhp.win;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zhp.win.config.SSOConfig;

@SpringBootApplication
@MapperScan("zhp.win.mybatis")
public class WinApplication {

    public static void main(String[] args) {
        SpringApplication.run(WinApplication.class, args);
    }

}
