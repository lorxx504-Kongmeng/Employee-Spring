package kongmenglor.employeespring.dtos;

import javax.persistence.Column;

//data transfer objects
public class UpdateEmployeeDTO {
    public Long id;
    public String name;
    public String email;
    public String password;
    public String jobTitle;
    public Long phone;
    public String imageUrl;
    public String code;

}
