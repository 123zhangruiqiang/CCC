package Service.imp;

import com.lanmao.runtime.Remote;
import com.lanmaoly.fee.facade.notify.FeeNotifyFacade;
import com.lanmaoly.fee.facade.param.*;
import org.springframework.stereotype.Service;

import java.util.Date;


@Remote(interfaces = FeeNotifyFacade.class)
@Service
public class testService implements FeeNotifyFacade {
    public GeneralResultParam generalNotify(GeneralParam generalParam) {
        GeneralResultParam gp=new GeneralResultParam();
        if(generalParam.getDeductBill()!=null){

            DeductBillsParam deductBillsParam = generalParam.getDeductBill();

            System.out.println(deductBillsParam);
            gp  = new GeneralResultParam();

            DeductBillsResult deductBillResult = new DeductBillsResult();

            deductBillResult.setStatus("SUCCESS");
            deductBillResult.setStatusMsg("执行成功");

            gp.setDeductBillResult(deductBillResult);



        }else if(generalParam.getAcquireDeductStatus()!=null){
           AcquireDeductStatus acquireDeductStatus= generalParam.getAcquireDeductStatus();
            System.out.println(acquireDeductStatus);
           String orderId=acquireDeductStatus.getOrderId();
           AcquireDeductResult acquireDeductResult=new AcquireDeductResult();
           acquireDeductResult.setOrderId(orderId);
           acquireDeductResult.setStatusCode("SUCCESS");
           acquireDeductResult.setDeductTime(new Date());

           gp.setAcquireDeductResult(acquireDeductResult);

        }else{
           FileNotiFyParam fileNotiFyParam= generalParam.getFileNotify();
            System.out.println(fileNotiFyParam);
            FileResultNotiFyParam fileResultNotiFyParam=new FileResultNotiFyParam();
            fileNotiFyParam.setStatusCode("SUCCESS");
            fileNotiFyParam.setStatusMsg("成功");
        }

        return gp;

    }
}
