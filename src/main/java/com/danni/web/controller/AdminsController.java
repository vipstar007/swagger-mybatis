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

import io.swagger.annotations.ApiOperation;

//@RestController注解表示这个类是一个controller。它里面包含了@ResponseBody，因此在下面的方法上不需要进行@ResponseBody声明了
@RestController
@RequestMapping(value = "admins")
public class AdminsController {

	@Autowired
	private AdminsService adminsService;

	@ApiOperation("登录")
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

	@ApiOperation("添加")
	@RequestMapping(value = "", method = RequestMethod.POST)
	private JsonResult add(@RequestBody Admins admins) {
		Integer row = adminsService.add(admins);

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
		Integer row = adminsService.delete(id);

		JsonResult jsonResult = new JsonResult();
		if (row > 0) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
		}

		return jsonResult;
	}

	@ApiOperation("根据id更新信息")
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	private JsonResult update(@RequestBody Admins admins, @PathVariable Integer id) {
		Integer row = adminsService.update(admins);

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
		Admins admins = adminsService.queryById(id);

		JsonResult jsonResult = new JsonResult();
		if (admins != null) {
			jsonResult.setResultCode(200);
			jsonResult.setResultName("success");
			jsonResult.setResult(admins);
		}

		return jsonResult;
	}

	@ApiOperation("查询所有")
	@RequestMapping(value = "", method = RequestMethod.GET)
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
