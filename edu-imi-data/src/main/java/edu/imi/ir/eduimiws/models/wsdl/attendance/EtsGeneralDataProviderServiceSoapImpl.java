
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package edu.imi.ir.eduimiws.models.wsdl.attendance;

import java.util.logging.Logger;
import javax.jws.WebService;

/**
 * This class was generated by Apache CXF 3.6.5
 * 2025-01-08T14:55:53.910+03:30
 * Generated source version: 3.6.5
 *
 */

@WebService(
                      serviceName = "EtsGeneralDataProviderService",
                      portName = "EtsGeneralDataProviderServiceSoap",
                      targetNamespace = "http://tempuri.org/",
                      wsdlLocation = "http://172.17.70.21:8090/EtsGeneralDataProviderService.asmx?WSDL",
                      endpointInterface = "edu.imi.ir.eduimiws.models.wsdl.attendance.EtsGeneralDataProviderServiceSoap")

public class EtsGeneralDataProviderServiceSoapImpl implements EtsGeneralDataProviderServiceSoap {

    private static final Logger LOG = Logger.getLogger(EtsGeneralDataProviderServiceSoapImpl.class.getName());

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceSoap#addSpecialExtraWorkPermission(java.lang.String employeeCode, int value, long periodId, java.lang.String requestReason, java.lang.String description, long specialExtraWorkId, long organizationChartId)*
     */
    public String addSpecialExtraWorkPermission(String employeeCode, int value, long periodId, String requestReason, String description, long specialExtraWorkId, long organizationChartId) {
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
     * @see EtsGeneralDataProviderServiceSoap#addMissionRegistrationPermission(java.lang.String employeeCode, long missionId, long missionLocationId, java.lang.String missionSubject, javax.xml.datatype.XMLGregorianCalendar beginDateTime, javax.xml.datatype.XMLGregorianCalendar endDateTime, java.lang.String requestReason, java.lang.String description)*
     */
    public String addMissionRegistrationPermission(String employeeCode, long missionId, long missionLocationId, String missionSubject, javax.xml.datatype.XMLGregorianCalendar beginDateTime, javax.xml.datatype.XMLGregorianCalendar endDateTime, String requestReason, String description) {
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
     * @see EtsGeneralDataProviderServiceSoap#isValidPersonStringDate(java.lang.String employeeCode, java.lang.String dateTime, int requestState)*
     */
    public boolean isValidPersonStringDate(String employeeCode, String dateTime, int requestState) {
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
     * @see EtsGeneralDataProviderServiceSoap#test()*
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
     * @see EtsGeneralDataProviderServiceSoap#getIORecordPerPersistOn(java.lang.String fromDate, java.lang.String toDate)*
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
     * @see EtsGeneralDataProviderServiceSoap#getFunctionalityList(java.lang.String employeeCode, javax.xml.datatype.XMLGregorianCalendar fromDate, javax.xml.datatype.XMLGregorianCalendar toDate)*
     */
    public ArrayOfString getFunctionalityList(String employeeCode, javax.xml.datatype.XMLGregorianCalendar fromDate, javax.xml.datatype.XMLGregorianCalendar toDate) {
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
     * @see EtsGeneralDataProviderServiceSoap#addDailyExtraWorkPermission(java.lang.String employeeCode, long extraWorkId, javax.xml.datatype.XMLGregorianCalendar beginDateTime, javax.xml.datatype.XMLGregorianCalendar endDateTime, java.lang.String requestReason, java.lang.String description)*
     */
    public String addDailyExtraWorkPermission(String employeeCode, long extraWorkId, javax.xml.datatype.XMLGregorianCalendar beginDateTime, javax.xml.datatype.XMLGregorianCalendar endDateTime, String requestReason, String description) {
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
     * @see EtsGeneralDataProviderServiceSoap#getFunctionalityWinPayList(java.lang.String employeeCode, javax.xml.datatype.XMLGregorianCalendar date, boolean withVacation, boolean withSequenceWorkingDetails, boolean withSpecialExtraWork, boolean withVacationRemaining, boolean withSpecialAddSubVacation, boolean withMission)*
     */
    public PeriodCalculationInfo getFunctionalityWinPayList(String employeeCode, javax.xml.datatype.XMLGregorianCalendar date, boolean withVacation, boolean withSequenceWorkingDetails, boolean withSpecialExtraWork, boolean withVacationRemaining, boolean withSpecialAddSubVacation, boolean withMission) {
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
     * @see EtsGeneralDataProviderServiceSoap#getAllCurrentlyEmployeesWithKey()*
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
     * @see EtsGeneralDataProviderServiceSoap#getPeriodCalculationInfo(java.lang.String employeeCode, javax.xml.datatype.XMLGregorianCalendar fromDate, javax.xml.datatype.XMLGregorianCalendar toDate)*
     */
    public void getPeriodCalculationInfo(String employeeCode, javax.xml.datatype.XMLGregorianCalendar fromDate, javax.xml.datatype.XMLGregorianCalendar toDate) {
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
     * @see EtsGeneralDataProviderServiceSoap#isValidReserve(java.lang.String employeeCode, javax.xml.datatype.XMLGregorianCalendar startDateTime, javax.xml.datatype.XMLGregorianCalendar endDateTime, java.lang.String officialHolidaySetting, java.lang.String agreedHolidaySetting, java.lang.String normalDaySetting, boolean chekExtraWorkPermission)*
     */
    public boolean isValidReserve(String employeeCode, javax.xml.datatype.XMLGregorianCalendar startDateTime, javax.xml.datatype.XMLGregorianCalendar endDateTime, String officialHolidaySetting, String agreedHolidaySetting, String normalDaySetting, boolean chekExtraWorkPermission) {
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
     * @see EtsGeneralDataProviderServiceSoap#isValidPerson(java.lang.String employeeCode, javax.xml.datatype.XMLGregorianCalendar dateTime, int requestState, java.lang.String leaveHour)*
     */
    public boolean isValidPerson(String employeeCode, javax.xml.datatype.XMLGregorianCalendar dateTime, int requestState, String leaveHour) {
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
     * @see EtsGeneralDataProviderServiceSoap#getOrganizationChartIdByEmployeeById(long regionId, long employeeId)*
     */
    public Long getOrganizationChartIdByEmployeeById(long regionId, long employeeId) {
        LOG.info("Executing operation getOrganizationChartIdByEmployeeById");
        System.out.println(regionId);
        System.out.println(employeeId);
        try {
            Long _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceSoap#getAllExtraWorkPermissionsByDate(java.lang.String date)*
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
     * @see EtsGeneralDataProviderServiceSoap#getDailyMissionsOrVacations(javax.xml.datatype.XMLGregorianCalendar startDateTime, javax.xml.datatype.XMLGregorianCalendar endDateTime)*
     */
    public String getDailyMissionsOrVacations(javax.xml.datatype.XMLGregorianCalendar startDateTime, javax.xml.datatype.XMLGregorianCalendar endDateTime) {
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
     * @see EtsGeneralDataProviderServiceSoap#getAllEmployeesInfo()*
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
     * @see EtsGeneralDataProviderServiceSoap#addMissionRegistration(java.lang.String employeeCode, long missionId, javax.xml.datatype.XMLGregorianCalendar beginDateTime, javax.xml.datatype.XMLGregorianCalendar endDateTime)*
     */
    public String addMissionRegistration(String employeeCode, long missionId, javax.xml.datatype.XMLGregorianCalendar beginDateTime, javax.xml.datatype.XMLGregorianCalendar endDateTime) {
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
     * @see EtsGeneralDataProviderServiceSoap#getIoSources()*
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
     * @see EtsGeneralDataProviderServiceSoap#getEmployeeFullNameFromLoginResult(java.lang.String userName, java.lang.String password)*
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
     * @see EtsGeneralDataProviderServiceSoap#getUiRequestCartableIds(java.lang.String employeeCode)*
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
     * @see EtsGeneralDataProviderServiceSoap#getCalendarWorkDayTypesByEmployee(java.lang.String employeeCode, java.lang.String fromDate, java.lang.String toDate)*
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
     * @see EtsGeneralDataProviderServiceSoap#getAllEmployeesWithOrgId()*
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
     * @see EtsGeneralDataProviderServiceSoap#getAllPeriodFunctionalityWinPayList(java.lang.String employeeCode, javax.xml.datatype.XMLGregorianCalendar date, boolean withVacation, boolean withSequenceWorkingDetails, boolean withSpecialExtraWork, boolean withVacationRemaining, boolean withSpecialAddSubVacation, boolean withMission)*
     */
    public ArrayOfPeriodCalculationInfo getAllPeriodFunctionalityWinPayList(String employeeCode, javax.xml.datatype.XMLGregorianCalendar date, boolean withVacation, boolean withSequenceWorkingDetails, boolean withSpecialExtraWork, boolean withVacationRemaining, boolean withSpecialAddSubVacation, boolean withMission) {
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
     * @see EtsGeneralDataProviderServiceSoap#getOrganizationChartList(long regionId)*
     */
    public ArrayOfString getOrganizationChartList(long regionId) {
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
     * @see EtsGeneralDataProviderServiceSoap#getValidCardList(long regionId)*
     */
    public ArrayOfString getValidCardList(long regionId) {
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
     * @see EtsGeneralDataProviderServiceSoap#getAllVacationRegistrationsByDate(java.lang.String date)*
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
     * @see EtsGeneralDataProviderServiceSoap#getAllSubsetOrganizationChartsWithEmployeesByCurrentOrgId(long currentOrganizationchartId)*
     */
    public ArrayOfOrganizationChartDataModel getAllSubsetOrganizationChartsWithEmployeesByCurrentOrgId(long currentOrganizationchartId) {
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
     * @see EtsGeneralDataProviderServiceSoap#getAllMissionRegistrationsByDate(java.lang.String date)*
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
     * @see EtsGeneralDataProviderServiceSoap#getIoRecordInDayByEmployeeCode(java.lang.String employeeCode, javax.xml.datatype.XMLGregorianCalendar dayDate)*
     */
    public ArrayOfStaffIOs getIoRecordInDayByEmployeeCode(String employeeCode, javax.xml.datatype.XMLGregorianCalendar dayDate) {
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
     * @see EtsGeneralDataProviderServiceSoap#checkTimeAttendanceSystemHasThirdPartyWebServicec()*
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
     * @see EtsGeneralDataProviderServiceSoap#getAllOrganizationChartList()*
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
     * @see EtsGeneralDataProviderServiceSoap#getAllEmployees()*
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
     * @see EtsGeneralDataProviderServiceSoap#getRemainUiEmployeeVacationTypeRepositoryList(java.lang.String employeeCode, long currentWorkingYear)*
     */
    public ArrayOfString getRemainUiEmployeeVacationTypeRepositoryList(String employeeCode, long currentWorkingYear) {
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
     * @see EtsGeneralDataProviderServiceSoap#getAllSpecialExtraWorksByPeriodId(long periodId)*
     */
    public ArrayOfSpecialExtraWorkDataModel getAllSpecialExtraWorksByPeriodId(long periodId) {
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
     * @see EtsGeneralDataProviderServiceSoap#getEmployeeCodeByKeyNumber(java.lang.String keyNumber, java.lang.String gregorianDate, java.lang.String shamsiDate, SystemModuleType systemType, UiDeviceModuleType deviceModuleType)*
     */
    public String getEmployeeCodeByKeyNumber(String keyNumber, String gregorianDate, String shamsiDate, SystemModuleType systemType, UiDeviceModuleType deviceModuleType) {
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
     * @see EtsGeneralDataProviderServiceSoap#getIsExitOverTimeList(java.lang.String perno, java.lang.String time, javax.xml.datatype.XMLGregorianCalendar startDate, javax.xml.datatype.XMLGregorianCalendar endDate)*
     */
    public boolean getIsExitOverTimeList(String perno, String time, javax.xml.datatype.XMLGregorianCalendar startDate, javax.xml.datatype.XMLGregorianCalendar endDate) {
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
     * @see EtsGeneralDataProviderServiceSoap#getOrganizationChartIdByEmployee(long regionId, long employeeId)*
     */
    public long getOrganizationChartIdByEmployee(long regionId, long employeeId) {
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
     * @see EtsGeneralDataProviderServiceSoap#getDayCalculationInfo(java.lang.String employeeCode, javax.xml.datatype.XMLGregorianCalendar fromDate, javax.xml.datatype.XMLGregorianCalendar toDate)*
     */
    public void getDayCalculationInfo(String employeeCode, javax.xml.datatype.XMLGregorianCalendar fromDate, javax.xml.datatype.XMLGregorianCalendar toDate) {
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
     * @see EtsGeneralDataProviderServiceSoap#getListOfEmployeeEvents(EmployeeEventType employeeEvent)*
     */
    public ArrayOfEmployeeDataModel getListOfEmployeeEvents(EmployeeEventType employeeEvent) {
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
     * @see EtsGeneralDataProviderServiceSoap#addVacationRegistration(java.lang.String employeeCode, long vacationId, javax.xml.datatype.XMLGregorianCalendar beginDateTime, javax.xml.datatype.XMLGregorianCalendar endDateTime)*
     */
    public String addVacationRegistration(String employeeCode, long vacationId, javax.xml.datatype.XMLGregorianCalendar beginDateTime, javax.xml.datatype.XMLGregorianCalendar endDateTime) {
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
     * @see EtsGeneralDataProviderServiceSoap#getAllCurrentlyEmployees()*
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
     * @see EtsGeneralDataProviderServiceSoap#getAllEmployeesOfOneOrganizationChartWithAllSubsets(long currentOrganizationchartId)*
     */
    public ArrayOfEmployeeDataModel getAllEmployeesOfOneOrganizationChartWithAllSubsets(long currentOrganizationchartId) {
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
     * @see EtsGeneralDataProviderServiceSoap#getIORecordAfterId(long id)*
     */
    public ArrayOfIoRecordDataModel getIORecordAfterId(long id) {
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
     * @see EtsGeneralDataProviderServiceSoap#isPresent(long id, javax.xml.datatype.XMLGregorianCalendar dateTime)*
     */
    public boolean isPresent(long id, javax.xml.datatype.XMLGregorianCalendar dateTime) {
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
     * @see EtsGeneralDataProviderServiceSoap#getDevicePersons(java.util.List<java.lang.String> deviceModuleType)*
     */
    public ArrayOfDevicePerson getDevicePersons(java.util.List<String> deviceModuleType) {
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
     * @see EtsGeneralDataProviderServiceSoap#getAllIoRecordsByDate(java.lang.String date)*
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
     * @see EtsGeneralDataProviderServiceSoap#getUiRequestCartableCount(java.lang.String employeeCode)*
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
     * @see EtsGeneralDataProviderServiceSoap#getRemainUiEmployeeVacationTypeRepository(java.lang.String employeeCode, long vacationtypeId)*
     */
    public String getRemainUiEmployeeVacationTypeRepository(String employeeCode, long vacationtypeId) {
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
     * @see EtsGeneralDataProviderServiceSoap#getAllValidEmployeeRange(javax.xml.datatype.XMLGregorianCalendar dateTime, int requestState)*
     */
    public ArrayOfValidEmployeeRange getAllValidEmployeeRange(javax.xml.datatype.XMLGregorianCalendar dateTime, int requestState) {
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
     * @see EtsGeneralDataProviderServiceSoap#getIORecordPerDateRange(java.lang.String fromDate, java.lang.String toDate)*
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
     * @see EtsGeneralDataProviderServiceSoap#getCalendarWorkDayTypes(java.lang.String calendarName, java.lang.String fromDate, java.lang.String toDate)*
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
     * @see EtsGeneralDataProviderServiceSoap#addMissionRegistrationEx(java.lang.String employeeCode, java.lang.String confirmEmployeeCode, long missionId, javax.xml.datatype.XMLGregorianCalendar beginDateTime, javax.xml.datatype.XMLGregorianCalendar endDateTime, java.lang.String missionLocationName)*
     */
    public String addMissionRegistrationEx(String employeeCode, String confirmEmployeeCode, long missionId, javax.xml.datatype.XMLGregorianCalendar beginDateTime, javax.xml.datatype.XMLGregorianCalendar endDateTime, String missionLocationName) {
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
     * @see EtsGeneralDataProviderServiceSoap#addVacationRegistrationPermission(java.lang.String employeeCode, long vacationId, javax.xml.datatype.XMLGregorianCalendar beginDateTime, javax.xml.datatype.XMLGregorianCalendar endDateTime, java.lang.String vacationRequestReason, java.lang.String description)*
     */
    public String addVacationRegistrationPermission(String employeeCode, long vacationId, javax.xml.datatype.XMLGregorianCalendar beginDateTime, javax.xml.datatype.XMLGregorianCalendar endDateTime, String vacationRequestReason, String description) {
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
     * @see EtsGeneralDataProviderServiceSoap#persistIoRecrd(java.lang.String keyNumber, javax.xml.datatype.XMLGregorianCalendar ioDateTime, long deviceModuleType, long hadwareCode)*
     */
    public boolean persistIoRecrd(String keyNumber, javax.xml.datatype.XMLGregorianCalendar ioDateTime, long deviceModuleType, long hadwareCode) {
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

    /* (non-Javadoc)
     * @see EtsGeneralDataProviderServiceSoap#getTimeAttendancePcCheckByEmployeeCode(java.lang.String employeeCode, java.lang.String dateTime, java.lang.Boolean getTimeAttendancePcCheckByEmployeeCodeResult, java.lang.String reason)*
     */
    public void getTimeAttendancePcCheckByEmployeeCode(String employeeCode, String dateTime, javax.xml.ws.Holder<Boolean> getTimeAttendancePcCheckByEmployeeCodeResult, javax.xml.ws.Holder<String> reason) {
        LOG.info("Executing operation getTimeAttendancePcCheckByEmployeeCode");
        System.out.println(employeeCode);
        System.out.println(dateTime);
        try {
            Boolean getTimeAttendancePcCheckByEmployeeCodeResultValue = null;
            getTimeAttendancePcCheckByEmployeeCodeResult.value = getTimeAttendancePcCheckByEmployeeCodeResultValue;
            String reasonValue = "";
            reason.value = reasonValue;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
