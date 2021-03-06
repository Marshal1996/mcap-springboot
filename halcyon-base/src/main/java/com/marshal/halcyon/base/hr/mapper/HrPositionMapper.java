package com.marshal.halcyon.base.hr.mapper;

import com.marshal.halcyon.base.hr.entity.HrPosition;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface HrPositionMapper extends Mapper<HrPosition> {

    List<HrPosition> query(HrPosition condition);

    List<Map> selectByUnitId(Long unitId);

    List<Map> getParentPositionOptions();

    List<HrPosition> getPositionByEmployeeCode(String empCode);

}