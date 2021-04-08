package payloads;

import pojo.Dummy;

public class DummyPayload {
public static Dummy addUser(){
    Dummy pojo=new Dummy();
    pojo.setName("EsraY");
    pojo.setSalary("90.000");
    pojo.setAge("28");
    return pojo;

}
}
