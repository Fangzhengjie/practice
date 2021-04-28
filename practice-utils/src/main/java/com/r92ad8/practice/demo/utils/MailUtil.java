package com.r92ad8.practice.demo.utils;

import com.r92ad8.core.constants.JoinerConstant;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class MailUtil {


    //邮件发送的对象，用于邮件发送
    @Autowired
    private JavaMailSender initMailSender;

    @Autowired
    private static JavaMailSender mailSender;

    @PostConstruct
    public void init() {
        mailSender = initMailSender;
    }

    /**
     * 发送简单的文本邮件
     *
     * @param from    发件人
     * @param subject 邮件主题，即邮件的邮件名称
     * @param content 邮件内容
     * @param to      收件人
     * @param cc      抄送人
     */
    @SneakyThrows
    public static void sendSimpleTextMail(String from, String[] to, String[] cc, String subject, String content) {
        //附件处理需要进行二进制传输
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.displayName());
        //设置必要的邮件元素
        //设置发件人
        mimeMessageHelper.setFrom(from);
        //设置邮件的主题
        mimeMessageHelper.setSubject(subject);
        //设置邮件的内容，区别是否是HTML邮件
        mimeMessageHelper.setText(content, false);
        //设置邮件的收件人
        mimeMessageHelper.setTo(to);
        //设置非必要的邮件元素，在使用helper进行封装时，这些数据都不能够为空
        if (ArrayUtils.isNotEmpty(cc)) {
            //设置邮件的抄送人
            mimeMessageHelper.setCc(cc);
        }
        //发送
        mailSender.send(mimeMessage);
    }

    /**
     * 发送简单的文本邮件
     *
     * @param from    发件人
     * @param to      收件人
     * @param cc      抄送人,支持逗号分割
     * @param subject
     * @param content
     */
    public static void sendSimpleTextMail(String from, String to[], String cc, String subject, String content) {
        //抄送人cc
        String[] carbonCopyRecipients = {};
        if (StringUtils.isNotBlank(cc)) {
            carbonCopyRecipients = cc.split(JoinerConstant.COMMA);
        }
        sendSimpleTextMail(from, to, carbonCopyRecipients, subject, content);
    }

    /**
     * 发送简单的文本邮件
     *
     * @param from    发件人
     * @param to      收件人,支持逗号分割
     * @param cc      抄送人,支持逗号分割
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    public static void sendSimpleTextMail(String from, String to, String cc, String subject, String content) {
        //发送人
        String[] sendTo = {};
        if (StringUtils.isNotBlank(to)) {
            sendTo = to.split(JoinerConstant.COMMA);
        }
        //抄送人
        String[] carbonCopyRecipients = {};
        if (StringUtils.isNotBlank(cc)) {
            carbonCopyRecipients = cc.split(JoinerConstant.COMMA);
        }
        sendSimpleTextMail(from, sendTo, carbonCopyRecipients, subject, content);
    }

    /**
     * 发送简单的文本邮件
     *
     * @param from    发件人
     * @param to      收件人,支持逗号分割
     * @param cc      抄送人
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    public static void sendSimpleTextMail(String from, String to, String[] cc, String subject, String content) {
        //发送人
        String[] sendTo = {};
        if (StringUtils.isNotBlank(to)) {
            sendTo = to.split(JoinerConstant.COMMA);
        }
        sendSimpleTextMail(from, sendTo, cc, subject, content);
    }


    /**
     * 发送Html邮件
     *
     * @param from    发件人
     * @param subject 邮件主题，即邮件的邮件名称
     * @param content 邮件内容
     * @param to      收件人
     * @param cc      抄送人
     */
    @SneakyThrows
    public static void sendNormalHtmlMail(String from, String[] to, String[] cc, String subject, String content) {
        //附件处理需要进行二进制传输
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.displayName());
        //设置必要的邮件元素
        //设置发件人
        mimeMessageHelper.setFrom(from);
        //设置邮件的主题
        mimeMessageHelper.setSubject(subject);
        //设置邮件的内容，区别是否是HTML邮件
        mimeMessageHelper.setText(content, true);
        //设置邮件的收件人
        mimeMessageHelper.setTo(to);
        //设置非必要的邮件元素，在使用helper进行封装时，这些数据都不能够为空
        if (ArrayUtils.isNotEmpty(cc)) {
            //设置邮件的抄送人
            mimeMessageHelper.setCc(cc);
        }
        //发送
        mailSender.send(mimeMessage);
    }

    /**
     * 发送Html邮件,内置图片
     *
     * @param from    发件人
     * @param subject 邮件主题，即邮件的邮件名称
     * @param content 邮件内容
     * @param to      收件人
     * @param cc      抄送人
     */
    @SneakyThrows
    public static void sendHtmlMailWithInLine(String from, String[] to, String[] cc, String subject, String content, File... picture) {
        //附件处理需要进行二进制传输
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.displayName());
        //设置必要的邮件元素
        //设置发件人
        mimeMessageHelper.setFrom(from);
        //设置邮件的主题
        mimeMessageHelper.setSubject(subject);
        //设置邮件的内容，区别是否是HTML邮件
        mimeMessageHelper.setText(content, true);
        //设置邮件的收件人
        mimeMessageHelper.setTo(to);
        //设置非必要的邮件元素，在使用helper进行封装时，这些数据都不能够为空
        if (ArrayUtils.isNotEmpty(cc)) {
            //设置邮件的抄送人
            mimeMessageHelper.setCc(cc);
        }
        if (ArrayUtils.isNotEmpty(picture)) {
            for (int i = 0; i < picture.length; i++) {
                File file = picture[i];
                mimeMessageHelper.addInline(String.valueOf(i),file);
            }
        }
        //发送
        mailSender.send(mimeMessage);
    }
    /**
     * 发送Html邮件,内置图片
     *
     * @param from    发件人
     * @param subject 邮件主题，即邮件的邮件名称
     * @param content 邮件内容
     * @param to      收件人
     * @param cc      抄送人
     */
    @SneakyThrows
    public static void sendHtmlMailWithAttachment(String from, String[] to, String[] cc, String subject, String content, File... picture) {
        //附件处理需要进行二进制传输
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.displayName());
        //设置必要的邮件元素
        //设置发件人
        mimeMessageHelper.setFrom(from);
        //设置邮件的主题
        mimeMessageHelper.setSubject(subject);
        //设置邮件的内容，区别是否是HTML邮件
        mimeMessageHelper.setText(content, true);
        //设置邮件的收件人
        mimeMessageHelper.setTo(to);
        //设置非必要的邮件元素，在使用helper进行封装时，这些数据都不能够为空
        if (ArrayUtils.isNotEmpty(cc)) {
            //设置邮件的抄送人
            mimeMessageHelper.setCc(cc);
        }
        if (ArrayUtils.isNotEmpty(picture)) {
            for (int i = 0; i < picture.length; i++) {
                File file = picture[i];
                mimeMessageHelper.addAttachment(file.getName(),file );
            }
        }
        //发送
        mailSender.send(mimeMessage);
    }

    /**
     * 发送Html邮件
     *
     * @param from    发件人
     * @param to      收件人
     * @param cc      抄送人,支持逗号分割
     * @param subject
     * @param content
     */
    public static void sendNormalHtmlMail(String from, String to[], String cc, String subject, String content) {
        //抄送人cc
        String[] carbonCopyRecipients = {};
        if (StringUtils.isNotBlank(cc)) {
            carbonCopyRecipients = cc.split(JoinerConstant.COMMA);
        }
        sendNormalHtmlMail(from, to, carbonCopyRecipients, subject, content);
    }

    /**
     * 发送Html邮件
     *
     * @param from    发件人
     * @param to      收件人,支持逗号分割
     * @param cc      抄送人,支持逗号分割
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    public static void sendNormalHtmlMail(String from, String to, String cc, String subject, String content) {
        //发送人
        String[] sendTo = {};
        if (StringUtils.isNotBlank(to)) {
            sendTo = to.split(JoinerConstant.COMMA);
        }
        //抄送人
        String[] carbonCopyRecipients = {};
        if (StringUtils.isNotBlank(cc)) {
            carbonCopyRecipients = cc.split(JoinerConstant.COMMA);
        }
        sendNormalHtmlMail(from, sendTo, carbonCopyRecipients, subject, content);
    }

    /**
     * 发送Html邮件
     *
     * @param from    发件人
     * @param to      收件人,支持逗号分割
     * @param cc      抄送人
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    public static void sendNormalHtmlMail(String from, String to, String[] cc, String subject, String content) {
        //发送人
        String[] sendTo = {};
        if (StringUtils.isNotBlank(to)) {
            sendTo = to.split(JoinerConstant.COMMA);
        }
        sendNormalHtmlMail(from, sendTo, cc, subject, content);
    }


}
