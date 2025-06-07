package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HaichejiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HaichejiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HaichejiluView;


/**
 * 还车记录
 *
 * @author 
 * @email 
 * @date 2023-03-09 17:23:57
 */
public interface HaichejiluService extends IService<HaichejiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HaichejiluVO> selectListVO(Wrapper<HaichejiluEntity> wrapper);
   	
   	HaichejiluVO selectVO(@Param("ew") Wrapper<HaichejiluEntity> wrapper);
   	
   	List<HaichejiluView> selectListView(Wrapper<HaichejiluEntity> wrapper);
   	
   	HaichejiluView selectView(@Param("ew") Wrapper<HaichejiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HaichejiluEntity> wrapper);
   	

}

