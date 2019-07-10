package com.gy.upms.component;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * @Auther: guofeng
 * @Date: 2019/5/10 16:27
 * @Description: i18n 资源文件读取
 */
@Component
public class MessageUtils {
//    @Autowired
    private MessageSource messageSource;

    public MessageUtils(MessageSource messageSource)
    {
        this.messageSource=messageSource;
    }

    /**
     * @param code：对应文本配置的key.
     * @return 对应地区的语言消息字符串
     */
    public String getMessage(String code){
        return this.getMessage(code,new Object[]{});
    }

    public String getMessage(String code,String defaultMessage){
        return this.getMessage(code,null,defaultMessage);
    }

    public String getMessage(String code,String defaultMessage,Locale locale){
        return this.getMessage(code,null,defaultMessage,locale);
    }

    public String getMessage(String code,Locale locale){
        return this.getMessage(code,null,"",locale);
    }

    public String getMessage(String code,Object[] args){
        return this.getMessage(code,args,"");
    }

    public String getMessage(String code,Object[] args,Locale locale){
        return this.getMessage(code,args,"",locale);
    }

    public String getMessage(String code,Object[] args,String defaultMessage){
        Locale locale = LocaleContextHolder.getLocale();
        return this.getMessage(code,args, defaultMessage,locale);
    }

    public String getMessage(String code,Object[]args,String defaultMessage,Locale locale){
        return messageSource.getMessage(code,args, defaultMessage,locale);
    }

    /**
     * 获取资源文件后进行格式化
     * @param codeFormate 需要格式化的字符串
     * @param code  参数变量
     * @return
     */
    public String getMessageFormate(String codeFormate, String code){
        String codeFormateStr=getMessage(codeFormate);
        String codeStr=getMessage(code);
      return   MessageFormat.format(codeFormateStr,codeStr);
    }
}
