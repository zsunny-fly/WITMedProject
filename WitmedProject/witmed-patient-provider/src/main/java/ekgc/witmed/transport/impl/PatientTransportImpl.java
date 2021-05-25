package ekgc.witmed.transport.impl;


import ekgc.witmed.pojo.patient.role.entity.Patient;
import ekgc.witmed.pojo.vo.PatientVO;
import ekgc.witmed.service.PatientService;
import ekgc.witmed.transport.patient.PatientTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("patientTransport")
@RequestMapping("/patient/transport")
public class PatientTransportImpl implements PatientTransport {
	@Autowired
	private PatientService patientService;

	@Override
	@PostMapping("/cellphone")
	public Patient getByCellphone(@RequestParam String cellphone) throws Exception {
		return patientService.getByCellphone(cellphone);
	}

	@Override
	@PostMapping("/register")
	public boolean addPatient(@RequestBody PatientVO patientVO) throws Exception{
		return  patientService.addPatient(patientVO);
	}


}
