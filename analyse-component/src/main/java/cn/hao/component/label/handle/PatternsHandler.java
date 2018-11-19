package cn.hao.component.label.handle;

import cn.hao.api.IHandler;
import cn.hao.api.ITransferCache;
import cn.hao.component.IComponent;
import cn.hao.component.label.pojo.PatternsLabel;
import cn.hao.component.label.pojo.StageLabel;
import org.apache.oro.text.regex.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 解析队列2
 * 分段落
 * Created by Tianbohao on 2018/11/14.
 */
@Component("patternsHandler")
public class PatternsHandler implements IHandler {
    private final Logger logger = LoggerFactory.getLogger(PatternsHandler.class);
    private Perl5Matcher matcher;
    private Perl5Compiler compiler;

    PatternsHandler() {
        matcher = new Perl5Matcher();
        compiler = new Perl5Compiler();
    }

    @Override
    public void hand(ITransferCache cache) {
        StageLabel stageLabel = (StageLabel) cache.getLabel();
        String line;
        BufferedReader br = cache.getBufferedReader();

        PatternsLabel patternsLabel = stageLabel.getPatternsLabel();
        String head = patternsLabel.getHead();
        String tail = patternsLabel.getTail();

        if (null == head) {
            head = IComponent.ALL_MATCH;
        }
        if (null == tail) {
            tail = IComponent.ALL_MATCH;
        }
        try {
            Pattern headPattern = compiler.compile(head);
            Pattern tailPattern = compiler.compile(tail);
            while ((line = br.readLine()) != null) {
                //TODO 有需要擦除的数据
                PatternMatcherInput matcherInput = new PatternMatcherInput(line);
                boolean match = matcher.matches(matcherInput, headPattern);
                if (match) {
                    StringBuffer sb = new StringBuffer();
                    do {
                        sb.append(line).append(" ");
                        line = br.readLine();
                        if (line == null) {
                            continue;
                        }
                        matcherInput = new PatternMatcherInput(line);
                    } while (!matcher.matches(matcherInput, tailPattern));

                    cache.getStageDatas().add(sb.toString());
                }
            }
        } catch (MalformedPatternException e) {
            logger.error("pattern or compiler error",e);
        } catch (IOException e) {
            logger.error("buffer reader line error",e);
        }
    }
}
