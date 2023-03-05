package teamWeb;

import lombok.Data;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileProperties.class
}
)
@MapperScan("teamWeb.mapper")
public class YxwTeamApplication {

    public static void main(String[] args) {
        SpringApplication.run(YxwTeamApplication.class, args);
        System.out.println("\n-----------------------------------------ヾ(◍°∇°◍)ﾉﾞヾ(◍°∇°◍)ﾉﾞ                     启动成功                     ヾ(◍°∇°◍)ﾉﾞヾ(◍°∇°◍)ﾉﾞ-----------------------------------------");
    }

}
