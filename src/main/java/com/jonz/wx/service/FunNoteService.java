package com.jonz.wx.service;
import com.jonz.wx.model.FunNote;
import com.jonz.wx.core.Service;
import com.jonz.wx.model.vo.NoteFuncInfo;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;


/**
 * Created by CodeGenerator on 2019/04/03.
 */
public interface FunNoteService extends Service<FunNote> {
    void opByNoteFuncInfo(NoteFuncInfo info, WxMpXmlOutTextMessage textMessage);
}
