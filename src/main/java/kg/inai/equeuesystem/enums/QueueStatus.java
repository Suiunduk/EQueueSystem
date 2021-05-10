package kg.inai.equeuesystem.enums;

public enum QueueStatus {
    PENDING, STARTED, FINISHED, REDIRECTED;

    public String getSecondValue(QueueStatus status){
        if(status.equals(status.PENDING)){
            return "В ожидании";
        }else if(status.equals(status.STARTED)){
            return "Прием начат";
        }else if(status.equals(status.FINISHED)){
            return "Прием закончен";
        }else if(status.equals(status.REDIRECTED)){
            return "Перенаправлен";
        }
        return "";
    }
}
