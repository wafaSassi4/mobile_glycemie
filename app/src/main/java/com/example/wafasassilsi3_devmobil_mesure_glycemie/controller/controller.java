package com.example.wafasassilsi3_devmobil_mesure_glycemie.controller;
import com.example.wafasassilsi3_devmobil_mesure_glycemie.model.patient;

public class controller {
    private static patient patient;
    public void createPatient(double vm,int age,boolean isFasting){
        patient = new patient(vm,age,isFasting);
    }
    public controller(){
        super();
    }
    public String getResponse(){
        return patient.getConsultation();
    }
}
