package SpController;

import Utils.IpHost;
import Utils.Rpath;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UpdateController {
    private Logger logger= Logger.getLogger(UpdateController.class);
    @RequestMapping("/upFilePage")
    public String upFile(){

        return "updateFile";
    }
    @RequestMapping(value = "/doFile1",method = RequestMethod.POST)
    public  String doFile(@RequestParam("file") MultipartFile file, Model model){

        String filename=file.getOriginalFilename();

        String path= Rpath.rfPath(IpHost.getCurrentFile());
        logger.info(path);
        //C:\Users\Administrator\Desktop\image
        File fil=new File(path,filename);
        try {
            file.transferTo(fil);
            logger.info("successs");
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("file",file.getOriginalFilename());
        return "download";
    }

}
