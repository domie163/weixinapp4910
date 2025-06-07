package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CheliangpinpaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CheliangpinpaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CheliangpinpaiView;


/**
 * 车辆品牌
 *
 * @author 
 * @email 
 * @date 2023-03-09 17:23:57
 */
public interface CheliangpinpaiService extends IService<CheliangpinpaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheliangpinpaiVO> selectListVO(Wrapper<CheliangpinpaiEntity> wrapper);
   	
   	CheliangpinpaiVO selectVO(@Param("ew") Wrapper<CheliangpinpaiEntity> wrapper);
   	
   	List<CheliangpinpaiView> selectListView(Wrapper<CheliangpinpaiEntity> wrapper);
   	
   	CheliangpinpaiView selectView(@Param("ew") Wrapper<CheliangpinpaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheliangpinpaiEntity> wrapper);
   	

}

