package SpController;

import POJO.Person;
import Service.imp.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @Autowired
    PersonServiceImp personServiceImp;
    @RequestMapping("/uup")
    public void upd() throws Exception {
        Person p=new Person();
        p.setName("zhang");
        personServiceImp.updatePerson(p);
        throw new Exception("haha");
    }

@RequestMapping("/del")
public void delete (){



}


}
