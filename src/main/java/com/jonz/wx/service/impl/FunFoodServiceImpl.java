package com.jonz.wx.service.impl;

import com.jonz.wx.core.AbstractService;
import com.jonz.wx.dao.FunFoodMapper;
import com.jonz.wx.model.FunFood;
import com.jonz.wx.service.FunFoodService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/04/03.
 */
@Service
@Transactional
public class FunFoodServiceImpl extends AbstractService<FunFood> implements FunFoodService {
    @Resource
    private FunFoodMapper funFoodMapper;

    @Override
    public void opByFoodFuncInfo(WxMpXmlOutTextMessage textMessage) {
        // 查询出维护好的菜单
        List<FunFood> foods = super.findAll();
        // 打乱数据
        Collections.shuffle(foods);
        // 设定回复消息
        textMessage.setContent(foods.get(0).getDishName());
    }
}
