package me.wslian.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    private String name;
    private Integer age;
    private String[] position;
    private List<String> skills;
    private Map<String, BigDecimal> salary;

//    @Setter @Getter(AccessLevel.NONE)
    @JSONField(format = "dd/MM/yyyy HH:mm:ss")
    private Date createdDate;

}
