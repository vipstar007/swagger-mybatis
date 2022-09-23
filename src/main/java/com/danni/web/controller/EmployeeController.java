package com.danni.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danni.model.entity.Employee;
import com.danni.model.service.EmployeeService;
import com.danni.utils.JsonResult;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/api/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@Operation(summary = "Thêm vào", description = "Thêm vào")
	@RequestMapping(value = "", method = RequestMethod.POST)
	private JsonResult add(@RequestBody Employee employee) {
		Integer row = employeeService.add(employee);

		JsonResult jsonResult = new JsonResult();
		if (row > 0) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
		}

		return jsonResult;
	}

	@Operation(summary = "Xóa thông tin theo id", description = "Xóa thông tin theo id")
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	private JsonResult delete(@PathVariable Integer id) { // 删除的时候不需要传递json数据,但是需要有参数id，因此用
															// @PathVariable注解参数
		Integer row = employeeService.delete(id);

		JsonResult jsonResult = new JsonResult();
		if (row > 0) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
		}

		return jsonResult;
	}

	@Operation(summary = "Cập nhật thông tin dựa trên id", description = "Cập nhật thông tin dựa trên id")
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	private JsonResult update(@RequestBody Employee employee, @PathVariable Integer id) {
		Integer row = employeeService.update(employee);

		JsonResult jsonResult = new JsonResult();
		if (row > 0) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
		}

		return jsonResult;
	}

	@Operation(summary = "Truy vấn thông tin theo id", description = "Truy vấn thông tin theo id")
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	private JsonResult queryById(@PathVariable Integer id) {
		Employee employee = employeeService.queryById(id);

		JsonResult jsonResult = new JsonResult();
		if (employee != null) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
			jsonResult.setResult(employee);
		}

		return jsonResult;
	}

	@Operation(summary = "Truy vấn tất cả", description = "Truy vấn tất cả")
	@RequestMapping(value = "", method = RequestMethod.GET)
	private JsonResult queryAll() {
		List<Employee> empLists = employeeService.queryAll();

		JsonResult jsonResult = new JsonResult();
		if (empLists != null && empLists.size() > 0) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
			jsonResult.setResult(empLists);
		}

		return jsonResult;
	}

}
