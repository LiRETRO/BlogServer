package net.meloli.demo.sys.global.handler;

import net.meloli.demo.sys.dto.ExceptionDto;
import net.meloli.demo.sys.mongodb.util.MongoDBUtils;
import net.meloli.demo.sys.util.IdWorker;
import net.meloli.demo.sys.util.MvcDataDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MongoTemplate mongoTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public MvcDataDto exceptionHandler(Exception ex) {
        MvcDataDto result = MvcDataDto.getInstance();
        result.setMessage("方法异常：" + ex.getMessage());
        // 打印日志
        logger.error("******************************** " + dateFormat.format(new Date()) + " 异常开始 ********************************");
        // 将异常保存进Mongodb
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setExceptionId(IdWorker.getFullDateId());
        exceptionDto.setExceptionMsg(ex.getMessage());
        StackTraceElement[] error = ex.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : error) {
            logger.error(stackTraceElement.toString());
            sb.append(stackTraceElement.toString()+"\n");
        }
        logger.error(sb.toString());
        exceptionDto.setExceptionMsgDetail(sb.toString());
        exceptionDto.setExceptionTime(new Date());
        mongoTemplate.save(exceptionDto, MongoDBUtils.CollectionName.GLOBAL_EXCEPTION_INFO);
        return result;
    }
}
