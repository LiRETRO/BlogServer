package net.meloli.demo.sys.config;

import net.meloli.demo.sys.util.MvcDataDto;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

public class ReturnValueHandler implements HandlerMethodReturnValueHandler {

    private HandlerMethodReturnValueHandler handlerMethodReturnValueHandler;

    public ReturnValueHandler (HandlerMethodReturnValueHandler handlerMethodReturnValueHandler) {
        this.handlerMethodReturnValueHandler = handlerMethodReturnValueHandler;
    }

    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        return handlerMethodReturnValueHandler.supportsReturnType(methodParameter);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        // 直接返回MvcDataDto
        if (returnValue instanceof MvcDataDto) {
            handlerMethodReturnValueHandler.handleReturnValue(returnValue, methodParameter, modelAndViewContainer, nativeWebRequest);
            return;
        }

        MvcDataDto data = MvcDataDto.getInstance();
        if (returnValue != null) {
            data.setData(returnValue);
        } else {
            data.setData("");
        }
        data.setCode(HttpStatus.OK.value());
        data.setMessage("成功");
        handlerMethodReturnValueHandler.handleReturnValue(data, methodParameter, modelAndViewContainer, nativeWebRequest);
    }
}
