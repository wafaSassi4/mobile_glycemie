package com.example.wafasassilsi3_devmobil_mesure_glycemie.controller;
import com.example.wafasassilsi3_devmobil_mesure_glycemie.model.patient;

public class Controller {

    public static Controller instance;
    private static patient patient;
    public void createPatient(double vm,int age,boolean isFasting){
        patient = new patient(vm,age,isFasting);
    }
    private Controller(){
        super();
    }
    public String getResponse(){
        return patient.getConsultation();
    }
    public  static Controller getInstance(){
        if(instance== null){
            return instance=new Controller();
        }else {
            return instance;
        }
    }
}


