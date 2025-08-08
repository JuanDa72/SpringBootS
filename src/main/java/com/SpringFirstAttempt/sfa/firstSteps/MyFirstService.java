package com.SpringFirstAttempt.sfa.firstSteps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
//Tenemos que agregar esto dado que creamos otro archivo de propiedades
//@PropertySource("classpath:custom.properties")
public class MyFirstService {

    public MyFourthClass myFourthClass;

    public Environment environment;

    //Insertando un atributo mediante un value
    //@Value("${my.prop}")
    public String customPropertyFromA;

    //@Value("${my.propInt}")
    public String customPropertyFromAInt;

    //Inyectando dependencias mediante constructor puesto que es lo mas recomendado
    @Autowired
    public MyFirstService(@Qualifier ("mf4cConfig") MyFourthClass myFourthClass, Environment environment){
        this.myFourthClass=myFourthClass;
        this.environment=environment;
    }

    public String tellAStory(){
        return "La dependencia esta diciendo "+myFourthClass.sayHello();
    }

    public String getJavaVersion(){
        return "La versión de java es "+environment.getProperty("java.version");
    }

    public String getOsname(){
        return "El sistema operativo es "+environment.getProperty("os.name");
    }

    public String getOwnProperty(){
        return "Yo digo "+environment.getProperty("my.custom.property");
    }

    public String getOwnPropertyInt(){
        return "Yo digo "+environment.getProperty("my.custom.propertyInt");
    }

    public String GetAnotherPropery(){
        return "La propiedad exterior dice "+customPropertyFromA;
    }

    public String GetAnotherProperyInt(){
        return "La propiedad exterior numérica dice "+customPropertyFromAInt;
    }


}
