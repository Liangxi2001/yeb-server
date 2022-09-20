package com.yebProject.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yebProject.server.mapper.NationMapper;
import com.yebProject.server.pojo.Nation;
import com.yebProject.server.service.INationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liangxi
 * @since 2022-03-22
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

}
