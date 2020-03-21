package zhp.win;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("zhp.win.mybatis")
public class WinApplication {

    public static void main(String[] args) {
        SpringApplication.run(WinApplication.class, args);
    }

}
