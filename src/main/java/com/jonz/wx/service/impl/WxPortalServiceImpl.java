package com.jonz.wx.service.impl;

import com.jonz.wx.core.ProjectConstant;
import com.jonz.wx.model.vo.NoteFuncInfo;
import com.jonz.wx.service.SysNoteService;
import com.jonz.wx.service.WxPortalService;
import me.chanjar.weixin.mp.bean.message.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WxPortalServiceImpl implements WxPortalService {

    private static final String KEY_FUNC = "func";
    private static final String KEY_INFO = "info";

    private final SysNoteService sysNoteService;

    @Autowired
    public WxPortalServiceImpl(SysNoteService sysNoteService) {
        this.sysNoteService = sysNoteService;
    }

    /***
     * 消息回复处理
     */
    public void outMsgProcessor(WxMpXmlMessage inMessage, WxMpXmlOutMessage outMessage) {
        if (outMessage instanceof WxMpXmlOutTextMessage) {
            textMsgProcessor(inMessage, (WxMpXmlOutTextMessage) outMessage);
        } else if (outMessage instanceof WxMpXmlOutImageMessage) {

        } else if (outMessage instanceof WxMpXmlOutVoiceMessage) {

        }
    }

    private void textMsgProcessor(WxMpXmlMessage inMessage, WxMpXmlOutTextMessage textMessage) {
        String inContent = inMessage.getContent();
        // 解析发送的内容并进行对应的处理
        funcSwitcher(inContent, textMessage);
    }

    private void funcSwitcher(String content, WxMpXmlOutTextMessage textMessage) {
        Map<String, Object> parser = contentParser(content);
        String func = parser.get(KEY_FUNC).toString();
        if (ProjectConstant.FUNC_NOTE.equals(func)) {
            // 备忘录
            NoteFuncInfo info = (NoteFuncInfo) parser.get(KEY_INFO);
            sysNoteService.opByNoteFuncInfo(info, textMessage);

        } else if (ProjectConstant.FUNC_WEATHER.equals(func)) {
            // 天气查询

        } else {
            textMessage.setContent(ProjectConstant.RESPONSE_DEFAULT);
        }
    }

    private Map<String, Object> contentParser(String content) {
        String[] contentArray = content.split(ProjectConstant.SEPARATOR);
        String func = contentArray[0];
        Map<String, Object> result = new HashMap<>();
        if (ProjectConstant.FUNC_NOTE.equals(func)) {
            String operation = contentArray[1];
            String title = contentArray[2];
            String note = contentArray[3];

            result.put(KEY_FUNC, func);
            result.put(KEY_INFO, NoteFuncInfo.newBuilder().operation(operation).title(title).content(note).build());
        } else if (ProjectConstant.FUNC_WEATHER.equals(func)) {

        } else {
            result.put(KEY_FUNC, ProjectConstant.FUNC_DEFAULT);
        }
        return result;
    }
}
