package pres;

import metier.IMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

public class PresSpringXML {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.XML");
        IMetier metier=(IMetier) context.getBean("metier");
        System.out.println(metier.calcul());
    }
}
