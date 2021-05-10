package kg.inai.equeuesystem.enums;

public enum UserRole {
    SUPER_USER, EMPLOYEE, CLIENT;

    public String getSecondValue(UserRole role){
        if(role.equals(role.SUPER_USER)){
            return "Администратор системы";
        }else if(role.equals(role.EMPLOYEE)){
            return "Специаалист";
        }else if(role.equals(role.CLIENT)){
            return "Клиент";
        }
        return "";
    }
}
