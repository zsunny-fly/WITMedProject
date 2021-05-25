package ekgc.witmed.transport.patient;

import ekgc.witmed.pojo.patient.role.entity.Patient;
import ekgc.witmed.pojo.vo.PatientVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "witmed-patient-provider")
@RequestMapping("/patient/transport")
public interface PatientTransport {

	@PostMapping("/cellphone")
	Patient getByCellphone(@RequestParam String cellphone) throws Exception;

	@PostMapping("/register")
	boolean addPatient(@RequestBody PatientVO patientVO) throws Exception;

}
