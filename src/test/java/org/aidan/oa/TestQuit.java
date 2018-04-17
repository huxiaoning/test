package org.aidan.oa;

import org.aidan.util.HttpUtil;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestQuit {
    private static final String ADDR = "http://localhost:8084";
//    private static final String ADDR = "http://10.50.8.29:8084";
//    private static final String ADDR = "http://10.50.8.29";

    private static final String id = "235479ce2683452eb227ca9e0acecc63";

    // 新增
    @Test
    public void test1() {
        String url = ADDR + "/recon/check/oa/quit?userId=5ff6b2eaf861409fbdd8ca675fd4ed13";
        Map<String, Object> params = new HashMap<>();
        params.put("flowNum", "11111");
        params.put("applyUserId", "111");
        params.put("applyName", "111");
        params.put("quarter", 55);
        params.put("quarterName", "1111");
        params.put("orgId", "1");
        params.put("orgName", "dw   qfeww");

        params.put("entryTime", new Date());
        params.put("expectQuitTime", new Date());
        params.put("reason", "111111111111");
        params.put("transferUserId", "111111111111");
        params.put("transferUserName", "111111111111");
        params.put("retainPaperList", "1");
        params.put("paperDocument", "1");
        params.put("electronicDocument", "1");
        params.put("externalBusinessRelationsDocking", "1");
        params.put("workPositionOfficeArrangement", "1");
        params.put("todoWorkTransfer", "1");
        params.put("ownerOrgUnfinishedHandoverInstructions", "1111111111111111111111111111111");
        params.put("loan", "1");
        params.put("reimbursementCost", "1");
        params.put("payableMoney", "1");
        params.put("otherMoney", "1");
        params.put("financeOrgUnfinishedHandoverInstructions", "2222222222222222222222222");
        params.put("computer", "1");
        params.put("officeEquipment", "1");
        params.put("enterpriseMailboxCancellation", "1");
        params.put("writeOffOaCloudHomeSystem", "1");
        params.put("itOrgUnfinishedHandoverInstructions", "3333333333333333333333333333333");
        params.put("entranceGuardFingerprintDeletion", "1");
        params.put("returnRemainingBusinessCard", "1");
        params.put("officeSupplies", "1");
        params.put("fileCabinetOfficeKey", "1");
        params.put("otherValuables", "1");
        params.put("administrationOrgUnfinishedHandoverInstructions", "44444444444444444444444444");
        params.put("laborContractTermination", "1");
        params.put("employeesPersonnelFilesTurnedOut", "1");
        params.put("stopPayFiveSocialInsuranceAndOneHousingFund", "1");
        params.put("wageAccounting", "1");
        params.put("certificateOfDeparture", "1");
        params.put("humanOrgUnfinishedHandoverInstructions", "55555555555555555555555555555555555555");

        params.put("ifSubmit", "0");

        String result = HttpUtil.post(url, params, null);
        System.out.println(result);
    }

    // 查询
    @Test
    public void test2() {
        String url = ADDR + "/recon/check/oa/form/base/" + id;
        Map<String, Object> params = new HashMap<>();
        params.put("type", "172");
        String result = HttpUtil.get(url, params, null);
        System.out.println(result);
    }

}
