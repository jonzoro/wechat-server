package com.jonz.wx.service;
import com.jonz.wx.model.SysNote;
import com.jonz.wx.core.Service;
import com.jonz.wx.model.vo.NoteFuncInfo;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;


/**
 * Created by CodeGenerator on 2019/04/02.
 */
public interface SysNoteService extends Service<SysNote> {
    void opByNoteFuncInfo(NoteFuncInfo info, WxMpXmlOutTextMessage textMessage);
}
