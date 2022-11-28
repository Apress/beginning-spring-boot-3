package com.apress.springbootgroovydemo;

@org.springframework.stereotype.Controller() public class HomeController
  extends java.lang.Object  implements
    groovy.lang.GroovyObject {
;
@groovy.transform.Generated() @groovy.transform.Internal() @java.beans.Transient() public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
@groovy.transform.Generated() @groovy.transform.Internal() public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  com.apress.springbootgroovydemo.UserRepository getRepo() { return (com.apress.springbootgroovydemo.UserRepository)null;}
public  void setRepo(com.apress.springbootgroovydemo.UserRepository value) { }
@org.springframework.web.bind.annotation.GetMapping(value="/") public  java.lang.String home(org.springframework.ui.Model model) { return (java.lang.String)null;}
}
