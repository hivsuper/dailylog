package org.lxp.dailylog.web.controller;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.lxp.dailylog.exception.CodeEnum;
import org.lxp.dailylog.exception.DailylogException;
import org.lxp.dailylog.web.util.JsonVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import static org.lxp.dailylog.exception.CodeEnum.INTERNAL_SERVER_ERROR;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RestControllerAdvice
public class ExceptionHandlerController implements ErrorController {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlerController.class);
    private static final String ERROR_PATH = "/error";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.setSerializationInclusion(Include.NON_NULL);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = ERROR_PATH, method = {GET, POST})
    public ModelAndView handleError() {
        CodeEnum codeEnum = CodeEnum.PAGE_NOT_FOUND;
        return resolveException(codeEnum);
    }

    /**
     * implement ErrorController to handle 404
     */
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @ExceptionHandler(DailylogException.class)
    public ModelAndView resolveException(DailylogException e) {
        return resolveException(e, e.getCodeEnum());
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView resolveException(Exception e) {
        return resolveException(e, INTERNAL_SERVER_ERROR);
    }

    private ModelAndView resolveException(Exception e, CodeEnum codeEnum) {
        LOG.error(e.getMessage(), e);
        return resolveException(codeEnum);
    }

    private ModelAndView resolveException(CodeEnum codeEnum) {
        ModelAndView mav = new ModelAndView();
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setExtractValueFromSingleKeyModel(true);
        view.setObjectMapper(MAPPER);
        mav.setView(view);
        mav.addObject(new JsonVo<>(codeEnum, codeEnum.getMessage()));
        return mav;
    }
}