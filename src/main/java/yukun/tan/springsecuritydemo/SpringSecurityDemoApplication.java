package yukun.tan.springsecuritydemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.TimeZone;

@Slf4j
@SpringBootApplication
public class SpringSecurityDemoApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(SpringSecurityDemoApplication.class, args);
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanxi"));
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String name = env.getProperty("server.servlet.context-path");
        String port = env.getProperty("local.server.port");
        log.info("\n----------------------------------------------------------\n\t"
                + "Application Important matter is running! Access URLs:\n\t" + "Local: \t\thttp://localhost:" + port + name
                + "/\n\t" + "External: \thttp://" + ip + ":" + port + name + "/\n\t" + "swagger-ui: \thttp://" + ip + ":"
                + port + name + "/swagger-ui.html\n\t" + "Doc: \t\thttp://" + ip + ":" + port + name + "/doc.html\n"
                + "----------------------------------------------------------");
    }

}
