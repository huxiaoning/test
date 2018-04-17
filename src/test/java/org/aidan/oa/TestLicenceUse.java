package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.*;

public class TestLicenceUse {

    private static final String ADDR = "http://localhost:8084";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "64725e8d4f1a49f29ecd399d6dc6af31";

    // 新增
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/licence-use?userId=5ff6b2eaf861409fbdd8ca675fd4ed13";
        Map<String, Object> params = new HashMap<>();
        params.put("flowNum", "");
        params.put("startTime", new Date());
        params.put("applyUserId", "111");
        params.put("applyName", "111");
        params.put("quarter", 55);
        params.put("quarterName", "1111");
        params.put("orgId", "1");
        params.put("orgName", "dw   qfeww");
        params.put("companyId", "111");
        params.put("companyName", "222");
        params.put("reason", "11111v");
        params.put("licenceUseType", 22);
        params.put("licenceUseTypeValue", "222");
        params.put("licenceUseTypeName", "333");
        params.put("useSeal", "0");
        params.put("predictLendOutTime", new Date());
        params.put("predictReturnBackTime", new Date());
        params.put("ifSubmit", "0");

        List<Map<String, Object>> licenceName1List = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("licenceName1Type", 51);
            item.put("licenceName1TypeValue", "wwww");
            item.put("licenceName1TypeName", "111");
            licenceName1List.add(item);
        }
        params.put("licenceName1List", licenceName1List);

        List<Map<String, Object>> licenceName2List = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("licenceName2Type", 52);
            item.put("licenceName2TypeValue", "wwww");
            item.put("licenceName2TypeName", "111");
            licenceName2List.add(item);
        }
        params.put("licenceName2List", licenceName2List);


        List<Map<String, Object>> licenceTypeList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("licenceType", 52);
            item.put("licenceTypeValue", "wwww");
            item.put("licenceTypeName", "111");
            licenceTypeList.add(item);
        }
        params.put("licenceTypeList", licenceTypeList);

        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }
    // 查询
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/form/base/" + id;
        Map<String, Object> params = new HashMap<>();
        params.put("type", 149);
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

}
