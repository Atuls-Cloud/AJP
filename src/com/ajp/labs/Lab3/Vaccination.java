package com.ajp.labs.Lab3;
abstract class Vaccine{
    int firstDose=0;
    int secondDose=0;
    void firstDose(String n, int age){
        if((n.equalsIgnoreCase("Indian"))&&(age>=18)){
            System.out.println("Your first dose successfully done. Now you have to pay 250 Rs");
            firstDose=1;
        }
        else{
            System.out.println("You are not eligible for the first dose");
            if((n.equalsIgnoreCase("Indian"))&&(age<18)){
                System.out.println("Under Age");
            } else if (!(n.equalsIgnoreCase("Indian"))&&(age>=18)) {
                System.out.println("You are not an Indian");
            } else System.out.println("You are not an Indian and also you are under age");
        }
    }
    void secondDose(){
        if(firstDose==1){
            System.out.println("Your second dose successfully done");
            secondDose=1;
        }
        else System.out.println("You are not eligible for second dose");
    }
    abstract void boosterDose();
}
class VaccinationSuccessfull extends Vaccine{

    @Override
    void boosterDose() {
        if(firstDose==1 && secondDose==1){
            System.out.println("Your booster dose successfully done");
        }
        else System.out.println("You are not eligible for the Booster Dose");
    }
}
public class Vaccination {
    public static void main(String[] args) {
        VaccinationSuccessfull v = new VaccinationSuccessfull();
        v.firstDose("Indian",18);
        v.secondDose();
        v.boosterDose();
    }
}
