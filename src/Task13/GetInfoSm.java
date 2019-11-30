package Task13;

public interface GetInfoSm {
    // Получение информации инцидентам\изменениям\проблемам\запросам на обслуживание\ Риски \Выгрузки информации с БД

    // Получить информацию об инцидентах
    public void getImInfo();

    // Получить информацию по запросам на обслуживание
    public void getZnoInfo();

    // Получить информацию по проблемам
    public void getPmInfo();

    // Получить информацию по изменениям
    public void getCoInfo();

    // Получить информацию по рискам
    public void getRkInfo();

    // Получить информацию по выгрузкам информации с БД
    public void getDwInfo();
}
