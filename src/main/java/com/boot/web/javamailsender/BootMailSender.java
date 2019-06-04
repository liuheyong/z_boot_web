package com.boot.web.javamailsender;

import com.boot.commons.constants.Constants;
import com.boot.web.defaultcontroller.DefaultController;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * @author: LiuHeYong
 * @create: 2019-06-04
 * @description: 邮件发送
 **/
@RestController
public class BootMailSender extends DefaultController {

    public static final Logger logger = LoggerFactory.getLogger(BootMailSender.class);

    @Autowired
    private JavaMailSender mailSender;

    /**
     * @date: 2019/5/27
     * @return: void
     * @description: 测试邮件发送
     */
    @RequestMapping(value = Constants.BOOT + "/sendSimpleMail")
    public void sendSimpleMail() throws Exception {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("1711334386@qq.com");
            message.setTo("1711334386@qq.com");
            message.setSubject("主题：测试邮件");
            message.setText("测试邮件内容");
            mailSender.send(message);
        } catch (Exception e) {
            logger.error("邮件发送异常", e);
            throw new Exception("邮件发送异常");
        }
    }

    /**
     * @date: 2019/5/27
     * @return: void
     * @description: 测试邮件发送(带附件)
     */
    @RequestMapping(value = Constants.BOOT + "/sendAttachmentsMail")
    public void sendAttachmentsMail() throws Exception {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("17682347237@163.com");
            helper.setTo("1711334386@qq.com");
            helper.setSubject("主题：有附件");
            helper.setText("有附件的邮件");
            FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
            helper.addAttachment("附件-1.jpg", file);
            helper.addAttachment("附件-2.jpg", file);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            logger.error("邮件发送异常", e);
            throw new MessagingException("邮件发送异常");
        } catch (Exception e) {
            logger.error("邮件发送异常", e);
            throw new Exception("邮件发送异常");
        }
    }

    /**
     * @date: 2019/5/27
     * @return: void
     * @description: 测试邮件发送(嵌入静态资源)
     */
    @RequestMapping(value = Constants.BOOT + "/sendInlineMail")
    public void sendInlineMail() throws Exception {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("17682347237@163.com");
            helper.setTo("1711334386@qq.com");
            helper.setSubject("主题：嵌⼊静态资源");
            helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);
            FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
            helper.addInline("weixin", file);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            logger.error("邮件发送异常", e);
            throw new Exception("邮件发送异常");
        }
    }

    /**
     * @date: 2019/5/27
     * @return: void
     * @description: 测试邮件发送(嵌入模板)
     */
    @RequestMapping(value = Constants.BOOT + "/sendTemplateMail")
    public void sendTemplateMail() throws Exception {
        VelocityEngine velocityEngine = new VelocityEngine();
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("17682347237@163.com");
            helper.setTo("1711334386@qq.com");
            helper.setSubject("主题：模板邮件");
            Map<String, Object> model = new HashedMap(4);
            model.put("username", "didi");
            String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "template.vm", "UTF-8", model);
            helper.setText(text, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            logger.error("邮件发送异常", e);
            throw new MessagingException("邮件发送异常");
        } catch (MailException e) {
            logger.error("邮件发送异常", e);
            throw new Exception("邮件发送异常");
        }
    }

}
