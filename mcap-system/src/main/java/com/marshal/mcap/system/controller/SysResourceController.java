package com.marshal.mcap.system.controller;


import com.marshal.mcap.core.controller.BaseController;
import com.marshal.mcap.core.component.ResponseData;
import com.marshal.mcap.system.entity.SysResource;
import com.marshal.mcap.system.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * author: Marshal
 * Date: 2018/11/5
 * Time: 22:06
 * Description:
 */
@RestController
@RequestMapping("/sys/resource")
public class SysResourceController extends BaseController {

    @Autowired
    SysResourceService sysResourceService;

    @RequestMapping("/query")
    public ResponseData query(@RequestBody SysResource condition, int pageNum, int pageSize) {
        List<SysResource> list = sysResourceService.select(condition, pageNum, pageSize);
        return new ResponseData(list);
    }

    @RequestMapping("/save")
    public ResponseData save(@RequestBody SysResource sysResource) {
        if (!getValidator().isValid(sysResource)) {
            return new ResponseData(false, getValidator().getErrors(sysResource));
        }
        sysResourceService.save(sysResource);
        return new ResponseData(true, "保存成功");
    }

    @RequestMapping("/delete")
    public ResponseData delete(@RequestParam("selectedIds") Long[] selectedIds) {
        sysResourceService.delete(selectedIds);
        return new ResponseData(true, "删除成功");
    }

    @RequestMapping("/queryById")
    public SysResource queryById(@RequestParam Long id) {
        return sysResourceService.selectByPrimaryKey(id);
    }

    @RequestMapping("/getResourceOptions")
    public List<Map> getFunctionOptions() {
        return sysResourceService.getResourceOptions();
    }
}
