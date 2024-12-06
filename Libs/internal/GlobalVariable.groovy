package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object baseUrl
     
    /**
     * <p></p>
     */
    public static Object TrainingUrl
     
    /**
     * <p></p>
     */
    public static Object user_admin
     
    /**
     * <p></p>
     */
    public static Object password
     
    /**
     * <p></p>
     */
    public static Object user_fo
     
    /**
     * <p></p>
     */
    public static Object user_dokter
     
    /**
     * <p></p>
     */
    public static Object user_nurse
     
    /**
     * <p></p>
     */
    public static Object user_pharmacy
     
    /**
     * <p></p>
     */
    public static Object registrationNo
     
    /**
     * <p></p>
     */
    public static Object queuingNo
     
    /**
     * <p></p>
     */
    public static Object password_fo
     
    /**
     * <p></p>
     */
    public static Object registrasi
     
    /**
     * <p></p>
     */
    public static Object patient_data
     
    /**
     * <p></p>
     */
    public static Object Patient_address
     
    /**
     * <p></p>
     */
    public static Object Patient_guarantor
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters(), selectedVariables)
    
            baseUrl = selectedVariables['baseUrl']
            TrainingUrl = selectedVariables['TrainingUrl']
            user_admin = selectedVariables['user_admin']
            password = selectedVariables['password']
            user_fo = selectedVariables['user_fo']
            user_dokter = selectedVariables['user_dokter']
            user_nurse = selectedVariables['user_nurse']
            user_pharmacy = selectedVariables['user_pharmacy']
            registrationNo = selectedVariables['registrationNo']
            queuingNo = selectedVariables['queuingNo']
            password_fo = selectedVariables['password_fo']
            registrasi = selectedVariables['registrasi']
            patient_data = selectedVariables['patient_data']
            Patient_address = selectedVariables['Patient_address']
            Patient_guarantor = selectedVariables['Patient_guarantor']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
