package com.testassured;


public class PropostaRequest {
    private String InsertionDateStart;
    private String InsertionDateFinish;

    public String getDataInicio() { return InsertionDateStart; }
    public void setDataInicio(String InsertionDateStart) { this.InsertionDateStart = InsertionDateStart; }
    public String getDataFim() { return InsertionDateFinish; }
    public void setDataFim(String InsertionDateFinish) { this.InsertionDateFinish = InsertionDateFinish; }

}