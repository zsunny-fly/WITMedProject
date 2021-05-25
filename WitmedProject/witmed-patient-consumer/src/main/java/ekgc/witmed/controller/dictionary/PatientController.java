package ekgc.witmed.controller.dictionary;

import ekgc.witmed.base.pojo.vo.ResponseVO;
import ekgc.witmed.pojo.patient.role.entity.Patient;
import ekgc.witmed.transport.patient.PatientTransport;
import ekgc.witmed.util.ConstantUtil;
import ekgc.witmed.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("patientController")
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private PatientTransport patientTransport;


	/**
	 * 校验手机号是否合理（格式正确，且没有注册过）
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/cellphone/check/{cellphone}")
	public ResponseVO checkCellphone(@PathVariable("cellphone") String cellphone) throws Exception{
		// 校验参数手机号码是否为空。
		if(StringUtil.isStringForm(cellphone)){
			// 判断手机号码的格式是否正确
			if(cellphone.matches(ConstantUtil.STRING_REGEX)){
				// 通过手机号码获取对象
				Patient patient = patientTransport.getByCellphone(cellphone);
				if(patient != null){
					return ResponseVO.getSuccessResponseVO(true);
				}else{
					return ResponseVO.getSuccessResponseVO(false);
				}
			}
			return ResponseVO.getErrorResponseVO("格式不正确，请填写正确的手机号");
		}
		return ResponseVO.getErrorResponseVO("手机号码必填，不可为空");
	}




}
