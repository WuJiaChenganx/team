package teamWeb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAsync
@SpringBootApplication
@MapperScan("teamWeb.mapper")
public class YxwTeamApplication {

    public static void main(String[] args) {
        SpringApplication.run(YxwTeamApplication.class, args);
        System.out.println("\n-----------------------------------------ヾ(◍°∇°◍)ﾉﾞヾ(◍°∇°◍)ﾉﾞ                     启动成功                     ヾ(◍°∇°◍)ﾉﾞヾ(◍°∇°◍)ﾉﾞ-----------------------------------------");
    }

}
