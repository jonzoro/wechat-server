package com.jonz.wx.service.impl;

import com.jonz.wx.core.ProjectConstant;
import com.jonz.wx.dao.FunNoteMapper;
import com.jonz.wx.model.FunNote;
import com.jonz.wx.model.FunNote;
import com.jonz.wx.model.vo.NoteFuncInfo;
import com.jonz.wx.service.FunNoteService;
import com.jonz.wx.core.AbstractService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/04/03.
 */
@Service
@Transactional
public class FunNoteServiceImpl extends AbstractService<FunNote> implements FunNoteService {
    
    @Resource
    private FunNoteMapper funNoteMapper;

    @Override
    public void opByNoteFuncInfo(NoteFuncInfo info, WxMpXmlOutTextMessage textMessage) {
        String operation = info.getOperation();
        if (ProjectConstant.OP_ADD.equals(operation)) {
            FunNote funNote = new FunNote();
            funNote.setTitle(info.getTitle());
            funNote.setContent(info.getContent());
            super.save(funNote);
            textMessage.setContent("success:" + funNote.getId());
        } else if (ProjectConstant.OP_UPDATE.equals(operation)) {

        } else if (ProjectConstant.OP_DELETE.equals(operation)) {

        } else if (ProjectConstant.OP_QUERY.equals(operation)) {
            FunNote funNote = super.findBy("title", info.getTitle());
            textMessage.setContent(funNote.toString());
        }
    }
}
