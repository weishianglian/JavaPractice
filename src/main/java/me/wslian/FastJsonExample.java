package me.wslian;

import com.alibaba.fastjson.JSON;
import me.wslian.model.Staff;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FastJsonExample {
    public static void main(String[] args) {
        // Java object to json
        Staff staff = createStaff();
        System.out.println(
                JSON.toJSONString(staff, true));

        System.out.println(
                JSON.toJSONStringWithDateFormat(staff, "dd/MM/yyyy HH:mm:ss"));

        String json = JSON.toJSONString(
                List.of(createStaff(), createStaff()));
        System.out.println(json);

        try {
            Files.write(Paths.get("staff2.json"), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // json to Java object
        String jsonStr = "{\"name\":\"Lady Gaga\", \"age\":39}";
        Staff staff1 = JSON.parseObject(jsonStr, Staff.class);
        System.out.println(staff1);

        // json array to Java array
        String jsonList = String.format("[%s, %s]", jsonStr, jsonStr);
        List<Staff> staffs = JSON.parseArray(jsonList, Staff.class);
        System.out.println(staffs);

        // json file to Java objects
        try {
            String jsons = Files.readString(Paths.get("staff.json"));
            List<Staff> staffsFromFile = JSON.parseArray(jsons, Staff.class);
            System.out.println(staffsFromFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Staff createStaff() {
        Staff staff = new Staff();
        staff.setName("Ed Sheeran");
        staff.setAge(28);
        staff.setPosition(new String[]{"Singer", "songwriter", "record producer", "guitarist", "actor"});
        Map<String, BigDecimal> salary = new HashMap<>();
        salary.put("2017", new BigDecimal("7777777777"));
        salary.put("2018", new BigDecimal("8888888888"));
        salary.put("2019", new BigDecimal("9999999999"));
        staff.setSalary(salary);
        staff.setCreatedDate(new Date());

        return staff;
    }
}
