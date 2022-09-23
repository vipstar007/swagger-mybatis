package com.danni.web.controller;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danni.model.entity.Admins;
import com.danni.model.service.AdminsService;
import com.danni.utils.JsonResult;


import io.swagger.v3.oas.annotations.Operation;

//@RestController注解表示这个类是一个controller。它里面包含了@ResponseBody，因此在下面的方法上不需要进行@ResponseBody声明了
@RestController
@RequestMapping(value = "admins")
public class AdminsController {

	@Autowired
	private AdminsService adminsService;

	@Operation(summary = "Đăng nhập", description = "Đăng nhập")
	@RequestMapping(value = "login", method = RequestMethod.PUT) // @RequestMapping注解:value属性表示映射的路径,method属性用来表示请求的方式
	private JsonResult login(@RequestBody Admins admins) { // @RequestBody表示需要传递的json值
		Admins resultAdmin = adminsService.login(admins);

		JsonResult jsonResult = new JsonResult();
		if (resultAdmin != null) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
			jsonResult.setResult(resultAdmin);
		}

		return jsonResult;
	}

	@Operation(summary = "Thêm vào", description = "Thêm vào")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	private JsonResult add(@RequestBody Admins admins) {
		Integer row = adminsService.add(admins);

		JsonResult jsonResult = new JsonResult();
		if (row > 0) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
		}

		return jsonResult;
	}

	@Operation(summary = "Xóa thông tin theo id", description = "Xóa thông tin theo id")
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	private JsonResult delete(@PathVariable Integer id) { 
		// There is no need to pass json data when deleting, but the parameter id is required, so use
		// @PathVariable annotation parameter
		Integer row = adminsService.delete(id);

		JsonResult jsonResult = new JsonResult();
		if (row > 0) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
		}

		return jsonResult;
	}

	@Operation(summary = "Cập nhật thông tin dựa trên id", description = "Cập nhật thông tin dựa trên id")
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
	private JsonResult update(@RequestBody Admins admins, @PathVariable Integer id) {
		Integer row = adminsService.update(admins);

		JsonResult jsonResult = new JsonResult();
		if (row > 0) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
		}

		return jsonResult;
	}

	@Operation(summary = "Truy vấn thông tin theo id", description = "Truy vấn thông tin theo id")
	@RequestMapping(value = "getBy/{id}", method = RequestMethod.GET)
	private JsonResult queryById(@PathVariable Integer id) {
		Admins admins = adminsService.queryById(id);

		JsonResult jsonResult = new JsonResult();
		if (admins != null) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
			jsonResult.setResult(admins);
		}

		return jsonResult;
	}

	@Operation(summary = "Truy vấn tất cả", description = "Truy vấn tất cả")
	@RequestMapping(value = "getall", method = RequestMethod.GET)
	private JsonResult queryAll() {
		List<Admins> adminLists = adminsService.queryAll();

		JsonResult jsonResult = new JsonResult();
		if (adminLists != null && adminLists.size() > 0) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
			jsonResult.setResult(adminLists);
		}

		return jsonResult;
	}
}
