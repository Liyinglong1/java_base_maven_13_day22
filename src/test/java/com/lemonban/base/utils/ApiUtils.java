package com.lemonban.base.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.lemonban.base.pojo.ApiCaseDetail;
import com.lemonban.base.pojo.ApiInfo;
import com.lemonban.base.pojo.CellData;
import com.lemonban.base.pojo.ExtractRespData;
import com.lemonban.base.pojo.SqlChecker;

/**
 * 接口工具类
 *
 */
public class ApiUtils {

	// 创建一个数据池，保存要回写ApiCaseDetail实体的ActualResp、ExtractRespData
	public static List<CellData> cellDataList = new ArrayList<CellData>();
	
	public static void setCellData(CellData cellData) {
		cellDataList.add(cellData);
	}
	
	public static List<CellData> getCellDataList() {
		return cellDataList;
	}

	// ------------------------------------------------------------------------
	// 创建一个数据池，保存要回写SqlCheckUtils中的Actual、CheckResult
	public static List<CellData> sqlCellDataList = new ArrayList<CellData>();

	public static void setSqlCellData(CellData cellData) {
		sqlCellDataList.add(cellData);
	}

	public static List<CellData> getSqlCellDataList() {
		return sqlCellDataList;
	}

	/**
	 * 为数据提供者提供数据--》工具方法
	 */
	public static Object[][] getData() {
		// 接口的基本信息
		ArrayList<Object> apiInfoList = ExcelUtils.readExcel("/case17/test_case_01.xlsx", 0, ApiInfo.class);
		// 读取测试用例的详细数据列表
		ArrayList<Object> apiCaseDetailList = ExcelUtils.readExcel("/case17/test_case_01.xlsx", 1, ApiCaseDetail.class);
		// 测试用例的表数据验证信息
		ArrayList<Object> sqlCheckerList = ExcelUtils.readExcel("/case17/test_case_01.xlsx", 2, SqlChecker.class);

		// 每条测试用例都对应有一个接口基本信息：接口基本信息是测试用例对象的一个属性
		// 把List的中间数据重新组装到map中去
		Map<String, ApiInfo> apiInfoMap = new HashMap<String, ApiInfo>();
		for (Object obj : apiInfoList) {
			ApiInfo apiInfo = (ApiInfo) obj;
			apiInfoMap.put(apiInfo.getApiId(), apiInfo);
		}

		// 准备一个容器，存放不同测试用例的前置或者后置sql列表
		Map<String, List<SqlChecker>> sqlMap = new HashMap<String, List<SqlChecker>>();

		// 遍历所有的sql验证数据
		for (Object sqlObj : sqlCheckerList) {
			SqlChecker sqlChecker = (SqlChecker) sqlObj;
			// 以测试用例的id拼接上-再拼接上sql的类型
			String key = sqlChecker.getCaseId() + "-" + sqlChecker.getType();
			List<SqlChecker> checkerList = sqlMap.get(key);
			if (checkerList == null) {
				checkerList = new ArrayList<SqlChecker>();
			}
			checkerList.add(sqlChecker);// 添加到对应的篮子
			sqlMap.put(key, checkerList);
		}
		
		//这个for循环就是把apiCaseDetail 对象所有数据加进去 然后把它转换成二维数组
		Object[][] datas = new Object[apiCaseDetailList.size()][];
		for (int i = 0; i < apiCaseDetailList.size(); i++) {
			// 获取到当前索引的api的详细信息对象
			ApiCaseDetail apiCaseDetail = (ApiCaseDetail) apiCaseDetailList.get(i);
			// 获取到api详细信息对象设置到用例详细对象中
			apiCaseDetail.setApiInfo(apiInfoMap.get(apiCaseDetail.getApiId()));

			// 设置前置后后置验证sql列表
			String beforeKey = apiCaseDetail.getCaseId() + "-" + "bf";// 1-bf
																		// 2-af
			String afterKey = apiCaseDetail.getCaseId() + "-" + "af";
			apiCaseDetail.setBeforeCheckerList(sqlMap.get(beforeKey));
			apiCaseDetail.setAfterCheckerList(sqlMap.get(afterKey));

			Object[] itemArray = { apiCaseDetail };
			datas[i] = itemArray;
		}
		return datas;
	}

	/**
	 * 提取数据
	 * 
	 * @param actualResult  实际响应结果
	 * @param apiCaseDetail 测试用例对象
	 */
	public static void extractResqData(String actualResult, ApiCaseDetail apiCaseDetail) {
		// 这是excel中设计的提取数据的json字符串
		String extractRespDataStr = apiCaseDetail.getExtractRespData();
		List<ExtractRespData> respDataList = JSONObject.parseArray(extractRespDataStr, ExtractRespData.class);
		if (respDataList == null) {
			return;
		}
		// 把实际响应结果解析成jsonpath对应的对象
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(actualResult);

		for (ExtractRespData extractRespData : respDataList) {
			// 要提取数据对应的jsonPath
			String jsonPath = extractRespData.getJsonPath();
			// 参数名称
			String paramName = extractRespData.getParamName();
			// 通过jsonpath技术提取对应的数据
			Object paramValue = JsonPath.read(document, jsonPath);
			// 提取出来的数据放到全局数据池
			ParamUtils.addGlobalData(paramName, paramValue);
		}
	}

}
