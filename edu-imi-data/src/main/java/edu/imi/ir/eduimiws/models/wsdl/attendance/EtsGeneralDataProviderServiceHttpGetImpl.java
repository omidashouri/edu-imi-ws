
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package edu.imi.ir.eduimiws.models.wsdl.attendance;

import java.util.logging.Logger;
import javax.jws.WebService;

/**
 * This class was generated by Apache CXF 3.6.5
 * 2025-01-08T14:55:53.993+03:30
 * Generated source version: 3.6.5
 *
 */

@WebService(
                      serviceName = "EtsGeneralDataProviderService",
                      portName = "EtsGeneralDataProviderServiceHttpGet",
                      targetNamespace = "http://tempuri.org/",
                      wsdlLocation = "http://172.17.70.21:8090/EtsGeneralDataProviderService.asmx?WSDL",
                      endpointInterface = "edu.imi.ir.eduimiws.models.wsdl.attendance.EtsGeneralDataProviderServiceHttpGet")

public class EtsGeneralDataProviderServiceHttpGetImpl implements EtsGeneralDataProviderServiceHttpGet {

    private static final Logger LOG = Logger.getLogger(EtsGeneralDataProviderServiceHttpGetImpl.class.getName());

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#addSpecialExtraWorkPermission(java.lang.String employeeCode, java.lang.String value, java.lang.String periodId, java.lang.String requestReason, java.lang.String description, java.lang.String specialExtraWorkId, java.lang.String organizationChartId)*
     */
    public String addSpecialExtraWorkPermission(String employeeCode, String value, String periodId, String requestReason, String description, String specialExtraWorkId, String organizationChartId) {
        LOG.info("Executing operation addSpecialExtraWorkPermission");
        System.out.println(employeeCode);
        System.out.println(value);
        System.out.println(periodId);
        System.out.println(requestReason);
        System.out.println(description);
        System.out.println(specialExtraWorkId);
        System.out.println(organizationChartId);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#addMissionRegistrationPermission(java.lang.String employeeCode, java.lang.String missionId, java.lang.String missionLocationId, java.lang.String missionSubject, java.lang.String beginDateTime, java.lang.String endDateTime, java.lang.String requestReason, java.lang.String description)*
     */
    public String addMissionRegistrationPermission(String employeeCode, String missionId, String missionLocationId, String missionSubject, String beginDateTime, String endDateTime, String requestReason, String description) {
        LOG.info("Executing operation addMissionRegistrationPermission");
        System.out.println(employeeCode);
        System.out.println(missionId);
        System.out.println(missionLocationId);
        System.out.println(missionSubject);
        System.out.println(beginDateTime);
        System.out.println(endDateTime);
        System.out.println(requestReason);
        System.out.println(description);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#isValidPersonStringDate(java.lang.String employeeCode, java.lang.String dateTime, java.lang.String requestState)*
     */
    public boolean isValidPersonStringDate(String employeeCode, String dateTime, String requestState) {
        LOG.info("Executing operation isValidPersonStringDate");
        System.out.println(employeeCode);
        System.out.println(dateTime);
        System.out.println(requestState);
        try {
            boolean _return = false;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#test()*
     */
    public String test() {
        LOG.info("Executing operation test");
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getIORecordPerPersistOn(java.lang.String fromDate, java.lang.String toDate)*
     */
    public ArrayOfIoRecordDataModel getIORecordPerPersistOn(String fromDate, String toDate) {
        LOG.info("Executing operation getIORecordPerPersistOn");
        System.out.println(fromDate);
        System.out.println(toDate);
        try {
            ArrayOfIoRecordDataModel _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getFunctionalityList(java.lang.String employeeCode, java.lang.String fromDate, java.lang.String toDate)*
     */
    public ArrayOfString getFunctionalityList(String employeeCode, String fromDate, String toDate) {
        LOG.info("Executing operation getFunctionalityList");
        System.out.println(employeeCode);
        System.out.println(fromDate);
        System.out.println(toDate);
        try {
            ArrayOfString _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#addDailyExtraWorkPermission(java.lang.String employeeCode, java.lang.String extraWorkId, java.lang.String beginDateTime, java.lang.String endDateTime, java.lang.String requestReason, java.lang.String description)*
     */
    public String addDailyExtraWorkPermission(String employeeCode, String extraWorkId, String beginDateTime, String endDateTime, String requestReason, String description) {
        LOG.info("Executing operation addDailyExtraWorkPermission");
        System.out.println(employeeCode);
        System.out.println(extraWorkId);
        System.out.println(beginDateTime);
        System.out.println(endDateTime);
        System.out.println(requestReason);
        System.out.println(description);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getFunctionalityWinPayList(java.lang.String employeeCode, java.lang.String date, java.lang.String withVacation, java.lang.String withSequenceWorkingDetails, java.lang.String withSpecialExtraWork, java.lang.String withVacationRemaining, java.lang.String withSpecialAddSubVacation, java.lang.String withMission)*
     */
    public PeriodCalculationInfo getFunctionalityWinPayList(String employeeCode, String date, String withVacation, String withSequenceWorkingDetails, String withSpecialExtraWork, String withVacationRemaining, String withSpecialAddSubVacation, String withMission) {
        LOG.info("Executing operation getFunctionalityWinPayList");
        System.out.println(employeeCode);
        System.out.println(date);
        System.out.println(withVacation);
        System.out.println(withSequenceWorkingDetails);
        System.out.println(withSpecialExtraWork);
        System.out.println(withVacationRemaining);
        System.out.println(withSpecialAddSubVacation);
        System.out.println(withMission);
        try {
            PeriodCalculationInfo _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getAllCurrentlyEmployeesWithKey()*
     */
    public ArrayOfEmployeeDataModelWithKey getAllCurrentlyEmployeesWithKey() {
        LOG.info("Executing operation getAllCurrentlyEmployeesWithKey");
        try {
            ArrayOfEmployeeDataModelWithKey _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getPeriodCalculationInfo(java.lang.String employeeCode, java.lang.String fromDate, java.lang.String toDate)*
     */
    public void getPeriodCalculationInfo(String employeeCode, String fromDate, String toDate) {
        LOG.info("Executing operation getPeriodCalculationInfo");
        System.out.println(employeeCode);
        System.out.println(fromDate);
        System.out.println(toDate);
        try {
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#isValidReserve(java.lang.String employeeCode, java.lang.String startDateTime, java.lang.String endDateTime, java.lang.String officialHolidaySetting, java.lang.String agreedHolidaySetting, java.lang.String normalDaySetting, java.lang.String chekExtraWorkPermission)*
     */
    public boolean isValidReserve(String employeeCode, String startDateTime, String endDateTime, String officialHolidaySetting, String agreedHolidaySetting, String normalDaySetting, String chekExtraWorkPermission) {
        LOG.info("Executing operation isValidReserve");
        System.out.println(employeeCode);
        System.out.println(startDateTime);
        System.out.println(endDateTime);
        System.out.println(officialHolidaySetting);
        System.out.println(agreedHolidaySetting);
        System.out.println(normalDaySetting);
        System.out.println(chekExtraWorkPermission);
        try {
            boolean _return = false;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#isValidPerson(java.lang.String employeeCode, java.lang.String dateTime, java.lang.String requestState, java.lang.String leaveHour)*
     */
    public boolean isValidPerson(String employeeCode, String dateTime, String requestState, String leaveHour) {
        LOG.info("Executing operation isValidPerson");
        System.out.println(employeeCode);
        System.out.println(dateTime);
        System.out.println(requestState);
        System.out.println(leaveHour);
        try {
            boolean _return = false;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getOrganizationChartIdByEmployeeById(java.lang.String regionId, java.lang.String employeeId)*
     */
    public long getOrganizationChartIdByEmployeeById(String regionId, String employeeId) {
        LOG.info("Executing operation getOrganizationChartIdByEmployeeById");
        System.out.println(regionId);
        System.out.println(employeeId);
        try {
            long _return = 0;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getAllExtraWorkPermissionsByDate(java.lang.String date)*
     */
    public ArrayOfDailyExtraWorkPermissionDataModel getAllExtraWorkPermissionsByDate(String date) {
        LOG.info("Executing operation getAllExtraWorkPermissionsByDate");
        System.out.println(date);
        try {
            ArrayOfDailyExtraWorkPermissionDataModel _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getDailyMissionsOrVacations(java.lang.String startDateTime, java.lang.String endDateTime)*
     */
    public String getDailyMissionsOrVacations(String startDateTime, String endDateTime) {
        LOG.info("Executing operation getDailyMissionsOrVacations");
        System.out.println(startDateTime);
        System.out.println(endDateTime);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getAllEmployeesInfo()*
     */
    public ArrayOfEmployeeInfo getAllEmployeesInfo() {
        LOG.info("Executing operation getAllEmployeesInfo");
        try {
            ArrayOfEmployeeInfo _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#addMissionRegistration(java.lang.String employeeCode, java.lang.String missionId, java.lang.String beginDateTime, java.lang.String endDateTime)*
     */
    public String addMissionRegistration(String employeeCode, String missionId, String beginDateTime, String endDateTime) {
        LOG.info("Executing operation addMissionRegistration");
        System.out.println(employeeCode);
        System.out.println(missionId);
        System.out.println(beginDateTime);
        System.out.println(endDateTime);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getIoSources()*
     */
    public ArrayOfString getIoSources() {
        LOG.info("Executing operation getIoSources");
        try {
            ArrayOfString _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getEmployeeFullNameFromLoginResult(java.lang.String userName, java.lang.String password)*
     */
    public String getEmployeeFullNameFromLoginResult(String userName, String password) {
        LOG.info("Executing operation getEmployeeFullNameFromLoginResult");
        System.out.println(userName);
        System.out.println(password);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getUiRequestCartableIds(java.lang.String employeeCode)*
     */
    public UiRequestCartableIds getUiRequestCartableIds(String employeeCode) {
        LOG.info("Executing operation getUiRequestCartableIds");
        System.out.println(employeeCode);
        try {
            UiRequestCartableIds _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getCalendarWorkDayTypesByEmployee(java.lang.String employeeCode, java.lang.String fromDate, java.lang.String toDate)*
     */
    public ArrayOfCalendarDayListDto getCalendarWorkDayTypesByEmployee(String employeeCode, String fromDate, String toDate) {
        LOG.info("Executing operation getCalendarWorkDayTypesByEmployee");
        System.out.println(employeeCode);
        System.out.println(fromDate);
        System.out.println(toDate);
        try {
            ArrayOfCalendarDayListDto _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getAllEmployeesWithOrgId()*
     */
    public ArrayOfEmployeeInfo getAllEmployeesWithOrgId() {
        LOG.info("Executing operation getAllEmployeesWithOrgId");
        try {
            ArrayOfEmployeeInfo _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getAllPeriodFunctionalityWinPayList(java.lang.String employeeCode, java.lang.String date, java.lang.String withVacation, java.lang.String withSequenceWorkingDetails, java.lang.String withSpecialExtraWork, java.lang.String withVacationRemaining, java.lang.String withSpecialAddSubVacation, java.lang.String withMission)*
     */
    public ArrayOfPeriodCalculationInfo getAllPeriodFunctionalityWinPayList(String employeeCode, String date, String withVacation, String withSequenceWorkingDetails, String withSpecialExtraWork, String withVacationRemaining, String withSpecialAddSubVacation, String withMission) {
        LOG.info("Executing operation getAllPeriodFunctionalityWinPayList");
        System.out.println(employeeCode);
        System.out.println(date);
        System.out.println(withVacation);
        System.out.println(withSequenceWorkingDetails);
        System.out.println(withSpecialExtraWork);
        System.out.println(withVacationRemaining);
        System.out.println(withSpecialAddSubVacation);
        System.out.println(withMission);
        try {
            ArrayOfPeriodCalculationInfo _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getOrganizationChartList(java.lang.String regionId)*
     */
    public ArrayOfString getOrganizationChartList(String regionId) {
        LOG.info("Executing operation getOrganizationChartList");
        System.out.println(regionId);
        try {
            ArrayOfString _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getValidCardList(java.lang.String regionId)*
     */
    public ArrayOfString getValidCardList(String regionId) {
        LOG.info("Executing operation getValidCardList");
        System.out.println(regionId);
        try {
            ArrayOfString _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getAllVacationRegistrationsByDate(java.lang.String date)*
     */
    public ArrayOfVacationRegistrationDataModel getAllVacationRegistrationsByDate(String date) {
        LOG.info("Executing operation getAllVacationRegistrationsByDate");
        System.out.println(date);
        try {
            ArrayOfVacationRegistrationDataModel _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getAllSubsetOrganizationChartsWithEmployeesByCurrentOrgId(java.lang.String currentOrganizationchartId)*
     */
    public ArrayOfOrganizationChartDataModel getAllSubsetOrganizationChartsWithEmployeesByCurrentOrgId(String currentOrganizationchartId) {
        LOG.info("Executing operation getAllSubsetOrganizationChartsWithEmployeesByCurrentOrgId");
        System.out.println(currentOrganizationchartId);
        try {
            ArrayOfOrganizationChartDataModel _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getAllMissionRegistrationsByDate(java.lang.String date)*
     */
    public ArrayOfMissionRegistrationDataModel getAllMissionRegistrationsByDate(String date) {
        LOG.info("Executing operation getAllMissionRegistrationsByDate");
        System.out.println(date);
        try {
            ArrayOfMissionRegistrationDataModel _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getIoRecordInDayByEmployeeCode(java.lang.String employeeCode, java.lang.String dayDate)*
     */
    public ArrayOfStaffIOs getIoRecordInDayByEmployeeCode(String employeeCode, String dayDate) {
        LOG.info("Executing operation getIoRecordInDayByEmployeeCode");
        System.out.println(employeeCode);
        System.out.println(dayDate);
        try {
            ArrayOfStaffIOs _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#checkTimeAttendanceSystemHasThirdPartyWebServicec()*
     */
    public boolean checkTimeAttendanceSystemHasThirdPartyWebServicec() {
        LOG.info("Executing operation checkTimeAttendanceSystemHasThirdPartyWebServicec");
        try {
            boolean _return = false;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getAllOrganizationChartList()*
     */
    public ArrayOfOrganizationChartDataModel getAllOrganizationChartList() {
        LOG.info("Executing operation getAllOrganizationChartList");
        try {
            ArrayOfOrganizationChartDataModel _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getAllEmployees()*
     */
    public ArrayOfEmployeeDataModel getAllEmployees() {
        LOG.info("Executing operation getAllEmployees");
        try {
            ArrayOfEmployeeDataModel _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getRemainUiEmployeeVacationTypeRepositoryList(java.lang.String employeeCode, java.lang.String currentWorkingYear)*
     */
    public ArrayOfString getRemainUiEmployeeVacationTypeRepositoryList(String employeeCode, String currentWorkingYear) {
        LOG.info("Executing operation getRemainUiEmployeeVacationTypeRepositoryList");
        System.out.println(employeeCode);
        System.out.println(currentWorkingYear);
        try {
            ArrayOfString _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getAllSpecialExtraWorksByPeriodId(java.lang.String periodId)*
     */
    public ArrayOfSpecialExtraWorkDataModel getAllSpecialExtraWorksByPeriodId(String periodId) {
        LOG.info("Executing operation getAllSpecialExtraWorksByPeriodId");
        System.out.println(periodId);
        try {
            ArrayOfSpecialExtraWorkDataModel _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getEmployeeCodeByKeyNumber(java.lang.String keyNumber, java.lang.String gregorianDate, java.lang.String shamsiDate, java.lang.String systemType, java.lang.String deviceModuleType)*
     */
    public String getEmployeeCodeByKeyNumber(String keyNumber, String gregorianDate, String shamsiDate, String systemType, String deviceModuleType) {
        LOG.info("Executing operation getEmployeeCodeByKeyNumber");
        System.out.println(keyNumber);
        System.out.println(gregorianDate);
        System.out.println(shamsiDate);
        System.out.println(systemType);
        System.out.println(deviceModuleType);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getIsExitOverTimeList(java.lang.String perno, java.lang.String time, java.lang.String startDate, java.lang.String endDate)*
     */
    public boolean getIsExitOverTimeList(String perno, String time, String startDate, String endDate) {
        LOG.info("Executing operation getIsExitOverTimeList");
        System.out.println(perno);
        System.out.println(time);
        System.out.println(startDate);
        System.out.println(endDate);
        try {
            boolean _return = false;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getOrganizationChartIdByEmployee(java.lang.String regionId, java.lang.String employeeId)*
     */
    public long getOrganizationChartIdByEmployee(String regionId, String employeeId) {
        LOG.info("Executing operation getOrganizationChartIdByEmployee");
        System.out.println(regionId);
        System.out.println(employeeId);
        try {
            long _return = 0;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getDayCalculationInfo(java.lang.String employeeCode, java.lang.String fromDate, java.lang.String toDate)*
     */
    public void getDayCalculationInfo(String employeeCode, String fromDate, String toDate) {
        LOG.info("Executing operation getDayCalculationInfo");
        System.out.println(employeeCode);
        System.out.println(fromDate);
        System.out.println(toDate);
        try {
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getListOfEmployeeEvents(java.lang.String employeeEvent)*
     */
    public ArrayOfEmployeeDataModel getListOfEmployeeEvents(String employeeEvent) {
        LOG.info("Executing operation getListOfEmployeeEvents");
        System.out.println(employeeEvent);
        try {
            ArrayOfEmployeeDataModel _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#addVacationRegistration(java.lang.String employeeCode, java.lang.String vacationId, java.lang.String beginDateTime, java.lang.String endDateTime)*
     */
    public String addVacationRegistration(String employeeCode, String vacationId, String beginDateTime, String endDateTime) {
        LOG.info("Executing operation addVacationRegistration");
        System.out.println(employeeCode);
        System.out.println(vacationId);
        System.out.println(beginDateTime);
        System.out.println(endDateTime);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getAllCurrentlyEmployees()*
     */
    public ArrayOfEmployeeDataModel getAllCurrentlyEmployees() {
        LOG.info("Executing operation getAllCurrentlyEmployees");
        try {
            ArrayOfEmployeeDataModel _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getAllEmployeesOfOneOrganizationChartWithAllSubsets(java.lang.String currentOrganizationchartId)*
     */
    public ArrayOfEmployeeDataModel getAllEmployeesOfOneOrganizationChartWithAllSubsets(String currentOrganizationchartId) {
        LOG.info("Executing operation getAllEmployeesOfOneOrganizationChartWithAllSubsets");
        System.out.println(currentOrganizationchartId);
        try {
            ArrayOfEmployeeDataModel _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getIORecordAfterId(java.lang.String id)*
     */
    public ArrayOfIoRecordDataModel getIORecordAfterId(String id) {
        LOG.info("Executing operation getIORecordAfterId");
        System.out.println(id);
        try {
            ArrayOfIoRecordDataModel _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#isPresent(java.lang.String id, java.lang.String dateTime)*
     */
    public boolean isPresent(String id, String dateTime) {
        LOG.info("Executing operation isPresent");
        System.out.println(id);
        System.out.println(dateTime);
        try {
            boolean _return = false;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getDevicePersons(java.lang.String deviceModuleType)*
     */
    public ArrayOfDevicePerson getDevicePersons(String deviceModuleType) {
        LOG.info("Executing operation getDevicePersons");
        System.out.println(deviceModuleType);
        try {
            ArrayOfDevicePerson _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getAllIoRecordsByDate(java.lang.String date)*
     */
    public ArrayOfIoRecordDataModel getAllIoRecordsByDate(String date) {
        LOG.info("Executing operation getAllIoRecordsByDate");
        System.out.println(date);
        try {
            ArrayOfIoRecordDataModel _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getUiRequestCartableCount(java.lang.String employeeCode)*
     */
    public String getUiRequestCartableCount(String employeeCode) {
        LOG.info("Executing operation getUiRequestCartableCount");
        System.out.println(employeeCode);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getRemainUiEmployeeVacationTypeRepository(java.lang.String employeeCode, java.lang.String vacationtypeId)*
     */
    public String getRemainUiEmployeeVacationTypeRepository(String employeeCode, String vacationtypeId) {
        LOG.info("Executing operation getRemainUiEmployeeVacationTypeRepository");
        System.out.println(employeeCode);
        System.out.println(vacationtypeId);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getAllValidEmployeeRange(java.lang.String dateTime, java.lang.String requestState)*
     */
    public ArrayOfValidEmployeeRange getAllValidEmployeeRange(String dateTime, String requestState) {
        LOG.info("Executing operation getAllValidEmployeeRange");
        System.out.println(dateTime);
        System.out.println(requestState);
        try {
            ArrayOfValidEmployeeRange _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getIORecordPerDateRange(java.lang.String fromDate, java.lang.String toDate)*
     */
    public ArrayOfIoRecordDataModel getIORecordPerDateRange(String fromDate, String toDate) {
        LOG.info("Executing operation getIORecordPerDateRange");
        System.out.println(fromDate);
        System.out.println(toDate);
        try {
            ArrayOfIoRecordDataModel _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#getCalendarWorkDayTypes(java.lang.String calendarName, java.lang.String fromDate, java.lang.String toDate)*
     */
    public ArrayOfCalendarDayListDto getCalendarWorkDayTypes(String calendarName, String fromDate, String toDate) {
        LOG.info("Executing operation getCalendarWorkDayTypes");
        System.out.println(calendarName);
        System.out.println(fromDate);
        System.out.println(toDate);
        try {
            ArrayOfCalendarDayListDto _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#addMissionRegistrationEx(java.lang.String employeeCode, java.lang.String confirmEmployeeCode, java.lang.String missionId, java.lang.String beginDateTime, java.lang.String endDateTime, java.lang.String missionLocationName)*
     */
    public String addMissionRegistrationEx(String employeeCode, String confirmEmployeeCode, String missionId, String beginDateTime, String endDateTime, String missionLocationName) {
        LOG.info("Executing operation addMissionRegistrationEx");
        System.out.println(employeeCode);
        System.out.println(confirmEmployeeCode);
        System.out.println(missionId);
        System.out.println(beginDateTime);
        System.out.println(endDateTime);
        System.out.println(missionLocationName);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#addVacationRegistrationPermission(java.lang.String employeeCode, java.lang.String vacationId, java.lang.String beginDateTime, java.lang.String endDateTime, java.lang.String vacationRequestReason, java.lang.String description)*
     */
    public String addVacationRegistrationPermission(String employeeCode, String vacationId, String beginDateTime, String endDateTime, String vacationRequestReason, String description) {
        LOG.info("Executing operation addVacationRegistrationPermission");
        System.out.println(employeeCode);
        System.out.println(vacationId);
        System.out.println(beginDateTime);
        System.out.println(endDateTime);
        System.out.println(vacationRequestReason);
        System.out.println(description);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceHttpGet#persistIoRecrd(java.lang.String keyNumber, java.lang.String ioDateTime, java.lang.String deviceModuleType, java.lang.String hadwareCode)*
     */
    public boolean persistIoRecrd(String keyNumber, String ioDateTime, String deviceModuleType, String hadwareCode) {
        LOG.info("Executing operation persistIoRecrd");
        System.out.println(keyNumber);
        System.out.println(ioDateTime);
        System.out.println(deviceModuleType);
        System.out.println(hadwareCode);
        try {
            boolean _return = false;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
