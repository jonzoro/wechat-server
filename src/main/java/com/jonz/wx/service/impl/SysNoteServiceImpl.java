package com.jonz.wx.service.impl;

import com.jonz.wx.core.ProjectConstant;
import com.jonz.wx.dao.SysNoteMapper;
import com.jonz.wx.model.SysNote;
import com.jonz.wx.model.vo.NoteFuncInfo;
import com.jonz.wx.service.SysNoteService;
import com.jonz.wx.core.AbstractService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/04/02.
 */
@Service
@Transactional
public class SysNoteServiceImpl extends AbstractService<SysNote> implements SysNoteService {

    @Resource
    private SysNoteMapper sysNoteMapper;

    @Override
    public void opByNoteFuncInfo(NoteFuncInfo info, WxMpXmlOutTextMessage textMessage) {
        String operation = info.getOperation();
        if (ProjectConstant.OP_ADD.equals(operation)) {
            SysNote sysNote = new SysNote();
            sysNote.setTitle(info.getTitle());
            sysNote.setContent(info.getContent());
            this.save(sysNote);
            textMessage.setContent("success:" + sysNote.getId());
        }
    }
}
