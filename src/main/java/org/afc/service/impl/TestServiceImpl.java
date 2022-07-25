package org.afc.service.impl;

import org.afc.entities.Test;
import org.afc.mappers.TestMapper;
import org.afc.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author czy
 * @since 2022-07-25
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

}
