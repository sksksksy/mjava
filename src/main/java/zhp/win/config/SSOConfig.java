package zhp.win.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SSOConfig {
    @Value("${SSOConfig.url}")
    private String sso_url;
    public String getSso_url() {
        return sso_url;
    }

    public void setSso_url(String sso_url) {
        this.sso_url = sso_url;
    }

    @Override
    public String toString() {
        return "SSOConfig{" +
                "sso_url='" + sso_url + '\'' +
                '}';
    }
}
