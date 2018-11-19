package cn.hao.analyse.boot.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Tianbohao on 2018/10/23.
 */
@Component
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        super();
        packages(new String[]{
                "cn.hao.rest"
        });
//        register(MultiPartFeature.class);
    }

}
