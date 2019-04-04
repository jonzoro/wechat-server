package com.jonz.wx.service.impl;

import com.jonz.wx.core.AbstractService;
import com.jonz.wx.dao.FunFoodMapper;
import com.jonz.wx.model.FunFood;
import com.jonz.wx.model.vo.FoodFuncInfo;
import com.jonz.wx.service.FunFoodService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

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
    public void opByFoodFuncInfo(FoodFuncInfo info, WxMpXmlOutTextMessage textMessage) {
        // 查询出维护好的菜单
        String type = info.getType();
        String whereCond = String.format("type like '%%%s%%'", type);

        Condition condition = new Condition(FunFood.class);
        condition.createCriteria().andCondition(whereCond);
        List<FunFood> foods = super.findByCondition(condition);

        // 打乱数据
        Collections.shuffle(foods);

        // 设定回复消息
        FunFood answer = foods.get(0);
        String answerContent = String.format("【%s】【%s】", answer.getRestaurant(), answer.getDishName());
        textMessage.setContent(answerContent);
    }
}
