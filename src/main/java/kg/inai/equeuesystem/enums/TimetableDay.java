package kg.inai.equeuesystem.enums;

public enum TimetableDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public String getSecondValue(TimetableDay day){
        if(day.equals(day.MONDAY)){
            return "Понедельник";
        }else if(day.equals(day.TUESDAY)){
            return "Вторник";
        }else if(day.equals(day.WEDNESDAY)){
            return "Среда";
        }else if(day.equals(day.THURSDAY)){
            return "Четверг";
        }else if(day.equals(day.FRIDAY)){
            return "Пятница";
        }else if(day.equals(day.SATURDAY)){
            return "Суббота";
        }else if(day.equals(day.SUNDAY)){
            return "Воскресенье";
        }
        return "";
    }
}
