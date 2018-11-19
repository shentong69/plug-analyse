package cn.hao.rest;

import cn.hao.model.ResultInfo;
import cn.hao.rest.exec.DefaultParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Tianbohao on 2018/10/30.
 */
@Component
@Path("/analyse")
public class AnalyseRest {
    private Logger logger = LoggerFactory.getLogger(AnalyseRest.class);
    @Autowired
    private DefaultParser parser;

    @GET
    @Consumes(MediaType.APPLICATION_JSON+";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
    public Response run2analyse(@QueryParam("filePath") String filePath, @QueryParam("xmlPath") String xmlPath) {
        logger.debug("analyse success");
        ResultInfo resultInfo = null;
        try {
            resultInfo = parser.parse(filePath, xmlPath);
        } catch (FileNotFoundException e) {
            logger.error("file not found,{}",filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response.ok(resultInfo).build();
    }
}