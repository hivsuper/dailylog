package org.lxp.dailylog.web.controller;

import static org.lxp.dailylog.exception.CodeEnum.INTERNAL_SERVER_ERROR;
import static org.lxp.dailylog.exception.CodeEnum.PAGE_NOT_FOUND;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.lxp.dailylog.exception.CodeEnum;
import org.lxp.dailylog.exception.DailylogException;
import org.lxp.dailylog.web.util.JsonVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RestControllerAdvice
public class ExceptionHandlerController {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlerController.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();
    static {
        MAPPER.setSerializationInclusion(Include.NON_NULL);
    }

    @ResponseBody
    @RequestMapping(value = "/404", method = { GET, POST })
    public JsonVo<String> _404() {
        return new JsonVo<>(PAGE_NOT_FOUND, "Page Not Found");
    }

    @ExceptionHandler(DailylogException.class)
    public ModelAndView resolveException(DailylogException e) {
        return resolveException(e, e.getCodeEnum(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView resolveException(Exception e) {
        return resolveException(e, INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    private ModelAndView resolveException(Exception e, CodeEnum codeEnum, String msg) {
        ModelAndView mav = new ModelAndView();
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setExtractValueFromSingleKeyModel(true);
        mav.setView(view);
        view.setObjectMapper(MAPPER);
        JsonVo<String> returnVO = new JsonVo<>(codeEnum, msg);
        mav.addObject(returnVO);
        LOG.error(e.getMessage(), e);
        return mav;
    }
}