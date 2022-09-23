package com.danni.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danni.model.entity.Department;
import com.danni.model.service.DepartmentService;
import com.danni.utils.JsonResult;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "dep")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@ApiOperation("添加")
	@RequestMapping(value = "", method = RequestMethod.POST)
	private JsonResult add(@RequestBody Department department) {
		Integer row = departmentService.add(department);

		JsonResult jsonResult = new JsonResult();
		if (row > 0) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
		}

		return jsonResult;
	}

	@ApiOperation("根据id删除信息")
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	private JsonResult delete(@PathVariable Integer id) { // 删除的时候不需要传递json数据,但是需要有参数id，因此用
															// @PathVariable注解参数
		Integer row = departmentService.delete(id);

		JsonResult jsonResult = new JsonResult();
		if (row > 0) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
		}

		return jsonResult;
	}

	@ApiOperation("根据id更新信息")
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	private JsonResult update(@RequestBody Department department, @PathVariable Integer id) {
		Integer row = departmentService.update(department);

		JsonResult jsonResult = new JsonResult();
		if (row > 0) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
		}

		return jsonResult;
	}

	@ApiOperation("根据id查询信息")
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	private JsonResult queryById(@PathVariable Integer id) {
		Department department = departmentService.queryById(id);

		JsonResult jsonResult = new JsonResult();
		if (department != null) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
			jsonResult.setResult(department);
		}

		return jsonResult;
	}

	@ApiOperation("查询所有")
	@RequestMapping(value = "", method = RequestMethod.GET)
	private JsonResult queryAll() {
		List<Department> departLists = departmentService.queryAll();

		JsonResult jsonResult = new JsonResult();
		if (departLists != null && departLists.size() > 0) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
			jsonResult.setResult(departLists);
		}

		return jsonResult;
	}

}
