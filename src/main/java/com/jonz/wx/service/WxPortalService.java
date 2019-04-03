package com.jonz.wx.service;

import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

public interface WxPortalService {
    void outMsgProcessor(WxMpXmlMessage inMessage, WxMpXmlOutMessage outMessage);
}
