package ru.geekbrains.lesson6_hw.common;

public class Configuration {

    public static final String BASE_URL = "https://crm.geekbrains.space/";
    public static final String LOGIN_PATH = "user/login";
    public static final String STUDENT_LOGIN = "Applanatest";
    public static final String STUDENT_PASSWORD = "Student2020!";

    public static final String projects_path = "project/";
    public static final String my_path = "my";
    public static final String create_path = "create/";

    public static final String new_project_name = "kat_project8";
    public static final String company_name = "Test Organisation_10";
    public static final String contact_name = "Мартынов Николай";

    public static final String check_company_name = "//span[@class='select2-chosen' and text()='Test Organisation_10']";
    public static final String check_contact_name = "//span[@class='select2-chosen' and text()='Мартынов Николай']";
    public static final String check_manager_name = "//span[contains(text(),'Амелин Владимир')]";
    public static final String check_head_name = "//span[contains(text(),'Карпов Руслан')]";
    public static final String check_curator_name = "//span[contains(text(),'Ким Юрий')]";
    public static final String check_department = "//span[contains(text(),'Research & Development')]";

}
