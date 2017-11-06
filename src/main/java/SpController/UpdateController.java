package SpController;

import Utils.IpHost;
import Utils.Rpath;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
    @RequestMapping("/dw")
    public ResponseEntity<byte[]> downloadFile(@RequestParam("file") String filename){

        try {
            String path= Rpath.rfPath(IpHost.getCurrentFile());

            String downloadFilename=new String(filename.getBytes("utf-8"),"iso-8859-1");
            logger.info(filename);
            logger.info(new String(filename.getBytes("iso-8859-1"),"utf-8"));
            File file=new File(path,new String(filename.getBytes("iso-8859-1"),"utf-8"));
            HttpHeaders httpHeaders=new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            httpHeaders.setContentDispositionFormData("attachment",filename);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),httpHeaders, HttpStatus.CREATED);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
