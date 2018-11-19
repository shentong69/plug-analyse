package cn.hao.analyse.boot.config;

import cn.hao.component.label.handle.ItemsHandler;
import cn.hao.component.label.handle.PatternsHandler;
import cn.hao.component.label.handle.RootHandler;
import cn.hao.component.label.handle.StageHandler;
import cn.hao.rest.exec.DefaultParser;
import cn.hao.api.IHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianbohao on 2018/10/23.
 */
@Configuration
@ComponentScan(basePackages = "cn.hao")
public class AnalyseConfig {
    private static final Logger logger = LoggerFactory.getLogger(AnalyseConfig.class);

    @Autowired
    private Environment environment = null;


    @Bean("defaultParser")
    public DefaultParser defaultParserService(@Qualifier("rootHandler") RootHandler rootHandler
            , @Qualifier("stageHandler") StageHandler stageHandler
            , @Qualifier("patternsHandler")PatternsHandler patternsHandler
            , @Qualifier("itemsHandler")ItemsHandler itemsHandler){
        DefaultParser defaultParser = new DefaultParser();
        List<IHandler> handlers = new ArrayList<>();
        handlers.add(stageHandler);
        handlers.add(patternsHandler);
        handlers.add(itemsHandler);

        defaultParser.setRootHandler(rootHandler);
        defaultParser.setHandlers(handlers);
        return defaultParser;
    }
}