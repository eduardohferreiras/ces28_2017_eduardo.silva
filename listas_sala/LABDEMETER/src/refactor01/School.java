package refactor01;

public class School {

	public void register(Applicant applicant) {
		// TODO Auto-generated method stub
		
	}

	public ApplicationValidation getApplicationValidation() {
		// TODO Auto-generated method stub
		return null;
	}

	public ApplicationResult recordNewApplication(Applicant applicant) {
		ApplicationResult retResult = new ApplicationResult();
		
		ApplicationValidation applicationValidation = getApplicationValidation();
		ApplicationDao admissionApplicationDao = getApplicationValidation().getApplicationDao();
		
		ApplicationResult result = applicationValidation.validate(applicant);
		if (result.isSuccess()) {
			result = admissionApplicationDao.persist(applicant);
			if (result.isSuccess()) { // Note isSuccess()
				retResult.setSuccess(true);
				retResult.setMessage("Admission application successful");
				register(applicant);
			} else {
				retResult.setMessage(result.getMessage());
			}
		} else {
			retResult.setMessage(result.getMessage());
		}
		return retResult;
	}

	
}
